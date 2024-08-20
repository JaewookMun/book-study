package com.github.jaewookmun.tdd.ch09_integration_test.user.api;

import com.github.jaewookmun.tdd.ch09_integration_test.user.UserRegReq;
import com.github.jaewookmun.tdd.ch09_integration_test.user.UserRegister;
import com.github.jaewookmun.tdd.ch09_integration_test.user.exception.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class UserApi {
    @Autowired
    private UserRegister userRegister;

    @PostMapping("/users")
    public ResponseEntity<Object> register(@RequestBody UserRegReq req) {
        try {
            userRegister.register(req.getId(), req.getPw(), req.getEmail());
            return ResponseEntity.created(URI.create("/users/" + req.getId())).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ErrorResponse.error(e));
        }
    }
}
