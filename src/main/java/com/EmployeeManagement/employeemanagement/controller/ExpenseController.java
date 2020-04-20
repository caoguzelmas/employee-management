package com.EmployeeManagement.employeemanagement.controller;

import com.EmployeeManagement.employeemanagement.dto.ExpenseDTO;
import com.EmployeeManagement.employeemanagement.entity.ExpenseEntity;
import com.EmployeeManagement.employeemanagement.impl.ExpenseServiceImpl;
import com.EmployeeManagement.employeemanagement.service.ExpenseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping(name = "/getExpensesByPagination")
    public ResponseEntity<Page<ExpenseEntity>> getAllExpenses(Pageable pageable) {
        return ResponseEntity.ok(expenseService.getAllExpensesPaged(pageable));
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
