package com.EmployeeManagement.employeemanagement.service;

import com.EmployeeManagement.employeemanagement.dto.TimeSheetDTO;
import org.springframework.stereotype.Service;

@Service
public interface TimeSheetService {

    TimeSheetDTO save(TimeSheetDTO timeSheet);


}
