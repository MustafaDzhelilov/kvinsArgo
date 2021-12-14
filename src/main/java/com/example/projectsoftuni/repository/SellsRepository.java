package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.Client;
import com.example.projectsoftuni.model.entity.Sells;
import com.example.projectsoftuni.model.view.SellsViewModel;
import com.example.projectsoftuni.service.SellsService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.List;
import java.util.Optional;

@Repository
public interface SellsRepository extends JpaRepository<Sells, Long> {


    List<Sells> findSellsByIdOrderByAddDateDesc(Long id);

    Sells findTopByAddDate(LocalDate addDate);

    List<Sells> findAll();

    List<Sells> findByAddDateOrderByAddDateDesc(LocalDate addDate);


}
