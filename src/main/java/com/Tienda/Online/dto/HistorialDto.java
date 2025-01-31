package com.Tienda.Online.dto;

import java.time.LocalDate;
import java.util.List;

public class HistorialDto {
	
	private Long numeroPedido;
	private LocalDate diaPedido;
	private Long precioTotal;
	private List<ProductosDto> productos;
	
    public LocalDate getDiaPedido() {
		return diaPedido;
	}
	public void setDiaPedido(LocalDate diaPedido) {
		this.diaPedido = diaPedido;
	}
	public Long getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(Long precioTotal) {
		this.precioTotal = precioTotal;
	}
	public HistorialDto(Long numeroPedido) {
        this.numeroPedido = numeroPedido;
    }
	public Long getNumeroPedido() {
		return numeroPedido;
	}
    public HistorialDto(Long numeroPedido, LocalDate diaPedido, Long precioTotal, List<ProductosDto> productos) {
        this.numeroPedido = numeroPedido;
        this.diaPedido = diaPedido;
        this.precioTotal = precioTotal;
        this.productos = productos;
    }
	public List<ProductosDto> getProductos() {
		return productos;
	}
	public void setProductos(List<ProductosDto> productos) {
		this.productos = productos;
	}

}