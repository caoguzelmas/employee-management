package com.EmployeeManagement.employeemanagement.impl;

import com.EmployeeManagement.employeemanagement.dto.TimeIntervals;
import com.EmployeeManagement.employeemanagement.entity.*;
import com.EmployeeManagement.employeemanagement.repository.*;
import com.EmployeeManagement.employeemanagement.service.ICommonService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommonServiceImpl implements ICommonService {

    private final IExpenseTypeRepository expenseTypeRepository;
    private final ILeaveTypeRepository leaveTypeRepository;
    private final ExpenseRepository expenseRepository;
    private final LeaveRepository leaveRepository;
    private final TimeSheetRepository timeSheetRepository;
    private final IUserRoleTypeRepository userRoleTypeRepository;
    private final IProjectRepository projectRepository;

    public CommonServiceImpl(IExpenseTypeRepository commonRepository, ILeaveTypeRepository leaveTypeRepository,
                             IUserRoleTypeRepository userRoleTypeRepository, IProjectRepository projectRepository,
                             ExpenseRepository expenseRepository, LeaveRepository leaveRepository, TimeSheetRepository timeSheetRepository) {
        this.expenseTypeRepository = commonRepository;
        this.leaveTypeRepository = leaveTypeRepository;
        this.userRoleTypeRepository = userRoleTypeRepository;
        this.projectRepository =  projectRepository;
        this.expenseRepository = expenseRepository;
        this.leaveRepository = leaveRepository;
        this.timeSheetRepository = timeSheetRepository;
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

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public AdminDashboardItems getAdminDashboardItems(Date startingDate, Date endingDate) {
        AdminDashboardItems adminDashboardItems = new AdminDashboardItems();
        adminDashboardItems.setListOfExpenses(expenseRepository.getAllByCreatedAtBetween(startingDate, endingDate));
        adminDashboardItems.setListOfLeaves(leaveRepository.getAllByCreatedAtBetween(startingDate, endingDate));
        adminDashboardItems.setListOfTimeSheets(timeSheetRepository.getAllByCreatedAtBetween(startingDate, endingDate));
        return adminDashboardItems;
    }

}
