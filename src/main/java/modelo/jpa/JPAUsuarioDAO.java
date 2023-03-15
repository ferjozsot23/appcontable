package modelo.jpa;

import modelo.dao.UsuarioDAO;
import modelo.entidades.Usuario;

/**Clase para manejar la persitencia de los datos del usuario que extiende métodos de la clase genérica
 * @author Cristian
 *
 */
public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, Integer> implements UsuarioDAO{

	/**
	 *Cosntructor sin parámetros
	 */
	public JPAUsuarioDAO() {
		super(Usuario.class);
	}

	/**
	 *Método para autorizar a un usuario dentro de la aplicación según los registros de la base de datos
	 */
	@Override
	public Usuario autorizar(String nombre, String clave) {
		
		String JPQL="SELECT p FROM Usuario p WHERE p.clave= :clave AND p.nombre= :nombre";
		javax.persistence.Query query= em.createQuery(JPQL);
		query.setParameter("clave", clave);
		query.setParameter("nombre", nombre);
		Usuario persona=null;
		try {
			persona=(Usuario) query.getSingleResult();
		} catch (Exception e) {
			persona=null;
		}
		return persona;
		
		
	}
	

}
