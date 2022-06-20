package oisisi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import oisisi.MainApp;

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
	
	public Zaposleni(String ime, String prezime, String jmbg, String datumRodjenja, String email, Adresa adresaStanovanja,
			List<String> softveri) {
		super();
		
		ArrayList<Softver> softveriList = new ArrayList<Softver>();
		
		for(int i = 0; i < softveri.size(); i++) {
			for(Softver sf : MainApp.softveri) {
				if(sf.getNaziv().equals(softveri.get(i))) {
					softveriList.add(sf);
				}
			}
		}
		
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = Long.parseLong(jmbg);
		this.datumRodjenja = datumRodjenja;
		this.email = email;
		this.adresaStanovanja = adresaStanovanja;
		this.softveri = softveriList;
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
	
	public String getJmbgToString() {
		return String.valueOf(jmbg);
	}

	public void setJmbg(long jmbg) {
		this.jmbg = jmbg;
	}

	public String getDatumRodjenja() {
		return datumRodjenja;
	}
	
	public String getDan() {
		String[] parts = datumRodjenja.split(Pattern.quote("."));
		return parts[0];
	}
	
	public String getMesec() {
		String[] parts = datumRodjenja.split(Pattern.quote("."));
		return parts[1];
	}
	
	public String getGodina() {
		String[] parts = datumRodjenja.split(Pattern.quote("."));
		return parts[2];
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
	
	public String getAdresaStanovanjaToString() {
		return this.adresaStanovanja.getUlica() + " " + this.adresaStanovanja.getBroj() + ", " + this.adresaStanovanja.getGrad();
	}
	
	public String getSoftveriToString() {
		String softveri = "";
		
		for(Softver softver : getSoftveri()) {
			String softverTemp = softver.getNaziv() + ", " + softveri ;
			softveri = softverTemp;
		}
		
		return softveri;
	}

	@Override
	public String toString() {
		return "Zaposleni [ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", datumRodjenja=" + datumRodjenja
				+ ", email=" + email + ", adresaStanovanja=" + adresaStanovanja + ", softveri=" + softveri + "]";
	}
}
