package com.hr.salarymanagement.adapter.out.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AttendanceRecordRepository extends JpaRepository<AttendanceRecordEntity, UUID> {

	@Query("select a from AttendanceRecordEntity a " + "where a.attendanceRecordId = :attendanceRecordId")
	AttendanceRecordEntity findByAttendanceRecordId(@Param("attendanceRecordId") UUID attendanceRecordId);
}
