package com.example.booksellingwebsite.repository;

import com.example.booksellingwebsite.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    public Long countById(Integer id);

}