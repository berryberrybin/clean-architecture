package com.hr.salarymanagement.adapter.out.persistence;

import com.hr.salarymanagement.common.PersistenceAdapter;
import com.hr.salarymanagement.application.port.out.CreateSalaryPort;
import com.hr.salarymanagement.domain.Salary;

import lombok.RequiredArgsConstructor;

//adapter.out은 port.out의 구현체를 제공함
//adapter패키지에 들어있는 모든 클래스들은 package-private 접근 수준으로 둠

@RequiredArgsConstructor
@PersistenceAdapter
class SalaryPersistenceAdapter implements CreateSalaryPort {

	private final SalaryRepository salaryRepository;
	private final SalaryMapper salaryMapper;

	@Override
	public void createSalary(Salary salary) {
			salaryRepository.save(salaryMapper.mapToJpaEntity(salary));
	}

}
