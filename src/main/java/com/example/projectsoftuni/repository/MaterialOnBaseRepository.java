package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.MaterialOnBase;
import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.MaterialEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MaterialOnBaseRepository extends JpaRepository<MaterialOnBase, Long> {

    List<MaterialOnBase> getMaterialOnBaseByMaterialEnumAndCategoryBaseEnum(MaterialEnum materialEnum, CategoryBaseEnum categoryBaseEnum);

    List<MaterialOnBase> findMaterialOnBaseByAddDateBetween(LocalDate from, LocalDate to);
}
