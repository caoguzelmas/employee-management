package com.EmployeeManagement.employeemanagement.repository;

import com.EmployeeManagement.employeemanagement.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findAll();

}
