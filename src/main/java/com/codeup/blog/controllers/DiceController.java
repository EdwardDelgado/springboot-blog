package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String salutation(){
        return "roll-dice";
    }


    @GetMapping("/roll-dice/{guess}")
    public String play(@PathVariable Integer guess, Model vModel){
//        Generating random # from 1-6
        int rnd =  (int) (Math.random() * 6 + 1);
//       Determines if you win, or not
        boolean win = (rnd == guess) ? true : false;

        vModel.addAttribute("guess", guess);
        vModel.addAttribute("rnd", rnd);
        vModel.addAttribute("win", win);

        return "roll-dice";
    }

}
