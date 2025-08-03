package com.gianfranco.forohub.controller;

import com.gianfranco.forohub.config.JwtUtil;
import com.gianfranco.forohub.dto.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    private AuthenticationManager am;
    private JwtUtil jwt;

    public LoginController(AuthenticationManager am, JwtUtil jwt) {
        this.am = am;
        this.jwt = jwt;
    }

    @PostMapping("/login")
    public Map<String,String> login(@RequestBody UsernamePasswordAuthenticationToken req){
        Authentication a = am.authenticate(
                new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(req.username(),req.password()));
        String token = jwt.generateToken((UserDetails)a.getPrincipal());
        return Map.of("token", token);
    }
}
