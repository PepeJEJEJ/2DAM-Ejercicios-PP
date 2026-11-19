package com.dam.pc128;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNombreContaining(String texto); // WHERE nombre LIKE %texto%
}