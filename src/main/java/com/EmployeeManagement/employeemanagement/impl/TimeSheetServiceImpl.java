package com.EmployeeManagement.employeemanagement.impl;

import com.EmployeeManagement.employeemanagement.dto.EmployeeDTO;
import com.EmployeeManagement.employeemanagement.dto.TimeSheetAndUserBody;
import com.EmployeeManagement.employeemanagement.dto.TimeSheetDTO;
import com.EmployeeManagement.employeemanagement.dto.UserDTO;
import com.EmployeeManagement.employeemanagement.entity.EmployeeEntity;
import com.EmployeeManagement.employeemanagement.entity.TimeSheetEntity;
import com.EmployeeManagement.employeemanagement.repository.EmployeeRepository;
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
import java.util.Date;
import java.util.List;

@Service
public class TimeSheetServiceImpl implements TimeSheetService {

    private final ModelMapper modelMapper;
    private final TimeSheetRepository timeSheetRepo;
    private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;

    public TimeSheetServiceImpl(ModelMapper modelMapper,EmployeeService employeeService,TimeSheetRepository timeSheetRepo,
                                EmployeeRepository employeeRepository) {
        this.timeSheetRepo = timeSheetRepo;
        this.modelMapper = modelMapper;
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public TimeSheetDTO save(TimeSheetDTO timeSheet) {
        TimeSheetEntity timeSheetDB = modelMapper.map(timeSheet, TimeSheetEntity.class);
        EmployeeDTO employee = employeeService.getById(timeSheet.getEmployee().getId());
        timeSheetDB.setEmployee(modelMapper.map(employee, EmployeeEntity.class));
        timeSheetDB.setCreatedAt(new java.util.Date());
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
        timeSheetFromDB.setTimeSheetDate(timeSheet.getTimeSheetDate());
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

    @Override
    public List<TimeSheetEntity> getTimeSheetsOfEmployeeAsList(UserDTO user) {
        EmployeeEntity employeeFoundByUser = employeeRepository.findEmployeeEntityByeMail(user.geteMail());
        return timeSheetRepo.getAllByEmployeeEquals(employeeFoundByUser);
    }

    @Override
    public TimeSheetEntity getTimeSheetByDate(TimeSheetAndUserBody timeSheetAndUserBody) {
        EmployeeEntity employeeFoundByEmail = employeeRepository.findEmployeeEntityByeMail(timeSheetAndUserBody.getUser().geteMail());
        return timeSheetRepo.findTimeSheetEntityByTimeSheetDateAndEmployeeEquals(timeSheetAndUserBody.getTimeSheetBody().getTimeSheetDate(), employeeFoundByEmail);
    }

    @Override
    public List<TimeSheetEntity> getTimeSheetsOfEmployeeById(Long employeeId) {
        EmployeeEntity employeeFoundByEmployeeId = employeeRepository.getById(employeeId);
        return timeSheetRepo.getAllByEmployeeEquals(employeeFoundByEmployeeId);
    }
}
