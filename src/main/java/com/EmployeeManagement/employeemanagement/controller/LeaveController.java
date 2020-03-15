package com.EmployeeManagement.employeemanagement.controller;

import com.EmployeeManagement.employeemanagement.dto.LeaveDTO;
import com.EmployeeManagement.employeemanagement.impl.LeaveServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/leaves")
public class LeaveController {

    private final LeaveServiceImpl leaveService;
    public LeaveController( LeaveServiceImpl leaveService) {
        this.leaveService = leaveService;
    }

    @PostMapping("")
    public ResponseEntity<LeaveDTO> createLeave(@RequestBody LeaveDTO leave) {
        return ResponseEntity.ok(leaveService.save(leave));
    }

    @GetMapping("{id}")
    public ResponseEntity<LeaveDTO> getByLeaveId(@PathVariable Long id) {
        return ResponseEntity.ok(leaveService.getByLeaveId(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<LeaveDTO> updateLeave(@PathVariable Long id, @RequestBody LeaveDTO leave) {
        return ResponseEntity.ok(leaveService.update(id, leave));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteLeave(@PathVariable Long id) {
        return ResponseEntity.ok(leaveService.delete(id));
    }
}
