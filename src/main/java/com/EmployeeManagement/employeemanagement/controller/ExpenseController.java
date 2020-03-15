package com.EmployeeManagement.employeemanagement.controller;

import com.EmployeeManagement.employeemanagement.dto.ExpenseDTO;
import com.EmployeeManagement.employeemanagement.impl.ExpenseServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;


@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseServiceImpl expenseService;
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

    @GetMapping("/getAllExpenses")
    public ResponseEntity<ExpenseDTO> getAllExpenses() {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @PutMapping("{id}")
    public ResponseEntity<ExpenseDTO> updateExpense(@PathVariable Long id, @RequestBody ExpenseDTO expense) {
        return ResponseEntity.ok(expenseService.update(id,expense));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteExpense(@PathVariable Long id) {
        return ResponseEntity.ok(expenseService.delete(id));
    }
}
