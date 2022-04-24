package com.example.projectsoftuni.service;

import com.example.projectsoftuni.model.entity.Requests;
import com.example.projectsoftuni.model.service.RequestsServiceModel;
import com.example.projectsoftuni.model.view.RequestsViewModel;

import java.util.List;

public interface RequestsService {
    void add(RequestsServiceModel requestsServiceModel);

   // List<Requests> getAllRequests();

    List<Requests> getModifiedRequests();

    RequestsViewModel findById(Long id);

    void editRegisteredUser(RequestsViewModel request, Long id);

    void deleteLocation(Long id);
}
