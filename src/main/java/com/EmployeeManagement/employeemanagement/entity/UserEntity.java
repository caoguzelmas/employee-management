package com.EmployeeManagement.employeemanagement.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users")
public class UserEntity extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name = "u_name")
    private String userName;

    @Column(name = "pass")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserType userRole;

    @OneToOne
    @JoinColumn(name = "related_employee")
    private EmployeeEntity employee;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Enum getUserRole() {
        return userRole;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public void setUserRole(UserType userRole) {
        this.userRole = userRole;
    }
}
