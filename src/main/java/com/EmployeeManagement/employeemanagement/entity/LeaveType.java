package com.EmployeeManagement.employeemanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "leave_types")
public class LeaveType implements Serializable {

    @Id
    private Long leaveTypeID;

    @Column(name = "short_code")
    private String shortCode;

    @Column(name = "name")
    private String name;

    public Long getLeaveTypeID() {
        return leaveTypeID;
    }

    public void setLeaveTypeID(Long leaveTypeID) {
        this.leaveTypeID = leaveTypeID;
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
