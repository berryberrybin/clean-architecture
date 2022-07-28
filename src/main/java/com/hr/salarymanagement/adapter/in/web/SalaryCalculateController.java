package com.hr.salarymanagement.adapter.in.web;

// adapter.in은 port.in을 호출함
//adapter패키지에 들어있는 모든 클래스들은 package-private 접근 수준으로 둠

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.salarymanagement.common.WebAdapter;
import com.hr.salarymanagement.domain.Employee.EmployeeId;
import com.hr.salarymanagement.application.port.in.SalaryCalculateCommand;
import com.hr.salarymanagement.application.port.in.SalaryCalculateUseCase;

import lombok.RequiredArgsConstructor;

@WebAdapter
@RestController
@RequiredArgsConstructor
class SalaryCalculateController {

	private final SalaryCalculateUseCase salaryCalculateUseCase;

	@PostMapping(path = "salary/calculate/{employeeId}/{searchMonth}")
	void calculateSalary(
		@PathVariable("employeeId") Long employeeId,
		@PathVariable("searchMonth") int searchMonth){

		SalaryCalculateCommand command = new SalaryCalculateCommand(
			new EmployeeId(employeeId),
			searchMonth);

		salaryCalculateUseCase.calculateSalary(command);
	}

}
