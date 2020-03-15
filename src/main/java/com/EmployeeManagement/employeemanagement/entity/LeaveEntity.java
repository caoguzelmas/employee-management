package com.EmployeeManagement.employeemanagement.entity;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "leave_type")
    private LeaveType leaveType;

    @JoinColumn(name = "leave_employee")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private EmployeeEntity employee;

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

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }
}
