package com.example.projectsoftuni.model.binding;

import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.MaterialEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class MaterialBindingModel {

    private MaterialEnum materialEnum;
    private Long materialCount;
    private LocalDate addDate;

    public MaterialBindingModel() {
    }

    @NotNull(message = "Cannot be empty")
    public MaterialEnum getMaterialEnum() {
        return materialEnum;
    }

    public void setMaterialEnum(MaterialEnum materialEnum) {
        this.materialEnum = materialEnum;
    }

    @NotNull(message = "Cannot be empty")
    @Positive(message = "Must be positive number")
    public Long getMaterialCount() {
        return materialCount;
    }

    public void setMaterialCount(Long materialCount) {
        this.materialCount = materialCount;
    }

    @PastOrPresent(message = "Date cannot be in future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDate addDate) {
        this.addDate = addDate;
    }
}
