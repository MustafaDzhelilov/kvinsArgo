package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.Packaging;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackagingRepository extends JpaRepository<Packaging, Long> {

    List<Packaging> getAllByCategoryEggEnumAndCategoryCartonsEnum(CategoryEggEnum categoryEggEnum, CategoryCartonsEnum categoryCartonsEnum);

}
