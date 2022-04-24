package com.example.projectsoftuni.model.binding;

import com.example.projectsoftuni.model.entity.enums.CategorySupplierEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class MainFodderBindingModel {

    private CategorySupplierEnum supplierEnum;
    private Long kilogramOfFodder;
    private LocalDate acceptedTime;

    public MainFodderBindingModel() {
    }

    @NotNull(message = "Cannot be empty")
    public CategorySupplierEnum getSupplierEnum() {
        return supplierEnum;
    }

    public void setSupplierEnum(CategorySupplierEnum supplierEnum) {
        this.supplierEnum = supplierEnum;
    }

    @NotNull(message = "Cannot be empty")
    public Long getKilogramOfFodder() {
        return kilogramOfFodder;
    }

    public void setKilogramOfFodder(Long kilogramOfFodder) {
        this.kilogramOfFodder = kilogramOfFodder;
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
