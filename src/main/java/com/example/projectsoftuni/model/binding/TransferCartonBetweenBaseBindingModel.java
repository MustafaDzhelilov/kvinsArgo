package com.example.projectsoftuni.model.binding;

import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class TransferCartonBetweenBaseBindingModel {

    private CategoryBaseEnum fromBase;
    private CategoryBaseEnum toBase;
    private CategoryCartonsEnum categoryCartonsEnum;
    private Long count;
    private LocalDate date;

    public TransferCartonBetweenBaseBindingModel() {
    }

    @NotNull(message = "Cannot be empty")
    public CategoryBaseEnum getFromBase() {
        return fromBase;
    }

    public void setFromBase(CategoryBaseEnum fromBase) {
        this.fromBase = fromBase;
    }

    @NotNull(message = "Cannot be empty")
    public CategoryBaseEnum getToBase() {
        return toBase;
    }

    public void setToBase(CategoryBaseEnum toBase) {
        this.toBase = toBase;
    }

    @NotNull(message = "Cannot be empty")
    public CategoryCartonsEnum getCategoryCartonsEnum() {
        return categoryCartonsEnum;
    }

    public void setCategoryCartonsEnum(CategoryCartonsEnum categoryCartonsEnum) {
        this.categoryCartonsEnum = categoryCartonsEnum;
    }

    @NotNull(message = "Cannot be empty")
    @Positive(message = "Must be positive number")
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @NotNull(message = "Cannot be empty")
    @PastOrPresent(message = "Date cannot be in future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
