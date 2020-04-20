package com.EmployeeManagement.employeemanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="expenses")
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseEntity extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "exp_id")
    private Long expenseId;

    @Column(name = "exp_month")
    private Long expenseMonth;

    @Column(name = "exp_year")
    private Long expenseYear;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "description")
    private String description;

    @Column(name = "expense_type")
    private String expenseType;

    @JsonBackReference
    @JoinColumn(name = "employee_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmployeeEntity employee;


    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

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

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }
}
