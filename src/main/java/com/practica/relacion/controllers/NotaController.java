package com.practica.relacion.controllers;

import com.practica.relacion.model.dto.UserDto;
import com.practica.relacion.model.entity.Nota;
import com.practica.relacion.model.entity.User;
import com.practica.relacion.services.NotaService;
import com.practica.relacion.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notas")
public class NotaController {
    @Autowired
    private NotaService notaService;

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<Nota> list(){
        return notaService.findAllNotas();
    }

    @GetMapping("/{id}")
    public Optional<Nota> obtener (@PathVariable("id") Long id){
        return notaService.encontrarNota(id);
    }

    @GetMapping("usuario/{id}")
    public List<Nota> listaByUsuario(@PathVariable Long id) {
        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            UserDto userDto = convertToUserDto(user);
            return notaService.findAllUserNotas(userDto);
        } else {


        }

    }
    private UserDto convertToUserDto(User user) {
        return new UserDto
                (user.getId(),user.getUsername(), user.getEmail());
    }
}
