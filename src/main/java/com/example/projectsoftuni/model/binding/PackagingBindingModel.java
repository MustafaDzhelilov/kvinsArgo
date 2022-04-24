package com.example.projectsoftuni.model.binding;

import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
@Configuration
public class PackagingBindingModel {

    private CategoryEggEnum categoryEggEnum;
    private CategoryCartonsEnum categoryCartonsEnum;
    private CategoryBaseEnum categoryBaseEnum;
    private Long count;
    private LocalDate transferDate;

    public PackagingBindingModel() {
    }

    @NotNull(message = "Cannot be empty")
    public CategoryEggEnum getCategoryEggEnum() {
        return categoryEggEnum;
    }

    public void setCategoryEggEnum(CategoryEggEnum categoryEggEnum) {
        this.categoryEggEnum = categoryEggEnum;
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
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @PastOrPresent(message = "Date cannot be in future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDate transferDate) {
        this.transferDate = transferDate;
    }
}
