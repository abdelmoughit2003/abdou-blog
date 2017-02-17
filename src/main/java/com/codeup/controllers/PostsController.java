package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.models.repositories.Posts;
import com.codeup.myservices.UserSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collections;
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
    @Value("${uploads}")
    private String uploadsPath;
    @Autowired
    UserSvc userSvc;
    @GetMapping("/posts")
    public String viewAllposts(Model m){
        m.addAttribute("posts", Collections.emptyList());
        //another way to to the same thing without using variables
        //m.addAttribute("posts", postSvc.findAll());
//        for(Post post:postsDao.findWhereTitleLike("%abdou%")){
//            System.out.println(post.getTitle());
//        }
        return "posts/index";
    }
    @GetMapping("/posts.json")
    public @ResponseBody List<Post> retrieveAllAds(){
        return (List<Post>) postsDao.findAll();
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
//it calls model attribute first
            @Valid Post post,
            Errors validation,
            Model model,
            @RequestParam(name = "image_file") MultipartFile uploadedFile
    )
    {
        if(validation.hasErrors()){

            model.addAttribute("errors",validation);
            model.addAttribute("post",post);
            return "posts/create";
        }
        String filename= uploadedFile.getOriginalFilename();
        String filepath = Paths.get(uploadsPath,filename).toString();
        File destinationFile = new File(filepath);

        try{
            uploadedFile.transferTo(destinationFile);//it will move the file in this step
        }catch (IOException e){
            e.printStackTrace();
        }


//        User user =(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(userSvc.loggedInUser());
        post.setImage(filename);
        postsDao.save(post);
         return "redirect:/posts";
    }

}
