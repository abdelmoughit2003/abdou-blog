package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.models.UserPost;
import com.codeup.models.repositories.Posts;
import com.codeup.myservices.PostSvc;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdelmoughit on 2/7/2017.
 */
@Controller
public class PostsController {
////    @GetMapping("/posts")
//    public String posts(Model model){
//// array list with several post objects
//        List<Post> posts = new ArrayList<>();
//        //pass the list to the view (through a view model)
//        posts.add(new Post("My first post", "Body of my first post"));
//        posts.add(new Post("My second post", "Body of my second post"));
//        model.addAttribute("listOfPosts",posts);
//
//        return "posts/index";//posts/index
//    }
////    @GetMapping("/posts/{id}")
//    public String postsid(@PathVariable long id, Model model){
//        Post post = new Post("Hello World","yes here I am");
//        model.addAttribute("post",post);
//        return "posts/show";
//    }//posts show
////    @GetMapping("/posts/create")
//    @ResponseBody
//    public String getcreate(){
//        return "<h1>view the form for creating a post!!!!</h1>";
//    }
////    @PostMapping("/posts/create")
//    @ResponseBody
//    public String postscreate(){
//
//        return "<h1>create a new post!!!!</h1>";
//    }



//    @Autowired
//     PostSvc postSvc;//instance of variable

//    public PostsController(PostSvc postSvc){
//        this.postSvc=postSvc;
//    }
    //Constructor injection
    @Autowired
    Posts postsDao;
    @GetMapping("/posts")
    public String viewAllposts(Model m){
        m.addAttribute("posts", postsDao.findAll());
        //another way to to the same thing without using variables
        //m.addAttribute("posts", postSvc.findAll());
        for(Post post:postsDao.findWhereTitleLike("%abdou%")){
            System.out.println(post.getTitle());
        }
        return "posts/index";
    }
    @GetMapping("/")
    public String firstPage(){
        return "posts/home";
    }

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable long id, Model m){
        m.addAttribute("post", postsDao.findOne(id));
        return "posts/show";
    }
    @GetMapping("/posts/{id}/edit")
    public String editPost(Model viewModel, @PathVariable long id) {
        Post post = postsDao.findOne(id);
        viewModel.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(Model viewModel, @ModelAttribute Post post) {
        
        postsDao.save(post);
        viewModel.addAttribute("post", post);
        return "posts/edit";
    }


    @PostMapping("/posts/delete")
    public String deletePost(@ModelAttribute Post post){
    postsDao.delete(postsDao.findOne(post.getId()));
    return "redirect:/posts";
}


    @GetMapping("/posts/create")
    public String showCreateForm( @ModelAttribute Post post, Model model) {
        model.addAttribute("post",post);
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create(
//            @RequestParam(name = "title") String title,
//            @RequestParam(name = "description") String description


            @ModelAttribute Post post

    )
    {
        postsDao.save(post);
         return "posts/create";
    }



}
