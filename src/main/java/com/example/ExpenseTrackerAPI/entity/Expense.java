package com.example.ExpenseTrackerAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Expense {

    private String month;
    private int year;
    private int groceries;
    private int clothing;
    private int transportation;
    private int utilities;
    private int entertainment;
    private int miscellaneous;

    @Column(name = "ID", nullable = false)
    @Id
    private Long id;

}
