package com.bct.ficheCarriere.controller;

import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AuthenticationController {
    @GetMapping("/customLogin")
    public String getLoginPage(){
        return "test";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        // Manually invalidate the session
        new SecurityContextLogoutHandler().logout(request, response, null);

        // Redirect to the login page with a logout parameter
      return "redirect:/login?logout=true";

    }
}
