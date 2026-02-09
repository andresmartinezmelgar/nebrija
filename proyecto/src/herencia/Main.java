package herencia;


public class Main {
	public static void main(String[] args) {
		Coche c = new Coche(4, 4, "Skoda", 4, 4, 280);
		CocheElectrico ce = new CocheElectrico(4, 4, "Skoda", 4, 4, 280, 420.2);
	

		mostrarInfoCoche(c);
		mostrarInfoCoche(ce);
	}
	
	public static void mostrarInfoCoche(Coche c) {
		c.mostrarInfo();
		
	}
	
	
}
