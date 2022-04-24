package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.MainFodder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainFodderRepository extends JpaRepository<MainFodder, Long> {

}
