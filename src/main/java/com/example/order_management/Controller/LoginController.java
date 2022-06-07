package com.example.order_management.Controller;

import com.example.order_management.Exception.ApiRequestException;
import com.example.order_management.Services.LoginServices;
import com.example.order_management.model.AuthenticationRequest;
import com.example.order_management.model.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class LoginController {

    @Autowired
    LoginServices loginService;

    @PostMapping("")
    public AuthenticationResponse LogIn(@RequestBody AuthenticationRequest authenticationRequest) throws ApiRequestException {
        return loginService.logIn(authenticationRequest);
    }
}