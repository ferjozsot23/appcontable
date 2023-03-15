package modelo.entidades;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**Clase destinada a ser el modelo de la entidad Movimiento, unicamente consta de los atributos de la clase y 
 * está configurada de forma que se acople a la estructua de las tablas de la base de datos
 * @author Cristian
 */
@Entity
@Table(name = "movimiento")
public class Movimiento implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "concepto")
	private String concepto;
	
	@Column(name = "valor")
	private double valor;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "cuenta_origen")
	private Cuenta origen;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "cuenta_destino")
	private Cuenta destino;
	
	/**Constructor sin parámetros 
	 * 
	 */
	public Movimiento() {
	}

	/**Constructor con cincos parámetros
	 * @param concepto, indica el concepto del movimiento
	 * @param valor, indica el valor del movimiento
	 * @param fecha, indica la fecha de realización del movimiento
	 * @param origen, indica la cuenta origen del movimiento
	 * @param destino, indica la cuenta destino del movimiento
	 */
	public Movimiento(String concepto, double valor, Date fecha, Cuenta origen, Cuenta destino) {
		super();
		this.concepto = concepto;
		this.valor = valor;
		this.fecha = fecha;
		this.origen = origen;
		this.destino = destino;
	}

	/**Método que retorna el id del movimiento
	 * @return 
	 */
	public Integer getId() {
		return id;
	}

	/**Método que modifica el id del movimiento
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**Método que retorna el concepto del movimiento
	 */
	public String getConcepto() {
		return concepto;
	}

	/**Método que modifica el concepto del movimiento
	 * @param id
	 */
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	/**Método que retorna el valor del movimiento
	 * @return 
	 */
	public double getValor() {
		return valor;
	}

	/**Método que modifica el valor del movimiento
	 * @param id
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	/**Método que retorna la fecha del movimiento
	 * @return 
	 */
	public Date getFecha() {
		return fecha;
	}

	/**Método que modifica la fecha del movimiento
	 * @param id
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**Método que retorna la cuenta origen del movimiento
	 * @return 
	 */
	public Cuenta getOrigen() {
		return origen;
	}

	/**Método que modifica la cuenta origen del movimiento
	 * @param id
	 */
	public void setOrigen(Cuenta origen) {
		this.origen = origen;
	}

	/**Método que retorna la cuenta destino del movimiento
	 * @return 
	 */
	public Cuenta getDestino() {
		return destino;
	}

	/**Método que modifica la cuenta destino del movimiento
	 * @param id
	 */
	public void setDestino(Cuenta destino) {
		this.destino = destino;
	}

	/**
	 *Método que devuelve en String, la información sobre el movimiento
	 */
	@Override
	public String toString() {
		return "Movimiento [id=" + id + ", concepto=" + concepto + ", valor=" + valor + ", fecha=" + fecha + ", origen="
				+ origen + ", destino=" + destino + "]";
	}
	
	
	
}
