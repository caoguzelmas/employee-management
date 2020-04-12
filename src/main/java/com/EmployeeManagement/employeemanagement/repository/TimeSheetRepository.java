package com.EmployeeManagement.employeemanagement.repository;

import com.EmployeeManagement.employeemanagement.dto.TimeSheetDTO;
import com.EmployeeManagement.employeemanagement.entity.TimeSheetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheetEntity, Long> {

}
