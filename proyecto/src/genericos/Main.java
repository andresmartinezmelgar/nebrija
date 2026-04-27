package genericos;

import java.util.List;
import java.lang.reflect.*;

public class Main {

	public static void main(String[] args) throws Exception {
//		Genericos<Integer> g = new Genericos<>();
//		g.guardar(852);
//		System.out.println(g.obtener());
//
//		Genericos<String> g1 = new Genericos<String>();
//		g1.guardar("qwaeqweqe");
//		System.out.println(g1.obtener());
		Prueba p = new Prueba();
		Class<?> c = Prueba.class;

		Method[] m = c.getMethods();
		for (Method metodo : m) {
			System.out.println(metodo);
		}
		Method metodoConcreto = Prueba.class.getMethod("a",String.class);
		metodoConcreto.invoke(p,"1111111111");
		
		System.out.println("------------------");
		Field[] f = c.getDeclaredFields();
		for (Field campos : f) {
			System.out.println(campos.getName());
		}
		System.out.println("------------------");
		Constructor<?>[] co = c.getConstructors();
		for (Constructor<?> constr : co) {
			System.out.println(constr);
		}
		System.out.println("------------------");
		Field campoConcreto = c.getDeclaredField("valor");
		System.out.println(campoConcreto);
		campoConcreto.setAccessible(true);
		System.out.println(campoConcreto.get(p));
		
		
		
		
	}

}
