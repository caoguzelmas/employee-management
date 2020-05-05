package com.EmployeeManagement.employeemanagement.controller;

import com.EmployeeManagement.employeemanagement.dto.LeaveDTO;
import com.EmployeeManagement.employeemanagement.dto.UserDTO;
import com.EmployeeManagement.employeemanagement.entity.LeaveEntity;
import com.EmployeeManagement.employeemanagement.impl.LeaveServiceImpl;
import com.EmployeeManagement.employeemanagement.service.LeaveService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/leaves")
public class LeaveController {

    private final LeaveService leaveService;
    public LeaveController( LeaveServiceImpl leaveService) {
        this.leaveService = leaveService;
    }

    @PostMapping("")
    public ResponseEntity<LeaveDTO> createLeave(@RequestBody LeaveDTO leave) {
        return ResponseEntity.ok(leaveService.save(leave));
    }

    @GetMapping("{id}")
    public ResponseEntity<LeaveDTO> getByLeaveId(@PathVariable Long id) {
        LeaveDTO leaveDTO = this.leaveService.getByLeaveId(id);
        return ResponseEntity.ok(leaveDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<LeaveDTO> updateLeave(@PathVariable Long id, @RequestBody LeaveDTO leave) {
        return ResponseEntity.ok(leaveService.update(id, leave));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteLeave(@PathVariable Long id) {
        return ResponseEntity.ok(leaveService.delete(id));
    }

    @GetMapping("/getLeavesByPagination")
    public ResponseEntity<Page<LeaveEntity>> getLeavesByPagination(Pageable pageable) {
        return ResponseEntity.ok(leaveService.getLeavesByPagination(pageable));
    }

    @PostMapping("/getLeavesByEmployeeIdWithPagination")
    public ResponseEntity<Page<LeaveEntity>> getLeavesByEmployeeBody(@RequestBody UserDTO user, Pageable pageable) {
        return ResponseEntity.ok(leaveService.getLeavesByEmployeeBody(user, pageable));
    }
}
