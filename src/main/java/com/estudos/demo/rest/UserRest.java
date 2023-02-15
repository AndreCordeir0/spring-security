package com.estudos.demo.rest;


import com.estudos.demo.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserRest {

    @PostMapping("/adicionar")
    public ResponseEntity salvarUsuario(@RequestBody User user){

        System.out.println(user);
        return null;
    }
}
