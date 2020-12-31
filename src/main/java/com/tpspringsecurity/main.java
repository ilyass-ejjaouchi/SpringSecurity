package com.tpspringsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class main {

    public static void main(String[] args) {
        String pass = "ilyass123";
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String r1 = encoder.encode(pass);
        String r2 = encoder.encode(pass);
        String r3 = encoder.encode(pass);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(encoder.matches(pass,r1));
        System.out.println(encoder.matches(pass,r2));
        System.out.println(encoder.matches(pass,r3));
    }
}
