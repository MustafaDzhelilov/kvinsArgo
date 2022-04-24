package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.PackingProduct;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.model.entity.enums.PackagingCartonsEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductAfterPackagingRepository extends JpaRepository<PackingProduct, Long> {

    List<PackingProduct> getPackingProductByCategoryEggEnumAndPackagingCartonsEnum(CategoryEggEnum categoryEggEnum, PackagingCartonsEnum packagingCartonsEnum);

    List<PackingProduct> findDistinctByCategoryCartonsEnumIsNotNull();
}
