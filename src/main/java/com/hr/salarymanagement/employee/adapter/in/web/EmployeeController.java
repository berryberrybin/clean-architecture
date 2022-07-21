package com.hr.salarymanagement.employee.adapter.in.web;

// adapter.in은 port.in을 호출함
//adapter패키지에 들어있는 모든 클래스들은 package-private 접근 수준으로 둠

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hr.salarymanagement.common.WebAdapter;
import com.hr.salarymanagement.employee.application.port.in.GetEmployeeQuery;
import com.hr.salarymanagement.employee.domain.Employee;

import lombok.RequiredArgsConstructor;

@WebAdapter
@RestController
@RequiredArgsConstructor
class EmployeeController {
	private final GetEmployeeQuery getEmployeeQuery;

	@GetMapping("employee/get/{employeeId}")
	Employee getEmployee(@PathVariable("employeeId")Long employeeId){
		return getEmployeeQuery.getEmployee(new Employee.EmployeeId(employeeId));
	}
}
