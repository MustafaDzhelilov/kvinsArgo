package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.EggCategory;
import com.example.projectsoftuni.model.entity.Fodder;
import com.example.projectsoftuni.model.entity.enums.CategorySiloEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FodderRepository extends JpaRepository<Fodder, Long> {

    //За извеждане на кг фураж за точна определена дата която искаме.
    Fodder getFodderBySiloEnumAndAcceptedTime(CategorySiloEnum siloEnum, LocalDate acceptedTime);

    //За извеждане на наличното количество фураж който го има наличен точно сега от определен силоз.
    Long getFodderBySiloEnumAndAcceptedTimeAndSupplierEnumNull(CategorySiloEnum siloEnum, LocalDate localDate);

}
