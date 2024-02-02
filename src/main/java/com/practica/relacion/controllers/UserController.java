package com.practica.relacion.controllers;

import com.practica.relacion.model.dto.UserDto;
import com.practica.relacion.model.entity.User;
import com.practica.relacion.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public List<UserDto> list(){
        return userService.findAll();
    }
}

