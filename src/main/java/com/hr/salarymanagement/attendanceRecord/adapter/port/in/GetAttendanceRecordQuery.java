package com.hr.salarymanagement.attendanceRecord.adapter.port.in;

import com.hr.salarymanagement.attendanceRecord.domain.AttendanceRecord;
import com.hr.salarymanagement.employee.domain.Employee;

public interface GetAttendanceRecordQuery {
	AttendanceRecord getAttendanceRecord(Employee.EmployeeId employeeId);
}
