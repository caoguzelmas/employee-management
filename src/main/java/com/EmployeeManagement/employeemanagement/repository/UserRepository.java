package com.EmployeeManagement.employeemanagement.repository;

import com.EmployeeManagement.employeemanagement.entity.UserEntity;
import com.EmployeeManagement.employeemanagement.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity getByUserNameAndUserRole(String userName, String N);

    UserEntity findByuserName(String userName);
}
