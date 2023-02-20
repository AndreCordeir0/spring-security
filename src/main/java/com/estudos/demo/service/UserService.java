package com.estudos.demo.service;

import com.estudos.demo.dao.RoleDAO;
import com.estudos.demo.dao.UserDAO;
import com.estudos.demo.dao.UserRoleDAO;
import com.estudos.demo.model.Role;
import com.estudos.demo.model.User;
import com.estudos.demo.model.UserRoles;
import com.estudos.demo.securingweb.WebSecurityConfig;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    RoleDAO roleDAO;

    @Autowired
    UserRoleDAO UserRoleDAO;


    @Transactional(Transactional.TxType.REQUIRED)
    public User salvarNovoUsuario(User user){

        System.out.println("aa");
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        String passwordEncoded = bc.encode(user.getPassword());
        user.setPassword(passwordEncoded);

        userDAO.save(user);
        userDAO.flush();
        Optional<Role> roleOptional =  roleDAO.findById(1L);
        Role role = roleOptional.get();

        UserRoles userRoles = new UserRoles(user, role);
        UserRoleDAO.save(userRoles);
        return user;
    }
}
