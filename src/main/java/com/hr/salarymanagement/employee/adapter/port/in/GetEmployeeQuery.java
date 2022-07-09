package com.hr.salarymanagement.employee.adapter.port.in;

import com.hr.salarymanagement.employee.domain.Employee;

public interface GetEmployeeQuery {
	Employee getEmployee(Employee.EmployeeId employeeId);
}
