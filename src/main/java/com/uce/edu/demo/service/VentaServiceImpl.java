package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.IVentaRepository;
import com.uce.edu.demo.repository.modelo.DetalleVenta;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoSencillo;
import com.uce.edu.demo.repository.modelo.Venta;
import com.uce.edu.demo.repository.modelo.VentaSencillo;

@Service
public class VentaServiceImpl implements IVentaService {

	@Autowired
	private IProductoRepository iProductoRepository;
	@Autowired
	private IVentaRepository iVentaRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarVenta(List<ProductoSencillo> productoSencillos, String cedulaCliente, String numeroVenta) {
		// TODO Auto-generated method stub

		List<DetalleVenta> detalleVentas = new ArrayList<>();
		Venta venta = new Venta();
		BigDecimal montoTotal = BigDecimal.ZERO;

		venta.setCedulaCliente(cedulaCliente);
		venta.setNumero(numeroVenta);
		venta.setFecha(LocalDateTime.now());

		for (ProductoSencillo productoSencillo : productoSencillos) {
			Producto producto = this.iProductoRepository.buscarPorCodigoBarra(productoSencillo.getCodigoBarras());
			if (producto.getStock() == 0) {
				throw new RuntimeException();
			}
			if (producto.getStock() <= productoSencillo.getCantidad()) {
				productoSencillo.setCantidad(producto.getStock());
			}

			DetalleVenta detalleVenta = new DetalleVenta();
			detalleVenta.setProducto(producto);
			detalleVenta.setPrecioUnitario(producto.getPrecio());
			detalleVenta.setSubtotal(producto.getPrecio().multiply(new BigDecimal(productoSencillo.getCantidad())));
			detalleVenta.setCantidad(productoSencillo.getCantidad());
			detalleVenta.setVenta(venta);
			detalleVentas.add(detalleVenta);
			montoTotal = montoTotal.add(detalleVenta.getSubtotal());

			producto.setStock(producto.getStock() - productoSencillo.getCantidad());
			this.iProductoRepository.actualizar(producto);
		}
		venta.setDetalleVentas(detalleVentas);
		venta.setTotalVenta(montoTotal);
		this.iVentaRepository.insertar(venta);

	}

	@Override
	public List<VentaSencillo> buscarPorFechaCategoriaCantidad(LocalDateTime fechaVenta, String categoria,
			Integer cantidad) {
		// TODO Auto-generated method stub
		return this.iVentaRepository.buscarPorFechaCategoriaCantidad(fechaVenta, categoria, cantidad);
	}
}
