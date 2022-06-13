package oisisi.model;

import java.util.ArrayList;

public class Zaposleni {

	private String ime;
	private String prezime;
	private long jmbg;
	private String datumRodjenja;
	private String email;
	private Adresa adresaStanovanja;
	private ArrayList<Softver> softveri;
	
	public Zaposleni() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Zaposleni(String ime, String prezime, long jmbg, String datumRodjenja, String email, Adresa adresaStanovanja,
			ArrayList<Softver> softveri) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.datumRodjenja = datumRodjenja;
		this.email = email;
		this.adresaStanovanja = adresaStanovanja;
		this.softveri = softveri;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public long getJmbg() {
		return jmbg;
	}

	public void setJmbg(long jmbg) {
		this.jmbg = jmbg;
	}

	public String getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Adresa getAdresaStanovanja() {
		return adresaStanovanja;
	}

	public void setAdresaStanovanja(Adresa adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}

	public ArrayList<Softver> getSoftveri() {
		return softveri;
	}

	public void setSoftveri(ArrayList<Softver> softveri) {
		this.softveri = softveri;
	}
	
	
	
}
