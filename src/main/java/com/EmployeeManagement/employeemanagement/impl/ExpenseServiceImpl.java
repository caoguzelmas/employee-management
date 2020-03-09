package com.EmployeeManagement.employeemanagement.impl;

import com.EmployeeManagement.employeemanagement.dto.ExpenseDTO;
import com.EmployeeManagement.employeemanagement.entity.ExpenseEntity;
import com.EmployeeManagement.employeemanagement.repository.ExpenseRepository;
import com.EmployeeManagement.employeemanagement.service.ExpenseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepo;
    private final ModelMapper modelMapper;

    public ExpenseServiceImpl(ExpenseRepository expenseRepo,ModelMapper modelMapper){
        this.expenseRepo = expenseRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public ExpenseDTO save(ExpenseDTO expense) {
        ExpenseEntity expenseDB = modelMapper.map(expense,ExpenseEntity.class);
        expenseDB = expenseRepo.save(expenseDB);
        return modelMapper.map(expenseDB,ExpenseDTO.class);
    }

    @Override
    public ExpenseDTO getByExpId(Long expenseId) {
        ExpenseEntity expenseDB = modelMapper.map(expenseId, ExpenseEntity.class);
        expenseDB = expenseRepo.getOne(expenseId);
        return modelMapper.map(expenseDB,ExpenseDTO.class);
    }
}
