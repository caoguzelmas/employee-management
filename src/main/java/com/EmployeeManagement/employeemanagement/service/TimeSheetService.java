package com.EmployeeManagement.employeemanagement.service;

import com.EmployeeManagement.employeemanagement.dto.TimeSheetDTO;
import com.EmployeeManagement.employeemanagement.entity.TimeSheetEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TimeSheetService {

    TimeSheetDTO save(TimeSheetDTO timeSheet);

    TimeSheetDTO getByTsId(Long id);

    TimeSheetDTO update(Long id, TimeSheetDTO timeSheet);

    Boolean delete(Long id);

    Page<TimeSheetEntity> getTimeSheetsByPagination(Pageable pageable);
}
