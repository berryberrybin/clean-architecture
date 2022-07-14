package com.hr.salarymanagement.workcontract.application.port.out;

import com.hr.salarymanagement.workcontract.domain.WorkContract;
import com.hr.salarymanagement.employee.domain.Employee;

public interface LoadWorkContractPort {

	WorkContract loadWorkContract(Employee.EmployeeId employeeId);
}
