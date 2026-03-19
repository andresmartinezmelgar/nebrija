package arboles;

public class Nodo {
	public Nodo derecha;
	public Nodo izquierda;
	public Nodo padre;
	public int valor;

	public Nodo(int valor) {
		this.valor = valor;
		this.derecha = null;
		this.izquierda = null;
		this.padre = null;
	}


}
