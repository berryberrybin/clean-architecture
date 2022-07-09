package com.hr.salarymanagement.attendanceRecord.application;

import com.hr.salarymanagement.attendanceRecord.adapter.port.in.GetAttendanceRecordQuery;
import com.hr.salarymanagement.attendanceRecord.adapter.port.out.LoadAttendanceRecordPort;
import com.hr.salarymanagement.attendanceRecord.domain.AttendanceRecord;
import com.hr.salarymanagement.employee.domain.Employee;
import com.hr.salarymanagement.workcontract.adapter.port.in.GetWorkContractQuery;
import com.hr.salarymanagement.workcontract.domain.WorkContract;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class GetAttendanceRecordService implements GetAttendanceRecordQuery {

	private final LoadAttendanceRecordPort loadAttendanceRecordPort;

	@Override
	public AttendanceRecord getAttendanceRecord(Employee.EmployeeId employeeId) {
		return loadAttendanceRecordPort.loadAttendanceRecord(employeeId);
	}



}
