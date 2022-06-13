package oisisi.model;

public class Adresa {

	private int broj;
	private String ulica;
	private String grad;
	
	
	public Adresa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adresa(int broj, String ulica, String grad) {
		super();
		this.broj = broj;
		this.ulica = ulica;
		this.grad = grad;
	}

	public int getBroj() {
		return broj;
	}

	public void setBroj(int broj) {
		this.broj = broj;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}
	
	
	
}
