package com.hr.salarymanagement.attendanceRecord.application.port.out;

import com.hr.salarymanagement.attendanceRecord.domain.AttendanceRecord;
import com.hr.salarymanagement.employee.domain.Employee;

public interface LoadAttendanceRecordPort {

	AttendanceRecord loadAttendanceRecord(Employee.EmployeeId employeeId, int month);
}
