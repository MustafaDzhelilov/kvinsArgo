package com.example.projectsoftuni.model.binding;

import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.PalletTypeEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class TransferPalletsBetweenBaseBindingModel {

    private CategoryBaseEnum from;
    private  CategoryBaseEnum to;
    private PalletTypeEnum palletTypeEnum;
    private Long count;
    private LocalDate date;

    public TransferPalletsBetweenBaseBindingModel() {
    }

    @NotNull(message = "Cannot be empty")
    public CategoryBaseEnum getFrom() {
        return from;
    }

    public void setFrom(CategoryBaseEnum from) {
        this.from = from;
    }

    @NotNull(message = "Cannot be empty")
    public CategoryBaseEnum getTo() {
        return to;
    }

    public void setTo(CategoryBaseEnum to) {
        this.to = to;
    }

    @NotNull(message = "Cannot be empty")
    public PalletTypeEnum getPalletTypeEnum() {
        return palletTypeEnum;
    }

    public void setPalletTypeEnum(PalletTypeEnum palletTypeEnum) {
        this.palletTypeEnum = palletTypeEnum;
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
