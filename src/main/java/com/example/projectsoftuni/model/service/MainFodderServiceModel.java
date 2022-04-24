package com.example.projectsoftuni.model.service;

import com.example.projectsoftuni.model.entity.enums.CategorySupplierEnum;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class MainFodderServiceModel {
    private Long id;
    private CategorySupplierEnum supplierEnum;
    private Long kilogramOfFodder;
    private LocalDate acceptedTime;

    public MainFodderServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategorySupplierEnum getSupplierEnum() {
        return supplierEnum;
    }

    public void setSupplierEnum(CategorySupplierEnum supplierEnum) {
        this.supplierEnum = supplierEnum;
    }

    public Long getKilogramOfFodder() {
        return kilogramOfFodder;
    }

    public void setKilogramOfFodder(Long kilogramOfFodder) {
        this.kilogramOfFodder = kilogramOfFodder;
    }

    public LocalDate getAcceptedTime() {
        return acceptedTime;
    }

    public void setAcceptedTime(LocalDate acceptedTime) {
        this.acceptedTime = acceptedTime;
    }
}
