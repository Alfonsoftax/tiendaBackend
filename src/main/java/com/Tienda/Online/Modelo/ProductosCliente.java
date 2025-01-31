package com.Tienda.Online.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

//Entidad relacional de la tabla productos_cliente
@Entity
@Table(name = "productos_cliente")
public class ProductosCliente {

	@EmbeddedId
	private ProductosClienteId id;
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;  
	@ManyToOne
	@MapsId("productoId")
	@JoinColumn(name = "fk_producto")
	private Productos producto;
	
	public ProductosClienteId getId() {
		return id;
	}
	public void setId(ProductosClienteId id) {
		this.id = id;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Productos getProducto() {
		return producto;
	}
	public void setProducto(Productos producto) {
		this.producto = producto;
	}
	
}