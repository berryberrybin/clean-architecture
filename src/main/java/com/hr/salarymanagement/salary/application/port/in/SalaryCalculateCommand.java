package com.hr.salarymanagement.salary.application.port.in;


import java.time.Month;

import com.hr.salarymanagement.common.SelfValidating;
import com.hr.salarymanagement.employee.domain.Employee.EmployeeId;
import com.sun.istack.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Value;

// 입력 유효성 검증

@Value
@EqualsAndHashCode(callSuper = false)
public class SalaryCalculateCommand extends SelfValidating<SalaryCalculateCommand> {
	@NotNull
	private final EmployeeId employeeId;

	@NotNull
	private final int searchMonth;

	public SalaryCalculateCommand(EmployeeId employeeId, int searchMonth){
		this.employeeId = employeeId;
		this.searchMonth = searchMonth;
		this.validateSelf();
	}

}
