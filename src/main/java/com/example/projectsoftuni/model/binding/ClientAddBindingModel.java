package com.example.projectsoftuni.model.binding;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class ClientAddBindingModel {

    private String name;
    private String firmName;
    private String bulstat;
    private String dds;
    private String address;
    private String telephone;


    public ClientAddBindingModel() {
    }

    @NotNull(message = "Cannot be empty")
    @Column(columnDefinition = "TEXT")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "Cannot be empty")
    @Column(columnDefinition = "TEXT")
    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    @NotNull(message = "Cannot be empty")
    public String getBulstat() {
        return bulstat;
    }

    public void setBulstat(String bulstat) {
        this.bulstat = bulstat;
    }

    @NotNull(message = "Cannot be empty")
    @Column(columnDefinition = "TEXT")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @NotNull(message = "Cannot be empty")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @NotNull(message = "Cannot be empty")
    public String getDds() {
        return dds;
    }

    public void setDds(String dds) {
        this.dds = dds;
    }
}
