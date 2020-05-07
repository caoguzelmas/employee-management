package com.EmployeeManagement.employeemanagement.entity;

import java.util.List;

public class AdminDashboardItems {

    private List<ExpenseEntity> listOfExpenses;

    private List<LeaveEntity> listOfLeaves;

    private List<TimeSheetEntity> listOfTimeSheets;

    public List<ExpenseEntity> getListOfExpenses() {
        return listOfExpenses;
    }

    public void setListOfExpenses(List<ExpenseEntity> listOfExpenses) {
        this.listOfExpenses = listOfExpenses;
    }

    public List<LeaveEntity> getListOfLeaves() {
        return listOfLeaves;
    }

    public void setListOfLeaves(List<LeaveEntity> listOfLeaves) {
        this.listOfLeaves = listOfLeaves;
    }

    public List<TimeSheetEntity> getListOfTimeSheets() {
        return listOfTimeSheets;
    }

    public void setListOfTimeSheets(List<TimeSheetEntity> listOfTimeSheets) {
        this.listOfTimeSheets = listOfTimeSheets;
    }
}
