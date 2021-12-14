package com.example.projectsoftuni.model.binding;

import com.example.projectsoftuni.model.entity.enums.CategoryHaleEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
public class HensAddBindingModel {

     private CategoryHaleEnum categoryHale;
     private Long countOfHens;
     private Long countOfDelHens;
     private LocalDate created_date;

    public HensAddBindingModel() {
    }


    public CategoryHaleEnum getCategoryHale() {
        return categoryHale;
    }

    public void setCategoryHale(CategoryHaleEnum categoryHale) {
        this.categoryHale = categoryHale;
    }

    @Positive(message = "Must be positive number")
    public Long getCountOfHens() {
        return countOfHens;
    }

    public void setCountOfHens(Long countOfHens) {
        this.countOfHens = countOfHens;
    }

    public Long getCountOfDelHens() {
        return countOfDelHens;
    }

    public void setCountOfDelHens(Long countOfDelHens) {
        this.countOfDelHens = countOfDelHens;
    }

    @PastOrPresent(message = "Date cannot be in future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDate created_date) {
        this.created_date = created_date;
    }
}
