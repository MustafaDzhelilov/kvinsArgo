package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.Export;
import com.example.projectsoftuni.model.entity.enums.ClientEnum;
import com.example.projectsoftuni.model.entity.enums.PalletTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExportRepository extends JpaRepository<Export, Long> {

    List<Export> getAllByClientEnumAndPalletTypeEnum(ClientEnum clientEnum, PalletTypeEnum palletTypeEnum);
}
