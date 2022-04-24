package com.example.projectsoftuni.model.service;

import com.example.projectsoftuni.model.entity.enums.PackagingCartonsEnum;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class CartonsForPackagingServiceModel {

    private Long id;
    private PackagingCartonsEnum packagingCartonsEnum;
    private Long count;
    private LocalDate date;

    public CartonsForPackagingServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PackagingCartonsEnum getPackagingCartonsEnum() {
        return packagingCartonsEnum;
    }

    public void setPackagingCartonsEnum(PackagingCartonsEnum packagingCartonsEnum) {
        this.packagingCartonsEnum = packagingCartonsEnum;
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
