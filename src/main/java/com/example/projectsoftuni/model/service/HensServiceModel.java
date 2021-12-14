package com.example.projectsoftuni.model.service;

import com.example.projectsoftuni.model.entity.HaleCategory;
import com.example.projectsoftuni.model.entity.enums.CategoryHaleEnum;
import org.springframework.context.annotation.Configuration;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
public class HensServiceModel {

    private Long id;
    private CategoryHaleEnum hale;
    private Long countOfHens;
    private Long countOfDelHens;
    private LocalDate created;


    public HensServiceModel() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryHaleEnum getHale() {
        return hale;
    }

    public void setHale(CategoryHaleEnum hale) {
        this.hale = hale;
    }

    public Long getCountOfHens() {
        return countOfHens;
    }

    public void setCountOfHens(Long countOfHens) {
        this.countOfHens = countOfHens;
    }

    public Long getCountOfDelHens() {
        return countOfDelHens;
    }

    public void setCountOfDelHens(Long countOfDelHens) {
        this.countOfDelHens = countOfDelHens;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }
}
