package com.EmployeeManagement.employeemanagement.entity;

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
    private Long expense_id;

    @Column(name = "exp_month")
    private String expenseMonth;

    @Column(name = "exp_year")
    private String expenseYear;

    @Column(name = "total_amount")
    private Float totalAmount;


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
}
