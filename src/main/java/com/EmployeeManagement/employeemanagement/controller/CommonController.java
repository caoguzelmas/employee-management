package com.EmployeeManagement.employeemanagement.controller;

import com.EmployeeManagement.employeemanagement.entity.ExpenseType;
import com.EmployeeManagement.employeemanagement.entity.LeaveType;
import com.EmployeeManagement.employeemanagement.entity.UserType;
import com.EmployeeManagement.employeemanagement.impl.CommonServiceImpl;
import com.EmployeeManagement.employeemanagement.service.ICommonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
