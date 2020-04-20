package com.EmployeeManagement.employeemanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="expense_types")
public class ExpenseType implements Serializable {

    @Id
    private Long expenseTypeID;

    @Column(name = "short_code")
    private String shortCode;

    @Column(name = "name")
    private String name;

    public Long getExpenseTypeID() {
        return expenseTypeID;
    }

    public void setExpenseTypeID(Long expenseTypeID) {
        this.expenseTypeID = expenseTypeID;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
