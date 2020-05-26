package com.EmployeeManagement.employeemanagement.controller;

import com.EmployeeManagement.employeemanagement.dto.ExpenseDTO;
import com.EmployeeManagement.employeemanagement.dto.TimeIntervals;
import com.EmployeeManagement.employeemanagement.dto.UserDTO;
import com.EmployeeManagement.employeemanagement.entity.ExpenseEntity;
import com.EmployeeManagement.employeemanagement.impl.ExpenseServiceImpl;
import com.EmployeeManagement.employeemanagement.service.ExpenseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;
    public ExpenseController(ExpenseServiceImpl expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping("")
    public ResponseEntity<ExpenseDTO> createExpense(@RequestBody ExpenseDTO expense) {
        return ResponseEntity.ok(expenseService.save(expense));
    }

    @GetMapping("{id}")
    public ResponseEntity<ExpenseDTO> getByExpenseId(@PathVariable Long id) {
        return ResponseEntity.ok(expenseService.getByExpId(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<ExpenseDTO> updateExpense(@PathVariable Long id, @RequestBody ExpenseDTO expense) {
        return ResponseEntity.ok(expenseService.update(id,expense));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteExpense(@PathVariable Long id) {
        return ResponseEntity.ok(expenseService.delete(id));
    }

    @PostMapping("/getExpensesByUserWithPagination")
    public ResponseEntity<Page<ExpenseEntity>> getExpensesByUserBody(@RequestBody UserDTO user, Pageable pageable) {
        return ResponseEntity.ok(expenseService.getExpensesByUserBody(user, pageable));
    }

    @GetMapping("/pagination/getAllExpensesWithPagination")
    public ResponseEntity<Page<ExpenseEntity>> getAllExpensesWithPagination(Pageable pageable) {
        return ResponseEntity.ok(expenseService.getAllExpensesWithPagination(pageable));
    }
}
