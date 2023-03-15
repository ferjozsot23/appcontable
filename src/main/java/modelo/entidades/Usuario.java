package modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**Clase destinada a ser el modelo de la entidad Usuario, unicamente consta de los atributos de la clase y 
 * está configurada de forma que se acople a la estructua de las tablas de la base de datos
 * @author Cristian
 */
@Entity
@Table(name="Usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="clave")
	private String clave;
	
	/**Constructor sin parámetros 
	 * 
	 */
	public Usuario() {
		
	}

	/**Constructor con dos parámetros
	 * @param nombre, indica el nombre del usuario
	 * @param clave, indica la clave del usuario
	 */
	public Usuario(String nombre, String clave) {
		super();
		this.nombre = nombre;
		this.clave = clave;
	}

	/**Método que retorna el id del usuario
	 * @return 
	 */
	public Integer getId() {
		return id;
	}

	/**Método que modifica el id del usuario
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**Método que retorna el nombre del usuario
	 * @return 
	 */
	public String getNombre() {
		return nombre;
	}

	/**Método que modifica el nombre del usuario
	 * @param id
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**Método que retorna la clave del usuario
	 * @return 
	 */
	public String getClave() {
		return clave;
	}

	/**Método que modifica la clave del usuario
	 * @param id
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 *Método que devuelve en String, la información sobre el usuario
	 */
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", clave=" + clave + "]";
	}
	
	
}


