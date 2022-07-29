package com.hr.salarymanagement.adapter.out.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

	@Query("select a from CompanyEntity  a " + "where a.companyId = :companyId")
	CompanyEntity findByCompanyId(@Param("companyId") Long companyId);

}
