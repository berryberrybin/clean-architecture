package com.hr.salarymanagement.adapter.out.persistence;

//adapter패키지에 들어있는 모든 클래스들은 package-private 접근 수준으로 둠

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hr.salarymanagement.domain.Company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="company")
@Data
@AllArgsConstructor
@NoArgsConstructor
class CompanyEntity {

	@Id
	@GeneratedValue
	@Column(name = "company_id")
	private Long companyId;

	@Column
	private String companyName;

	@Column
	private boolean isUnderFiveEmployee; // 5인미만사업장여부 true일 경우 급여달라짐  (5명 포함X)

}
