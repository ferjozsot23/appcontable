package modelo.jpa;


import java.util.List;

import javax.persistence.Query;

import modelo.dao.CuentaDAO;
import modelo.dto.CuentaDTO;
import modelo.entidades.Cuenta;
import modelo.entidades.CuentaTipo;


/**Clase usada para manejar la persistencia de los datos de la entidad cuentaDAO. 
 * @author Cristian
 */
public class JPACuentaDAO extends JPAGenericDAO<Cuenta, Integer> implements CuentaDAO {

	/**
	 * Constructor de la clase sin parámetros
	 */
	public JPACuentaDAO() {
		super(Cuenta.class);
	}

	/**
	 *Método para obtener el consolidado de una cuenta de ingreso en un mes específico, mediante una Query a la base de datos.
	 */
	@Override
	public List<CuentaDTO> getConsolidadoCuentasIngreso(int mes) {
		String JPQL = "SELECT new modelo.dto.CuentaDTO( m.origen.id, m.origen.nombre, SUM(m.valor)) FROM Movimiento m "
				+ "WHERE m.origen.tipo= :tipo AND "
				+ "FUNC('MONTH', m.fecha)= :mes "
				+ "GROUP BY m.origen";
		Query query = em.createQuery(JPQL);
		query.setParameter("tipo", CuentaTipo.INGRESO);
		query.setParameter("mes", mes);
		
		return query.getResultList();
	}
	
	/**
	 *Método para obtener el consolidado de una cuenta de egreso en un mes específico, mediante una Query a la base de datos.
	 */
	@Override
	public List<CuentaDTO> getConsolidadoCuentsEgreso(int mes) {
		
		String JPQL = "SELECT new modelo.dto.CuentaDTO( m.destino.id, m.destino.nombre, SUM(m.valor)) FROM Movimiento m "
				+ "WHERE m.destino.tipo= :tipo AND "
				+ "FUNC('MONTH', m.fecha)= :mes "
				+ "GROUP BY m.destino";
		Query query = em.createQuery(JPQL);
		query.setParameter("tipo", CuentaTipo.GASTO);
		query.setParameter("mes", mes);
		return query.getResultList();
	}

	/**
	 *Método para obtener el consolidado de una cuenta de IngresoEgreso en un mes específico, mediante una Query a la base de datos.
	 */
	@Override
	public List<Cuenta> getConsolidadoCuentasIngresoEgreso() {
		String JPQL = "SELECT c FROM Cuenta c "
				+ "WHERE c.tipo= :tipo";
		Query query = em.createQuery(JPQL);
		query.setParameter("tipo", CuentaTipo.INGRESOGASTO);
		return query.getResultList();
	}

	/**
	 *Método para obtener la cuenta segun el tipo, mediante una Query a la base de datos.
	 */
	public List<Cuenta> getCuentasByType(CuentaTipo tipo){
		String JPQL = "SELECT c FROM Cuenta c "
				+ "WHERE c.tipo= :tipo";
		Query query = em.createQuery(JPQL);
		query.setParameter("tipo", tipo);
		return query.getResultList();
		
	}
	
	

}
