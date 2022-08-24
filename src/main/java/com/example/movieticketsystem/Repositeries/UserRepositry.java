package com.example.movieticketsystem.Repositeries;

import com.example.movieticketsystem.Entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositry extends JpaRepository<User,Integer> {
    User findUserById(Integer id);
   User   findUserByUsername(String username);
}
