package com.EmployeeManagement.employeemanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "user_role_types")
public class UserType implements Serializable {

    @Id
    private Long userRoleTypeID;

    @Column(name = "short_code")
    private String shortCode;

    @Column(name = "name")
    private String name;

    public Long getUserRoleTypeID() {
        return userRoleTypeID;
    }

    public void setUserRoleTypeID(Long userRoleTypeID) {
        this.userRoleTypeID = userRoleTypeID;
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
