package com.hr.salarymanagement.company.adapter.port.out;

import com.hr.salarymanagement.company.domain.Company;

public interface LoadCompanyPort {
	Company loadCompanyPort(Company.CompanyId companyId);
}
