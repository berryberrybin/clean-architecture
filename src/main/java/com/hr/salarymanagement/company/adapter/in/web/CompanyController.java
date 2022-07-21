package com.hr.salarymanagement.company.adapter.in.web;

// adapter.in은 port.in을 호출함
//adapter패키지에 들어있는 모든 클래스들은 package-private 접근 수준으로 둠

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hr.salarymanagement.common.WebAdapter;
import com.hr.salarymanagement.company.application.port.in.GetCompanyQuery;
import com.hr.salarymanagement.company.domain.Company;

import lombok.RequiredArgsConstructor;

@WebAdapter
@RestController
@RequiredArgsConstructor
class CompanyController {

	private final GetCompanyQuery getCompanyQuery;

	@GetMapping("company/get/{companyId}")
	Company getCompany(
		@PathVariable("companyId") Long companyId
	){
		return getCompanyQuery.getCompany(new Company.CompanyId(companyId));
		// Long으로 받은것을 CompnayId타입으로 받아야 함 ??
	}


}
