package com.hr.salarymanagement.salary.adapter.out.persistence;

import com.hr.salarymanagement.common.PersistenceAdapter;
import com.hr.salarymanagement.salary.application.port.out.CreateSalaryPort;
import com.hr.salarymanagement.salary.domain.Salary;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class SalaryPersistenceAdapter implements CreateSalaryPort {

	private final SalaryRepository salaryRepository;
	private final SalaryMapper salaryMapper;

	@Override
	public void createSalary(Salary salary) {
			salaryRepository.save(salaryMapper.mapToJpaEntity(salary));
	}

}
