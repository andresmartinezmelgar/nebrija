package a;

import java.util.ArrayList;
import java.util.List;

class Estacion { // Inicio de la clase Estacion.
	private String linea;
    private String nombre; // Nombre de la estación.
    private Estacion anterior; // Estación anterior dentro de la misma línea.
    private Estacion siguiente; // Estación siguiente dentro de la misma línea.
    private List<Estacion> transbordos; // Lista de estaciones a las que se puede transbordar.

    public Estacion(String linea,String nombre) { // Constructor que recibe el nombre de la estación.
        this.linea=linea;
    	this.nombre = nombre; // Guarda el nombre recibido.
        this.transbordos = new ArrayList<>(); // Crea la lista vacía de transbordos.
    } // Fin del constructor.

    public String getNombre() { // Método para obtener el nombre.
        return nombre; // Devuelve el nombre.
    } // Fin del método getNombre.

    public Estacion getAnterior() { // Método para obtener la estación anterior.
        return anterior; // Devuelve la estación anterior.
    } // Fin del método getAnterior.

    public void setAnterior(Estacion anterior) { // Método para asignar la estación anterior.
        this.anterior = anterior; // Guarda la referencia a la estación anterior.
    } // Fin del método setAnterior.

    public Estacion getSiguiente() { // Método para obtener la estación siguiente.
        return siguiente; // Devuelve la estación siguiente.
    } // Fin del método getSiguiente.

    public void setSiguiente(Estacion siguiente) { // Método para asignar la estación siguiente.
        this.siguiente = siguiente; // Guarda la referencia a la estación siguiente.
    } // Fin del método setSiguiente.

    public List<Estacion> getTransbordos() { // Método para obtener la lista de transbordos.
        return transbordos; // Devuelve la lista de transbordos.
    } // Fin del método getTransbordos.

    public void addTransbordo(Estacion estacion) { // Método para añadir un transbordo.
        if (estacion != null && !transbordos.contains(estacion)) { // Comprueba que la estación no sea null y que no esté repetida.
            transbordos.add(estacion); // Añade la estación a la lista de transbordos.
        } // Fin del if.
    } // Fin del método addTransbordo.

    @Override // Indica que este método sobrescribe uno heredado.
    public String toString() { // Método para representar la estación como texto.
        return linea+"-"+nombre; // Devuelve el nombre de la estación.
    } // Fin del método toString.
} // Fin de la clase Estacion.
