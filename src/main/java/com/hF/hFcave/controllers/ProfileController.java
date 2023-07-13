package com.hF.hFcave.controllers;

import com.hF.hFcave.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @GetMapping("/{id}")
    public User getProfile(@PathVariable("id")User user){
        return user;
    }

}
