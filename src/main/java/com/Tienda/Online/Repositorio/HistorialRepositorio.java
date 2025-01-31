package com.Tienda.Online.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Tienda.Online.Modelo.Historial;


@Repository
public interface HistorialRepositorio extends JpaRepository<Historial, Long> {

    @Query("SELECT h FROM Historial h WHERE h.cliente.id = ?1")
    List<Historial> findAllByIdCliente(Long idCliente);
	
}
