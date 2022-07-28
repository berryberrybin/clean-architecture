package com.hr.salarymanagement.application.service;

import com.hr.salarymanagement.application.port.in.GetEmployeeQuery;
import com.hr.salarymanagement.application.port.out.LoadEmployeePort;
import com.hr.salarymanagement.domain.Employee;

import lombok.RequiredArgsConstructor;

//서비스는 인커밍포트 인터페이스 뒤에 숨겨질 수 있으므로 public필요가 없다

@RequiredArgsConstructor
class GetEmployeeService implements GetEmployeeQuery {
	private final LoadEmployeePort loadEmployeePort;

	@Override
	public Employee getEmployee(Employee.EmployeeId employeeId) {
		return loadEmployeePort.loadEmployee(employeeId);
	}
}
