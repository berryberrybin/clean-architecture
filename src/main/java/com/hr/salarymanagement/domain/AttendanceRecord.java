package com.hr.salarymanagement.domain;

import org.hibernate.annotations.ColumnDefault;

import com.hr.salarymanagement.domain.Employee.EmployeeId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

// 근태기록
@AllArgsConstructor
@Data
public class AttendanceRecord {

	private final AttendanceRecordId attendanceRecordId;
	private final int monthOfAttendanceRecord;

	@ColumnDefault("0")
	private final int unpaidDaysOff; // 무급추가휴무일수 - 결근 등

	@ColumnDefault("0")
	private final int paidDaysOff; // 유급추가휴무일수 - 8시간 추가근무조건에 대해서는 급여 지급 안함

	private final int sumOverTimeWorkingHours; // 월추가연장근로시간 (5인이상일때 시간당 1.5배지급) => 월급 + (월추가연장근로시간 * 시급 * 0.5배)
	private final int sumNightWorkingHours; // 월야간근로시간 (5인이상일때 시간당 2배지급) => 월급 + (월추가연장근로시간 * 시급 * 1배)
	// 현재 계산에서 5인미만 사업장일 경우도 고려하기 위해 -> 기본급에 (모든 근무시간 * 시급)으로 계산되어있으므로 나머지 가산부분만 추가로 더하면 됨

	@Value
	public static class AttendanceRecordId{
		private Long value;
	}
}
