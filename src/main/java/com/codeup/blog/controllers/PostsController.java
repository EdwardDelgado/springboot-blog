package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostsController {

    @GetMapping("/posts")
    @ResponseBody

    public String showAll(){
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody

    public String postId(@PathVariable int id){
        return "view an individual post " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody

    public String showCreateForm(){
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody

    public String createPost(){
        return "create a new post";
    }
}
