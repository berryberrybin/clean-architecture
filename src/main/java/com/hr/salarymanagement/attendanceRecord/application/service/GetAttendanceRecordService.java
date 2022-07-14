package com.hr.salarymanagement.attendanceRecord.application.service;

import com.hr.salarymanagement.attendanceRecord.application.port.in.GetAttendanceRecordQuery;
import com.hr.salarymanagement.attendanceRecord.application.port.out.LoadAttendanceRecordPort;
import com.hr.salarymanagement.attendanceRecord.domain.AttendanceRecord;
import com.hr.salarymanagement.employee.domain.Employee;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class GetAttendanceRecordService implements GetAttendanceRecordQuery {

	private final LoadAttendanceRecordPort loadAttendanceRecordPort;

	@Override
	public AttendanceRecord getAttendanceRecord(Employee.EmployeeId employeeId, int month) {
		return loadAttendanceRecordPort.loadAttendanceRecord(employeeId, month);
	}



}
