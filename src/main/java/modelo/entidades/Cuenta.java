package modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**Clase destinada a ser el modelo de la entidad Cuenta, unicamente consta de los atributos de la clase y 
 * está configurada de forma que se acople a la estructua de las tablas de la base de datos
 * @author Cristian
 */
@Entity
public class Cuenta implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nombre;
	@Column
	private double total;
	@Enumerated
	private CuentaTipo tipo;
	
	/**Constructor sin parámetros 
	 * 
	 */
	public Cuenta() {}

	/**Constructor con dos parámetros
	 * @param nombre, indica el nombre de la cuenta
	 * @param total, indica el valor total de la cuenta
	 */
	public Cuenta(String nombre, double total) {
		super();
		this.nombre = nombre;
		this.total = total;
	}

	/**Método que retorna el id de la cuenta
	 * @return 
	 */
	public int getId() {
		return id;
	}

	/**Método que modifica el id de la cuenta 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**Método que retorna el nombre de la cuenta
	 * @return 
	 */
	public String getNombre() {
		return nombre;
	}

	/**Método que modifica el nombre de la cuenta 
	 * @param id
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**Método que retorna el valor total de la cuenta
	 * @return 
	 */
	public double getTotal() {
		return total;
	}

	/**Método que modifica el valor total de la cuenta 
	 * @param id
	 */
	public void setTotal(double total) {
		this.total = total;
	}
	
	/**Método que retorna el objeto CuentaTipo de la cuenta
	 * @return 
	 */
	public CuentaTipo getTipo() {
		return tipo;
	}

	/**Método que modifica el tipo de la cuenta ti
	 * @param id
	 */
	public void setTipo(CuentaTipo tipo) {
		this.tipo = tipo;
	}

	/**
	 *Método que devuelve en String, la información sobre la cuenta
	 */
	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", nombre=" + nombre + ", total=" + total + "]";
	}
	
	
}
