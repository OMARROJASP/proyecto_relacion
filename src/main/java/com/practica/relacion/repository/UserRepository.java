package com.practica.relacion.repository;

import com.practica.relacion.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
