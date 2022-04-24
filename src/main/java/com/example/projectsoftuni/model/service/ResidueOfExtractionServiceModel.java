package com.example.projectsoftuni.model.service;

import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryHaleEnum;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class ResidueOfExtractionServiceModel {

    private Long id;
    private CategoryEggEnum egg;
    private CategoryBaseEnum base;
    private CategoryCartonsEnum cartons;
    private CategoryCartonsEnum coreyInCartons;
    private CategoryHaleEnum hale;
    private Long countOfEgg;
    private LocalDate addDate;

    public ResidueOfExtractionServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryEggEnum getEgg() {
        return egg;
    }

    public void setEgg(CategoryEggEnum egg) {
        this.egg = egg;
    }

    public CategoryBaseEnum getBase() {
        return base;
    }

    public void setBase(CategoryBaseEnum base) {
        this.base = base;
    }

    public CategoryHaleEnum getHale() {
        return hale;
    }

    public void setHale(CategoryHaleEnum hale) {
        this.hale = hale;
    }

    public CategoryCartonsEnum getCartons() {
        return cartons;
    }

    public void setCartons(CategoryCartonsEnum cartons) {
        this.cartons = cartons;
    }

    public CategoryCartonsEnum getCoreyInCartons() {
        return coreyInCartons;
    }

    public void setCoreyInCartons(CategoryCartonsEnum coreyInCartons) {
        this.coreyInCartons = coreyInCartons;
    }

    public Long getCountOfEgg() {
        return countOfEgg;
    }

    public void setCountOfEgg(Long countOfEgg) {
        this.countOfEgg = countOfEgg;
    }

    public LocalDate getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDate addDate) {
        this.addDate = addDate;
    }
}
