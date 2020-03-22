package com.EmployeeManagement.employeemanagement.controller;

import com.EmployeeManagement.employeemanagement.dto.TimeSheetDTO;
import com.EmployeeManagement.employeemanagement.impl.TimeSheetServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
@RequestMapping("/timeSheets")
public class TimeSheetController {

    private final TimeSheetServiceImpl timeSheetService;

    public TimeSheetController(TimeSheetServiceImpl timeSheetService) {
        this.timeSheetService = timeSheetService;
    }

    @PostMapping()
    public ResponseEntity<TimeSheetDTO> createTimeSheet(@RequestBody TimeSheetDTO timeSheet) {
        return ResponseEntity.ok(timeSheetService.save(timeSheet));
    }
}
