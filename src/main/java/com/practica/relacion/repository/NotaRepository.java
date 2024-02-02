package com.practica.relacion.repository;

import com.practica.relacion.model.dto.UserDto;
import com.practica.relacion.model.entity.Nota;
import com.practica.relacion.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotaRepository extends CrudRepository<Nota, Long> {

    List<Nota> findByUser(User user);
}
