package com.tpspringsecurity.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomSuccessHandler  implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        FilterChain chain,
                                        Authentication authentication) throws IOException, ServletException {

    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        authentication.getAuthorities().forEach(role ->{
            String rs ;
            switch(role.getAuthority()) {
                case "ROLE_USER":
                    rs = "/user/dashboard";
                    break;
                case "ROLE_ADMIN":
                    rs = "/admin/dashboard";
                    break;
                default:
                    throw new IllegalStateException();
            }
            try {
                new DefaultRedirectStrategy().sendRedirect(request,response,rs);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
