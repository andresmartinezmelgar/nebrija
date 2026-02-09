package proyecto;

import java.util.ArrayList;
import java.util.List;

//clase de ayuda para la clase de linkedlist
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
	private int numNodos;

	LinkedListImplementacion() {
		primero = null;
		numNodos = 0;
	}

	public void add(int valor) {
		Nodo n = new Nodo(valor);
		numNodos++;
		if (primero == null) {
			primero = n;
			n.siguiente = primero;
			return;
		}
		Nodo actual = primero;
		n.siguiente = primero;
		while (actual.siguiente != primero) {
			actual = actual.siguiente;
		}
		actual.siguiente = n;
	}

	public boolean eliminarPorIndice(int indice) {
		if (numNodos < indice || indice < 0) {
			return false;
		}
		Nodo actual = primero;
		int contador = 0;
		Nodo nBorrar = null;
		while (true) {
			if (indice == contador) {
				nBorrar = actual;
				break;
			}
			actual = actual.siguiente;
			contador++;
		}
		if (indice == 0) {
			borrarNodoPrimeroConSeguridad();
		} else {
			borrar(nBorrar);
		}
		numNodos--;

		return true;
	}

	private void borrarNodoPrimeroConSeguridad() {
		Nodo oldPrimero = primero;
		primero = oldPrimero.siguiente;
		borrar(oldPrimero);
	}

	public void eliminarTodosValor(int elementoABorrar) {
		List<Integer> posicionesABorrar = buscarIndicesABorrar(elementoABorrar);
		posicionesABorrar = posicionesABorrar.reversed();
		for(Integer pos:posicionesABorrar) {
			eliminarPorIndice(pos);
		}
	}

	private List<Integer> buscarIndicesABorrar(int elementoABorrar) {
		List<Integer> aux = new ArrayList<Integer>();
		int contador = 0;
		Nodo actual = primero;

		if (primero.valor == elementoABorrar) {
			aux.add(0);
		}
		while (actual.siguiente != primero) {
			if (actual.valor == elementoABorrar) {
				aux.add(contador);
			}
			contador++;
			actual=actual.siguiente;
		}
		return aux;
	}

	public boolean eliminarPorValor(int elementoABorrar) {
		if (primero.valor == elementoABorrar) {
			
			borrarNodoPrimeroConSeguridad();
			numNodos--;
			return true;
		}

		Nodo actual = primero;
		while (actual.siguiente != primero) {
			if (actual.valor == elementoABorrar) {
				borrar(actual);
				numNodos--;
				return true;
			}
			actual = actual.siguiente;
		}
		return false;
	}

	private void borrar(Nodo nBorrar) {
		Nodo anterior = buscarAnterior(nBorrar);
		anterior.siguiente = nBorrar.siguiente;
		nBorrar = null;
	}

	private Nodo buscarAnterior(Nodo nBorrar) {
		Nodo actual = primero;
		while (actual.siguiente != nBorrar) {
			actual = actual.siguiente;
		}
		return actual;
	}

	public void print() {
		Nodo actual = primero;
		int contador = 2;
		while (contador != 0) {
			if (actual.equals(primero)) {
				System.out.print("[" + actual.valor + "]" + " -> ");
			} else {
				System.out.print(actual.valor + " -> ");
			}
			actual = actual.siguiente;
			if (actual == primero) {
				contador--;
			}
		}
		System.out.print("[" + actual.valor + "]" + "\n");
		System.out.println("Núm nodos: " + numNodos);
	}
}
