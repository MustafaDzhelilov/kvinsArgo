package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.Cartons;
import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartonAddRepository extends JpaRepository<Cartons, Long> {

    List<Cartons> findAllByBaseAndCartons(CategoryBaseEnum base, CategoryCartonsEnum categoryCartonsEnum);

    // For Scheduling
    List<Cartons> findTopByBaseAndCartons(CategoryBaseEnum base, CategoryCartonsEnum categoryCartonsEnum);

}
