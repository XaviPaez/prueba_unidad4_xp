package com.uce.edu.demo.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoStock;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepository iProductoRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Producto p) {
		// TODO Auto-generated method stub
		Producto producto=new Producto();
		Integer n=0;
		
		try {
			 producto=this.iProductoRepository.buscarPorCodigoBarra(p.getCodigoBarra());
		}catch (Exception e) {
			n=1;
		}
	
		if(n==1) {
			this.iProductoRepository.insertar(p);
		}else {
			producto.setStock(producto.getStock()+p.getStock());
			this.iProductoRepository.actualizar(producto);
		}
	}
	@Override
	@Transactional(value = TxType.REQUIRED)
	public ProductoStock buscarPorCodigoBarras(String codigoBarras) {
		// TODO Auto-generated method stub
		
		Producto producto=this.iProductoRepository.buscarPorCodigoBarras(codigoBarras);
		ProductoStock productoStock=new ProductoStock();
		productoStock.setCodigoBarra(producto.getCodigoBarra());
		productoStock.setCategoria(producto.getCategoria());
		productoStock.setNombre(producto.getNombre());
		productoStock.setStock(producto.getStock());
		return productoStock;
	}
	@Override
	public List<Producto> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iProductoRepository.buscarTodos();
	}
}
