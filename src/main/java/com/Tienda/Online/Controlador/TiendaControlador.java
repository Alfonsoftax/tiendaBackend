package com.Tienda.Online.Controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tienda.Online.Modelo.Clientes;
import com.Tienda.Online.Modelo.Productos;
import com.Tienda.Online.Modelo.ProductosCliente;
import com.Tienda.Online.Modelo.ProductosClienteId;
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
	
	final Long PAGADO = 1l;
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
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/aniadirCarrito/{idProducto}")
	public void aniadirCarrito(@PathVariable Long idProducto) {
		Optional<Productos> producto = this.repositorio.findById(idProducto);
		Clientes cliente = clienteRepositorio.findAll().get(0);
		ProductosCliente productoCliente = new ProductosCliente();
		productoCliente.setCantidad(1);
		productoCliente.setProducto(producto.get());
		ProductosClienteId productoClienteId = new ProductosClienteId();
		productoClienteId.setClienteId(cliente.getId());
		productoClienteId.setProductoId(idProducto);
		productoCliente.setId(productoClienteId);
		this.clienteProductoRepositorio.save(productoCliente);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/pagar")
	public Long pagar() {
		this.clienteProductoRepositorio.deleteAll();
		return PAGADO;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/eliminarCarrito/{idProducto}")
	public void eliminarCarrito(@PathVariable Long idProducto) {
		Optional<Productos> producto = this.repositorio.findById(idProducto);
		Clientes cliente = clienteRepositorio.findAll().get(0);
		ProductosCliente productoCliente = new ProductosCliente();
		productoCliente.setCantidad(1);
		productoCliente.setProducto(producto.get());
		ProductosClienteId productoClienteId = new ProductosClienteId();
		productoClienteId.setClienteId(cliente.getId());
		productoClienteId.setProductoId(idProducto);
		productoCliente.setId(productoClienteId);
		this.clienteProductoRepositorio.delete(productoCliente);
	}
}
