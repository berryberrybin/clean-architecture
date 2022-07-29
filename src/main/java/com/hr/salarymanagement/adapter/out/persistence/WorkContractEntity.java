package com.hr.salarymanagement.adapter.out.persistence;

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
import com.hr.salarymanagement.domain.Company;
import com.hr.salarymanagement.domain.Employee;
import com.hr.salarymanagement.domain.WorkContract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//adapter패키지에 들어있는 모든 클래스들은 package-private 접근 수준으로 둠
@Entity
@Table(name="work_contract")
@Data
@AllArgsConstructor
@NoArgsConstructor
class WorkContractEntity {

	@Id
	@GeneratedValue
	@Column(name = "work_contract_Id")
	private Long workContractId;

	@Column
	private int hourlyWage; // 시급

	@Column
	private Double avgWorkingHoursPerDay; // 근로조건 - 1일 평균근로시간

	@Column
	private Double avgWorkingDaysPerWeek; // 근로조건 - 1주 평균근무일수

}
