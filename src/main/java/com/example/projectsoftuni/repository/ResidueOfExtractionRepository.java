package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.ResidueOfExtraction;
import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryHaleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ResidueOfExtractionRepository extends JpaRepository<ResidueOfExtraction, Long> {

    List<ResidueOfExtraction> findAllByEggAndBase(CategoryEggEnum egg, CategoryBaseEnum base);

}
