package com.hr.salarymanagement.workcontract.adapter.in.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hr.salarymanagement.common.WebAdapter;
import com.hr.salarymanagement.employee.domain.Employee;
import com.hr.salarymanagement.workcontract.application.port.in.GetWorkContractQuery;
import com.hr.salarymanagement.workcontract.domain.WorkContract;

import lombok.RequiredArgsConstructor;

// adapter.in은 port.in을 호출함
//adapter패키지에 들어있는 모든 클래스들은 package-private 접근 수준으로 둠
@WebAdapter
@RestController
@RequiredArgsConstructor
class WorkContractController {

	private final GetWorkContractQuery getWorkContractQuery;

	@GetMapping("workContract/get/{employeeId}")
	WorkContract getWorkContract(@PathVariable("employeeId")Long employeeId){
		return getWorkContractQuery.getWorkContract(new Employee.EmployeeId(employeeId));
	}

}
