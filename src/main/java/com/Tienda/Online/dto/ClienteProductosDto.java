package com.Tienda.Online.dto;

import java.util.List;

public class ClienteProductosDto {

	private ClienteDto cliente;
    private List<ProductosDto> productos;
    private Long precioTotal;
    // Getters y setters
    public ClienteDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDto cliente) {
        this.cliente = cliente;
    }

    public List<ProductosDto> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductosDto> productos) {
        this.productos = productos;
    }

	public Long getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Long precioTotal) {
		this.precioTotal = precioTotal;
	}

}