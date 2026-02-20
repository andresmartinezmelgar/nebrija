package ordenacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Persona p1 = new Persona(1, "a1");
		Persona p2 = new Persona(2, "aa3");
		Persona p3 = new Persona(3, "aa3");
		Persona p4 = new Persona(4, "qa4");
		Persona p5 = new Persona(5, "na5");
		DNI d1 = new DNI("4231");
		DNI d2 = new DNI("3232");
		DNI d3 = new DNI("1233");
		DNI d4 = new DNI("8234");
		DNI d5 = new DNI("1235");
		p1.setDni(d1);
		p2.setDni(d2);
		p3.setDni(d3);
		p4.setDni(d4);
		p5.setDni(d5);
		List<Persona> lst = new ArrayList<>();
		lst.add(p5);
		lst.add(p1);
		lst.add(p2);
		lst.add(p3);
		lst.add(p4);
		System.out.println(lst);
		lst.sort(Comparator.comparing(Persona::getId));

		System.out.println(lst);
		lst.sort(Comparator.comparing(Persona::getDni));

		System.out.println(lst);
		System.out.println(d1.compareTo(d5));

	}
}
