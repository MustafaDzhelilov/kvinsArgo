package com.example.projectsoftuni.model.service;

import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class PackagingServiceModel {

    private Long id;
    private CategoryEggEnum categoryEggEnum;
    private CategoryCartonsEnum categoryCartonsEnum;
    private CategoryBaseEnum categoryBaseEnum;
    private Long count;
    private LocalDate transferDate;


    public PackagingServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryEggEnum getCategoryEggEnum() {
        return categoryEggEnum;
    }

    public void setCategoryEggEnum(CategoryEggEnum categoryEggEnum) {
        this.categoryEggEnum = categoryEggEnum;
    }

    public CategoryCartonsEnum getCategoryCartonsEnum() {
        return categoryCartonsEnum;
    }

    public void setCategoryCartonsEnum(CategoryCartonsEnum categoryCartonsEnum) {
        this.categoryCartonsEnum = categoryCartonsEnum;
    }

    public CategoryBaseEnum getCategoryBaseEnum() {
        return categoryBaseEnum;
    }

    public void setCategoryBaseEnum(CategoryBaseEnum categoryBaseEnum) {
        this.categoryBaseEnum = categoryBaseEnum;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public LocalDate getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDate transferDate) {
        this.transferDate = transferDate;
    }
}
