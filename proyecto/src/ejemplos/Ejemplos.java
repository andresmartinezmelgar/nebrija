package ejemplos;

public class Ejemplos {

	public static void main(String[] args) {
		String txt = "";
		long ini = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			txt += 1;
		}
		long fin = System.currentTimeMillis();
		
		System.out.println("Construcción solo con String: "+(fin - ini));
		System.out.println("-----------");
		StringBuilder sb = new StringBuilder();
		ini = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			sb.append(2);
		}
		fin = System.currentTimeMillis();
		System.out.println("-----------");
		System.out.println("Construcción solo con StringBuilder: "+(fin - ini));
	}

}
