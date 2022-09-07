package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Producto;

public interface IProductoRepository {

	public void insertar(Producto producto);
	public void actualizar(Producto producto);
	public Producto buscarPorNombre(String nombre);
	public Producto buscarPorCodigoBarra(String codigoBarra);
	public Producto buscarPorCodigoBarras(String codigoBarras);
	public List<Producto> buscarTodos();
}
