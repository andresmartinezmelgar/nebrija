import java.util.List;

public class sxasx {
	static List<Integer> lst = List.of(1, 2, 3, 4, 5);

	public static void main(String[] args) {
		System.out.println(nextPlayer(4));//1
		System.out.println(nextPlayer(3));//5
		System.out.println(nextPlayer(2));//4
		System.out.println(prevPlayer(4));//4
		System.out.println(prevPlayer(3));//3
		System.out.println(prevPlayer(2));//2
		System.out.println(prevPlayer(1));//1
		System.out.println(prevPlayer(0));//5
	}

	public static int nextPlayer(int posActual) {
		if (posActual + 1 == lst.size()) {
			return lst.get(0);
		}
		return lst.get(posActual + 1);
	}

	public static  int prevPlayer(int posActual) {
		if (posActual == 0) {
			return lst.get(lst.size()-1);
		}
		return lst.get(posActual - 1);
	}
}
