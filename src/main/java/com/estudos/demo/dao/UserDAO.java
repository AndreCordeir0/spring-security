package com.estudos.demo.dao;

import com.estudos.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserDAO extends JpaRepository<User, Long> {
    @Query("Select user FROM User user WHERE user.email = ?1")
    public Optional<User> findByUsername(String username);

    @Query("Select user FROM User user WHERE user.email = ?1")
    Boolean existsByUsername(String username);


    @Query("Select user FROM User user WHERE user.email = ?1")
    Boolean existsByEmail(String email);
}
