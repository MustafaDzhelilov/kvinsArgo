package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.entity.Client;
import com.example.projectsoftuni.model.service.ClientServiceModel;

import java.util.Optional;

public interface ClientAddService {
    void addClient(ClientServiceModel clientServiceModel);

        Client findByClientName(Long bulstat);

}
