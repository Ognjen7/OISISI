package oisisi.model;

import java.util.ArrayList;

public class Softver {

	private String naziv;
	private ArrayList<Cetkica> cetkice;
	private String fajlFormat;
	private ArrayList<Alati> alatiZaAnimaciju;
	private Render render;
	
	
	public Softver() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Softver(String naziv, ArrayList<Cetkica> cetkice, String fajlFormat, ArrayList<Alati> alatiZaAnimaciju,
			Render render) {
		super();
		this.naziv = naziv;
		this.cetkice = cetkice;
		this.fajlFormat = fajlFormat;
		this.alatiZaAnimaciju = alatiZaAnimaciju;
		this.render = render;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public ArrayList<Cetkica> getCetkice() {
		return cetkice;
	}


	public void setCetkice(ArrayList<Cetkica> cetkice) {
		this.cetkice = cetkice;
	}


	public String getFajlFormat() {
		return fajlFormat;
	}


	public void setFajlFormat(String fajlFormat) {
		this.fajlFormat = fajlFormat;
	}


	public ArrayList<Alati> getAlatiZaAnimaciju() {
		return alatiZaAnimaciju;
	}


	public void setAlatiZaAnimaciju(ArrayList<Alati> alatiZaAnimaciju) {
		this.alatiZaAnimaciju = alatiZaAnimaciju;
	}


	public Render getRender() {
		return render;
	}


	public void setRender(Render render) {
		this.render = render;
	}
	
	
	
}
