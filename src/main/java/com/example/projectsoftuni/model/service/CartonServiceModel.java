package com.example.projectsoftuni.model.service;

import com.example.projectsoftuni.model.entity.CartonCategory;
import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class CartonServiceModel {

    private CartonCategory cartons;
    private CategoryBaseEnum base;
    private Long count;
    private LocalDateTime date;

    public CartonServiceModel() {
    }

    public CartonCategory getCartons() {
        return cartons;
    }

    public void setCartons(CartonCategory cartons) {
        this.cartons = cartons;
    }

    public CategoryBaseEnum getBase() {
        return base;
    }

    public void setBase(CategoryBaseEnum base) {
        this.base = base;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
