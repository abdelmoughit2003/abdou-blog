package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by abdelmoughit on 2/7/2017.
 */
@Controller
public class HelloWorldController {
    @GetMapping("/hello")
    public String homepage(){
        return "home"; // home.html
    }
    @GetMapping("/contact")
    public String contactPage(){
        return "contact/form"; // form.html
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable String name){
        return "<h1>Hello " +name+ " from spring!!!!</h1>";
    }

    @RequestMapping(path= "/bye/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String bye(@PathVariable String name){
        return "<h1>Goodbye " +name+ " from spring!!!!</h1>";
    }

}
