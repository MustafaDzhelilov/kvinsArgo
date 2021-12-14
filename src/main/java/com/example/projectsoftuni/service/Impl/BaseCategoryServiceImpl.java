package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.BaseCategory;
import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.repository.BaseCategoryRepository;
import com.example.projectsoftuni.service.BaseCategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BaseCategoryServiceImpl implements BaseCategoryService {

    private final BaseCategoryRepository baseCategoryRepository;

    public BaseCategoryServiceImpl(BaseCategoryRepository baseCategoryRepository) {
        this.baseCategoryRepository = baseCategoryRepository;
    }

    @Override
    public void initBaseCategories() {
        if(baseCategoryRepository.count() == 0){
            Arrays.stream(CategoryBaseEnum.values())
                    .forEach(categoryBaseEnum -> {
                        BaseCategory baseCategory = new BaseCategory(categoryBaseEnum);

                        baseCategoryRepository.save(baseCategory);
                    });
        }
    }

    @Override
    public BaseCategory findByName(CategoryBaseEnum categoryBaseEnum) {
        return baseCategoryRepository.findByBase(categoryBaseEnum)
                .orElse(null);
    }
}
