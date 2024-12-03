package com.Tienda.Online.Modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "descripcion_producto", length = 255)
	private String descripcionProducto;

	@Column(name = "precio")
	private Integer precio;

	
//	@ManyToMany(mappedBy = "productos")
//	private List<Pedido> pedidos;
//	public List<Pedido> getPedidos() {
//		return pedidos;
//	}
//
//	public void setPedidos(List<Pedido> pedidos) {
//		this.pedidos = pedidos;
//	}

	public Productos() {
	}

	public Productos(Long id, String descripcion_producto, Integer precio) {
		super();
		this.id = id;
		this.descripcionProducto = descripcion_producto;
		this.precio = precio;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion_producto() {
		return descripcionProducto;
	}

	public void setDescripcion_producto(String descripcion_producto) {
		this.descripcionProducto = descripcion_producto;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	
}
