package com.hr.salarymanagement.adapter.out.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AttendanceRecordRepository extends JpaRepository<AttendanceRecordEntity, Long> {

	@Query("select a from AttendanceRecordEntity a " + "where a.employeeId = :employeeId "+"and a.monthOfAttendanceRecord= :searchMonth")
	AttendanceRecordEntity findAttendanceRecordByMonth(@Param("employeeId") Long employeeId, @Param("searchMonth") int searchMonth);
}
