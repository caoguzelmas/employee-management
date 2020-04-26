package com.EmployeeManagement.employeemanagement.dto;

import lombok.Data;

@Data
public class TokenResponse {

    private String userName;
    private String token;
    private String userRole;

    public TokenResponse(String userName, String token, String userRole) {
        this.userName = userName;
        this.token = token;
        this.userRole = userRole;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
