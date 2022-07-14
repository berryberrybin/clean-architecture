package com.hr.salarymanagement.employee.application.port.in;

import com.hr.salarymanagement.employee.domain.Employee;

public interface GetEmployeeQuery {
	Employee getEmployee(Employee.EmployeeId employeeId);
}
