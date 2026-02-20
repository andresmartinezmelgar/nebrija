package ordenacion;

public class DNI implements Comparable<DNI>{
	private String numero;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	public DNI(String n) {
		this.numero=n;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(DNI o) {
		return this.numero.compareTo(o.getNumero());
	}
}














