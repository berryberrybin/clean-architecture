package com.hr.salarymanagement.adapter.out.persistence;

//adapter패키지에 들어있는 모든 클래스들은 package-private 접근 수준으로 둠

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hr.salarymanagement.domain.Company;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
class EmployeeEntity {

	@Id
	@GeneratedValue
	@Column(name = "employee_id")
	private Long employeeId; // 직원아이디

	@Column
	private String EmployeeName; // 직원이름

	@Column
	private int EmployeeRRN; //ResidentRegistrationNumber 주민등록번호

	@Column
	private Date joinCompanyDate; // 입사일

	@Column
	private Date retirementDate; // 퇴사일

	@Column
	private int numberOfDependents; // 부양가족수

	@JsonManagedReference
	@OneToMany(mappedBy = "attendance_record", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<AttendanceRecordEntity> attendanceRecordEntities = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="company_id")
	private CompanyEntity companyId; // 회사아이디

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="work_contract_id")
	private WorkContractEntity workContractId;

}
