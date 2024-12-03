package com.Tienda.Online.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Tienda.Online.Modelo.Clientes;


@Repository
public interface ClienteRepositorio extends JpaRepository<Clientes, Long> {

}
