package com.estudos.demo.dao;

import com.estudos.demo.model.User;
import com.estudos.demo.model.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRoleDAO extends JpaRepository<UserRoles, Long> {

}
