package com.EmployeeManagement.employeemanagement.service;

import com.EmployeeManagement.employeemanagement.dto.LeaveDTO;
import com.EmployeeManagement.employeemanagement.entity.LeaveEntity;
import org.springframework.stereotype.Service;

@Service
public interface LeaveService {

    LeaveDTO save(LeaveDTO leave);

    LeaveDTO getByLeaveId(Long leaveId);

}
