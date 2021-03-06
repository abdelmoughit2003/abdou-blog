package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * .
 */
@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String roll(){
    return "rollDiceexercise/rolling";
    }
    @GetMapping("/roll-dice/{n}")
    public String roll(@PathVariable int n, Model model){
//        model.addAttribute("numbers",new []{1,2,3,4,5,6});
        int randomNumber;
        Random random=new Random();
        randomNumber = random.nextInt(6) + 1;
        String result;
        if(n==randomNumber){
          result="you won";
        }else{
          result="you lost";
        }
        model.addAttribute("choice",result);
        model.addAttribute("guess",n);
        model.addAttribute("result",randomNumber);
        return "rollDiceexercise/rollingResult";

    }
}
