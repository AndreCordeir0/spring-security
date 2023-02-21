package com.estudos.demo.rest;


import com.estudos.demo.model.User;
import com.estudos.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserRest {
    @Autowired
    UserService userService;



    @PostMapping("/adicionar")
    public ResponseEntity salvarUsuario(@RequestBody User user){
        User userCreated = userService.salvarNovoUsuario(user);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity logarUsuario(@RequestBody User user){
    String token = userService.gerarTokenParaUsuario(user);
    return ResponseEntity.ok(token);
    }
}
