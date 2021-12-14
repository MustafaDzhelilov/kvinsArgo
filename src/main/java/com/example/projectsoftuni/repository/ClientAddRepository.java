package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.Client;
import com.example.projectsoftuni.model.entity.Sells;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientAddRepository extends JpaRepository<Client, Long> {

    List<Client> getClientByBulstatAndDdsAndAdressAndName
            (Long bulstat, Long dds, String adress, String name);

    Client findClientByBulstat(Long client_bulstat);

}
