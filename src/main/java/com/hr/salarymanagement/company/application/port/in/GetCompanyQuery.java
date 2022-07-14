package com.hr.salarymanagement.company.application.port.in;

import com.hr.salarymanagement.company.domain.Company;
import com.hr.salarymanagement.employee.domain.Employee;

public interface GetCompanyQuery {
	Company getCompany(Company.CompanyId companyId);
}
