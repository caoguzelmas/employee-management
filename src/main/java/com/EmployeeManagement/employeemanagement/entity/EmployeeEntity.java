package com.EmployeeManagement.employeemanagement.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/* DB ile tüm bağlantı bu class üzerinden gerçekleşir
*  DB Column isimleri buradan seçilir. */


@Entity
@Table(name="employee")
public class EmployeeEntity extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "title")
    private String title;

    @Column(name = " department")
    private String department;

    @Column(name = "email", unique = true)
    private String eMail;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "photo")
    private String photo;

    @Column(name = "days_left")
    private Long daysLeft;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<LeaveEntity> leave;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<ExpenseEntity> expense;

    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "employee")
    private UserEntity user;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<TimeSheetEntity> timeSheets;

    public Long getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(Long daysLeft) {
        this.daysLeft = daysLeft;
    }

    public List<TimeSheetEntity> getTimeSheets() {
        return timeSheets;
    }

    public void setTimeSheets(List<TimeSheetEntity> timeSheets) {
        this.timeSheets = timeSheets;
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

    public Long getId() {
        return id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
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
}
