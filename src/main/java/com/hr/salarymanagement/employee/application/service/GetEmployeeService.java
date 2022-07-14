package com.hr.salarymanagement.employee.application.service;

import com.hr.salarymanagement.employee.application.port.in.GetEmployeeQuery;
import com.hr.salarymanagement.employee.application.port.out.LoadEmployeePort;
import com.hr.salarymanagement.employee.domain.Employee;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetEmployeeService implements GetEmployeeQuery {
	private final LoadEmployeePort loadEmployeePort;

	@Override
	public Employee getEmployee(Employee.EmployeeId employeeId) {
		return loadEmployeePort.loadEmployee(employeeId);
	}
}
