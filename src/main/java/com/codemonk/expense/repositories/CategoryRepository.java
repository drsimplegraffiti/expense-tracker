package com.codemonk.expense.repositories;

import com.codemonk.expense.domain.Category;
import com.codemonk.expense.exceptions.EtBadRequestException;
import com.codemonk.expense.exceptions.EtResourceNotFoundException;

import java.util.List;

public interface CategoryRepository {

    List<Category> findAll(Integer userId) throws EtResourceNotFoundException;

    Category findById(Integer userId, Integer categoryId) throws EtResourceNotFoundException;

    Integer create(Integer userId, String title, String description) throws EtResourceNotFoundException;

    void update(Integer userId, Integer categoryId, Category category) throws EtResourceNotFoundException, EtBadRequestException;

    void removeById(Integer userId, Integer categoryId) throws EtResourceNotFoundException;
}
