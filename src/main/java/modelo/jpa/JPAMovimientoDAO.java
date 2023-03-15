package modelo.jpa;

import modelo.dao.MovimientoDAO;
import modelo.entidades.Movimiento;

/**Clase que extiende los métodos de la clase generica 
 * @author Cristian
 *
 */
public class JPAMovimientoDAO extends JPAGenericDAO<Movimiento, Integer> implements MovimientoDAO {

	/**
	 *Constructor sin parámetros
	 */
	public JPAMovimientoDAO() {
		super(Movimiento.class);
	}
}
