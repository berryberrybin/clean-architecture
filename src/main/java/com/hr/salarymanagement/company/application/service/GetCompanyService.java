package com.hr.salarymanagement.company.application.service;

import com.hr.salarymanagement.company.application.port.in.GetCompanyQuery;
import com.hr.salarymanagement.company.application.port.out.LoadCompanyPort;
import com.hr.salarymanagement.company.domain.Company;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetCompanyService implements GetCompanyQuery {
	private final LoadCompanyPort loadCompanyPort;

	public Company getCompany(Company.CompanyId companyId){
		return loadCompanyPort.loadCompanyPort(companyId);
	}
}
