package com.hr.salarymanagement.domain;

import com.hr.salarymanagement.domain.Employee.EmployeeId;

import lombok.AllArgsConstructor;
import lombok.Value;

// 급여명세서(월단위)
@AllArgsConstructor
public class PayStub {

	private final EmployeeId employeeId;
	private final int monthOfSalary;

	private final int netSalary; // 순급여 = (지급항목 - 공제항목) = 주휴수당제외기본급 + 월주휴수당 - 공제항목합계

	// 지급항목
	private final int baseSalary; // 기본급(주휴수당제외)
	private final int monthlyHolidaySalary; // 월주휴수당


	private final int overtimePqy; // 연장근로수당 (5인미만 가산수당 해당없음)
	private final int nightWorkPay; // 야간근로수당 (5인미만 가산수당 해당없음)
	private final int holidayWorkPay; // 휴일근로수당 (5인미만 근로자의날 제외 해당없음)
	private final int annualLeavePay; // 연차수당 (5인미만 해당없음)

	private final int totalDeductionPay; // 공제항목합계

	@Value
	public static class PayStubId{
		private Long value;
	}
}
