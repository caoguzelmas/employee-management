package com.EmployeeManagement.employeemanagement.impl;

import com.EmployeeManagement.employeemanagement.dto.EmployeeDTO;
import com.EmployeeManagement.employeemanagement.dto.TimeSheetDTO;
import com.EmployeeManagement.employeemanagement.entity.EmployeeEntity;
import com.EmployeeManagement.employeemanagement.entity.TimeSheetEntity;
import com.EmployeeManagement.employeemanagement.repository.TimeSheetRepository;
import com.EmployeeManagement.employeemanagement.service.EmployeeService;
import com.EmployeeManagement.employeemanagement.service.TimeSheetService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TimeSheetServiceImpl implements TimeSheetService {

    private final ModelMapper modelMapper;
    private final TimeSheetRepository timeSheetRepo;
    private final EmployeeService employeeService;

    public TimeSheetServiceImpl(ModelMapper modelMapper,EmployeeService employeeService,TimeSheetRepository timeSheetRepo) {
        this.timeSheetRepo = timeSheetRepo;
        this.modelMapper = modelMapper;
        this.employeeService = employeeService;
    }

    @Override
    public TimeSheetDTO save(TimeSheetDTO timeSheet) {
        TimeSheetEntity timeSheetDB = modelMapper.map(timeSheet, TimeSheetEntity.class);
        EmployeeDTO employee = employeeService.getById(timeSheet.getEmployee().getId());
        timeSheetDB.setEmployee(modelMapper.map(employee, EmployeeEntity.class));
        timeSheetDB.setCreatedAt(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()));
        timeSheetDB = timeSheetRepo.save(timeSheetDB);
        return modelMapper.map(timeSheetDB, TimeSheetDTO.class);
    }

    @Override
    public TimeSheetDTO getByTsId(Long id) {
        TimeSheetEntity timeSheetDB = timeSheetRepo.getOne(id);
        return modelMapper.map(timeSheetDB,TimeSheetDTO.class);
    }

    @Override
    public TimeSheetDTO update(Long id, TimeSheetDTO timeSheet) {
        TimeSheetEntity timeSheetFromDB = timeSheetRepo.getOne(id);
        if (timeSheetFromDB.getTimeSheetId() == null) {
            throw new IllegalArgumentException("Employee could not found! ID:" + id);
        }

        timeSheetFromDB.setUpdatedAt(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()));
        timeSheetFromDB.setHours(timeSheet.getHours());
        timeSheetFromDB.setStartDate(timeSheet.getStartDate());
        timeSheetFromDB.setEndDate(timeSheet.getEndDate());
        timeSheetFromDB.setDescription(timeSheet.getDescription());

        timeSheetRepo.save(timeSheetFromDB);
        return modelMapper.map(timeSheetFromDB, TimeSheetDTO.class);
    }

    public Boolean delete(Long id) {
        timeSheetRepo.deleteById(id);
        return true;
    }

    @Override
    public Page<TimeSheetEntity> getTimeSheetsByPagination(Pageable pageable) {
        Page<TimeSheetEntity> allTimeSheetsPaged = timeSheetRepo.findAll(pageable);
        return allTimeSheetsPaged;
    }
}
