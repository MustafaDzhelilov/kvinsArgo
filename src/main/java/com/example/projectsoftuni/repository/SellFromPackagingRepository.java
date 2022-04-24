package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.SellFromPackaging;
import com.example.projectsoftuni.model.entity.enums.ClientEnum;
import com.example.projectsoftuni.model.entity.enums.PalletTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellFromPackagingRepository extends JpaRepository<SellFromPackaging, Long> {

    List<SellFromPackaging> getReturnedPalletsByClientEnumAndPalletTypeEnum(ClientEnum clientEnum, PalletTypeEnum palletTypeEnum);

    List<SellFromPackaging> findAllByOrderByDateDesc();
}
