package com.example.projectsoftuni.model.service;

import com.example.projectsoftuni.model.entity.enums.CategoryHaleEnum;
import com.example.projectsoftuni.model.entity.enums.CategorySiloEnum;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
public class EatenFodderAndWaterServiceModel {

    private Long id;
    private CategorySiloEnum siloEnum;
    private Long kilogramOfFodder;
    private Long litreOfWater;
    private LocalDate acceptedTime;

    public EatenFodderAndWaterServiceModel() {
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

    public Long getLitreOfWater() {
        return litreOfWater;
    }

    public void setLitreOfWater(Long litreOfWater) {
        this.litreOfWater = litreOfWater;
    }

    public LocalDate getAcceptedTime() {
        return acceptedTime;
    }

    public void setAcceptedTime(LocalDate acceptedTime) {
        this.acceptedTime = acceptedTime;
    }
}
