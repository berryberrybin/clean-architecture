package com.hr.salarymanagement.adapter.out.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WorkContractRepository extends JpaRepository<WorkContractEntity, UUID> {

	@Query("select a from WorkContractEntity  a " + "where a.workContractId = :workContractId")
	WorkContractEntity findByWorkContractId(@Param("workContractId") UUID workContractId);

}
