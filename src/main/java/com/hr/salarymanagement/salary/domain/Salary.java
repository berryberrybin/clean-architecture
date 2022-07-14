package com.hr.salarymanagement.salary.domain;

import com.hr.salarymanagement.employee.domain.Employee;
import com.hr.salarymanagement.employee.domain.Employee.EmployeeId;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

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
