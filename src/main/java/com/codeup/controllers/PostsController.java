package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.mysercices.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdelmoughit on 2/7/2017.
 */
@Controller
public class PostsController {
//    @GetMapping("/posts")
    public String posts(Model model){
// array list with several post objects
        List<Post> posts = new ArrayList<>();
        //pass the list to the view (through a view model)
        posts.add(new Post("My first post", "Body of my first post"));
        posts.add(new Post("My second post", "Body of my second post"));
        model.addAttribute("listOfPosts",posts);

        return "posts/index";//posts/index
    }
//    @GetMapping("/posts/{id}")
    public String postsid(@PathVariable long id, Model model){
        Post post = new Post("Hello World","yes here I am");
        model.addAttribute("post",post);
        return "posts/show";
    }//posts show
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


     PostSvc postSvc;//instance of variable

    //Constructor injection
    @Autowired
    public PostsController(PostSvc postSvc){
        this.postSvc=postSvc;
    }

    @GetMapping("/posts")
    public String viewAllposts(Model m){
        List<Post> posts = postSvc.findAll();
        m.addAttribute("posts", posts);
        //another way to to the same thing without using variables
        //m.addAttribute("ads", adSvc.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable int id, Model m){
        m.addAttribute("post", postSvc.findOne(id));
        return "posts/show";
    }


}
