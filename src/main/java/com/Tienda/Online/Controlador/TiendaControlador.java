package com.Tienda.Online.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tienda.Online.Modelo.Clientes;
import com.Tienda.Online.Modelo.Productos;
import com.Tienda.Online.Repositorio.ClienteProductoRepositorio;
import com.Tienda.Online.Repositorio.ClienteRepositorio;
import com.Tienda.Online.Repositorio.ProductosRepositorio;

@RestController 
@RequestMapping("/api/v1/tienda")
public class TiendaControlador {

	@Autowired
	private ProductosRepositorio repositorio;
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	@Autowired
	private ClienteProductoRepositorio clienteProductoRepositorio;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("")
	public List<Productos> listarTodosLosProductos() {
		return repositorio.findAll();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/obtenerCliente")
	public Clientes obtenerClientes() {
		return clienteRepositorio.findAll().get(0);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/obtenerCarrito")
	public List<Productos> obtenerCarrito() {
		List<Long> idProductos = this.clienteProductoRepositorio.findIdProducto();
		List<Productos> productos = this.repositorio.findAllById(idProductos);
		return productos;
	}
}
