package com.hr.salarymanagement.application.port.in;

import com.hr.salarymanagement.domain.Employee;

public interface GetEmployeeQuery {
	Employee getEmployee(Employee.EmployeeId employeeId);
}
