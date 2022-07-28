package com.hr.salarymanagement.application.port.in;

import com.hr.salarymanagement.domain.AttendanceRecord;

public interface GetAttendanceRecordQuery {
	AttendanceRecord getAttendanceRecord(GetAttendanceRecordCommand getAttendanceRecordCommand);
}
