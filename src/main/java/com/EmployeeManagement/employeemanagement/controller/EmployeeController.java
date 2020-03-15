package com.EmployeeManagement.employeemanagement.controller;

import com.EmployeeManagement.employeemanagement.dto.EmployeeDTO;
import com.EmployeeManagement.employeemanagement.impl.EmployeeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getById(@PathVariable("id") Long id) {
      EmployeeDTO employeeDTO =  this.employeeService.getById(id);
      return ResponseEntity.ok(employeeDTO);
    }

    @PostMapping()
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employee) {
       return ResponseEntity.ok(employeeService.save(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDTO employee) {
        return ResponseEntity.ok(employeeService.update(id, employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") Long id) {
        return ResponseEntity.ok(employeeService.delete(id));
    }
}
