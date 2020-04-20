package com.EmployeeManagement.employeemanagement.dto;

import com.EmployeeManagement.employeemanagement.entity.ExpenseType;

public class ExpenseDTO {
    private Long expenseId;
    private Long expenseMonth;
    private Long expenseYear;
    private Double totalAmount;
    private String updatedAt;
    private String createdAt;
    private EmployeeDTO employee;
    private String expenseType;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Long expenseId) {
        this.expenseId = expenseId;
    }

    public Long getExpenseMonth() {
        return expenseMonth;
    }

    public void setExpenseMonth(Long expenseMonth) {
        this.expenseMonth = expenseMonth;
    }

    public Long getExpenseYear() {
        return expenseYear;
    }

    public void setExpenseYear(Long expenseYear) {
        this.expenseYear = expenseYear;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
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

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }
}
