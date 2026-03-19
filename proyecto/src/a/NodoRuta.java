package a;
class NodoRuta { // Inicio de la clase NodoRuta.

    public Estacion estacion; // Estación real asociada a este nodo.
    public int costeDesdeInicio; // Coste real acumulado desde la estación de origen.
    public NodoRuta padre; // Nodo anterior en el camino encontrado.

    public NodoRuta(Estacion estacion) { // Constructor que recibe una estación.
        this.estacion = estacion; // Guarda la estación.
        this.costeDesdeInicio = Integer.MAX_VALUE; // Inicialmente el coste es muy grande.
        this.padre = null; // Inicialmente no hay padre.
    } 
    @Override // Indica que este método sobrescribe uno heredado.
    public String toString() { // Método para representar la estación como texto.
        return estacion.toString()+"["+costeDesdeInicio+"]"; // Devuelve el nombre de la estación.
    } 
} // Fin de la clase NodoRuta.
