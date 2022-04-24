package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.CoreyFreeAfterPackaging;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoreyAfterPackagingRepository extends JpaRepository<CoreyFreeAfterPackaging, Long> {

    List<CoreyFreeAfterPackaging> findAllByCartons(CategoryCartonsEnum cartons);
}
