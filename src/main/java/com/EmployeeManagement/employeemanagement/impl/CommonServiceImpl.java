package com.EmployeeManagement.employeemanagement.impl;

import com.EmployeeManagement.employeemanagement.entity.ExpenseType;
import com.EmployeeManagement.employeemanagement.entity.LeaveType;
import com.EmployeeManagement.employeemanagement.entity.UserType;
import com.EmployeeManagement.employeemanagement.repository.IExpenseTypeRepository;
import com.EmployeeManagement.employeemanagement.repository.ILeaveTypeRepository;
import com.EmployeeManagement.employeemanagement.repository.IUserRoleTypeRepository;
import com.EmployeeManagement.employeemanagement.service.ICommonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonServiceImpl implements ICommonService {

    private final IExpenseTypeRepository expenseTypeRepository;
    private final ILeaveTypeRepository leaveTypeRepository;
    private final IUserRoleTypeRepository userRoleTypeRepository;

    public CommonServiceImpl(IExpenseTypeRepository commonRepository, ILeaveTypeRepository leaveTypeRepository,
                             IUserRoleTypeRepository userRoleTypeRepository) {
        this.expenseTypeRepository = commonRepository;
        this.leaveTypeRepository = leaveTypeRepository;
        this.userRoleTypeRepository = userRoleTypeRepository;
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

    @Override
    public List<UserType> getAllUserRoleTypes() {
        List<UserType> userTypes = userRoleTypeRepository.findAll();
        return userTypes;
    }

}
