package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.HaleCategory;
import com.example.projectsoftuni.model.entity.enums.CategoryHaleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HaleCategoryRepository extends JpaRepository<HaleCategory, Long> {

    Optional<HaleCategory> findByHale(CategoryHaleEnum categoryHaleEnum);
}
