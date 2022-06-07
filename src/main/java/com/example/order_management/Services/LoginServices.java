package com.example.order_management.Services;


import com.example.order_management.Exception.ApiRequestException;
import com.example.order_management.model.AuthenticationRequest;
import com.example.order_management.model.AuthenticationResponse;
import com.example.order_management.security.JwtUtil;
import com.example.order_management.security.MyCustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class LoginServices {

    @Autowired
    private MyCustomerDetailsService myCustomerDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtTokenUtil;

    public AuthenticationResponse logIn(AuthenticationRequest authenticationRequest) throws ApiRequestException {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new ApiRequestException("Incorrect email or password");
        }
        catch (Exception e){
            throw new ApiRequestException(e.getMessage());
        }

        final UserDetails userDetails = myCustomerDetailsService.loadUserByUsername(authenticationRequest.getEmail());

        final String jwt = jwtTokenUtil.generateToken(userDetails);
        final Date expirationTime = jwtTokenUtil.extractExpiration(jwt);

        return new AuthenticationResponse(jwt,expirationTime, userDetails.getUsername(), userDetails.getAuthorities());
    }


}