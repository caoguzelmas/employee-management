package com.EmployeeManagement.employeemanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "time_sheets")
public class TimeSheetEntity extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long timeSheetId;

    @Column(name = "time_sheet_date")
    private Date timeSheetDate;

    @Column(name = "hours")
    private Long hours;

    @Column(name = "description")
    private String description;

    @Column(name = "project")
    private String project;

    @JsonBackReference
    @JoinColumn(name = "employee_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmployeeEntity employee;

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Long getTimeSheetId() {
        return timeSheetId;
    }

    public void setTimeSheetId(Long timeSheetId) {
        this.timeSheetId = timeSheetId;
    }

    public Date getTimeSheetDate() {
        return timeSheetDate;
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

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }
}
