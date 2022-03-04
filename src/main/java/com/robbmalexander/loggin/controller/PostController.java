package com.robbmalexander.loggin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PostController {
    @GetMapping("/posts/{username}")
    public String getPostsPage(@PathVariable String username, Model model) {
        model.addAttribute("username", username);
        return "posts.html";
    }
}
