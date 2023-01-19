package com.estudos.demo.rest;



import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/teste")
public class RestTest {

    @GetMapping("/oi")
    public ResponseEntity devolverOk(){
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        String passwordEncoded = b.encode("1234");
        String passwordEncoded2 = b.encode("1234");
        System.out.println(passwordEncoded + " Segundo : " + passwordEncoded2);
        System.out.println(b.matches("1234",passwordEncoded));
        return ResponseEntity.ok(passwordEncoded);
    }
}
