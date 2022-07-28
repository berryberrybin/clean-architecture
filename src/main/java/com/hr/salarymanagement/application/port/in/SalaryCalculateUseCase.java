package com.hr.salarymanagement.application.port.in;

import com.hr.salarymanagement.domain.PayStub;

public interface SalaryCalculateUseCase {

	//급여계산
	PayStub calculateSalary(SalaryCalculateCommand salaryCalculateCommand);


}
