package com.hr.salarymanagement.application.service;

import com.hr.salarymanagement.application.port.in.GetAttendanceRecordCommand;
import com.hr.salarymanagement.application.port.in.GetAttendanceRecordQuery;
import com.hr.salarymanagement.application.port.out.LoadAttendanceRecordPort;
import com.hr.salarymanagement.domain.AttendanceRecord;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//서비스는 인커밍포트 인터페이스 뒤에 숨겨질 수 있으므로 public필요가 없다
@RequiredArgsConstructor
@Getter
class GetAttendanceRecordService implements GetAttendanceRecordQuery {

	private final LoadAttendanceRecordPort loadAttendanceRecordPort;

	@Override
	public AttendanceRecord getAttendanceRecord(GetAttendanceRecordCommand  command) {
		return loadAttendanceRecordPort.loadAttendanceRecord(command.getEmployeeId(), command.getMonth());
	}



}
