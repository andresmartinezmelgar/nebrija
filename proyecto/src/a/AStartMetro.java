package a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class AStarMetro {
	public static List<Estacion> buscarRuta(Estacion origen, Estacion destino) {
		// Lista de nodos pendientes de revisar
		List<NodoRuta> abiertos = new ArrayList<>();
		// Lista de estaciones ya revisadas
		List<Estacion> cerrados = new ArrayList<>();
		// Mapa para encontrar rápidamente el nodo asociado a cada estación
		HashMap<Estacion, NodoRuta> nodos = new HashMap<>();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// Crea el nodo auxiliar del origen
		NodoRuta nodoOrigen = new NodoRuta(origen);
		// El coste desde el origen hasta sí mismo es 0
		nodoOrigen.costeDesdeInicio = 0;
		// Calcula el coste total inicial
		//nodoOrigen.costeTotal = nodoOrigen.costeDesdeInicio;
		// Mete el nodo origen en la lista de abiertos
		abiertos.add(nodoOrigen);
		// Guarda en el mapa la relación entre estación y nodo
		nodos.put(origen, nodoOrigen);
		
		// Repite mientras queden nodos por revisar
		while (!abiertos.isEmpty()) {
			// Escoge el nodo más prometedor
			NodoRuta actual = obtenerNodoConMenorCosteTotal(abiertos);
			// Comprueba si la estación actual es el destino
			if (actual.estacion == destino) {
				// Si lo es, reconstruye y devuelve la ruta
				return reconstruirCamino(actual);
			}
			// Quita el nodo actual de la lista de abiertos
			abiertos.remove(actual);
			// Marca la estación actual como revisada
			cerrados.add(actual.estacion);
			// Obtiene todas las estaciones vecinas
			List<Estacion> vecinas = obtenerVecinas(actual.estacion);
			// Recorre todas las estaciones vecinas
			for (Estacion vecina : vecinas) {
				// Comprueba si esa vecina ya fue revisada
				if (cerrados.contains(vecina)) {
					// Si ya fue revisada, pasa a la siguiente
					continue;
				}
				// Busca si ya existe un nodo auxiliar para esa vecina
				NodoRuta nodoVecino = nodos.get(vecina);
				// Comprueba si todavía no existía
				if (nodoVecino == null) {
					// Crea un nuevo nodo auxiliar
					nodoVecino = new NodoRuta(vecina);
					// Lo guarda en el mapa
					nodos.put(vecina, nodoVecino);
					// Imprime el mapa de nodos
					System.out.println(nodos);
				}
				// Calcula el nuevo coste para llegar a la vecina pasando por actual
				int nuevoCosteDesdeInicio = actual.costeDesdeInicio + costeMovimiento(actual.estacion, vecina);
				// Comprueba si la vecina es nueva o si se ha encontrado un camino mejor
				if (!abiertos.contains(nodoVecino) || nuevoCosteDesdeInicio < nodoVecino.costeDesdeInicio) {
					// Guarda el nodo actual como padre de la vecina
					nodoVecino.padre = actual;
					// Actualiza el coste desde el inicio
					nodoVecino.costeDesdeInicio = nuevoCosteDesdeInicio;
					// Recalcula el coste total
					//nodoVecino.costeTotal = nodoVecino.costeDesdeInicio;
					// Comprueba si la vecina aún no estaba en abiertos
					if (!abiertos.contains(nodoVecino)) {
						// Si no estaba, la añade
						abiertos.add(nodoVecino);
					}
				}
			}
		}
		// Si no se encuentra ruta, devuelve una lista vacía
		return new ArrayList<>();
	}

	private static NodoRuta obtenerNodoConMenorCosteTotal(List<NodoRuta> abiertos) {
		// Toma el primero como mejor provisional
		NodoRuta mejor = abiertos.get(0);
		// Recorre todos los nodos abiertos
		for (NodoRuta nodo : abiertos) {
			// Comprueba si el nodo actual tiene menor coste total
			if (nodo.costeDesdeInicio < mejor.costeDesdeInicio) {
				// Si es mejor, lo guarda
				mejor = nodo;
			}
		}
		// Devuelve el nodo con menor coste total
		return mejor;
	}

	private static List<Estacion> obtenerVecinas(Estacion estacion) {
		// Crea una lista vacía para las vecinas
		List<Estacion> vecinas = new ArrayList<>();
		// Comprueba si existe estación anterior
		if (estacion.getAnterior() != null) {
			// Añade la estación anterior
			vecinas.add(estacion.getAnterior());
		}
		// Comprueba si existe estación siguiente
		if (estacion.getSiguiente() != null) {
			// Añade la estación siguiente
			vecinas.add(estacion.getSiguiente());
		}
		// Añade todas las estaciones de transbordo
		vecinas.addAll(estacion.getTransbordos());
		// Devuelve la lista de vecinas
		return vecinas;
	}

	private static int costeMovimiento(Estacion actual, Estacion vecina) {
		// Comprueba si el movimiento es un transbordo
		if (actual.getTransbordos().contains(vecina)) {
			// Si es transbordo, devuelve coste 2
			return 2;
		}
		// Si no es transbordo, devuelve coste 1
		return 1;
	}

	private static List<Estacion> reconstruirCamino(NodoRuta nodoDestino) {
		// Crea una lista vacía para el camino
		List<Estacion> camino = new ArrayList<>();
		// Empieza desde el nodo destino
		NodoRuta actual = nodoDestino;
		// Recorre hacia atrás hasta llegar al origen
		while (actual != null) {
			// Añade la estación actual al camino
			camino.add(actual.estacion);
			// Salta al padre
			actual = actual.padre;
		}
		// Invierte la lista para dejarla de origen a destino
		Collections.reverse(camino);
		// Devuelve el camino final
		return camino;
	}
}