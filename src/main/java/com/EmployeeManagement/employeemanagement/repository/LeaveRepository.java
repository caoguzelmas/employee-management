package com.EmployeeManagement.employeemanagement.repository;

import com.EmployeeManagement.employeemanagement.dto.EmployeeDTO;
import com.EmployeeManagement.employeemanagement.entity.EmployeeEntity;
import com.EmployeeManagement.employeemanagement.entity.LeaveEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveEntity,Long> {

    Page<LeaveEntity> getAllByEmployeeEquals(EmployeeEntity employee, Pageable pageable);

    List<LeaveEntity> getAllByCreatedAtBetween(Date startingDate, Date endingDate);
}
