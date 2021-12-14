package com.example.projectsoftuni.model.service;

import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class SellsServiceModel {

    private Long id;
    private CategoryEggEnum egg;
    private CategoryBaseEnum base;
    private Long countOfEgg;
    private CategoryCartonsEnum cartons;
    private LocalDate addDate;
    private Long bulstat;
    private double price;

    public SellsServiceModel() {
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

    public Long getCountOfEgg() {
        return countOfEgg;
    }

    public void setCountOfEgg(Long countOfEgg) {
        this.countOfEgg = countOfEgg;
    }

    public CategoryCartonsEnum getCartons() {
        return cartons;
    }

    public void setCartons(CategoryCartonsEnum cartons) {
        this.cartons = cartons;
    }

    public LocalDate getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDate addDate) {
        this.addDate = addDate;
    }


    public Long getBulstat() {
        return bulstat;
    }

    public void setBulstat(Long bulstat) {
        this.bulstat = bulstat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

