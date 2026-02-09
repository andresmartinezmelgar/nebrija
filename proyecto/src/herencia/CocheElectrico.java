package herencia;

public class CocheElectrico extends Coche {
	public double voltaje;
	public CocheElectrico(int numRuedas, int numPuertas, String modelo, int numVentanas, int numAsientos,
			int velocidadMax, double voltaje) {

		super(numRuedas, numPuertas, modelo, numVentanas, numAsientos, velocidadMax);

		this.voltaje = voltaje;
	}
	
	@Override
	public void mostrarInfo() {
		super.mostrarInfo();
		System.out.println("\tInfo particular del coche eléctrico\n"
				+ "\t\t Voltaje: "+this.voltaje);
	}
	
	public void sumarPuertasYVentanas() {
		System.out.println(numPuertas+numVentanas);
	}

}








