package com.animeCalendar.controller;

import com.animeCalendar.database.UserDatabase;
import com.animeCalendar.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {
    @Autowired
    private UserDatabase userDatabase;

    @GetMapping("/user/all")
    public List<User> getAllUsers(){
        return userDatabase.findAll();
    }


}
