package herencia;

public class CocheMecanico extends Coche {

	public CocheMecanico(int numRuedas, int numPuertas, String modelo, int numVentanas, int numAsientos,
			int velocidadMax) {
		super(numRuedas, numPuertas, modelo, numVentanas, numAsientos, velocidadMax);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void arrancar(int i) {
		// TODO Auto-generated method stub
		System.out.println("Pulso btn y suena un rum rum!");
	}

	public void pepe() {
		System.out.println(numPuertas + numVentanas);
	}

}
