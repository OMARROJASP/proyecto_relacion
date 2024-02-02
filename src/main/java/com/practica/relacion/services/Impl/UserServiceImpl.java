package com.practica.relacion.services.Impl;

import com.practica.relacion.model.dto.UserDto;
import com.practica.relacion.model.dto.mapper.DtoMapperUser;
import com.practica.relacion.model.entity.User;
import com.practica.relacion.repository.UserRepository;
import com.practica.relacion.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<UserDto> findAll() {
        List<User> users = (List<User>) userRepository.findAll();
        return users
                .stream()
                .map(u -> DtoMapperUser.builder().setUser(u).build())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<User> user = userRepository.findById(id);

        return user;
    }


}
