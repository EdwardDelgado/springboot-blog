package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostsController {

    @GetMapping("/posts")
    @ResponseBody

    public String posts(){
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody

    public String postsId(){
        return "view an individual post";
    }

    @GetMapping("/posts/create")
    @ResponseBody

    public String postsCreateGet(){
        return "view the form for creating a post";
    }

    @PatchMapping("/posts/create")
    @ResponseBody

    public String postsCreatePost(){
        return "create a new post";
    }
}