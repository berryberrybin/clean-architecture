package com.hr.salarymanagement.application.service;

import com.hr.salarymanagement.application.port.in.GetCompanyQuery;
import com.hr.salarymanagement.application.port.out.LoadCompanyPort;
import com.hr.salarymanagement.domain.Company;

import lombok.RequiredArgsConstructor;

//서비스는 인커밍포트 인터페이스 뒤에 숨겨질 수 있으므로 public필요가 없다
@RequiredArgsConstructor
class GetCompanyService implements GetCompanyQuery {

	private final LoadCompanyPort loadCompanyPort;
	public Company getCompany(Company.CompanyId companyId){
		return loadCompanyPort.loadCompanyPort(companyId);
	}

}

// 서비스는 어댑터에 의해 구현된 아웃고잉포트인 LoadCompanyPort를 호출
// LoadCompnayPort는 아웃고잉포트는 adapter인 CompanyPersistenceAdapter에 의해 구현됨
//  class CompanyPersistenceAdapter implements LoadCompanyPort { ... }
