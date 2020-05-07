package com.EmployeeManagement.employeemanagement.service;

import com.EmployeeManagement.employeemanagement.dto.ExpenseDTO;
import com.EmployeeManagement.employeemanagement.dto.UserDTO;
import com.EmployeeManagement.employeemanagement.entity.ExpenseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface ExpenseService {

    ExpenseDTO save(ExpenseDTO expense);

    ExpenseDTO getByExpId(Long expenseId);

    ExpenseDTO update(Long id, ExpenseDTO expense);

    Boolean delete(Long id);

    Page<ExpenseEntity> getExpensesByUserBody(UserDTO user, Pageable pageable);

    Page<ExpenseEntity> getAllExpensesWithPagination(Pageable pageable);
}
