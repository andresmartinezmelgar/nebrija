package proyecto;

class Nodo {
	int valor;
	Nodo siguiente;

	Nodo(int valor) {
		this.valor = valor;
		siguiente = null;
	}
}

public class LinkedListImplementacion {
	private Nodo primero;

	LinkedListImplementacion() {
		primero = null;
	}

	public void add(int valor) {
		Nodo n = new Nodo(valor);
		
		if (primero == null) {
			primero = n;
			n.siguiente=primero;
			return;
		}
		Nodo actual = primero;
		n.siguiente=primero;
		while (actual.siguiente != primero) {
			actual = actual.siguiente;
		}
		actual.siguiente = n;
		

	}

	public void print() {
		Nodo actual = primero;
		int contador=2;
		while (contador!=0 ) {
			System.out.print(actual.valor + " -> ");
			actual = actual.siguiente;
			if(actual==primero) {
				contador--;
			}
		}
		System.out.print(actual.valor );
	}
}
