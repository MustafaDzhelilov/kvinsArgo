package com.example.projectsoftuni.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client extends BaseEntity{

    private Long bulstat;
    private Long dds;
    private String firmName;
    private String name;
    private String adress;
    private Long telephone;
    private Set<Sells> sells;

    public Client() {
        this.sells = new HashSet<>();
    }

    @Column(name = "bulstat")
    public Long getBulstat() {
        return bulstat;
    }

    public void setBulstat(Long bulstat) {
        this.bulstat = bulstat;
    }

    @Column(name = "name", columnDefinition = "TEXT")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "address", columnDefinition = "TEXT")
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Column(name = "telephone")
    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }


    @Column(name = "firmName", columnDefinition = "TEXT")
    public String getFirmName() {
        return firmName;
    }


    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }


    @Column(name = "dds")
    public Long getDds() {
        return dds;
    }

    public void setDds(Long dds) {
        this.dds = dds;
    }


    @OneToMany(fetch = FetchType.EAGER)
    public Set<Sells> getSells() {
        return sells;
    }

    public void setSells(Set<Sells> sells) {
        this.sells = sells;
    }
}
