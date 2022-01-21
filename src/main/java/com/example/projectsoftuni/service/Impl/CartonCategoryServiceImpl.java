package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.CartonCategory;
import com.example.projectsoftuni.model.entity.Cartons;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.repository.CartonCategoryRepository;
import com.example.projectsoftuni.service.CartonCategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CartonCategoryServiceImpl implements CartonCategoryService {

    private final CartonCategoryRepository cartonCategoryRepository;

    public CartonCategoryServiceImpl(CartonCategoryRepository cartonCategoryRepository) {
        this.cartonCategoryRepository = cartonCategoryRepository;
    }

    @Override
    public void initCartonCategories() {
        if(cartonCategoryRepository.count() == 0){
            Arrays.stream(CategoryCartonsEnum.values())
                    .forEach(categoryCartonsEnum -> {
                        CartonCategory cartonCategory = new CartonCategory(categoryCartonsEnum);

                        cartonCategoryRepository.save(cartonCategory);
                    });
        }
    }

}
