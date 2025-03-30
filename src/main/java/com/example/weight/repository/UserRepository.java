package com.example.weight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.weight.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
    
}
