package com.hr.salarymanagement.salary.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<SalaryJpaEntity, Long> {
}
