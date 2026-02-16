package excepciones;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		List<Object> lst = new ArrayList<>();
		lst.add("1");
		lst.add("1.2");
		lst.add(1);
		lst.add(1.3);

		List<String> lstErrores = new ArrayList<String>();
		fn(lst, lstErrores);
		System.out.println(lstErrores);
	}

	public static void fn(List<Object> lst, List<String> lstErrores) {
		for (Object o : lst) {
			try {
				convertir(o);
			} catch (Exception e) {
				lstErrores.add(e.getMessage());
			}
		}
	}

	private static void convertir(Object o) throws Exception {
		if (o instanceof String) {
			try {
				Integer.parseInt((String) o);
			} catch (Exception e) {
				throw new Exception("No puedo convertir " + o + " a entero");
			}
		} else {
			int i = (Integer) o;
		}

	}
}
