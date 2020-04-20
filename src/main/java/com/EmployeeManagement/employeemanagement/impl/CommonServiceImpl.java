package com.EmployeeManagement.employeemanagement.impl;

import com.EmployeeManagement.employeemanagement.entity.ExpenseType;
import com.EmployeeManagement.employeemanagement.entity.LeaveType;
import com.EmployeeManagement.employeemanagement.repository.IExpenseTypeRepository;
import com.EmployeeManagement.employeemanagement.repository.ILeaveTypeRepository;
import com.EmployeeManagement.employeemanagement.service.ICommonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonServiceImpl implements ICommonService {

    private final IExpenseTypeRepository expenseTypeRepository;
    private final ILeaveTypeRepository leaveTypeRepository;

    public CommonServiceImpl(IExpenseTypeRepository commonRepository, ILeaveTypeRepository leaveTypeRepository) {
        this.expenseTypeRepository = commonRepository;
        this.leaveTypeRepository = leaveTypeRepository;
    }


    @Override
    public List<ExpenseType> getAllExpenseTypes() {
        List<ExpenseType> expenseTypes = expenseTypeRepository.findAll();
        return expenseTypes;
    }

    @Override
    public List<LeaveType> getAllLeaveTypes() {
        List<LeaveType> leaveTypes = leaveTypeRepository.findAll();
        return leaveTypes;
    }

}
