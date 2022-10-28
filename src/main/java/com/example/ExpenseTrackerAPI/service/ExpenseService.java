package com.example.ExpenseTrackerAPI.service;

import com.example.ExpenseTrackerAPI.entity.Expense;
import com.example.ExpenseTrackerAPI.exception.ExpenseNotFoundException;
import com.example.ExpenseTrackerAPI.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    public ExpenseService() {};

    @Autowired
    private ExpenseRepository expenseRepository;


    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void createExpense(Expense expense) {
         expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses;
    }

    public List<Expense> getExpenseByMonth(String month) {
        Optional<List<Expense>> expense = Optional.ofNullable(expenseRepository.findByMonth(month));
        List<Expense> monthlyExpenses = expense.orElseThrow(ExpenseNotFoundException::new);
        return monthlyExpenses;
    }
    
    public List<Expense> getExpenseByYear(int year) {
        Optional<List<Expense>> expense = Optional.ofNullable(expenseRepository.findByYear(year));
        List<Expense> yearlyExpenses = expense.orElseThrow(ExpenseNotFoundException::new);
        return yearlyExpenses;
    }
    
    public void deleteExpenseById(Long id) {
         expenseRepository.deleteById(id);

    }
}
