package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.User;
import com.example.projectsoftuni.model.entity.UserRoleEntity;
import com.example.projectsoftuni.model.entity.enums.UserRoleEnum;
import com.example.projectsoftuni.model.service.UserServiceModel;
import com.example.projectsoftuni.model.view.UserViewModel;
import com.example.projectsoftuni.repository.UserRepository;
import com.example.projectsoftuni.repository.UserRoleRepository;
import com.example.projectsoftuni.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepository userRoleRepository;
    private final KvinsUserServiceImpl kvinsUserService;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, UserRoleRepository userRoleRepository, KvinsUserServiceImpl kvinsUserService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
        this.kvinsUserService = kvinsUserService;
    }



    @Override
    public void initializeUsersAndRoles() {
        initializeRoles();
        initializeUsers();
    }

    @Override
    public void register(UserServiceModel userServiceModel) {

        UserRoleEntity userRole = userRoleRepository.findByRole(UserRoleEnum.USER);

        User admin = new User();
        admin.setUsername(userServiceModel.getUsername());
        admin.setPassword(passwordEncoder.encode(userServiceModel.getPassword())); //passwordEncoder.encode
        admin.setFirstName(userServiceModel.getFirstName());
        admin.setLastName(userServiceModel.getLastName());
        admin.setEmail(userServiceModel.getEmail());

        admin.setRoles(List.of(userRole));

        admin = userRepository.save(admin);

        UserDetails principal = kvinsUserService.loadUserByUsername(admin.getUsername());
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                admin.getPassword(),
                principal.getAuthorities()
        );

        SecurityContextHolder.
                getContext().
                setAuthentication(authentication);
    }




    private void initializeUsers() {
        if (userRepository.count() == 0) {

            UserRoleEntity adminRole = userRoleRepository.findByRole(UserRoleEnum.ADMIN);

            User admin = new User();
            admin.setUsername("ivancho");
            admin.setPassword(passwordEncoder.encode("111"));
            admin.setFirstName("Ivan");
            admin.setLastName("Ivanov");
            admin.setEmail("ivan@abv.bg");

            admin.setRoles(List.of(adminRole));
            userRepository.save(admin);
        }
    }

    private void initializeRoles() {

        if (userRoleRepository.count() == 0) {
            UserRoleEntity adminRole = new UserRoleEntity();
            adminRole.setRole(UserRoleEnum.ADMIN);

            UserRoleEntity userRole = new UserRoleEntity();
            userRole.setRole(UserRoleEnum.USER);

            userRoleRepository.saveAll(List.of(adminRole, userRole));
        }
    }


    @Override
    public User findByEmail(String email) {
        return userRepository.findUserByEmail(email).orElse(null);
    }

    @Override
    public String findByUsername(String username) {
        return userRepository.findByUsername(username).stream().map(User::getUsername).findFirst().orElse(" ");
    }

    @Override
    public UserViewModel findUserById(Long id) {
        User user = userRepository.findUserById(id).orElse(null);
        UserViewModel userViewModel = new UserViewModel();
      return   modelMapper.map(user, UserViewModel.class);
    }

    @Override
    public void editRegisteredUser(UserViewModel userViewModel, Long id) {
        User user = userRepository.findById(id).orElse(null);
        UserRoleEntity userRole;

        switch (userViewModel.getRoles()){

            case "USER":
                userRole = userRoleRepository.findByRole(UserRoleEnum.USER);
                user.setRoles(List.of(userRole));
                break;
            case "ADMIN":
               userRole = userRoleRepository.findByRole(UserRoleEnum.ADMIN);
                user.setRoles(List.of(userRole));
        }
        System.out.println();
        userRepository.save(user);
    }

    @Override
    public List<UserViewModel> getAllUsers() {
        List<User> users = userRepository.findAll();
       return  users.stream().map(user ->{
            UserViewModel userViewModel = new UserViewModel();
            userViewModel.setFirstName(user.getFirstName());
            userViewModel.setUsername(user.getUsername());
            userViewModel.setEmail(user.getEmail());
            userViewModel.setId(user.getId());
            userViewModel.setLastName(user.getLastName());
            for (UserRoleEntity a: user.getRoles()) {
                userViewModel.setRoles(a.getRole().name());
            }

            return userViewModel;

        }).collect(Collectors.toList());
    }
    
}

