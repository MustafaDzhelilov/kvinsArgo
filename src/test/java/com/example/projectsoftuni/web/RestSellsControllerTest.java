package com.example.projectsoftuni.web;

import com.example.projectsoftuni.model.entity.Sells;
import com.example.projectsoftuni.model.entity.enums.CategoryBaseEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryCartonsEnum;
import com.example.projectsoftuni.model.entity.enums.CategoryEggEnum;
import com.example.projectsoftuni.repository.SellsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RestSellsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SellsRepository sellsRepository;


    @Transactional
    @BeforeEach
    @WithMockUser(username = "admin",roles = "ADMIN")
    void init(){
        Sells sells = new Sells();
        sells.setEgg(CategoryEggEnum.L);
        sells.setCartons(CategoryCartonsEnum.CARTONS_180_WHITE);
        sells.setBase(CategoryBaseEnum.LOWER);
        sells.setPrice(0.2);
        sells.setCountOfEgg(2000L);
        sells.setAddDate(LocalDateTime.now());
        sellsRepository.save(sells);
    }

    @Test
    @WithMockUser(username = "admin",roles = "ADMIN")
    void allSells() throws Exception {
        mockMvc.perform(get("/all-sells"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(jsonPath("$.[0].countOfEgg", is(2000)));
    }

}