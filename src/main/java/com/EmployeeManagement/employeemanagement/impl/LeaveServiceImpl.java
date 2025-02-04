package com.EmployeeManagement.employeemanagement.impl;

import com.EmployeeManagement.employeemanagement.dto.EmployeeDTO;
import com.EmployeeManagement.employeemanagement.dto.LeaveDTO;
import com.EmployeeManagement.employeemanagement.dto.UserDTO;
import com.EmployeeManagement.employeemanagement.entity.EmployeeEntity;
import com.EmployeeManagement.employeemanagement.entity.LeaveEntity;
import com.EmployeeManagement.employeemanagement.repository.EmployeeRepository;
import com.EmployeeManagement.employeemanagement.repository.LeaveRepository;
import com.EmployeeManagement.employeemanagement.service.EmployeeService;
import com.EmployeeManagement.employeemanagement.service.LeaveService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {

    private final LeaveRepository leaveRepo;
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final EmployeeService employeeService;

    public LeaveServiceImpl(LeaveRepository leaveRepo, ModelMapper modelMapper,EmployeeService employeeService,EmployeeRepository employeeRepository){
        this.leaveRepo = leaveRepo;
        this.modelMapper = modelMapper;
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }


    @Override
    public LeaveDTO save(LeaveDTO leave) {
        LeaveEntity leaveDB = modelMapper.map(leave, LeaveEntity.class);
        EmployeeDTO employee =  employeeService.getById(leave.getEmployee().getId());
        leaveDB.setEmployee(modelMapper.map(employee, EmployeeEntity.class));
        leaveDB.setCreatedAt(new java.util.Date());
        leaveDB.setCreatedBy(employee.getFirstName() + ' ' + employee.getLastName());
        leaveDB = leaveRepo.save(leaveDB);
        return modelMapper.map(leaveDB,LeaveDTO.class);
    }

    @Override
    public LeaveDTO getByLeaveId(Long leaveId) {
        LeaveEntity leaveDB = leaveRepo.getOne(leaveId);
        return modelMapper.map(leaveDB, LeaveDTO.class);
    }

    @Override
    public LeaveDTO update(Long id, LeaveDTO leave) {
        LeaveEntity leaveFromDB = leaveRepo.getOne(id);
        if (leaveFromDB.getLeaveID() == null) {
            throw new IllegalArgumentException("Leave could not found! ID:" + id);
        }

        leaveFromDB.setLeaveType(leave.getLeaveType());
        leaveFromDB.setStartDate(leave.getStartDate());
        leaveFromDB.setEndDate(leave.getEndDate());
        leaveFromDB.setDescription(leave.getDescription());
        leaveFromDB.setRequestedNumberOfDays(leave.getRequestedNumberOfDays());
        leaveFromDB.setUpdatedAt(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()));

        leaveRepo.save(leaveFromDB);
        return modelMapper.map(leaveFromDB, LeaveDTO.class);
    }

    public Boolean delete(Long id) {
        leaveRepo.deleteById(id);
        return true;
    }

    @Override
    public Page<LeaveEntity> getLeavesByPagination(Pageable pageable) {
        return leaveRepo.findAll(pageable);
    }

    @Override
    public Page<LeaveEntity> getLeavesByEmployeeBody(UserDTO user, Pageable pageable) {
        EmployeeEntity employeeFoundByUser = employeeRepository.findEmployeeEntityByeMail(user.geteMail());
        return leaveRepo.getAllByEmployeeEquals(employeeFoundByUser, pageable);
    }
}
