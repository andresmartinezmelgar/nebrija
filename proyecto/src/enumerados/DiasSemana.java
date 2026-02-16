package enumerados;

public enum DiasSemana {
	LUNES(1), MARTES(2), MIERCOLES(3), JUEVES(4), VIERNES(5), SABADO(6), DOMINGO(7);

	private int valor;

	DiasSemana(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	
}
