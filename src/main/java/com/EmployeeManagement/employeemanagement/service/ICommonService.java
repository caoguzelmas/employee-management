package com.EmployeeManagement.employeemanagement.service;

import com.EmployeeManagement.employeemanagement.dto.TimeIntervals;
import com.EmployeeManagement.employeemanagement.entity.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface ICommonService {
    List<ExpenseType> getAllExpenseTypes();

    List<LeaveType> getAllLeaveTypes();

    List<UserType> getAllUserRoleTypes();

    List<Project> getAllProjects();

    AdminDashboardItems getAdminDashboardItems(Date startingDate, Date endingDate);
}
