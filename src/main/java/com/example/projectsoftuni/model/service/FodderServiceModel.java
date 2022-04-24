package com.example.projectsoftuni.model.service;

import com.example.projectsoftuni.model.entity.enums.CategorySiloEnum;
import com.example.projectsoftuni.model.entity.enums.CategorySupplierEnum;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
public class FodderServiceModel {

    private Long id;
    private CategorySiloEnum siloEnum;
    private Long kilogramOfFodder;
    private LocalDate acceptedTime;

    public FodderServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategorySiloEnum getSiloEnum() {
        return siloEnum;
    }

    public void setSiloEnum(CategorySiloEnum siloEnum) {
        this.siloEnum = siloEnum;
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
