package model;

public class X {
	private int numero;
	private int id;
	
	public X() {
		this.id = -1;
		this.numero = 0;
	}
	
	public X(int num, int id) {
		this.id = id;
		this.numero = num;
	}
	
	//setter:
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	//getter:
	public int getNumero() {
		return this.numero;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getId() {
		return this.id;
	}
	
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", numero=" + numero + "]";
	}
	
}
