package com.example.projectsoftuni.model.service;

import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class TransferCartonBetweenBaseServiceModel {

    private Long id;
    private CategoryBaseEnum fromBase;
    private CategoryBaseEnum toBase;
    private CategoryCartonsEnum categoryCartonsEnum;
    private Long count;
    private LocalDate date;

    public TransferCartonBetweenBaseServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryBaseEnum getFromBase() {
        return fromBase;
    }

    public void setFromBase(CategoryBaseEnum fromBase) {
        this.fromBase = fromBase;
    }

    public CategoryBaseEnum getToBase() {
        return toBase;
    }

    public void setToBase(CategoryBaseEnum toBase) {
        this.toBase = toBase;
    }

    public CategoryCartonsEnum getCategoryCartonsEnum() {
        return categoryCartonsEnum;
    }

    public void setCategoryCartonsEnum(CategoryCartonsEnum categoryCartonsEnum) {
        this.categoryCartonsEnum = categoryCartonsEnum;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
