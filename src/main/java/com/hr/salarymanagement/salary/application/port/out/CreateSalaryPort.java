package com.hr.salarymanagement.salary.application.port.out;

import com.hr.salarymanagement.salary.domain.Salary;

public interface CreateSalaryPort {
	void createSalary(Salary salary);
}
