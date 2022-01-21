package com.example.projectsoftuni.model.binding;

import com.example.projectsoftuni.model.entity.enums.CategoryHaleEnum;
import com.example.projectsoftuni.model.entity.enums.CategorySiloEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EatenFodderBindingModel {

    private CategorySiloEnum siloEnum;
    private Long kilogramOfFodder;
    private Long litreOfWater;
    private LocalDate acceptedTime;

    public EatenFodderBindingModel() {
    }

    @NotNull(message = "Cannot be empty")
    public CategorySiloEnum getSiloEnum() {
        return siloEnum;
    }

    public void setSiloEnum(CategorySiloEnum siloEnum) {
        this.siloEnum = siloEnum;
    }

    @NotNull(message = "Cannot be empty")
    public Long getKilogramOfFodder() {
        return kilogramOfFodder;
    }

    public void setKilogramOfFodder(Long kilogramOfFodder) {
        this.kilogramOfFodder = kilogramOfFodder;
    }

    @NotNull(message = "Cannot be empty")
    public Long getLitreOfWater() {
        return litreOfWater;
    }

    public void setLitreOfWater(Long litreOfWater) {
        this.litreOfWater = litreOfWater;
    }

    @PastOrPresent(message = "Date cannot be in future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getAcceptedTime() {
        return acceptedTime;
    }

    public void setAcceptedTime(LocalDate acceptedTime) {
        this.acceptedTime = acceptedTime;
    }
}



