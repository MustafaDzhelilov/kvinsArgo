package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.Requests;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.model.entity.enums.ClientEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RequestsRepository extends JpaRepository<Requests, Long> {

    List<Requests> findAllByOrderByRequestsDateDesc();
}
