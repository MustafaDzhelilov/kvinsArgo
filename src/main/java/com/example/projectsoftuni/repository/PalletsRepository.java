package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.Pallets;
import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.PalletTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PalletsRepository extends JpaRepository<Pallets, Long> {

    List<Pallets> getPalletsByCategoryBaseEnumAndPalletTypeEnum(CategoryBaseEnum categoryBaseEnum, PalletTypeEnum palletTypeEnum);
}
