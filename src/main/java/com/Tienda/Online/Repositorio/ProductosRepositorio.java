package com.Tienda.Online.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Tienda.Online.Modelo.Productos;

@Repository
public interface ProductosRepositorio extends JpaRepository<Productos, Long> {

}