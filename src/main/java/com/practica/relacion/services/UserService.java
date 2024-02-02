package com.practica.relacion.services;

import com.practica.relacion.model.dto.UserDto;
import com.practica.relacion.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDto> findAll();

    Optional<User> findById(Long id);
}
