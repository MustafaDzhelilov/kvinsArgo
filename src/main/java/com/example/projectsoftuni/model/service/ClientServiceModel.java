package com.example.projectsoftuni.model.service;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientServiceModel {

    private Long bulstat;
    private String firmName;
    private String name;
    private String dds;
    private String address;
    private Long telephone;


    public ClientServiceModel() {
    }

    public Long getBulstat() {
        return bulstat;
    }

    public void setBulstat(Long bulstat) {
        this.bulstat = bulstat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }


    public String getDds() {
        return dds;
    }

    public void setDds(String dds) {
        this.dds = dds;
    }
}
