package com.hr.salarymanagement.application.port.in;

import com.hr.salarymanagement.domain.Company;

public interface GetCompanyQuery {
	Company getCompany(Company.CompanyId companyId);
}
