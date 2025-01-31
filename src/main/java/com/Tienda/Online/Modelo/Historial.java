package com.Tienda.Online.Modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "historial")
public class Historial {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "numero_pedido")
    private Long numeroPedido;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes cliente;

    @Column(name = "dia_pedido")
    private LocalDate diaPedido;

    @Column(name = "precio_total")
    private Long precioTotal;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Productos productos;

    public Historial() {}

    public Historial(Long numeroPedido, Clientes cliente, Productos productos, LocalDate diaPedido, Long precioTotal) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.productos = productos;
        this.diaPedido = diaPedido;
        this.precioTotal = precioTotal;
    }

    // ✅ Getters y Setters
    public Long getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Long numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

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

    @Override
    public String toString() {
        return "Historial{" +
                "numeroPedido=" + numeroPedido +
                ", cliente=" + cliente.getId() +
                ", productos=" + productos +
                ", diaPedido=" + diaPedido +
                ", precioTotal=" + precioTotal +
                '}';
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}