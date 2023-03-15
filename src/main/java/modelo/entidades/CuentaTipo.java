package modelo.entidades;

/**Clase destinada a ser diferencias los tipos de cuentas existentes:
 * Tipo Ingreso: Cuentas que registren los valores positivos ingresados 
 * Tipo Gasto: Cuentas que registren los valores negativos
 * Tipo IngresoGasto: Cuentas que registran los valores que ingresan y salen y que te entregan un valor acumulativo
 * @author Cristian
 */
public enum CuentaTipo {
	INGRESO ("INGRESO", 1),
	GASTO ("GASTO", 2),
	INGRESOGASTO ("INGRESOGASTO",3);
	
	private String nombreTipo;
	private int idTipo;
	
	/**Constructor con dos parámetros
	 * @param nombreTipo, indica el nombre del tipo de cuenta
	 * @param id, indica el id que corresponde a cada uno de los tipos de cuenta
	 */
	CuentaTipo(String nombreTipo, int id) {
		this.idTipo = id;
		this.nombreTipo = nombreTipo; 
	}
	
	/**Método que retorna el nombre del tipo de la cuenta
	 * @return 
	 */
	public String getNombreTipo() {
		return nombreTipo;
	}
	
	/**Método que modifica el nombre del tipo de la cuenta 
	 * @param id
	 */
	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}
	
	/**Método que retorna el id del tipo de la cuenta
	 * @return 
	 */
	public int getIdTipo() {
		return idTipo;
	}
	
	/**Método que modifica el id del tipo de la cuenta 
	 * @param id
	 */
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	
	
}
