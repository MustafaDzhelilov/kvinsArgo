package com.example.projectsoftuni.model.entity;

import com.example.projectsoftuni.model.entity.enums.CategoryHaleEnum;
import com.example.projectsoftuni.model.entity.enums.CategorySiloEnum;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "eatenFodderAndWater")
public class EatenFodderAndWater extends BaseEntity{

    private CategorySiloEnum siloEnum;
    private Long kilogramOfFodder;
    private Long litreOfWater;
    private LocalDate acceptedTime;

    public EatenFodderAndWater() {
    }

    @Enumerated(EnumType.STRING)
    public CategorySiloEnum getSiloEnum() {
        return siloEnum;
    }

    public void setSiloEnum(CategorySiloEnum siloEnum) {
        this.siloEnum = siloEnum;
    }

    @Column(name = "eatenKilogramOfFodder", nullable = false)
    public Long getKilogramOfFodder() {
        return kilogramOfFodder;
    }

    public void setKilogramOfFodder(Long kilogramOfFodder) {
        this.kilogramOfFodder = kilogramOfFodder;
    }

    @Column(name = "dinkedLitreOfWater", nullable = false)
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
