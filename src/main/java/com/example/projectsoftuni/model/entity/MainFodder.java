package com.example.projectsoftuni.model.entity;

import com.example.projectsoftuni.model.entity.enums.CategorySiloEnum;
import com.example.projectsoftuni.model.entity.enums.CategorySupplierEnum;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "mainFodder")
public class MainFodder extends BaseEntity{

    private CategorySupplierEnum supplierEnum;
    private Long kilogramOfFodder;
    private LocalDate acceptedTime;

    public MainFodder() {
    }

    @Enumerated(EnumType.STRING)
    public CategorySupplierEnum getSupplierEnum() {
        return supplierEnum;
    }

    public void setSupplierEnum(CategorySupplierEnum supplierEnum) {
        this.supplierEnum = supplierEnum;
    }

    @Column(name = "kilogramOfFodder",nullable = false)
    public Long getKilogramOfFodder() {
        return kilogramOfFodder;
    }

    public void setKilogramOfFodder(Long kilogramOfFodder) {
        this.kilogramOfFodder = kilogramOfFodder;
    }

    @Column(name = "acceptedTime", nullable = false)
    public LocalDate getAcceptedTime() {
        return acceptedTime;
    }

    public void setAcceptedTime(LocalDate acceptedTime) {
        this.acceptedTime = acceptedTime;
    }
}
