package com.hr.salarymanagement.employee.adapter.port.out;

import com.hr.salarymanagement.employee.domain.Employee;

public interface LoadEmployeePort {
	Employee loadEmployee(Employee.EmployeeId employeeId);
}
