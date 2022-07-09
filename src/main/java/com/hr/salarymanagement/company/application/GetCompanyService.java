package com.hr.salarymanagement.company.application;

import com.hr.salarymanagement.company.adapter.port.in.GetCompanyQuery;
import com.hr.salarymanagement.company.adapter.port.out.LoadCompanyPort;
import com.hr.salarymanagement.company.domain.Company;
import com.hr.salarymanagement.workcontract.adapter.port.out.LoadWorkContractPort;
import com.hr.salarymanagement.workcontract.domain.WorkContract;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetCompanyService implements GetCompanyQuery {
	private final LoadCompanyPort loadCompanyPort;

	public Company getCompany(Company.CompanyId companyId){
		return loadCompanyPort.loadCompanyPort(companyId);
	}
}
