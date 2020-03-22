package com.EmployeeManagement.employeemanagement.entity;

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

    @Column(name = "email")
    private String eMail;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "photo")
    private String photo;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "leave_req")
    private List<LeaveEntity> leave;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "expense_req")
    private List<ExpenseEntity> expense;

    @OneToOne
    @JoinColumn(name = "related_user")
    private UserEntity user;

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
