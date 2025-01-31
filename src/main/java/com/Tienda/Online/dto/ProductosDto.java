package com.Tienda.Online.dto;

public class ProductosDto {


	private Long id;

	private String descripcionProducto;

	public ProductosDto(Long id, String descripcionProducto, Integer precio) {
		super();
		this.id = id;
		this.descripcionProducto = descripcionProducto;
		this.precio = precio;
	}

	private Integer precio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public ProductosDto() {
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	

}