package com.example.ExpenseTrackerAPI.controller;

import com.example.ExpenseTrackerAPI.entity.Expense;
import com.example.ExpenseTrackerAPI.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }


    @GetMapping
    public ResponseEntity<List<Expense>> getExpenses() {
        List<Expense> allExpenses = expenseService.getAllExpenses();
        return new ResponseEntity<List<Expense>>(allExpenses, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpenseById(id);
    }

    @GetMapping(path = "/{month}")
    public ResponseEntity<List<Expense>> getExpensesByMonth(@PathVariable String month) {
        List<Expense> monthlyExpenses = expenseService.getExpenseByMonth(month);
        return new ResponseEntity<List<Expense>>(monthlyExpenses, HttpStatus.OK);
    }

    @GetMapping(path = "/{year}")
    public ResponseEntity<List<Expense>> getExpensesByYear(@PathVariable int year) {
        List<Expense> yearlyExpenses = expenseService.getExpenseByYear(year);
        return new ResponseEntity<List<Expense>>(yearlyExpenses, HttpStatus.OK);
    }

    @PostMapping
    public void createExpense(@Valid @RequestBody Expense expense) {
         expenseService.createExpense(expense);
    }

}
