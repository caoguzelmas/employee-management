package com.EmployeeManagement.employeemanagement.impl;

import com.EmployeeManagement.employeemanagement.dto.LeaveDTO;
import com.EmployeeManagement.employeemanagement.entity.LeaveEntity;
import com.EmployeeManagement.employeemanagement.repository.LeaveRepository;
import com.EmployeeManagement.employeemanagement.service.LeaveService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class LeaveServiceImpl implements LeaveService {

    private final LeaveRepository leaveRepo;
    private final ModelMapper modelMapper;

    public LeaveServiceImpl(LeaveRepository leaveRepo,ModelMapper modelMapper){
        this.leaveRepo = leaveRepo;
        this.modelMapper = modelMapper;
    }


    @Override
    public LeaveDTO save(LeaveDTO leave) {
        LeaveEntity leaveDB = modelMapper.map(leave, LeaveEntity.class);
        leaveDB = leaveRepo.save(leaveDB);
        return modelMapper.map(leaveDB,LeaveDTO.class);
    }

    @Override
    public LeaveDTO getByLeaveId(Long leaveId) {
        LeaveEntity leaveDB = modelMapper.map(leaveId, LeaveEntity.class);
        leaveDB = leaveRepo.getOne(leaveId);
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

        leaveRepo.save(leaveFromDB);
        return modelMapper.map(leaveFromDB, LeaveDTO.class);
    }

    public Boolean delete(Long id) {
        leaveRepo.deleteById(id);
        return true;
    }
}
