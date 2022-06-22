package oisisi.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import oisisi.MainApp;

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


	public Softver(String naziv, ArrayList<Cetkica> cetkice, String fajlFormat, ArrayList<Alati> alatiZaAnimaciju, Render render) {
		super();
		this.naziv = naziv;
		this.cetkice = cetkice;
		this.fajlFormat = fajlFormat;
		this.alatiZaAnimaciju = alatiZaAnimaciju;
		this.render = render;
	}
	
	public Softver(String naziv, List<String> cetkice, String fajlFormat, List<String> alatiZaAnimaciju, int render) {
		super();
		
		ArrayList<Cetkica> cetkiceList = new ArrayList<Cetkica>();
		ArrayList<Alati> alatiZaAnimacijuList = new ArrayList<Alati>();
		Render renderConverted = MainApp.renderi.get(render);
		
		for(int i = 0; i < cetkice.size(); i++) {
			for(Cetkica ct : MainApp.cetkice) {
				if(ct.getNaziv().equals(cetkice.get(i))) {
					cetkiceList.add(ct);
				}
			}
		}
		
		for(int i = 0; i < alatiZaAnimaciju.size(); i++) {
			for(Alati al : MainApp.alati) {
				if(al.getNaziv().equals(alatiZaAnimaciju.get(i))) {
					alatiZaAnimacijuList.add(al);
				}
			}
		}
		
		this.naziv = naziv;
		this.cetkice = cetkiceList;
		this.fajlFormat = fajlFormat;
		this.alatiZaAnimaciju = alatiZaAnimacijuList;
		this.render = renderConverted;
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
	
	public ArrayList<Color> getCetkiceColors() {
		
		ArrayList<Color> colors = new ArrayList<Color>();
		
		for(Cetkica cetkica : cetkice) {
			colors.add(cetkica.getBoja());
		}
		
		return colors;
	}
	
	public String getCetkiceToString() {
		
		String brushes = "";
		
		for(Cetkica ct : cetkice) {
			String brushesTemp = ct.getNaziv() + ", " + brushes;
			brushes = brushesTemp;
		}
		
		return brushes;
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
	
	public String getAlatiZaAnimacijuToString() {
		String tools = "";
		
		for(Alati tool : alatiZaAnimaciju) {
			String toolsTemp = tool.getNaziv() + ", " + tools;
			tools = toolsTemp;
		}
		
		return tools;
	}


	public void setAlatiZaAnimaciju(ArrayList<Alati> alatiZaAnimaciju) {
		this.alatiZaAnimaciju = alatiZaAnimaciju;
	}


	public Render getRender() {
		return render;
	}
	
	public String getRenderToString() {
		return render.getNaziv();
	}


	public void setRender(Render render) {
		this.render = render;
	}


	@Override
	public String toString() {
		return "Softver [naziv=" + naziv + ", cetkice=" + cetkice + ", fajlFormat=" + fajlFormat + ", alatiZaAnimaciju="
				+ alatiZaAnimaciju + ", render=" + render + "]";
	}
	
	
	
}
