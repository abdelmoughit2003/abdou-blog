package com.codeup.controllers;

import com.codeup.models.User;
import com.codeup.models.UserRole;
import com.codeup.models.repositories.Roles;
import com.codeup.models.repositories.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * .
 */
@Controller
public class AuthenticationController {
    private Users repository;
    private PasswordEncoder encoder;
    @Autowired
    Roles roles;

    @Autowired
    public AuthenticationController(Users repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }


    @GetMapping("/login")
    public String login() {
        System.out.println(new BCryptPasswordEncoder().encode("codeup"));
        return "login";
    }

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "users/create";
    }

    @PostMapping("/users/create")
    public String register(
            @Valid User user,//create the user from the input values, and apply validations
            Errors validation,
            Model viewModel,
            @RequestParam(name = "password_confirm") String passwordConfirmation
    ) {
        //create the user from the input

        //creating a new User Object

        // @ModelAttribute
//        User user =new User();
//        user.setPassword();
//        user.setUsername();
//        user.setEmail();
        System.out.println("message");

        if (!passwordConfirmation.equals(user.getPassword())) {
            System.out.println("confirm");
            validation.rejectValue("password", "user.password", "Your passwords doesn't match");
            viewModel.addAttribute("errors", validation);
            viewModel.addAttribute("user", user);
            return "users/create";
        }

        if (validation.hasErrors()) {
            System.out.println("general message");
            viewModel.addAttribute("errors", validation);
            viewModel.addAttribute("user", user);
            return "users/create";
        }

        String hashedPassword = encoder.encode(user.getPassword()); //hash the user password

        user.setPassword(hashedPassword); //save user to the database
        User newUser = repository.save(user);
        UserRole userRole=new UserRole();
        userRole.setRole("ROLE_USER");
        userRole.setUserId(newUser.getId());
        roles.save(userRole);
        return "redirect:/login";//redirect the user to the login page
    }
}