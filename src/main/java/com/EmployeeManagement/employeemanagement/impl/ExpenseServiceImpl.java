package com.EmployeeManagement.employeemanagement.impl;

import com.EmployeeManagement.employeemanagement.dto.EmployeeDTO;
import com.EmployeeManagement.employeemanagement.dto.ExpenseDTO;
import com.EmployeeManagement.employeemanagement.dto.UserDTO;
import com.EmployeeManagement.employeemanagement.entity.EmployeeEntity;
import com.EmployeeManagement.employeemanagement.entity.ExpenseEntity;
import com.EmployeeManagement.employeemanagement.entity.ExpenseType;
import com.EmployeeManagement.employeemanagement.repository.EmployeeRepository;
import com.EmployeeManagement.employeemanagement.repository.ExpenseRepository;
import com.EmployeeManagement.employeemanagement.service.EmployeeService;
import com.EmployeeManagement.employeemanagement.service.ExpenseService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepo;
    private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;
    private final ModelMapper modelMapper;

    public ExpenseServiceImpl(ExpenseRepository expenseRepo,ModelMapper modelMapper,
                              EmployeeService employeeService,EmployeeRepository employeeRepository){
        this.expenseRepo = expenseRepo;
        this.modelMapper = modelMapper;
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ExpenseDTO save(ExpenseDTO expense) {
        ExpenseEntity expenseDB = modelMapper.map(expense,ExpenseEntity.class);
        expenseDB.setCreatedAt(new java.util.Date());
        EmployeeDTO employee = employeeService.getById(expense.getEmployee().getId());
        expenseDB.setEmployee(modelMapper.map(employee, EmployeeEntity.class));
        expenseDB.setCreatedBy(employee.getFirstName() + ' ' + employee.getLastName());
        expenseDB = expenseRepo.save(expenseDB);
        return modelMapper.map(expenseDB,ExpenseDTO.class);
    }

    @Override
    public ExpenseDTO getByExpId(Long expenseId) {
        ExpenseEntity expenseDB = modelMapper.map(expenseId, ExpenseEntity.class);
        expenseDB = expenseRepo.getOne(expenseId);
        return modelMapper.map(expenseDB,ExpenseDTO.class);
    }

    @Override
    public ExpenseDTO update(Long id, ExpenseDTO expense) {
        ExpenseEntity expenseFromDB = expenseRepo.getOne(id);
        if (expenseFromDB.getExpenseId() == null) {
            throw new IllegalArgumentException("Expense could not found! ID:" + id);
        }
        expenseFromDB.setExpenseDate(expense.getExpenseDate());
        expenseFromDB.setExpenseType(expense.getExpenseType());
        expenseFromDB.setDescription(expense.getDescription());
        expenseFromDB.setTotalAmount(expense.getTotalAmount());
        expenseFromDB.setUpdatedAt(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()));

        expenseRepo.save(expenseFromDB);
        return modelMapper.map(expenseFromDB, ExpenseDTO.class);
    }

    public Boolean delete(Long id) {
        expenseRepo.deleteById(id);
        return true;
    }

    @Override
    public Page<ExpenseEntity> getExpensesByUserBody(UserDTO user, Pageable pageable) {
        EmployeeEntity employeeFoundByUser = employeeRepository.findEmployeeEntityByeMail(user.geteMail());
        return expenseRepo.getAllByEmployeeEquals(employeeFoundByUser, pageable);
    }

    @Override
    public Page<ExpenseEntity> getAllExpensesWithPagination(Pageable pageable) {
        Page<ExpenseEntity> allExpenses = expenseRepo.findAll(pageable);
        return allExpenses;
    }
}
