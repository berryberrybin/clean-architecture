package com.hr.salarymanagement.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Company {

	private final CompanyId companyId;
	private final String companyName;
	private final boolean isUnderFiveEmployee; // 5인미만사업장여부 true일 경우 급여달라짐  (5명 포함X)

	@Value
	public static class CompanyId{
		private Long value;
	}
}
