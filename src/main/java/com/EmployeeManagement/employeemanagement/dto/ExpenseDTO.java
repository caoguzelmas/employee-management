package com.EmployeeManagement.employeemanagement.dto;

import com.EmployeeManagement.employeemanagement.entity.EmployeeEntity;

public class ExpenseDTO {
    private Long expense_id;
    private String expenseMonth;
    private String expenseYear;
    private Float totalAmount;
    private String updatedAt;
    private String createdAt;
    private EmployeeDTO employee;

    public Long getExpense_id() {
        return expense_id;
    }

    public void setExpense_id(Long expense_id) {
        this.expense_id = expense_id;
    }

    public String getExpenseMonth() {
        return expenseMonth;
    }

    public void setExpenseMonth(String expenseMonth) {
        this.expenseMonth = expenseMonth;
    }

    public String getExpenseYear() {
        return expenseYear;
    }

    public void setExpenseYear(String expenseYear) {
        this.expenseYear = expenseYear;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }
}
