package com.EmployeeManagement.employeemanagement.repository;

import com.EmployeeManagement.employeemanagement.entity.ExpenseType;
import com.EmployeeManagement.employeemanagement.entity.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILeaveTypeRepository extends JpaRepository<LeaveType, Long> {

    List<LeaveType> findAll();

}
