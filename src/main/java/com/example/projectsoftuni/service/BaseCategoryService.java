package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.entity.BaseCategory;
import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;

public interface BaseCategoryService {
    void initBaseCategories();

    BaseCategory findByName(CategoryBaseEnum categoryBaseEnum);
}
