package com.example.projectsoftuni.model.binding;

import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryHaleEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

public class CartonAddBindingModel {

    private CategoryCartonsEnum categoryCartonsEnum;
    private CategoryBaseEnum categoryBaseEnum;
    private Long countOfCartons;
    private LocalDateTime date;

    public CartonAddBindingModel() {
    }

    @NotNull(message = "Cannot be empty")
    public CategoryCartonsEnum getCategoryCartonsEnum() {
        return categoryCartonsEnum;
    }

    public void setCategoryCartonsEnum(CategoryCartonsEnum categoryCartonsEnum) {
        this.categoryCartonsEnum = categoryCartonsEnum;
    }

    @NotNull(message = "Cannot be empty")
    public CategoryBaseEnum getCategoryBaseEnum() {
        return categoryBaseEnum;
    }

    public void setCategoryBaseEnum(CategoryBaseEnum categoryBaseEnum) {
        this.categoryBaseEnum = categoryBaseEnum;
    }

    @NotNull(message = "Cannot be empty")
    @Positive(message = "Must be positive number")
    public Long getCountOfCartons() {
        return countOfCartons;
    }

    public void setCountOfCartons(Long countOfCartons) {
        this.countOfCartons = countOfCartons;
    }

    @NotNull(message = "Cannot be empty")
    @PastOrPresent(message = "Date cannot be in future")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
