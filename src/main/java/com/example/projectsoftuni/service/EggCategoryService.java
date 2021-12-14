package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.entity.EggCategory;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;

public interface EggCategoryService {

    void initEggCategories();

    EggCategory findByName(CategoryEggEnum categoryEggEnum);
}
