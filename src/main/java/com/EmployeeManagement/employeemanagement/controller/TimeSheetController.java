package com.EmployeeManagement.employeemanagement.controller;

import com.EmployeeManagement.employeemanagement.dto.TimeIntervals;
import com.EmployeeManagement.employeemanagement.dto.TimeSheetAndUserBody;
import com.EmployeeManagement.employeemanagement.dto.TimeSheetDTO;
import com.EmployeeManagement.employeemanagement.dto.UserDTO;
import com.EmployeeManagement.employeemanagement.entity.TimeSheetEntity;
import com.EmployeeManagement.employeemanagement.impl.TimeSheetServiceImpl;
import com.EmployeeManagement.employeemanagement.repository.TimeSheetRepository;
import com.EmployeeManagement.employeemanagement.service.TimeSheetService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/timeSheets")
public class TimeSheetController {

    private final TimeSheetService timeSheetService;

    public TimeSheetController(TimeSheetServiceImpl timeSheetService) {
        this.timeSheetService = timeSheetService;
    }

    @PostMapping()
    public ResponseEntity<TimeSheetDTO> createTimeSheet(@RequestBody TimeSheetDTO timeSheet) {
        return ResponseEntity.ok(timeSheetService.save(timeSheet));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeSheetDTO> getByTsId(@PathVariable("id") Long id) {
        TimeSheetDTO timeSheet = this.timeSheetService.getByTsId(id);
        return ResponseEntity.ok(timeSheet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimeSheetDTO> updateTimeSheet(@RequestBody TimeSheetDTO timeSheet, @PathVariable("id") Long id) {
        return ResponseEntity.ok(timeSheetService.update(id, timeSheet));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTimeSheet(@PathVariable("id") Long id) {
        return ResponseEntity.ok(timeSheetService.delete(id));
    }

    @GetMapping("/getTimeSheetsByPagination")
    public ResponseEntity<Page<TimeSheetEntity>> getTimeSheetsByPagination(Pageable pageable) {
        return ResponseEntity.ok(timeSheetService.getTimeSheetsByPagination(pageable));
    }

    @PostMapping("/getTimeSheetsOfEmployeeAsList")
    public ResponseEntity<List<TimeSheetEntity>> getTimeSheetsOfEmployeeAsList(@RequestBody UserDTO user) {
        return ResponseEntity.ok(timeSheetService.getTimeSheetsOfEmployeeAsList(user));
    }

    @GetMapping("/getById/getTimeSheetsOfEmployeeById/{employeeId}")
    public ResponseEntity<List<TimeSheetEntity>> getTimeSheetsOfEmployeeById(@PathVariable("employeeId") Long employeeId) {
        return ResponseEntity.ok(timeSheetService.getTimeSheetsOfEmployeeById(employeeId));
    }

    @PostMapping("/getTimeSheetByDate")
    public ResponseEntity<TimeSheetEntity> getTimeSheetByDate(@RequestBody TimeSheetAndUserBody timeSheetAndUserBody) {
        return ResponseEntity.ok(timeSheetService.getTimeSheetByDate(timeSheetAndUserBody));
    }
}
