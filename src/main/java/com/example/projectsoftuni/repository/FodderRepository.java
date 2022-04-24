package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.EggCategory;
import com.example.projectsoftuni.model.entity.Fodder;
import com.example.projectsoftuni.model.entity.enums.CategorySiloEnum;
import com.example.projectsoftuni.model.entity.enums.CategorySupplierEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FodderRepository extends JpaRepository<Fodder, Long> {

    //За извеждане на кг фураж за точна определена дата която искаме.
    List<Fodder> getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum siloEnum, LocalDate acceptedTime);

    List<Fodder> getAllByAcceptedTimeBetween(LocalDate start, LocalDate end);

    List<Fodder> getAllBySiloEnum(CategorySiloEnum siloEnum);


}
