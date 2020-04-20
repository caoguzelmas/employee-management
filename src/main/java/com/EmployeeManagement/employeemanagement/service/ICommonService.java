package com.EmployeeManagement.employeemanagement.service;

import com.EmployeeManagement.employeemanagement.entity.ExpenseType;
import com.EmployeeManagement.employeemanagement.entity.LeaveType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICommonService {
    List<ExpenseType> getAllExpenseTypes();

    List<LeaveType> getAllLeaveTypes();
}
