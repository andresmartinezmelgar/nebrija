package a;

import java.util.List;

public class Main { // Inicio de la clase principal.

	public static void main(String[] args) { // Método principal del programa.

		Estacion pinar = new Estacion("L1", "Pinar de Chamartín"); // Crea la estación Pinar de Chamartín.
		Estacion chamartin1 = new Estacion("L1", "Chamartín"); // Crea la estación Chamartín de una línea.
		Estacion plazaCastilla1 = new Estacion("L1", "Plaza de Castilla"); // Crea la estación Plaza de Castilla de una
																			// línea.
		Estacion cuatroCaminos1 = new Estacion("L1", "Cuatro Caminos"); // Crea la estación Cuatro Caminos de una línea.
		Estacion tribunal1 = new Estacion("L1", "Tribunal"); // Crea la estación Tribunal de una línea.
		Estacion granVia1 = new Estacion("L1", "Gran Vía"); // Crea la estación Gran Vía.
		Estacion sol1 = new Estacion("L1", "Sol"); // Crea la estación Sol de una línea.
		Estacion atocha = new Estacion("L1", "Atocha"); // Crea la estación Atocha.

		pinar.setSiguiente(chamartin1); // Indica que después de Pinar va Chamartín.
		chamartin1.setAnterior(pinar); // Indica que antes de Chamartín va Pinar.

		chamartin1.setSiguiente(plazaCastilla1); // Indica que después de Chamartín va Plaza de Castilla.
		plazaCastilla1.setAnterior(chamartin1); // Indica que antes de Plaza de Castilla va Chamartín.

		plazaCastilla1.setSiguiente(cuatroCaminos1); // Indica que después de Plaza de Castilla va Cuatro Caminos.
		cuatroCaminos1.setAnterior(plazaCastilla1); // Indica que antes de Cuatro Caminos va Plaza de Castilla.

		cuatroCaminos1.setSiguiente(tribunal1); // Indica que después de Cuatro Caminos va Tribunal.
		tribunal1.setAnterior(cuatroCaminos1); // Indica que antes de Tribunal va Cuatro Caminos.

		tribunal1.setSiguiente(granVia1); // Indica que después de Tribunal va Gran Vía.
		granVia1.setAnterior(tribunal1); // Indica que antes de Gran Vía va Tribunal.

		granVia1.setSiguiente(sol1); // Indica que después de Gran Vía va Sol.
		sol1.setAnterior(granVia1); // Indica que antes de Sol va Gran Vía.

		sol1.setSiguiente(atocha); // Indica que después de Sol va Atocha.
		atocha.setAnterior(sol1); // Indica que antes de Atocha va Sol.

		Estacion cuatroCaminos2 = new Estacion("L2", "Cuatro Caminos"); // Crea Cuatro Caminos de otra línea.
		Estacion canal2 = new Estacion("L2", "Canal"); // Crea Canal.
		Estacion sanBernardo2 = new Estacion("L2", "San Bernardo"); // Crea San Bernardo.
		Estacion opera2 = new Estacion("L2", "Ópera"); // Crea Ópera.
		Estacion sol2 = new Estacion("L2", "Sol"); // Crea Sol de otra línea.
		Estacion sevilla2 = new Estacion("L2", "Sevilla"); // Crea Sevilla.

		cuatroCaminos2.setSiguiente(canal2); // Indica que después de Cuatro Caminos va Canal.
		canal2.setAnterior(cuatroCaminos2); // Indica que antes de Canal va Cuatro Caminos.

		canal2.setSiguiente(sanBernardo2); // Indica que después de Canal va San Bernardo.
		sanBernardo2.setAnterior(canal2); // Indica que antes de San Bernardo va Canal.

		sanBernardo2.setSiguiente(opera2); // Indica que después de San Bernardo va Ópera.
		opera2.setAnterior(sanBernardo2); // Indica que antes de Ópera va San Bernardo.

		opera2.setSiguiente(sol2); // Indica que después de Ópera va Sol.
		sol2.setAnterior(opera2); // Indica que antes de Sol va Ópera.

		sol2.setSiguiente(sevilla2); // Indica que después de Sol va Sevilla.
		sevilla2.setAnterior(sol2); // Indica que antes de Sevilla va Sol.

		Estacion chamartin10 = new Estacion("L10", "Chamartín"); // Crea Chamartín de otra línea.
		Estacion plazaCastilla10 = new Estacion("L10", "Plaza de Castilla"); // Crea Plaza de Castilla de otra línea.
		Estacion cuatroCaminos10 = new Estacion("L10", "Cuatro Caminos"); // Crea Cuatro Caminos de otra línea.
		Estacion tribunal10 = new Estacion("L10", "Tribunal"); // Crea Tribunal de otra línea.
		Estacion plazaEspana = new Estacion("L10", "Plaza de España"); // Crea Plaza de España.

		chamartin10.setSiguiente(plazaCastilla10); // Indica que después de Chamartín va Plaza de Castilla.
		plazaCastilla10.setAnterior(chamartin10); // Indica que antes de Plaza de Castilla va Chamartín.

		plazaCastilla10.setSiguiente(cuatroCaminos10); // Indica que después de Plaza de Castilla va Cuatro Caminos.
		cuatroCaminos10.setAnterior(plazaCastilla10); // Indica que antes de Cuatro Caminos va Plaza de Castilla.

		cuatroCaminos10.setSiguiente(tribunal10); // Indica que después de Cuatro Caminos va Tribunal.
		tribunal10.setAnterior(cuatroCaminos10); // Indica que antes de Tribunal va Cuatro Caminos.

		tribunal10.setSiguiente(plazaEspana); // Indica que después de Tribunal va Plaza de España.
		plazaEspana.setAnterior(tribunal10); // Indica que antes de Plaza de España va Tribunal.

		chamartin1.addTransbordo(chamartin10); // Añade transbordo entre Chamartín de una línea y Chamartín de otra.
		chamartin10.addTransbordo(chamartin1); // Añade el transbordo inverso.

		plazaCastilla1.addTransbordo(plazaCastilla10); // Añade transbordo entre Plaza de Castilla de una línea y otra.
		plazaCastilla10.addTransbordo(plazaCastilla1); // Añade el transbordo inverso.

		cuatroCaminos1.addTransbordo(cuatroCaminos2); // Añade transbordo entre Cuatro Caminos de una línea y otra.
		cuatroCaminos2.addTransbordo(cuatroCaminos1); // Añade el transbordo inverso.

		cuatroCaminos1.addTransbordo(cuatroCaminos10); // Añade transbordo entre Cuatro Caminos de una línea y otra.
		cuatroCaminos10.addTransbordo(cuatroCaminos1); // Añade el transbordo inverso.

		tribunal1.addTransbordo(tribunal10); // Añade transbordo entre Tribunal de una línea y otra.
		tribunal10.addTransbordo(tribunal1); // Añade el transbordo inverso.

		sol1.addTransbordo(sol2); // Añade transbordo entre Sol de una línea y otra.
		sol2.addTransbordo(sol1); // Añade el transbordo inverso.

		List<Estacion> ruta = AStarMetro.buscarRuta(atocha, plazaEspana); // Busca una ruta desde Atocha hasta Plaza de
																			// España.

		for (Estacion e : ruta) { // Recorre todas las estaciones de la ruta encontrada.
			System.out.println(e); // Imprime el nombre de cada estación.
		} // Fin del for.
	} // Fin del método main.
} // Fin de la clase Main.