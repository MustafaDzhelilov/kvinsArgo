package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.EatenFodderAndWater;
import com.example.projectsoftuni.model.entity.enums.CategoryHaleEnum;
import com.example.projectsoftuni.model.entity.enums.CategorySiloEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EatenFodderAndWaterRepository extends JpaRepository<EatenFodderAndWater, Long> {

    List<EatenFodderAndWater> getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByKilogramOfFodder(CategorySiloEnum siloEnum, LocalDate acceptedTime);

    List<EatenFodderAndWater> getEatenFodderAndWaterBySiloEnumAndAcceptedTimeOrderByLitreOfWater(CategorySiloEnum siloEnum, LocalDate acceptedTime);

    List<EatenFodderAndWater> findFirstBySiloEnumOrderByIdDesc(CategorySiloEnum siloEnum);

}
