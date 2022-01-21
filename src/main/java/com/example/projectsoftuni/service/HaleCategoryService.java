package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.entity.HaleCategory;
import com.example.projectsoftuni.model.entity.enums.CategoryHaleEnum;

public interface HaleCategoryService {
    void initHaleCategories();

    HaleCategory findByHaleEnum(CategoryHaleEnum categoryHaleEnum);
}
