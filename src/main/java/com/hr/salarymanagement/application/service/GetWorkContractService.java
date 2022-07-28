package com.hr.salarymanagement.application.service;

import com.hr.salarymanagement.domain.Employee;
import com.hr.salarymanagement.application.port.in.GetWorkContractQuery;
import com.hr.salarymanagement.application.port.out.LoadWorkContractPort;
import com.hr.salarymanagement.domain.WorkContract;

import lombok.RequiredArgsConstructor;

//서비스는 인커밍포트 인터페이스 뒤에 숨겨질 수 있으므로 public필요가 없다

@RequiredArgsConstructor
class GetWorkContractService implements GetWorkContractQuery {

	private final LoadWorkContractPort loadWorkContractPort;

	@Override
	public WorkContract getWorkContract(WorkContract.WorkContractId workContractId){
		return loadWorkContractPort.loadWorkContract(workContractId);
	}
}
