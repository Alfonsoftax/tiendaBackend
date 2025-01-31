package com.Tienda.Online.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tienda.Online.Modelo.Clientes;
import com.Tienda.Online.Modelo.Productos;
import com.Tienda.Online.Service.TiendaService;
import com.Tienda.Online.dto.ClienteProductosDto;
import com.Tienda.Online.dto.HistorialDto;

@RestController 
@RequestMapping("/api/v1/tienda")
public class TiendaControlador {

	@Autowired
	private TiendaService tiendaService;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("")
	public List<Productos> listarTodosLosProductos() {
		return this.tiendaService.listarTodosLosProductos();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/obtenerCliente")
	public Clientes obtenerClientes() {
		return this.tiendaService.obtenerClientes();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/obtenerCarrito/{idCliente}")
	public List<Productos> obtenerCarrito(@PathVariable Long idCliente) {
		return this.tiendaService.obtenerCarrito(idCliente);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/aniadirCarrito/{idProducto}/{idCliente}")
	public void aniadirCarrito(@PathVariable Long idProducto, @PathVariable Long idCliente) {
		this.tiendaService.aniadirCarrito(idProducto, idCliente);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/pagar")
	public Long pagar(@RequestBody  ClienteProductosDto clienteProductos) {
		return this.tiendaService.pagar(clienteProductos);

	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/eliminarCarrito/{idProducto}/{idCliente}")
	public void eliminarCarrito(@PathVariable Long idProducto, @PathVariable Long idCliente) {
		this.tiendaService.eliminarCarrito(idProducto, idCliente);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/obtenerHistorial/{idCliente}")
	public List<HistorialDto> obtenerHistorial(@PathVariable Long idCliente) {
		return this.tiendaService.obtenerHistorial(idCliente);
	}
}
