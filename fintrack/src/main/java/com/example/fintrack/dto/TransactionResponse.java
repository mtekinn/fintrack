package com.example.fintrack.dto;

import java.time.LocalDate;

public class TransactionResponse {
    private Long id;
    private double amount;
    private String description;
    private String type;
    private LocalDate date;
    private String userEmail;
    private String categoryName;

    public TransactionResponse(Long id, double amount, String description, String type, LocalDate date, String userEmail, String categoryName) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.type = type;
        this.date = date;
        this.userEmail = userEmail;
        this.categoryName = categoryName;
    }

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
