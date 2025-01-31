package com.Tienda.Online.Service;

import java.util.List;

import com.Tienda.Online.Modelo.Clientes;
import com.Tienda.Online.Modelo.Productos;
import com.Tienda.Online.dto.ClienteProductosDto;
import com.Tienda.Online.dto.HistorialDto;

public interface TiendaService {

	public List<Productos> listarTodosLosProductos();
	public Clientes obtenerClientes();
	public List<Productos> obtenerCarrito(Long idCliente);
	public void aniadirCarrito(Long idProducto, Long idCliente);
	public Long pagar(ClienteProductosDto clienteProductos);
	public void eliminarCarrito(Long idProducto, Long idCliente);
	public List<HistorialDto> obtenerHistorial(Long idCliente);
    
}
