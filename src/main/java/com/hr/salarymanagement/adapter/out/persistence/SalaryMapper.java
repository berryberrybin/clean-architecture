package com.hr.salarymanagement.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.hr.salarymanagement.domain.Salary;

//adapter패키지에 들어있는 모든 클래스들은 package-private 접근 수준으로 둠

@Component
class SalaryMapper {

	SalaryJpaEntity mapToJpaEntity(Salary salary){

		return new SalaryJpaEntity(
			salary.getEmployeeId().getValue(),
			salary.getMonthOfSalary(),
			salary.getTotalSalary()
		);
	}

}
