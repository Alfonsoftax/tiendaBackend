package com.Tienda.Online.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Tienda.Online.Modelo.Clientes;

// Repositorio en el que consultamos los clientes
@Repository
public interface ClienteRepositorio extends JpaRepository<Clientes, Long> {
	@Query("SELECT c FROM Clientes c WHERE c.email = :email AND c.password = :password")
	Clientes findByEmail(String email, String password);
}
