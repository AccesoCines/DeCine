package modelo;

public class Columna {
	private String nombreTabla;
	private String tipo;
	private boolean nula;
	private String esquema;
	private String nombreCol;
	private String clave;
	
	public Columna(String nombreTabla, String tipo, boolean nula, String esquema, String nombreCol, String clave) {
		this.nombreTabla = nombreTabla;
		this.tipo = tipo;
		this.nula = nula;
		this.esquema = esquema;
		this.nombreCol = nombreCol;
		this.clave = clave;
	}

	public String getNombreTabla() {
		return nombreTabla;
	}

	public void setNombreTabla(String nombreTabla) {
		this.nombreTabla = nombreTabla;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isNula() {
		return nula;
	}

	public void setNula(boolean nula) {
		this.nula = nula;
	}

	public String getEsquema() {
		return esquema;
	}

	public void setEsquema(String esquema) {
		this.esquema = esquema;
	}

	public String getNombreCol() {
		return nombreCol;
	}

	public void setNombreCol(String nombreCol) {
		this.nombreCol = nombreCol;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
}