package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.User;
import com.example.projectsoftuni.model.entity.UserRoleEntity;
import com.example.projectsoftuni.model.entity.enums.UserRoleEnum;
import com.example.projectsoftuni.repository.UserRepository;
import com.example.projectsoftuni.repository.UserRoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class UserServiceImplTest {

    private UserServiceImpl userService;

    @Mock
    private ModelMapper mockModelMapper;
    @Mock
    private PasswordEncoder mockPasswordEncoder;
    @Mock
    private UserRepository mockUserRepository;

    @Mock
    private UserRoleRepository userRoleRepository;
    @Mock
    private KvinsUserServiceImpl kvinsUserService;

    User testUser;
    @BeforeEach
    void init(){
        userService = new UserServiceImpl(mockUserRepository,mockModelMapper,mockPasswordEncoder, userRoleRepository,kvinsUserService);
        testUser = new User();
        testUser.setFirstName("Test");
        testUser.setLastName("Testov");
        testUser.setUsername("test");
        testUser.setPassword("111");
        testUser.setEmail("test@test.abv.bg");
        UserRoleEntity entity = new UserRoleEntity();
        entity.setRole(UserRoleEnum.ADMIN);
        testUser.addRoles(entity);
    }

    @Test
    void findUser(){
        Mockito.when(mockUserRepository.findByUsername(testUser.getUsername())).thenReturn(Optional.ofNullable(testUser));
        User actual = userService.findByEmail("test");
        String username = userService.findByUsername("test");

        assertEquals(username,testUser.getUsername());
    }

}