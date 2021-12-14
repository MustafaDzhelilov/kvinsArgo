package com.example.projectsoftuni.web;

import com.example.projectsoftuni.model.view.SellsViewModel;
import com.example.projectsoftuni.service.SellsService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RestSellsController {

    private final SellsService sellsService;

    public RestSellsController(SellsService sellsService) {
        this.sellsService = sellsService;
    }

    @Transactional
    @GetMapping("/all-sells")
    public ResponseEntity<List<SellsViewModel>> getRestAllSells(){
        List<SellsViewModel>  allSells  = sellsService.getAllSells().stream().sorted(Comparator.comparing(SellsViewModel::getAddDate)).collect(Collectors.toList());
        return ResponseEntity.ok(allSells);
    }

}
