package com.EmployeeManagement.employeemanagement.service;

import com.EmployeeManagement.employeemanagement.dto.EmployeeDTO;
import com.EmployeeManagement.employeemanagement.dto.LeaveDTO;
import com.EmployeeManagement.employeemanagement.dto.UserDTO;
import com.EmployeeManagement.employeemanagement.entity.LeaveEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface LeaveService {

    LeaveDTO save(LeaveDTO leave);

    LeaveDTO getByLeaveId(Long leaveId);

    LeaveDTO update(Long id, LeaveDTO leave);

    Boolean delete(Long id);

    Page<LeaveEntity> getLeavesByPagination(Pageable pageable);

    Page<LeaveEntity> getLeavesByEmployeeBody(UserDTO user, Pageable pageable);
}
