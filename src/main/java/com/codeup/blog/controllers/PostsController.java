package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import com.codeup.blog.repositories.UsersRepository;
import com.codeup.blog.services.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostsController {
    private final PostSvc service;
    private final UsersRepository usersDao;

    @Autowired
    // Constructor injection
    public PostsController(PostSvc service, UsersRepository usersDao) {

        this.service = service;
        this.usersDao = usersDao;
    }

    @GetMapping("/posts")
    public String showAll(Model vModel) {
        vModel.addAttribute("posts", service.findAll());
        return "posts/index";
    }

    // auto-boxing
    //int -> Integer
    // long -> Long

    // Extra step needed in this case
    // Boxing is not automatic
    // int -> long -> Long X
    // This is fine because it doesn't interact with objects, they're both primitive types
    // int -> long

    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable int id, Model vModel){
        vModel.addAttribute("post", service.findById(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model vModel){
        vModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post){
        User user = usersDao.findOne(2L);
        post.setUser(user);
        service.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(Model vModel, @PathVariable long id) {
        Post existingPost = service.findById(id);
        vModel.addAttribute("post", existingPost);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable long id, @ModelAttribute Post post) {
        // the post object we get from the form only has a title and body
        // and in order to update an existing record, we need to have an id
        // well use the path variable to set the id of the post object
        // before we try to save it
        post.setId(id);
        service.save(post);
        return "redirect:/posts/" + post.getId();
    }

    @PostMapping("/posts/{id}/delete")
    public String removeFromExistence(@PathVariable long id) {
        service.delete(id);
        return "redirect:/posts";
    }

}