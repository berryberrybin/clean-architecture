package com.hr.salarymanagement.application.port.in;

import com.hr.salarymanagement.domain.WorkContract;
import com.hr.salarymanagement.domain.Employee;

public interface GetWorkContractQuery {
	WorkContract getWorkContract(WorkContract.WorkContractId workContractId);
}
