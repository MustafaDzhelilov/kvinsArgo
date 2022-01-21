package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.Egg;
import com.example.projectsoftuni.model.entity.Hale;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryHaleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface HensAddRepository extends JpaRepository<Hale, Long> {

    List<Hale> findAllByHale(CategoryHaleEnum categoryHaleEnum);

    List<Hale> findLastOrderByHale(CategoryHaleEnum categoryHaleEnum);

    List<Hale> findLastOrderByHaleAndCreated(CategoryHaleEnum hale, LocalDate created);


}
