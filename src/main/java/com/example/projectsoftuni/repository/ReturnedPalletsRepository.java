package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.ReturnedPallets;
import com.example.projectsoftuni.model.entity.enums.ClientEnum;
import com.example.projectsoftuni.model.entity.enums.PalletTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReturnedPalletsRepository extends JpaRepository<ReturnedPallets, Long> {

    List<ReturnedPallets> getReturnedPalletsByClientEnumAndPalletTypeEnum(ClientEnum clientEnum, PalletTypeEnum palletTypeEnum);

}
