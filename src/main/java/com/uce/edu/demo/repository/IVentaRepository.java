package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Venta;
import com.uce.edu.demo.repository.modelo.VentaSencillo;

public interface IVentaRepository {


	public void insertar(Venta venta);
	public List<VentaSencillo> buscarPorFechaCategoriaCantidad(LocalDateTime fechaVenta, String categoria, Integer cantidad);

}
