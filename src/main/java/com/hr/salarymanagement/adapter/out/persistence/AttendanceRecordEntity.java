package com.hr.salarymanagement.adapter.out.persistence;

//adapter패키지에 들어있는 모든 클래스들은 package-private 접근 수준으로 둠

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hr.salarymanagement.domain.Employee;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="attendance_record")
@Data
@AllArgsConstructor
@NoArgsConstructor
class AttendanceRecordEntity {

	@Id
	@GeneratedValue
	@Column(name = "attendance_record_id")
	private Long attendanceRecordId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="employee_id")
	@JsonBackReference
	private EmployeeEntity employeeId;

	@Column
	private int monthOfAttendanceRecord;

	@Column
	private int unpaidDaysOff; // 무급추가휴무일수 - 결근 등

	@Column
	private int paidDaysOff; // 유급추가휴무일수 - 8시간 추가근무조건에 대해서는 급여 지급 안함


	@Column
	private int sumOverTimeWorkingHours; // 월추가연장근로시간 (5인이상일때 시간당 1.5배지급) => 월급 + (월추가연장근로시간 * 시급 * 0.5배)

	@Column
	private int sumNightWorkingHours; // 월야간근로시간 (5인이상일때 시간당 2배지급) => 월급 + (월추가연장근로시간 * 시급 * 1배)
	// 현재 계산에서 5인미만 사업장일 경우도 고려하기 위해 -> 기본급에 (모든 근무시간 * 시급)으로 계산되어있으므로 나머지 가산부분만 추가로 더하면 됨

}
