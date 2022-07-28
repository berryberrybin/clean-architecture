package com.hr.salarymanagement.application.port.out;

import com.hr.salarymanagement.domain.Employee;

public interface LoadEmployeePort {
	Employee loadEmployee(Employee.EmployeeId employeeId);
}
