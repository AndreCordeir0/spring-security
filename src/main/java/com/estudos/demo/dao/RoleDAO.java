package com.estudos.demo.dao;

import com.estudos.demo.model.Role;
import com.estudos.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleDAO extends JpaRepository<Role, Long> {
    @Query("Select role FROM Role role WHERE role.id = ?1")
    public Optional<Role> findById(Long id);

}
