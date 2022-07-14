package com.hr.salarymanagement.salary.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.hr.salarymanagement.salary.domain.Salary;

@Component
public class SalaryMapper {

	SalaryJpaEntity mapToJpaEntity(Salary salary){

		return new SalaryJpaEntity(
			salary.getEmployeeId().getValue(),
			salary.getMonthOfSalary(),
			salary.getTotalSalary()
		);
	}

}
