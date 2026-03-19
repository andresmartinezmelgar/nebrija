package arboles;

public class Main {

	public static void main(String[] args) {
		Nodo n = new Nodo(10);
		agregarValor(n, 17);
		agregarValor(n, 15);
		agregarValor(n, 9);
		agregarValor(n, 6);
		
		System.out.println();

	}

	public static void agregarValor(Nodo n, int valor) {
		if (n.valor < valor) {
			if (n.derecha == null) {
				Nodo nuevoNodo= new Nodo(valor);
				n.derecha=nuevoNodo;
				nuevoNodo.padre=n;
			} else {
				agregarValor(n.derecha, valor);
			}
		} else {
			if (n.izquierda == null) {
				Nodo nuevoNodo= new Nodo(valor);
				n.izquierda=nuevoNodo;
				nuevoNodo.padre=n;
			} else {
				agregarValor(n.izquierda, valor);
			}
		}
	}

}
