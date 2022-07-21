package com.hr.salarymanagement.attendanceRecord.adapter.in.web;

// adapter.in은 port.in을 호출함
//adapter패키지에 들어있는 모든 클래스들은 package-private 접근 수준으로 둠

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hr.salarymanagement.attendanceRecord.application.port.in.GetAttendanceRecordCommand;
import com.hr.salarymanagement.attendanceRecord.application.port.in.GetAttendanceRecordQuery;
import com.hr.salarymanagement.attendanceRecord.domain.AttendanceRecord;
import com.hr.salarymanagement.common.WebAdapter;
import com.hr.salarymanagement.employee.domain.Employee;

import lombok.RequiredArgsConstructor;

@WebAdapter
@RestController
@RequiredArgsConstructor
class AttendanceRecordController {
	private final GetAttendanceRecordQuery getAttendanceRecordQuery;

	@GetMapping("attendanceRecord/get/{employeeId}/{month}")
	AttendanceRecord getAttendanceRecord(
		@PathVariable("employeeId") Long employeeId,
		@PathVariable("month") int month) {

		GetAttendanceRecordCommand command = new GetAttendanceRecordCommand(
			new Employee.EmployeeId(employeeId), month);
		return getAttendanceRecordQuery.getAttendanceRecord(command);
	}
}
