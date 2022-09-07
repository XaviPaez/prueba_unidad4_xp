package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Producto;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(producto);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}
	
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Producto> myQuery=this.entityManager.createQuery("SELECT p FROM Producto p WHERE p.nombre= :datoNombre", Producto.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto buscarPorCodigoBarra(String codigoBarra) {
		// TODO Auto-generated method stub
		TypedQuery<Producto> myQuery=this.entityManager.createQuery("SELECT p FROM Producto p WHERE p.codigoBarra= :datoCodigoBarra", Producto.class);
		myQuery.setParameter("datoCodigoBarra", codigoBarra);
		return myQuery.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto buscarPorCodigoBarras(String codigoBarras) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createNativeQuery("SELECT * FROM producto WHERE prod_codigo_barra =:datoCodigoBarra  ", Producto.class);
		myQuery.setParameter("datoCodigoBarra", codigoBarras);
		return (Producto) myQuery.getSingleResult();
	}

	@Override
	public List<Producto> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT p FROM Producto p", Producto.class);
		return myQuery.getResultList();
	}

}
