package com.EmployeeManagement.employeemanagement.dto;

import com.EmployeeManagement.employeemanagement.entity.UserEntity;
import lombok.Data;

@Data
public class TokenResponse {

    UserEntity user;
    private String token;

    public TokenResponse(UserEntity user, String token) {
        this.user = user;
        this.token = token;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
