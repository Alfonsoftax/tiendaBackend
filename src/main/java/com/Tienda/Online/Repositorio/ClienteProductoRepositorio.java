package com.Tienda.Online.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.Tienda.Online.Modelo.ProductosCliente;
import com.Tienda.Online.Modelo.ProductosClienteId;

//Repositorio en el que consultamos los productos de un cliente
@Repository
public interface ClienteProductoRepositorio extends JpaRepository<ProductosCliente, ProductosClienteId> {
	@Query("select p.id.productoId from ProductosCliente p where p.id.clienteId = ?1")
	List<Long> findIdProducto(Long idCliente);

}
