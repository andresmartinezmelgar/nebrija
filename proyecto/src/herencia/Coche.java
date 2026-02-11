package herencia;

public class Coche {
	protected int numRuedas;
	protected int numPuertas;
	protected String modelo;
	protected int numVentanas;
	protected int numAsientos;
	protected int velocidadMax;
	//COMENTARIO SUPER IMPORTANTE
	public Coche(int numRuedas, int numPuertas,
			String modelo, int numVentanas,
			int numAsientos, int velocidadMax) {
		this.numRuedas = numRuedas;
		this.numPuertas = numPuertas;
		this.modelo = modelo;
		this.numVentanas = numVentanas;
		this.numAsientos = numAsientos;
		this.velocidadMax = velocidadMax;
	}
	
	
	public void mostrarInfo() {
		System.out.println("Info general del coche\n"
				+ "\tNumRuedas:" +this.numRuedas+"\n"
				+ "\tnumPuertas:" +this.numPuertas+"\n"
				+ "\tmodelo:" +this.modelo+"\n"
				+ "\tnumVentanas:" +this.numVentanas+"\n"
				+ "\tnumAsientos:" +this.numAsientos+"\n"
				+ "\tvelocidadMax:" +this.velocidadMax+""
				);
	}
}











