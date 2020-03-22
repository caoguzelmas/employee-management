package com.EmployeeManagement.employeemanagement.service;

import com.EmployeeManagement.employeemanagement.dto.UserDTO;
import com.EmployeeManagement.employeemanagement.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserDTO save(UserDTO user);

    UserDTO getByUserID(Long userId);

    UserDTO update(Long id, UserDTO user);

    UserDTO getByUserNameAndUserRole(UserDTO user);
}
