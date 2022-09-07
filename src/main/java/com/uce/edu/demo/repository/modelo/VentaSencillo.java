package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;

public class VentaSencillo {
	private String codigoBarra;
	private String categoria;
	private Integer cantidad;
	private BigDecimal precioUnitario;
	private BigDecimal subtotal;

	@Override
	public String toString() {
		return "VentaSencillo [codigoBarra=" + codigoBarra + ", categoria=" + categoria + ", cantidad=" + cantidad
				+ ", precioUnitario=" + precioUnitario + ", subtotal=" + subtotal + "]";
	}

	public VentaSencillo() {
		// TODO Auto-generated constructor stub
	}

	public VentaSencillo(String codigoBarra, String categoria, Integer cantidad, BigDecimal precioUnitario,
			BigDecimal subtotal) {
		super();
		this.codigoBarra = codigoBarra;
		this.categoria = categoria;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.subtotal = subtotal;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

}
