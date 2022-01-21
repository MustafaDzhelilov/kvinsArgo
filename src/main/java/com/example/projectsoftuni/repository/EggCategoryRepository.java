package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.EggCategory;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EggCategoryRepository extends JpaRepository<EggCategory, Long> {

    Optional<EggCategory> findByEgg(CategoryEggEnum egg);

}
