package com.hr.salarymanagement.salary.adapter.out.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hr.salarymanagement.employee.domain.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="salary")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryJpaEntity {

	@Id
	@GeneratedValue
	private Long salaryId;

	@Column
	private long employeeId;

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


