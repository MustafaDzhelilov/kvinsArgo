package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.EggCategory;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.repository.EggCategoryRepository;
import com.example.projectsoftuni.service.EggCategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class EggCategoryServiceImpl implements EggCategoryService {

    private final EggCategoryRepository eggCategoryRepository;

    public EggCategoryServiceImpl(EggCategoryRepository eggCategoryRepository) {
        this.eggCategoryRepository = eggCategoryRepository;
    }

    @Override
    public void initEggCategories() {
        if(eggCategoryRepository.count() == 0){
            Arrays.stream(CategoryEggEnum.values())
                    .forEach(categoryEggEnum -> {
                        EggCategory eggCategory = new EggCategory(categoryEggEnum);

                        eggCategoryRepository.save(eggCategory);
                    });
        }
    }

    @Override
    public EggCategory findByName(CategoryEggEnum categoryEggEnum) {
        return eggCategoryRepository.findByEgg(categoryEggEnum)
                .orElse(null);
    }
}
