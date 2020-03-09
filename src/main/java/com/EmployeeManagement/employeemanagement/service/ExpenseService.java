package com.EmployeeManagement.employeemanagement.service;

import com.EmployeeManagement.employeemanagement.dto.ExpenseDTO;
import com.EmployeeManagement.employeemanagement.entity.ExpenseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ExpenseService {

    ExpenseDTO save(ExpenseDTO expense);

    ExpenseDTO getByExpId(Long exenseId);
}
