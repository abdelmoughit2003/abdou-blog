package com.codeup.controllers;

import com.codeup.models.User;
import com.codeup.models.repositories.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by abdelmoughit on 2/10/2017.
 */
@Controller
public class UserPostController {
    @Autowired
    Users usersDao;


    @GetMapping("/users/{id}")
    public String showUser(@PathVariable long id, Model m){
        User user= usersDao.findOne(id);
        m.addAttribute("user",user);
        return "users/show";
    }
}
