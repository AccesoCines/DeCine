package modelo;

public class Columna {
	
	private String tipo;
	private boolean nula;
	private String nombreCol;
	
	public Columna(String tipo, boolean nula, String nombreCol) {
		this.tipo = tipo;
		this.nula = nula;
		this.nombreCol = nombreCol;
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

	public String getNombreCol() {
		return nombreCol;
	}

	public void setNombreCol(String nombreCol) {
		this.nombreCol = nombreCol;
	}
	
}