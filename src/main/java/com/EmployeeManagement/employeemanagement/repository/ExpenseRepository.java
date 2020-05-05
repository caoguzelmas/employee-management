package com.EmployeeManagement.employeemanagement.repository;

import com.EmployeeManagement.employeemanagement.entity.EmployeeEntity;
import com.EmployeeManagement.employeemanagement.entity.ExpenseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity,Long> {

    List<ExpenseEntity> findAll(Sort sort);

    Page<ExpenseEntity> getAllByEmployeeEquals(EmployeeEntity employee, Pageable pageable);

    List<ExpenseEntity> getAllByCreatedAtBetween(Date startingDate, Date endingDate);
}