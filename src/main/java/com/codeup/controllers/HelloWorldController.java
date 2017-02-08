package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    @GetMapping("/demo")
    public String showDefault(Model model){
        List<String> Listnames = new ArrayList<>();
        Listnames.add("zack");
        Listnames.add("fer");
        Listnames.add("luis");
        Listnames.add("jesse");
//passing all attributes to my view using the model
        //This is a string
        model.addAttribute("date","Feb 7th" );
        //Tis is an integer
        model.addAttribute("age","27");
        //This is a list
        model.addAttribute("names",Listnames);

        return "demos/default"; // form.html
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
