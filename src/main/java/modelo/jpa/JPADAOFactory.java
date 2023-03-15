package modelo.jpa;

import modelo.dao.CuentaDAO;
import modelo.dao.DAOFactory;
import modelo.dao.MovimientoDAO;
import modelo.dao.UsuarioDAO;

/**Clase usada para manejar la persistencia de los datos. 
 * @author Cristian
 */
public class JPADAOFactory extends DAOFactory {
	
	/**
	 *Método para obtener el usuarioDAO
	 */
	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new JPAUsuarioDAO();
	}

	/**
	 *Método para obtener el cuentaDAO
	 */
	@Override
	public CuentaDAO getCuentaDAO() {
		return new JPACuentaDAO();
	}

	/**
	 *Método para obtener el movimientoDAO
	 */
	@Override
	public MovimientoDAO getMovimientoDAO() {
		return new JPAMovimientoDAO();
	}

	


}
