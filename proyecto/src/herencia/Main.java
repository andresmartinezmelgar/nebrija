package herencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		CocheElectrico ce = new CocheElectrico(4, 4, "Skoda", 4, 4, 280, 420.2);

		CocheMecanico cm = new CocheMecanico(4, 4, "Skoda", 4, 4, 280);

		asd(ce);
		asd(cm);
	}

	public static void asd(Coche c) {
		c.arrancar(0);
		System.out.println(c.getClass() == CocheElectrico.class);

		if (c instanceof CocheElectrico) {
			System.out.println("Coche Electrico");

			CocheElectrico aux = (CocheElectrico) c;
			aux.sumarPuertasYVentanas();

			((CocheElectrico) c).sumarPuertasYVentanas();
		}
		else if(c instanceof CocheMecanico) {
			CocheMecanico aux = (CocheMecanico)c;
			aux.pepe();
		}

	}

}
