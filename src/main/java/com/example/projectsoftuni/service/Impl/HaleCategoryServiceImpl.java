package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.HaleCategory;
import com.example.projectsoftuni.model.entity.enums.CategoryHaleEnum;
import com.example.projectsoftuni.repository.HaleCategoryRepository;
import com.example.projectsoftuni.service.HaleCategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class HaleCategoryServiceImpl implements HaleCategoryService {

    private final HaleCategoryRepository haleCategoryRepository;

    public HaleCategoryServiceImpl(HaleCategoryRepository haleCategoryRepository) {
        this.haleCategoryRepository = haleCategoryRepository;
    }

    @Override
    public void initHaleCategories() {
        if(haleCategoryRepository.count() == 0){
            Arrays.stream(CategoryHaleEnum.values())
                    .forEach(categoryHaleEnum -> {
                        HaleCategory haleCategory = new HaleCategory(categoryHaleEnum);

                        haleCategoryRepository.save(haleCategory);
                    });
        }
    }

    @Override
    public HaleCategory findByHaleEnum(CategoryHaleEnum categoryHaleEnum) {
        return haleCategoryRepository.findByHale(categoryHaleEnum)
                .orElse(null);
    }
}
