package com.EmployeeManagement.employeemanagement.dto;


import java.util.Date;

public class TimeSheetDTO {

    private Long timeSheetId;
    private Date timeSheetDate;
    private Long hours;
    private String description;
    private String createdAt;
    private String updatedAt;
    private EmployeeDTO employee;
    private String project;

    public Long getTimeSheetId() {
        return timeSheetId;
    }

    public void setTimeSheetId(Long timeSheetId) {
        this.timeSheetId = timeSheetId;
    }

    public Date getTimeSheetDate() {
        return timeSheetDate;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void setTimeSheetDate(Date timeSheetDate) {
        this.timeSheetDate = timeSheetDate;
    }

    public Long getHours() {
        return hours;
    }

    public void setHours(Long hours) {
        this.hours = hours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
