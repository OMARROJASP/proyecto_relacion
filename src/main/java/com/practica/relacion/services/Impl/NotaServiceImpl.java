package com.practica.relacion.services.Impl;

import com.practica.relacion.model.dto.UserDto;
import com.practica.relacion.model.entity.Nota;
import com.practica.relacion.model.entity.User;
import com.practica.relacion.repository.NotaRepository;
import com.practica.relacion.services.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class NotaServiceImpl implements NotaService {

    @Autowired
    private NotaRepository notaRepository;
    @Override
    public List<Nota> findAllNotas() {
        return StreamSupport.stream(notaRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Nota> encontrarNota(Long id) {

        Optional<Nota> notaOptional = notaRepository.findById(id);

        return notaOptional;
    }

    @Override
    public List<Nota> findAllUserNotas(UserDto userDto) {
        User user = convertToUser(userDto);
        return notaRepository.findByUser(user);
    }

    private User convertToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        // Puedes copiar más campos si es necesario
        return user;
    }
}
