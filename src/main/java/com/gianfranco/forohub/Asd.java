package com.gianfranco.forohub;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Asd {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
