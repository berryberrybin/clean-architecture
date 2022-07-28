package com.hr.salarymanagement.adapter.out.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository {

	@Query("select a from EmployeeEntity a " + "where a.employeeId = :employeeId")
	CompanyEntity findByEmployeeId(@Param("employeeId") UUID employeeId);

}
