package com.hr.salarymanagement.adapter.out.persistence;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hr.salarymanagement.domain.AttendanceRecord;
import com.hr.salarymanagement.domain.Employee;

@Component
class AttendanceRecordMapper {

	AttendanceRecord mapToDamian(AttendanceRecordEntity attendanceRecordEntity){

		return new AttendanceRecord(new AttendanceRecord.AttendanceRecordId(attendanceRecordEntity.getAttendanceRecordId()),
			attendanceRecordEntity.getMonthOfAttendanceRecord(),
			attendanceRecordEntity.getUnpaidDaysOff(),
			attendanceRecordEntity.getPaidDaysOff(),
			attendanceRecordEntity.getSumOverTimeWorkingHours(),
			attendanceRecordEntity.getSumNightWorkingHours());
	}
}
