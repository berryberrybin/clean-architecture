package com.hr.salarymanagement.domain;

import com.hr.salarymanagement.domain.Company.CompanyId;
import com.hr.salarymanagement.domain.Employee.EmployeeId;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

// 근로계약
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class WorkContract {

	private WorkContractId workContractId;
	private final EmployeeId employeeId;
	private final int hourlyWage; // 시급
	private final Double avgWorkingHoursPerDay; // 근로조건 - 1일 평균근로시간
	private final Double avgWorkingDaysPerWeek; // 근로조건 - 1주 평균근무일수


	@Value
	public static class WorkContractId{
		private Long value;
	}
}
