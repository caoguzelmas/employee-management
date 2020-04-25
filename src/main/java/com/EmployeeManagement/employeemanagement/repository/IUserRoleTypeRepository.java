package com.EmployeeManagement.employeemanagement.repository;

import com.EmployeeManagement.employeemanagement.entity.LeaveType;
import com.EmployeeManagement.employeemanagement.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRoleTypeRepository extends JpaRepository<UserType, Long> {

    List<UserType> findAll();
}
