package com.example.projectsoftuni.model.binding;

import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryHaleEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EggAddBindingModel {

    private CategoryEggEnum categoryEgg;
    private CategoryCartonsEnum categoryCartons;
    private CategoryBaseEnum categoryBase;
    private CategoryHaleEnum categoryHale;
    private Long countOfEgg;
    private LocalDate addDate;

    public EggAddBindingModel() {
    }

    @NotNull(message = "Cannot be empty")
    public CategoryEggEnum getCategoryEgg() {
        return categoryEgg;
    }

    public void setCategoryEgg(CategoryEggEnum categoryEgg) {
        this.categoryEgg = categoryEgg;
    }

    @NotNull(message = "Cannot be empty")
    public CategoryCartonsEnum getCategoryCartons() {
        return categoryCartons;
    }

    public void setCategoryCartons(CategoryCartonsEnum categoryCartons) {
        this.categoryCartons = categoryCartons;
    }

    @NotNull(message = "Cannot be empty")
    public CategoryBaseEnum getCategoryBase() {
        return categoryBase;
    }

    public void setCategoryBase(CategoryBaseEnum categoryBase) {
        this.categoryBase = categoryBase;
    }

    @Positive(message = "Must be positive number")
    public Long getCountOfEgg() {
        return countOfEgg;
    }

    public void setCountOfEgg(Long countOfEgg) {
        this.countOfEgg = countOfEgg;
    }

    @PastOrPresent(message = "Date cannot be in future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDate addDate) {
        this.addDate = addDate;
    }

    @NotNull(message = "Cannot be empty")
    public CategoryHaleEnum getCategoryHale() {
        return categoryHale;
    }

    public void setCategoryHale(CategoryHaleEnum categoryHale) {
        this.categoryHale = categoryHale;
    }
}
