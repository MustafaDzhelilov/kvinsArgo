package com.example.projectsoftuni.repository;

import com.example.projectsoftuni.model.entity.UserRoleEntity;
import com.example.projectsoftuni.model.entity.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

    UserRoleEntity findByRole(UserRoleEnum role);
}
