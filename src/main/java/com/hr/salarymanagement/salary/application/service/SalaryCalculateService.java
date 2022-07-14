package com.hr.salarymanagement.salary.application.service;

/*
유스케이스 단계
- 입력을 받는다 => 시급, 1일평균근로시간, 1주 평균근무일수를 받음
- 비지니스 규칙을 검증한다 => 급여 계산
- 모델 상태를 조작한다 => 급여 등록
- 출력을 반환한다 => PayStub반환
 */

import com.hr.salarymanagement.attendanceRecord.application.port.in.GetAttendanceRecordQuery;
import com.hr.salarymanagement.attendanceRecord.domain.AttendanceRecord;
import com.hr.salarymanagement.company.application.port.in.GetCompanyQuery;
import com.hr.salarymanagement.company.domain.Company;
import com.hr.salarymanagement.employee.application.port.in.GetEmployeeQuery;
import com.hr.salarymanagement.employee.domain.Employee;
import com.hr.salarymanagement.employee.domain.Employee.EmployeeId;
import com.hr.salarymanagement.salary.application.port.in.SalaryCalculateCommand;
import com.hr.salarymanagement.salary.application.port.in.SalaryCalculateUseCase;
import com.hr.salarymanagement.salary.application.port.out.CreateSalaryPort;
import com.hr.salarymanagement.salary.domain.Salary;
import com.hr.salarymanagement.workcontract.application.port.in.GetWorkContractQuery;
import com.hr.salarymanagement.workcontract.domain.WorkContract;
import com.hr.salarymanagement.salary.domain.PayStub;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SalaryCalculateService implements SalaryCalculateUseCase {

	private final GetWorkContractQuery getWorkContractQuery;
	private final GetAttendanceRecordQuery getAttendanceRecordQuery;
	private final GetCompanyQuery getCompanyQuery;
	private final GetEmployeeQuery getEmployeeQuery;
	private final static double AVERAGE_WEEKS_OF_MONTH = 365.0 / 12.0 / 7.0;
	private final static int MINIMUM_WORKING_HOURS_TO_HOLIDAY_SALARY_IN_WEEK = 15;
	private final static int MAXIMUM_WORKING_HOURS_TO_HOLIDAY_SALARY_IN_WEEK = 40;
	private final static int DEFAULT_WORKING_HOURS_IN_DAY = 8;

	private final CreateSalaryPort createSalaryPort;

	@Override
	public PayStub calculateSalary(SalaryCalculateCommand salaryCalculateCommand) {

		EmployeeId employeeId = salaryCalculateCommand.getEmployeeId();
		int searchMonth = salaryCalculateCommand.getSearchMonth();
		Employee employee = getEmployeeQuery.getEmployee(employeeId);
		WorkContract workContract = getWorkContractQuery.getWorkContract(employeeId);
		AttendanceRecord attendanceRecord = getAttendanceRecordQuery.getAttendanceRecord(employeeId,searchMonth);

		//시급
		int hourlyWage = workContract.getHourlyWage();

		//1주 평균근무일수
		double avgWorkingDaysPerWeek = workContract.getAvgWorkingDaysPerWeek();

		//1일평균근로시간
		double avgWorkingHoursPerDay = workContract.getAvgWorkingHoursPerDay();

		//무급추가휴무일수
		int sumUnpaidDaysOff = attendanceRecord.getUnpaidDaysOff();

		//유급추가휴무일수
		int sumPaidDaysOff = attendanceRecord.getPaidDaysOff();

		// 일급 계산
		int dayWage = getDayWage(hourlyWage, avgWorkingHoursPerDay);

		// 주휴수당 계산
		int weeklyHolidaySalary = getWeeklyHolidaySalary(avgWorkingDaysPerWeek, avgWorkingHoursPerDay, dayWage);

		// 월주휴수당 계산
		int monthlyHolidaySalary = getMonthlyHolidaySalary(weeklyHolidaySalary);

		// 주휴수당제외한 기본급 계산
		int baseSalary = getBaseSalary(hourlyWage, avgWorkingDaysPerWeek, avgWorkingHoursPerDay, sumPaidDaysOff,
			sumUnpaidDaysOff);

		// 5인미만 사업장여부
		Company.CompanyId companyId = employee.getCompanyId();
		boolean isUnderFiveEmployee = getCompanyQuery.getCompany(companyId).isUnderFiveEmployee();

		// 추가지급급여 (연장근로수당 + 야간근로수당, 휴일근로수당, 연차수당의 가산분 계산)
		int overtimePay = 0;
		int nightWorkPay = 0;
		int holidayWorkPay = 0;
		int annualLeavePay = 0;

		if (!isUnderFiveEmployee) {
			//TODO : 연장근로수당, 야간근로수당, 휴일근로수당, 연차수당 가산분에 대한 계산
			overtimePay = (int)Math.floor(attendanceRecord.getSumOverTimeWorkingHours() * hourlyWage * 0.5);
			nightWorkPay = (int)Math.floor(attendanceRecord.getSumNightWorkingHours() * holidayWorkPay);
			holidayWorkPay = 0;
			annualLeavePay = 0;
		}

		int additionalSalary = overtimePay + nightWorkPay + holidayWorkPay + annualLeavePay;

		// 과세급여 (기본급 + 주휴수당 + 추가지급급여 + 상여금(제외))
		int taxationSalary = baseSalary + monthlyHolidaySalary + additionalSalary;

		//TODO : 비과세급여 (식대 + 자가운전보조금+출산/자녀보육수당+연장근로수당+연구보조비+여비+학자금,근로장학금+기타비과세급여)
		int taxFreeSalary = 0;

		int totalDeductionPay = 0; // TODO : 공제항목합계 계산

		//순급여
		int netSalary = taxationSalary + taxFreeSalary - totalDeductionPay;

		Salary salary = new Salary(employeeId, searchMonth, netSalary);
		createSalaryPort.createSalary(salary);

		return new PayStub(employeeId, searchMonth, netSalary, baseSalary, monthlyHolidaySalary, overtimePay, nightWorkPay,
			holidayWorkPay, annualLeavePay, totalDeductionPay);
	}

	private int getBaseSalary(int hourlyWage, Double avgWorkingDaysPerWeek, Double avgWorkingHoursPerDay,
		int sumPaidDaysOff, int sumUnpaidDaysOff) {

		int baseSalary = 0;

		// 제외해야할근무시간
		double excludedWorkingHours = 0;
		if (sumPaidDaysOff
			> 0) { // 유급추가휴무일일경우 근로조건에서 1일근로시간이 8시간 이상이라도 8시간 분만 지급됨 (ex. 월~금까지 9시간씩 일한다고 했을때, 유급휴무일일경우 8시간분만 지급하므로 1시간 급여는 제외해야 함)
			excludedWorkingHours += (avgWorkingHoursPerDay >= 8) ? ((avgWorkingHoursPerDay - 8) * sumPaidDaysOff) : 0;
		}
		if (sumUnpaidDaysOff > 0) {
			excludedWorkingHours += avgWorkingHoursPerDay * sumUnpaidDaysOff;
		}

		baseSalary = (int)Math.floor(
			hourlyWage * (avgWorkingHoursPerDay * avgWorkingDaysPerWeek * AVERAGE_WEEKS_OF_MONTH
				- excludedWorkingHours));
		return baseSalary;
	}

	private int getMonthlyHolidaySalary(int weeklyHolidaySalary) {
		return (int)Math.floor(weeklyHolidaySalary * AVERAGE_WEEKS_OF_MONTH);
	}

	private int getWeeklyHolidaySalary(Double avgWorkingDaysPerWeek, Double avgWorkingHoursPerDay, int dayWage) {
		int weeklyHolidaySalary = 0;

		double avgWorkingHoursPerWeek = avgWorkingHoursPerDay * avgWorkingDaysPerWeek;

		if (avgWorkingHoursPerWeek < MINIMUM_WORKING_HOURS_TO_HOLIDAY_SALARY_IN_WEEK) {
			weeklyHolidaySalary = 0;
		} else if (avgWorkingHoursPerWeek > MAXIMUM_WORKING_HOURS_TO_HOLIDAY_SALARY_IN_WEEK) {
			weeklyHolidaySalary = DEFAULT_WORKING_HOURS_IN_DAY * dayWage;
		} else {
			weeklyHolidaySalary =
				(int)Math.floor(avgWorkingHoursPerWeek / MAXIMUM_WORKING_HOURS_TO_HOLIDAY_SALARY_IN_WEEK)
					* DEFAULT_WORKING_HOURS_IN_DAY * dayWage;
		}
		return weeklyHolidaySalary;
	}

	private int getDayWage(int hourlyWage, Double avgWorkingHoursPerDay) {
		int dayWage = 0;
		if (avgWorkingHoursPerDay >= DEFAULT_WORKING_HOURS_IN_DAY) {
			dayWage = DEFAULT_WORKING_HOURS_IN_DAY * hourlyWage;
		} else {
			dayWage = (int)Math.floor(avgWorkingHoursPerDay * hourlyWage);
		}
		return dayWage;
	}

}
