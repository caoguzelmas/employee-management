package com.EmployeeManagement.employeemanagement.controller;

import com.EmployeeManagement.employeemanagement.dto.TimeIntervals;
import com.EmployeeManagement.employeemanagement.entity.*;
import com.EmployeeManagement.employeemanagement.impl.CommonServiceImpl;
import com.EmployeeManagement.employeemanagement.service.ICommonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/common")
public class CommonController {

    private final ICommonService commonService;

    public CommonController(CommonServiceImpl commonService) {
        this.commonService = commonService;
    }

    @GetMapping("/getAllExpenseTypes")
    public ResponseEntity<List<ExpenseType>> getAllExpenseTypes() {
        return ResponseEntity.ok(commonService.getAllExpenseTypes());
    }

    @GetMapping("/getAllLeaveTypes")
    public ResponseEntity<List<LeaveType>> getAllLeaveTypes() {
        return ResponseEntity.ok(commonService.getAllLeaveTypes());
    }

    @GetMapping("/getAllUserRoleTypes")
    public ResponseEntity<List<UserType>> getAllUserRoleTypes() {
        return ResponseEntity.ok(commonService.getAllUserRoleTypes());
    }

    @GetMapping("/getAllProjects")
    public ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.ok(commonService.getAllProjects());
    }

    @PostMapping("/getAdminDashboardItems")
    public ResponseEntity<AdminDashboardItems> getAdminDashboardItems(@RequestBody TimeIntervals timeIntervalGroup) {
        return ResponseEntity.ok(commonService.getAdminDashboardItems(timeIntervalGroup.getStartingDate(), timeIntervalGroup.getEndingDate()));
    }


}
