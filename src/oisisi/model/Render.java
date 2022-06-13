package oisisi.model;

import java.util.ArrayList;

public class Render {
	
	private String naziv;
	private ArrayList<Materijal> materijali;
	private ArrayList<Kamera> kamere;
	private ArrayList<Objekat> objekti;
	
	
	public Render() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Render(String naziv, ArrayList<Materijal> materijali, ArrayList<Kamera> kamere, ArrayList<Objekat> objekti) {
		super();
		this.naziv = naziv;
		this.materijali = materijali;
		this.kamere = kamere;
		this.objekti = objekti;
	}
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public ArrayList<Materijal> getMaterijali() {
		return materijali;
	}
	public void setMaterijali(ArrayList<Materijal> materijali) {
		this.materijali = materijali;
	}
	public ArrayList<Kamera> getKamere() {
		return kamere;
	}
	public void setKamere(ArrayList<Kamera> kamere) {
		this.kamere = kamere;
	}
	public ArrayList<Objekat> getObjekti() {
		return objekti;
	}
	public void setObjekti(ArrayList<Objekat> objekti) {
		this.objekti = objekti;
	}
}
