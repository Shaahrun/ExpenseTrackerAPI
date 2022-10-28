package com.example.ExpenseTrackerAPI.repository;

import com.example.ExpenseTrackerAPI.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByMonth(String month);

    List<Expense> findByYear(int year);

}
