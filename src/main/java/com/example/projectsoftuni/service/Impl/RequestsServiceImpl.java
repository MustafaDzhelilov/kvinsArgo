package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.Requests;
import com.example.projectsoftuni.model.entity.Sells;
import com.example.projectsoftuni.model.service.RequestsServiceModel;
import com.example.projectsoftuni.model.view.RequestsViewModel;
import com.example.projectsoftuni.repository.RequestsRepository;
import com.example.projectsoftuni.repository.SellsRepository;
import com.example.projectsoftuni.service.RequestsService;
import com.example.projectsoftuni.service.SellsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestsServiceImpl implements RequestsService {
    private final RequestsServiceModel requestsServiceModel;
    private final ModelMapper modelMapper;
    private final RequestsRepository requestsRepository;
    private final SellsRepository sellsRepository;

    public RequestsServiceImpl(RequestsServiceModel requestsServiceModel, ModelMapper modelMapper, RequestsRepository requestsRepository, SellsRepository sellsRepository) {
        this.requestsServiceModel = requestsServiceModel;
        this.modelMapper = modelMapper;
        this.requestsRepository = requestsRepository;
        this.sellsRepository = sellsRepository;
    }

    @Override
    public void add(RequestsServiceModel requestsServiceModel) {
        Requests requests = modelMapper.map(requestsServiceModel, Requests.class);
        requests.setClientEnum(requestsServiceModel.getClientEnum());
        requests.setCategoryEggEnum(requestsServiceModel.getCategoryEggEnum());
        requests.setCategoryCartonsEnum(requestsServiceModel.getCategoryCartonsEnum());
        requests.setCount(requestsServiceModel.getCount());
        requests.setRequestsDate(requestsServiceModel.getRequestsDate());
        requests.setSellCount(0L);

        requestsRepository.save(requests);
    }

   // @Override
    //public List<Requests> getAllRequests() {
     //   return requestsRepository.findAllByOrderByRequestsDateDesc();
    //}

    @Override
    public List<Requests> getModifiedRequests() {
        List<Requests> requests = requestsRepository.findAllByOrderByRequestsDateDesc();

        for(int i=0; i<= requests.size() -1; i++) {

            LocalDateTime start = requests.get(i).getRequestsDate().atStartOfDay();
            LocalDateTime end = start.plusDays(6);

            List<Sells> sellsList = sellsRepository.getSellsByAddDateBetween(start, end);

            if (sellsList.size() >= 1) {

                for (int j = 0; j <= sellsList.size() -1; j++) {

                    if (requests.get(i).getClientEnum().equals(sellsList.get(j).getClientEnum()) &&
                            requests.get(i).getCategoryEggEnum().equals(sellsList.get(j).getEgg()) &&
                            requests.get(i).getCategoryCartonsEnum().equals(sellsList.get(j).getCartons())) {


                        Long currentCount = sellsList.get(j).getCountOfEgg();
                        Long currentReqCount = requests.get(i).getSellCount();
                        currentReqCount += currentCount;

                        requests.get(i).setSellCount(currentReqCount);

                    }
                }

            }
        }

        return requests.stream()
                 .sorted(Comparator.comparing(Requests::getRequestsDate)
                         .thenComparing(Requests::getCategoryEggEnum)
                         .reversed())
                 .collect(Collectors.toList());
    }


    @Override
    public RequestsViewModel findById(Long id) {
        Requests requests = requestsRepository.findById(id).orElse(null);
        RequestsViewModel requestsViewModel = new RequestsViewModel();
        return modelMapper.map(requests, RequestsViewModel.class);
    }

    //User user = userRepository.findById(id).orElse(null);
    //        UserRoleEntity userRole;
    //
    //        switch (userViewModel.getRoles()){
    //
    //            case "USER":
    //                userRole = userRoleRepository.findByRole(UserRoleEnum.USER);
    //                user.setRoles(List.of(userRole));
    //                break;
    //            case "ADMIN":
    //               userRole = userRoleRepository.findByRole(UserRoleEnum.ADMIN);
    //                user.setRoles(List.of(userRole));
    //        }
    //        System.out.println();
    //        userRepository.save(user);

    @Override
    public void editRegisteredUser(RequestsViewModel request, Long id) {
        Requests requests = requestsRepository.findById(id).orElse(null);
        requests.setCount(request.getCount());

        requestsRepository.save(requests);
    }

    @Override
    public void deleteLocation(Long id) {
        requestsRepository.deleteById(id);
    }

}
