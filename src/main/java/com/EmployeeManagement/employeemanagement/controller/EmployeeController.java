package com.EmployeeManagement.employeemanagement.controller;

import com.EmployeeManagement.employeemanagement.dto.EmployeeDTO;
import com.EmployeeManagement.employeemanagement.dto.UserDTO;
import com.EmployeeManagement.employeemanagement.entity.EmployeeEntity;
import com.EmployeeManagement.employeemanagement.impl.EmployeeServiceImpl;
import com.EmployeeManagement.employeemanagement.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<EmployeeDTO> getById(@PathVariable("id") Long id) {
      EmployeeDTO employeeDTO =  this.employeeService.getById(id);
      return ResponseEntity.ok(employeeDTO);
    }

    @GetMapping("/getEmployeesByPagination")
    public ResponseEntity<Page<EmployeeEntity>> getEmployeesWithPagination(Pageable pageable) {
        return ResponseEntity.ok(employeeService.getEmployeesByPagination(pageable));
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employee) {
       return ResponseEntity.ok(employeeService.save(employee));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDTO employee) {
        return ResponseEntity.ok(employeeService.update(id, employee));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") Long id) {
        return ResponseEntity.ok(employeeService.delete(id));
    }

    @PostMapping("/getEmployeeByUser")
    public ResponseEntity<EmployeeEntity> getEmployeeByUser(@RequestBody UserDTO user) {
        return ResponseEntity.ok(employeeService.getEmployeeByEMail(user.geteMail()));
    }
}
