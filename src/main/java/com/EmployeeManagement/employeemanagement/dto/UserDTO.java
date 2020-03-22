package com.EmployeeManagement.employeemanagement.dto;

import com.EmployeeManagement.employeemanagement.entity.UserType;

public class UserDTO {

    private Long userId;
    private String userName;
    private String password;
    private UserType userRole;

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

    public UserType getUserRole() {
        return userRole;
    }

    public void setUserRole(UserType userRole) {
        this.userRole = userRole;
    }
}
