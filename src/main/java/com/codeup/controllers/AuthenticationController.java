package com.codeup.controllers;
import com.codeup.models.UserPost;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * .
 */
@Controller
public class AuthenticationController {
    @GetMapping("/login")
    public String login() {
        System.out.println(new BCryptPasswordEncoder().encode("codeup"));
        return "login";
    }
    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("user",new UserPost());
        return "users/create";
    }
}