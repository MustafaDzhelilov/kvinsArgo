package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.BaseCategory;
import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BaseCategoryRepository extends JpaRepository<BaseCategory, Long> {

    Optional<BaseCategory> findByBase(CategoryBaseEnum categoryBaseEnum);
}
