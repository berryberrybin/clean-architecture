package com.hr.salarymanagement.domain;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Employee {

	private final EmployeeId employeeId; // 직원아이디
	private final String EmployeeName; // 직원이름
	private final int EmployeeRRN; //ResidentRegistrationNumber 주민등록번호
	private final Date joinCompanyDate; // 입사일
	private final Date retirementDate; // 퇴사일
	private final int numberOfDependents; // 부양가족수
	private final Company.CompanyId companyId; // 회사아이디
	private final WorkContract.WorkContractId workContractId;

	@Value
	public static class EmployeeId {
		private Long value;
	}
	// UUID나 long타입을 사용하지 않고 새로 타입을 만들어 준 이유
	// - EmployeeId 타입을 명확히하여 long이나 UUID보다 좀 더 명확히 EmplyeeId라는 것을 명시할 수 있음
	// - SalaryId와 EmplyeeId가 동일한 값이라도 타입이 달라 잘못된 값이 들어오거나 조회했을때 컴파일에러를 통해 방지 할 수 있음
}
