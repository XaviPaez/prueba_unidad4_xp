package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Venta;
import com.uce.edu.demo.repository.modelo.VentaSencillo;

@Repository
@Transactional
public class VentaRepositoryImpl implements IVentaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Venta venta) {
		// TODO Auto-generated method stub
		this.entityManager.persist(venta);
	}

	@Override
	public List<VentaSencillo> buscarPorFechaCategoriaCantidad(LocalDateTime fechaVenta, String categoria,
			Integer cantidad) {
		TypedQuery<VentaSencillo> myQuery = this.entityManager.createQuery(
				"SELECT new com.uce.edu.demo.repository.modelo.VentaSencillo(p.codigoBarra, p.categoria,p.cantidad, p.precioUnitario,p.subtotal) FROM Venta p WHERE p.fechaVenta = :datoFecha AND p.categoria= :datoCategoria AND p.cantidad > :datoCantidad ",
				VentaSencillo.class);
		myQuery.setParameter("datoFecha", fechaVenta);
		myQuery.setParameter("datoCategoria", categoria);
		myQuery.setParameter("datoCantidad", cantidad);
		return myQuery.getResultList();
	}
}