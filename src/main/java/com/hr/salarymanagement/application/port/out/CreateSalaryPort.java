package com.hr.salarymanagement.application.port.out;

import com.hr.salarymanagement.domain.Salary;

public interface CreateSalaryPort {
	void createSalary(Salary salary);
}
