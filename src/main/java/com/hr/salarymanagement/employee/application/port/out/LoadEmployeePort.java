package com.hr.salarymanagement.employee.application.port.out;

import com.hr.salarymanagement.employee.domain.Employee;

public interface LoadEmployeePort {
	Employee loadEmployee(Employee.EmployeeId employeeId);
}
