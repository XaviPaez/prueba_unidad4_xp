package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "producto")

public class Producto {

	@Id
	@Column(name = "prod_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_id_seq")
	@SequenceGenerator(name = "prod_id_seq", sequenceName = "prod_id_seq", allocationSize = 1)
	private Integer id;
	@Column(name = "prod_codigo_barra")
	private String codigoBarra;
	@Column(name = "prod_nombre")
	private String nombre;
	@Column(name = "prod_categoria")
	private String categoria;
	@Column(name = "prod_Stock")
	private Integer Stock;
	@Column(name = "prod_precio")
	private BigDecimal precio;

	@OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
	private List<DetalleVenta> detalleVentas;

	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", codigoBarra=" + codigoBarra
				+ ", Stock=" + Stock + ", categoria=" + categoria + ", detalleVentas=" + detalleVentas + "]";
	}

	// SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public Integer getStock() {
		return Stock;
	}

	public void setStock(Integer stock) {
		Stock = stock;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<DetalleVenta> getDetalleVentas() {
		return detalleVentas;
	}

	public void setDetalleVentas(List<DetalleVenta> detalleVentas) {
		this.detalleVentas = detalleVentas;
	}

}
