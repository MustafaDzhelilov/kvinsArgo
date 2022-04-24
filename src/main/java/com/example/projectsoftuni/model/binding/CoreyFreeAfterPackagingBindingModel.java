package com.example.projectsoftuni.model.binding;

import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class CoreyFreeAfterPackagingBindingModel {

    private CategoryBaseEnum categoryBaseEnum;
    private CategoryCartonsEnum cartons;
    private Long count;
    private LocalDate date;

    public CoreyFreeAfterPackagingBindingModel() {
    }

    @NotNull(message = "Cannot be empty")
    public CategoryBaseEnum getCategoryBaseEnum() {
        return categoryBaseEnum;
    }

    public void setCategoryBaseEnum(CategoryBaseEnum categoryBaseEnum) {
        this.categoryBaseEnum = categoryBaseEnum;
    }

    @NotNull(message = "Cannot be empty")
    public CategoryCartonsEnum getCartons() {
        return cartons;
    }

    public void setCartons(CategoryCartonsEnum cartons) {
        this.cartons = cartons;
    }

    @NotNull(message = "Cannot be empty")
    @Positive(message = "Must be positive number")
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @PastOrPresent(message = "Date cannot be in future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
