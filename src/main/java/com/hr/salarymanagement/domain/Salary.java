package com.hr.salarymanagement.domain;

import com.hr.salarymanagement.domain.Employee.EmployeeId;

import lombok.Getter;

@Getter
public class Salary {

	private final EmployeeId employeeId;
	private final int monthOfSalary;
	private final int totalSalary;

	public Salary(EmployeeId employeeId, int monthOfSalary, int totalSalary){
		this.employeeId = employeeId;
		this.monthOfSalary = monthOfSalary;
		this.totalSalary = totalSalary;
	}
}
