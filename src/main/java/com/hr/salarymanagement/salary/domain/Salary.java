package com.hr.salarymanagement.salary.domain;

import com.hr.salarymanagement.employee.domain.Employee.EmployeeId;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Salary {

	private final SalaryId salaryId;
	private final EmployeeId employeeId;


	public PayStub calculateSalary(){
		return null;
	}

	@Value
	public static class SalaryId {
		private Long value;
	}
}
