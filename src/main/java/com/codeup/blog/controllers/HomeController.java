package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 1. Add Controller Annotation
@Controller
public class HomeController {

//    4. Bind this method to a URL
    @GetMapping("/home")

//    3. Add response body annotation
    @ResponseBody

//    2. Create a regular method for your controller action
    public String home(){
        return "This is the landing page!";
    }

}
