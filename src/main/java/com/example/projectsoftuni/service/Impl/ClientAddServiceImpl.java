package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.Client;
import com.example.projectsoftuni.model.service.ClientServiceModel;
import com.example.projectsoftuni.repository.ClientAddRepository;
import com.example.projectsoftuni.repository.SellsRepository;
import com.example.projectsoftuni.service.ClientAddService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ClientAddServiceImpl implements ClientAddService {

    private final ModelMapper modelMapper;
    private final ClientServiceModel clientServiceModel;
    private final ClientAddRepository clientAddRepository;
    private final SellsRepository sellsRepository;

    public ClientAddServiceImpl(ModelMapper modelMapper, ClientServiceModel clientServiceModel, ClientAddRepository clientAddRepository, SellsRepository sellsRepository) {
        this.modelMapper = modelMapper;
        this.clientServiceModel = clientServiceModel;
        this.clientAddRepository = clientAddRepository;
        this.sellsRepository = sellsRepository;
    }

    @Override
    public void addClient(ClientServiceModel clientServiceModel) {

        Client client = modelMapper.map(clientServiceModel, Client.class);
        client.setBulstat(clientServiceModel.getBulstat());
        client.setAdress(clientServiceModel.getAddress());
        client.setName(clientServiceModel.getName());
        client.setTelephone(clientServiceModel.getTelephone());

        System.out.println();

        clientAddRepository.save(client);
    }

    @Override
    public Client findByClientName(Long bulstat) {
        return clientAddRepository.findClientByBulstat(bulstat);
    }

}
