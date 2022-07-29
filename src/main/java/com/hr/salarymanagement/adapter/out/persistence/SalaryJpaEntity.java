package com.hr.salarymanagement.adapter.out.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//adapter패키지에 들어있는 모든 클래스들은 package-private 접근 수준으로 둠

@Entity
@Table(name="salary")
@Data
@AllArgsConstructor
@NoArgsConstructor
class SalaryJpaEntity {

	@Id
	@GeneratedValue
	private Long salaryId;

	@Column
	private Long employeeId;

	@Column
	private int monthOfSalary;

	@Column
	private int totalSalary;

	public SalaryJpaEntity(long employeeId, int monthOfSalary, int totalSalary){
		this.employeeId=employeeId;
		this.monthOfSalary =monthOfSalary;
		this.totalSalary = totalSalary;
	}

}


