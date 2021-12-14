package com.example.projectsoftuni.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "admin",roles = "USER")
    void adminContr() throws Exception {
        mockMvc.perform(get("/percentage-table"))
                .andExpect(status().isOk());
        mockMvc.perform(get("/count-cartons-now"))
                .andExpect(status().isOk());
        mockMvc.perform(get("/count-hens-now"))
                .andExpect(status().isOk());
        mockMvc.perform(get("/allCountTableByCategory"))
                .andExpect(status().isOk());
        mockMvc.perform(get("/home"))
                .andExpect(status().isOk());
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());

    }

}