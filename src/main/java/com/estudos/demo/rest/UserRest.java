package com.estudos.demo.rest;


import com.estudos.demo.dto.JwtDTO;
import com.estudos.demo.model.User;
import com.estudos.demo.service.UserService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin("*")
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
        JwtDTO jwtDto = new JwtDTO();
        jwtDto.setJwtToken(token);
    return ResponseEntity.ok(jwtDto);
    }
}
