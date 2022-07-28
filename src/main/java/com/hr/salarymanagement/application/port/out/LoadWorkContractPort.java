package com.hr.salarymanagement.application.port.out;

import com.hr.salarymanagement.domain.WorkContract;
import com.hr.salarymanagement.domain.Employee;

public interface LoadWorkContractPort {

	WorkContract loadWorkContract(WorkContract.WorkContractId workContractId);
}
