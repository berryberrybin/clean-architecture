package com.hr.salarymanagement.salary.application.port.in;

import com.hr.salarymanagement.salary.domain.PayStub;

public interface SalaryCalculateUseCase {

	//급여계산
	PayStub calculateSalary(SalaryCalculateCommand salaryCalculateCommand);


}
