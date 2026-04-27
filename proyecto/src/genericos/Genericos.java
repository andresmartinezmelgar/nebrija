package genericos;

public class Genericos<T> {

	public T valor;

	public void guardar(T valor) {
		this.valor = valor;
	}

	public T obtener() {
		return valor;
	}

}
