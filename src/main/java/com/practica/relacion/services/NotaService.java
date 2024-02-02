package com.practica.relacion.services;

import com.practica.relacion.model.dto.UserDto;
import com.practica.relacion.model.entity.Nota;
import com.practica.relacion.model.entity.User;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public interface NotaService {

    List<Nota> findAllNotas ();
    Optional<Nota> encontrarNota(Long id);

    List<Nota> findAllUserNotas(UserDto user);

}
