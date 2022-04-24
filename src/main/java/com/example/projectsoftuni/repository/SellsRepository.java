package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.Sells;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.model.entity.enums.ClientEnum;
import com.example.projectsoftuni.model.entity.enums.PalletTypeEnum;
import com.example.projectsoftuni.model.view.SellsViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

@Repository
public interface SellsRepository extends JpaRepository<Sells, Long> {


    List<Sells> findSellsByIdOrderByAddDateDesc(Long id);

    Sells findTopByAddDate(LocalDate addDate);

    List<Sells> findAll();

    List<Sells> findByAddDateOrderByAddDateDesc(LocalDate addDate);

    List<Sells> getAllByClientEnumAndPalletTypeEnum(ClientEnum clientEnum, PalletTypeEnum palletTypeEnum);

    List<Sells> findSellsByEggAndAddDateBetween(CategoryEggEnum egg, LocalDateTime start, LocalDateTime end);

    Sells findSellsByAddDateBetween(LocalDate start, LocalDate end);

    List<Sells> getSellsByAddDateBetween(LocalDateTime start, LocalDateTime end);

    List<Sells> findSellsByEggAndClientEnumAndAddDateBetween(CategoryEggEnum egg, ClientEnum clientEnum, LocalDateTime start, LocalDateTime end);

    Sells getSellsByClientEnum(ClientEnum clientEnum);

    List<Sells> getAllByAddDateBetween(LocalDateTime start, LocalDateTime end);










}
