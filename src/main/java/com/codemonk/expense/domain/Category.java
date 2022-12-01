package com.codemonk.expense.domain;

public class Category {
    private Integer categoryId;
    private String title;
    private String description;
    private Double totalExpense;

    // Generate all args constructor

    public Category(Integer categoryId, int user_id, String title, String description, Double totalExpense) {
        this.categoryId = categoryId;
        this.title = title;
        this.description = description;
        this.totalExpense = totalExpense;
    }

    // Generate getters and setters

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(Double totalExpense) {
        this.totalExpense = totalExpense;
    }
}
