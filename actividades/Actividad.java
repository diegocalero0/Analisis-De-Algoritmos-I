package actividades;

public class Actividad {
	private int inicio;
	private int fin;
	private String nombre;
	
	public Actividad(int inicio, int fin, String nombre) {
		this.inicio = inicio;
		this.fin = fin;
		this.nombre = nombre;
	}

	public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Actividad [inicio=" + inicio + ", fin=" + fin + ", nombre=" + nombre + "]";
	}
	
	
}
