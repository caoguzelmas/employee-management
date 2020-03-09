package com.EmployeeManagement.employeemanagement.dto;

import com.EmployeeManagement.employeemanagement.entity.ExpenseEntity;
import com.EmployeeManagement.employeemanagement.entity.LeaveEntity;

import java.util.List;

public class EmployeeDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String title;
    private String department;
    private String eMail;
    private String phoneNumber;
    private String photo;
    private List<LeaveEntity> leave;
    private List<ExpenseEntity> expense;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<LeaveEntity> getLeave() {
        return leave;
    }

    public void setLeave(List<LeaveEntity> leave) {
        this.leave = leave;
    }

    public List<ExpenseEntity> getExpense() {
        return expense;
    }

    public void setExpense(List<ExpenseEntity> expense) {
        this.expense = expense;
    }
}
