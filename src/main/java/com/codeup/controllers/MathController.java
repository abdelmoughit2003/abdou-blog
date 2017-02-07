package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by abdelmoughit on 2/7/2017.
 */
@Controller
public class MathController {
    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String add(@PathVariable int num1,@PathVariable int num2){
        int total=num1+num2;
        return "<h1>Total is : " +total+ " !!!!</h1>";
    }
    @GetMapping("/subtract/{num1}/and/{num2}")
    @ResponseBody
    public String subtract(@PathVariable int num1,@PathVariable int num2){
        int total=num1-num2;
        return "<h1>Total is : " +total+ " !!!!</h1>";
    }
    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiply(@PathVariable int num1,@PathVariable int num2){
        int total=num1*num2;
        return "<h1>Total is : " +total+ " !!!!</h1>";
    }
    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public String divide(@PathVariable int num1,@PathVariable int num2){
        int total=num1/num2;
        return "<h1>Total is : " +total+ " !!!!</h1>";
    }

}
