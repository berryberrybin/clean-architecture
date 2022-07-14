package com.hr.salarymanagement.workcontract.application.port.in;

import com.hr.salarymanagement.workcontract.domain.WorkContract;
import com.hr.salarymanagement.employee.domain.Employee;

public interface GetWorkContractQuery {
	WorkContract getWorkContract(Employee.EmployeeId employeeId);
}
