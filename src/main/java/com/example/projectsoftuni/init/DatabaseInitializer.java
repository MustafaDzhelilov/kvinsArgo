package com.example.projectsoftuni.init;

import com.example.projectsoftuni.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final EggCategoryService eggCategoryService;
    private final BaseCategoryService baseCategoryService;
    private final CartonCategoryService cartonCategoryService;
    private final HaleCategoryService haleCategoryService;
    private final UserService userService;

    public DatabaseInitializer(EggCategoryService eggCategoryService, BaseCategoryService baseCategoryService, CartonCategoryService cartonCategoryService, HaleCategoryService haleCategoryService, UserService userService) {
        this.eggCategoryService = eggCategoryService;
        this.baseCategoryService = baseCategoryService;
        this.cartonCategoryService = cartonCategoryService;
        this.haleCategoryService = haleCategoryService;
        this.userService = userService;
    }


    @Override
    public void run(String... args) throws Exception {
        eggCategoryService.initEggCategories();
        baseCategoryService.initBaseCategories();
        cartonCategoryService.initCartonCategories();
        haleCategoryService.initHaleCategories();
        userService.initializeUsersAndRoles();
    }
}
