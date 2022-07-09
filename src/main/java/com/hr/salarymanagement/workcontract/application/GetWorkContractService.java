package com.hr.salarymanagement.workcontract.application;

import com.hr.salarymanagement.employee.domain.Employee;
import com.hr.salarymanagement.workcontract.adapter.port.in.GetWorkContractQuery;
import com.hr.salarymanagement.workcontract.adapter.port.out.LoadWorkContractPort;
import com.hr.salarymanagement.workcontract.domain.WorkContract;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetWorkContractService implements GetWorkContractQuery {

	private final LoadWorkContractPort loadWorkContractPort;

	@Override
	public WorkContract getWorkContract(Employee.EmployeeId employeeId){
		return loadWorkContractPort.loadWorkContract(employeeId);
	}
}
