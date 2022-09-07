package com.uce.edu.demo.repository.modelo;

public class ProductoStock {
	private String nombre;
	private String codigoBarra;
	private Integer stock;
	private String categoria;

	public ProductoStock() {
		// TODO Auto-generated constructor stub
	}

	public ProductoStock(String nombre, String codigoBarra, Integer stock, String categoria) {
		super();
		this.nombre = nombre;
		this.codigoBarra = codigoBarra;
		this.stock = stock;
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "ProductoStock [nombre=" + nombre + ", codigoBarra=" + codigoBarra + ", stock=" + stock + ", categoria="
				+ categoria + "]";
	}

	// SET Y GET
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
