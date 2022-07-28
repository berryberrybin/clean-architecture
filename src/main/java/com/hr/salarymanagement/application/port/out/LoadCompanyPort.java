package com.hr.salarymanagement.application.port.out;

import com.hr.salarymanagement.domain.Company;

public interface LoadCompanyPort {
	Company loadCompanyPort(Company.CompanyId companyId);
}
