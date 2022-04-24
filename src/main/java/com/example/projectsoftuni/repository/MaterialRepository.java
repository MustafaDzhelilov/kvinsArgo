package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.Material;
import com.example.projectsoftuni.model.entity.enums.MaterialEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {

    List<Material> getMaterialByMaterialEnum(MaterialEnum materialEnum);
}
