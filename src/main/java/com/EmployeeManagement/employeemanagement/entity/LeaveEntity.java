package com.EmployeeManagement.employeemanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="leaves")
@NoArgsConstructor
@AllArgsConstructor
public class LeaveEntity extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "leave_id")
    private Long leaveID;

    @Column(name = "s_date")
    private Date startDate;

    @Column(name = "e_date")
    private Date endDate;

    @Column(name = "leave_type")
    private String leaveType;

    @Column(name = "description")
    private String description;

    @JsonBackReference
    @JoinColumn(name = "employee_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmployeeEntity employee;

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
}
