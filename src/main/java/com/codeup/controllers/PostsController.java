package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by abdelmoughit on 2/7/2017.
 */
@Controller
public class PostsController {
    @GetMapping("/posts")
    @ResponseBody
    public String posts(){
        return "<h1>posts index page!!!!</h1>";
    }
    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postsid(){
        return "<h1>view an individual post!!!!</h1>";
    }
    @GetMapping("/posts/create")
    @ResponseBody
    public String getcreate(){
        return "<h1>view the form for creating a post!!!!</h1>";
    }
    @PostMapping("/posts/create")
    @ResponseBody
    public String postscreate(){
        return "<h1>create a new post!!!!</h1>";
    }

}
