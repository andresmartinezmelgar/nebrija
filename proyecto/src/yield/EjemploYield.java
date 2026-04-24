package yield;

public class EjemploYield {
	public static void main(String[] args) {
		System.out.println(ejecutar());
		System.out.println(ejecutar());
		System.out.println(ejecutar());
		System.out.println(ejecutar());
		System.out.println(ejecutar());
		System.out.println(ejecutar());
	}

	private static int ejecutar() {
		int i = 9;
		int valor = switch (i) {
		case 9: {

			yield 1;
		}
		default:
			yield 2;

		};
		switch (i) {
			case 9: {
	
				return 2;
			}
		}
		return 1;
	}

}
