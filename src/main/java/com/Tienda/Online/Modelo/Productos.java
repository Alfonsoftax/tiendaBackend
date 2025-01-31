package com.Tienda.Online.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Entidad de la tabla productos
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
