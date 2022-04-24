package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.Egg;
import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryHaleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface EggAddRepository extends JpaRepository<Egg, Long> {


    List<Egg> findAllByEgg(CategoryEggEnum xl);

    List<Egg> findAllByEggAndBaseAndCartons(CategoryEggEnum categoryEggEnum
            , CategoryBaseEnum categoryBaseEnum, CategoryCartonsEnum categoryCartonsEnum);


    List<Egg> findByHaleAndEggAndAddDate(CategoryHaleEnum hale, CategoryEggEnum egg, LocalDate addDate);

    List<Egg> findByHaleAndAddDate(CategoryHaleEnum hale, LocalDate addDate);

    List<Egg> findByAddDate(LocalDate addDate);

    List<Egg> findAll();

}
