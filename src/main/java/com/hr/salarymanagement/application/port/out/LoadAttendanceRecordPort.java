package com.hr.salarymanagement.application.port.out;

import com.hr.salarymanagement.domain.AttendanceRecord;
import com.hr.salarymanagement.domain.Employee;

public interface LoadAttendanceRecordPort {

	AttendanceRecord loadAttendanceRecord(Employee.EmployeeId employeeId, int month);
}
