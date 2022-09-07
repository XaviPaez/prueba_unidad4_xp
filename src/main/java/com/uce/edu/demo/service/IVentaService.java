package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.ProductoSencillo;
import com.uce.edu.demo.repository.modelo.VentaSencillo;

public interface IVentaService {
	public void realizarVenta(List<ProductoSencillo> productoSencillos, String cedulaCliente, String numeroVenta);
	public List<VentaSencillo> buscarPorFechaCategoriaCantidad(LocalDateTime fechaVenta, String categoria, Integer cantidad);

}
