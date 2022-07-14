package com.hr.salarymanagement.attendanceRecord.application.port.in;

import com.hr.salarymanagement.attendanceRecord.domain.AttendanceRecord;
import com.hr.salarymanagement.employee.domain.Employee;

public interface GetAttendanceRecordQuery {
	AttendanceRecord getAttendanceRecord(Employee.EmployeeId employeeId, int month);
}
