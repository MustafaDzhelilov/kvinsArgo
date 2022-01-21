package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.Sells;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.model.entity.enums.ClientEnum;
import com.example.projectsoftuni.model.entity.enums.PalletTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SellsRepository extends JpaRepository<Sells, Long> {


    List<Sells> findSellsByIdOrderByAddDateDesc(Long id);

    Sells findTopByAddDate(LocalDate addDate);

    List<Sells> findAll();

    List<Sells> findByAddDateOrderByAddDateDesc(LocalDate addDate);

    List<Sells> getAllByClientEnumAndPalletTypeEnum(ClientEnum clientEnum, PalletTypeEnum palletTypeEnum);

    List<Sells> findSellsByEggAndAddDateBetween(CategoryEggEnum egg, LocalDate start, LocalDate end);


}
