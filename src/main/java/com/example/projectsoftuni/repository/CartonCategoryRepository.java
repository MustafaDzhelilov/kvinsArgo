package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.CartonCategory;
import com.example.projectsoftuni.model.entity.Cartons;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartonCategoryRepository extends JpaRepository<CartonCategory, Long> {

    Optional<CartonCategory> findByCartons(CategoryCartonsEnum categoryCartonsEnum);
}
