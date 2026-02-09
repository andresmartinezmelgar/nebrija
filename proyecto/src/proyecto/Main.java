package proyecto;

public class Main {

	public static void main(String[] args) {
		LinkedListImplementacion l = new LinkedListImplementacion();
		l.add(0);
		l.add(1);
		l.add(32);
		l.add(1);
		l.add(103);
		l.add(14);
		l.add(1);
		l.add(123);
		l.add(0);
		l.add(1123);
		l.add(3241);
		l.add(0);
		l.add(1);
		l.add(0);
		l.add(37897);
		l.add(12377);
		
		l.print();
		l.eliminarPorValor(0);
		
		l.print();
		l.eliminarPorIndice(-2);
		l.print();
		l.eliminarTodosValor(1);
		l.print();
		
		
		
	}
}









