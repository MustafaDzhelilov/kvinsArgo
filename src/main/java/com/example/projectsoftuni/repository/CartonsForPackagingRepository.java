package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.CartonsForPackaging;
import com.example.projectsoftuni.model.entity.enums.PackagingCartonsEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartonsForPackagingRepository extends JpaRepository<CartonsForPackaging, Long> {

    List<CartonsForPackaging> findAllByPackagingCartonsEnum(PackagingCartonsEnum packagingCartonsEnum);
}
