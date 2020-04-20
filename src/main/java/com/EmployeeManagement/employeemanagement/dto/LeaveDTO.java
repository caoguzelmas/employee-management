package com.EmployeeManagement.employeemanagement.dto;

import com.EmployeeManagement.employeemanagement.entity.EmployeeEntity;
import com.EmployeeManagement.employeemanagement.entity.LeaveType;

import java.util.Date;

public class LeaveDTO {
    private Long leaveID;
    private Date startDate;
    private Date endDate;
    private String leaveType;
    private String createdAt;
    private String updatedAt;
    private EmployeeDTO employee;

    public Long getLeaveID() {
        return leaveID;
    }

    public void setLeaveID(Long leaveID) {
        this.leaveID = leaveID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }
}
