package com.Tienda.Online.Service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tienda.Online.Modelo.Clientes;
import com.Tienda.Online.Modelo.Historial;
import com.Tienda.Online.Modelo.Productos;
import com.Tienda.Online.Modelo.ProductosCliente;
import com.Tienda.Online.Modelo.ProductosClienteId;
import com.Tienda.Online.Repositorio.ClienteProductoRepositorio;
import com.Tienda.Online.Repositorio.ClienteRepositorio;
import com.Tienda.Online.Repositorio.HistorialRepositorio;
import com.Tienda.Online.Repositorio.ProductosRepositorio;
import com.Tienda.Online.Service.TiendaService;
import com.Tienda.Online.dto.ClienteProductosDto;
import com.Tienda.Online.dto.HistorialDto;
import com.Tienda.Online.dto.ProductosDto;

@Service
public class TiendaServiceImpl implements TiendaService {

	@Autowired
	private ProductosRepositorio repositorio;
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	@Autowired
	private ClienteProductoRepositorio clienteProductoRepositorio;
	
	final Long PAGADO = 1l;
	
	@Autowired
	private HistorialRepositorio historialRepositorio;
	
	@Override
	public List<Productos> listarTodosLosProductos() {
		return repositorio.findAll();

	}

	@Override
	public Clientes obtenerClientes() {
		return clienteRepositorio.findAll().get(0);
	}

	@Override
	public List<Productos> obtenerCarrito(Long idCliente) {
		List<Long> idProductos = this.clienteProductoRepositorio.findIdProducto(idCliente);
		List<Productos> productos = this.repositorio.findAllById(idProductos);
		return productos;
	}

	@Override
	public void aniadirCarrito(Long idProducto, Long idCliente) {
		Optional<Productos> producto = this.repositorio.findById(idProducto);
		Optional<Clientes> cliente  = clienteRepositorio.findById(idCliente);
		ProductosCliente productoCliente = new ProductosCliente();
		productoCliente.setCantidad(1);
		productoCliente.setProducto(producto.get());
		ProductosClienteId productoClienteId = new ProductosClienteId();
		productoClienteId.setClienteId(cliente.get().getId());
		productoClienteId.setProductoId(idProducto);
		productoCliente.setId(productoClienteId);
		this.clienteProductoRepositorio.save(productoCliente);
	}

	@Override
	public Long pagar(ClienteProductosDto clienteProductos) {
		Historial historial = new Historial();
		historial.setCliente(new Clientes());
		historial.getCliente().setId(clienteProductos.getCliente().getId());
		historial.setDiaPedido(LocalDate.now());
		historial.setPrecioTotal(clienteProductos.getPrecioTotal());
		Random random = new Random();
		Long numeroPedido = random.nextLong(10000000000L); // Genera El número de pedido
		historial.setNumeroPedido(numeroPedido);
		for(ProductosDto productosSave : clienteProductos.getProductos()) {
            Productos producto = new Productos();
            producto.setId(productosSave.getId());
            historial.setProductos(producto);
            historial.setId(null);
    		this.historialRepositorio.save(historial);
		}
		
		this.clienteProductoRepositorio.deleteAll();
		return PAGADO;
	}

	@Override
	public void eliminarCarrito(Long idProducto,Long idCliente) {
		Optional<Productos> producto = this.repositorio.findById(idProducto);
		Clientes cliente = clienteRepositorio.findById(idCliente).get();
		ProductosCliente productoCliente = new ProductosCliente();
		productoCliente.setCantidad(1);
		productoCliente.setProducto(producto.get());
		ProductosClienteId productoClienteId = new ProductosClienteId();
		productoClienteId.setClienteId(cliente.getId());
		productoClienteId.setProductoId(idProducto);
		productoCliente.setId(productoClienteId);
		this.clienteProductoRepositorio.delete(productoCliente);
	}

	@Override
	public List<HistorialDto> obtenerHistorial(Long idCliente) {
	    List<Historial> historial = this.historialRepositorio.findAllByIdCliente(idCliente);

	    Map<Long, HistorialDto> historialDtoMap = new HashMap();

	    for (Historial h : historial) {
	        HistorialDto hdto = historialDtoMap.computeIfAbsent(
	            h.getNumeroPedido(),
	            k -> new HistorialDto(h.getNumeroPedido(), h.getDiaPedido(), h.getPrecioTotal(), new ArrayList<>())
	        );

	        ProductosDto productosDto = new ProductosDto(
	            h.getProductos().getId(),
	            h.getProductos().getDescripcion_producto(),
	            h.getProductos().getPrecio()
	        );

	        hdto.getProductos().add(productosDto);
	    }

	    return new ArrayList<>(historialDtoMap.values());
	}

    
}
