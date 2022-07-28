package com.hr.salarymanagement.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<SalaryJpaEntity, Long> {
}
