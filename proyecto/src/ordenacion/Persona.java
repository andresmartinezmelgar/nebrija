package ordenacion;

public class Persona {
	private int id;
	private String nombre;
	private DNI dni;
	public String toString() {
		return nombre + "-" + id+"-"+dni.getNumero();

	}

	public Persona(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public DNI getDni() {
		return dni;
	}

	public void setDni(DNI dni) {
		this.dni = dni;
	}
	

}
