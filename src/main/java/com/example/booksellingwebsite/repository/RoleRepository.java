package com.example.booksellingwebsite.repository;

import com.example.booksellingwebsite.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}