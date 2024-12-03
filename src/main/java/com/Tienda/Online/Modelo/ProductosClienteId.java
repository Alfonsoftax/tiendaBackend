package com.Tienda.Online.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProductosClienteId {

	public Long getProductoId() {
		return productoId;
	}
	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	@Column(name = "fk_producto", length = 50)
	private Long productoId; 
	@Column(name = "fk_cliente", length = 50)
	private Long clienteId;	
	
}
