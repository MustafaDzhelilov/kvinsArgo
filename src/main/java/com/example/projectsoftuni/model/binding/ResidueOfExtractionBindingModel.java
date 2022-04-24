package com.example.projectsoftuni.model.binding;

import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryHaleEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ResidueOfExtractionBindingModel {

    private CategoryBaseEnum categoryBase;
    private CategoryEggEnum categoryEgg;
    private CategoryCartonsEnum cartons;
    private CategoryCartonsEnum coreyInCartons;
    private CategoryHaleEnum hale;
    private Long countOfEgg;

    public ResidueOfExtractionBindingModel() {
    }

    @NotNull(message = "Cannot be empty")
    public CategoryBaseEnum getCategoryBase() {
        return categoryBase;
    }

    public void setCategoryBase(CategoryBaseEnum categoryBase) {
        this.categoryBase = categoryBase;
    }

    @NotNull(message = "Cannot be empty")
    public CategoryEggEnum getCategoryEgg() {
        return categoryEgg;
    }

    public void setCategoryEgg(CategoryEggEnum categoryEgg) {
        this.categoryEgg = categoryEgg;
    }

    public CategoryCartonsEnum getCartons() {
        return cartons;
    }

    public void setCartons(CategoryCartonsEnum cartons) {
        this.cartons = cartons;
    }

    @NotNull(message = "Cannot be empty")
    public CategoryHaleEnum getHale() {
        return hale;
    }

    public void setHale(CategoryHaleEnum hale) {
        this.hale = hale;
    }

    public CategoryCartonsEnum getCoreyInCartons() {
        return coreyInCartons;
    }

    public void setCoreyInCartons(CategoryCartonsEnum coreyInCartons) {
        this.coreyInCartons = coreyInCartons;
    }


    @Positive(message = "Must be positive number")
    public Long getCountOfEgg() {
        return countOfEgg;
    }

    public void setCountOfEgg(Long countOfEgg) {
        this.countOfEgg = countOfEgg;
    }
}
