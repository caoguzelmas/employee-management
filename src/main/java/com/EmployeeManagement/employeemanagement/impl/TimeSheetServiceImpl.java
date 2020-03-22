package com.EmployeeManagement.employeemanagement.impl;

import com.EmployeeManagement.employeemanagement.dto.TimeSheetDTO;
import com.EmployeeManagement.employeemanagement.entity.TimeSheetEntity;
import com.EmployeeManagement.employeemanagement.repository.TimeSheetRepository;
import com.EmployeeManagement.employeemanagement.service.TimeSheetService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TimeSheetServiceImpl implements TimeSheetService {

    private final ModelMapper modelMapper;
    private final TimeSheetRepository timeSheetRepo;

    public TimeSheetServiceImpl(ModelMapper modelMapper, TimeSheetRepository timeSheetRepo) {
        this.timeSheetRepo = timeSheetRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public TimeSheetDTO save(TimeSheetDTO timeSheet) {
        TimeSheetEntity timeSheetDB = modelMapper.map(timeSheet, TimeSheetEntity.class);
        timeSheetDB = timeSheetRepo.save(timeSheetDB);
        return modelMapper.map(timeSheetDB, TimeSheetDTO.class);
    }
}
