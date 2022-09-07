package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoStock;

public interface IProductoService {

	public void insertar( Producto producto);
	public ProductoStock buscarPorCodigoBarras(String codigoBarras);
	public List<Producto> buscarTodos();

}
