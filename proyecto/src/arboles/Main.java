package arboles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Nodo n = new Nodo(50);
		Random rd = new Random();
//		for (int i = 0; i < 10; i++) {
//			int ii=rd.nextInt(100);
//			System.out.println(ii);
//			agregarValor(n, ii);
//		}
		// agregarValor(n, 500);
		agregarValor(n, 21);
		agregarValor(n, 48);
		agregarValor(n, 84);
		agregarValor(n, 52);
		agregarValor(n, 98);
		agregarValor(n, 66);
		agregarValor(n, 75);
		agregarValor(n, 62);
		agregarValor(n, 71);
		agregarValor(n, 36);

		System.out.println();
		Nodo aux = buscarNodo(n, 500);
		System.out.println(aux);
		mostrar1(n);

	}

	public static void mostrar1(Nodo n) {
		List<List<Nodo>> lstNodos = new ArrayList<>();
		if (n.padre == null) {
			List<Nodo> aux = new ArrayList<>();
			aux.add(n);
			lstNodos.add(aux);
		}

		int altura = 0;
		boolean token = true;

		for (int i = altura; i < lstNodos.size(); i++) {
			List<Nodo> nodos = lstNodos.get(i);
			List<Nodo> aux = new ArrayList<>();
			for (Nodo nodo : nodos) {
				if (nodo == null) {
					aux.add(null);
					aux.add(null);
					continue;
				}
				aux.add(nodo.izquierda);
				aux.add(nodo.derecha);

			}
			if (comprobar(aux))
				break;
			lstNodos.add(aux);
			altura++;
		}
		
		
		
	    int anchoCelda = 5;

	    // calcular número máximo de columnas
	    int maxColumnas = 0;
	    for (List<Nodo> fila : lstNodos) {
	        if (fila.size() > maxColumnas) {
	            maxColumnas = fila.size();
	        }
	    }

	    int anchoTotal = maxColumnas * anchoCelda;

	    for (List<Nodo> fila : lstNodos) {
	        int anchoFila = fila.size() * anchoCelda;

	        // espacios iniciales para centrar la fila
	        int espaciosInicio = (anchoTotal - anchoFila) / 2;

	        for (int i = 0; i < espaciosInicio; i++) {
	            System.out.print(" ");
	        }

	        for (Nodo nodo : fila) {
	            if (nodo != null) {
	                System.out.printf("%" + anchoCelda + "s", nodo.valor);
	            } else {
	                System.out.printf("%" + anchoCelda + "s", "--");
	            }
	        }

	        System.out.println();
	    }

	}

	public static boolean comprobar(List<Nodo> aux) {
		for (Nodo n : aux) {
			if (n != null) {
				return false;
			}
		}
		return true;
	}

	public static void mostrar(Nodo n) {
		if (n == null)
			return;
		mostrar(n.derecha);
		System.out.println(n.valor);
		mostrar(n.izquierda);
	}

	public static void agregarValor(Nodo n, int valor) {
		if (n.valor == valor)
			return;
		if (n.valor < valor) {
			if (n.derecha == null) {
				Nodo nuevoNodo = new Nodo(valor);
				n.derecha = nuevoNodo;
				nuevoNodo.padre = n;
			} else {
				agregarValor(n.derecha, valor);
			}
		} else {
			if (n.izquierda == null) {
				Nodo nuevoNodo = new Nodo(valor);
				n.izquierda = nuevoNodo;
				nuevoNodo.padre = n;
			} else {
				agregarValor(n.izquierda, valor);
			}
		}
	}

	public static Nodo buscarNodo(Nodo n, int valor) {
		if (n == null) {
			return null;
		}
		if (n.valor == valor) {
			return n;
		}
		if (n.valor < valor) {
			return buscarNodo(n.derecha, valor);
		} else {
			return buscarNodo(n.izquierda, valor);
		}
	}

	public static void eliminarNodo(Nodo n, int valor) {
		Nodo nodoABorrar = buscarNodo(n, valor);
		if (nodoABorrar != null) {
			if (nodoABorrar.derecha == null && nodoABorrar.izquierda == null) {
				nodoABorrar = null;
			}
			if (nodoABorrar.izquierda != null || nodoABorrar.derecha != null) {
				if (nodoABorrar.derecha != null) {
					nodoABorrar.padre.derecha = nodoABorrar.derecha;
				} else if (nodoABorrar.izquierda != null) {
					nodoABorrar.padre.izquierda = nodoABorrar.izquierda;
					// nodoABorrar.izquierda=
				}
			} else if (nodoABorrar.izquierda != null && nodoABorrar.derecha != null) {

			}
		} else {

		}
	}
//	public static List<Nodo> buscarTodosNodos(Nodo n){
//		
//	}

}
