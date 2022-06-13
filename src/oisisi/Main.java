package oisisi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oisisi.model.Adresa;
import oisisi.model.Alati;
import oisisi.model.Cetkica;
import oisisi.model.Kamera;
import oisisi.model.Materijal;
import oisisi.model.Objekat;
import oisisi.model.Render;
import oisisi.model.Softver;
import oisisi.model.Zaposleni;

import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.TextArea;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//Ubacivanje pocetnih objekata u aplikaciju
		ArrayList<Cetkica> cetkice = new ArrayList<Cetkica>();
		cetkice.add(new Cetkica("Standard", "Standardna visenamenska cetkica", new Color(128, 128, 128)));
		cetkice.add(new Cetkica("Smooth", "Ublazavanje neravnina na povrsini", new Color(255, 0, 0)));
		cetkice.add(new Cetkica("Deform", "Deformacija povrsina", new Color(0, 255, 0)));
		cetkice.add(new Cetkica("Remove", "Udubljivanje povrsina", new Color(0, 0, 255)));
		
		
		ArrayList<Alati> alati = new ArrayList<Alati>();
		alati.add(new Alati("Translate"));
		alati.add(new Alati("Scale"));
		alati.add(new Alati("Rotate"));
		alati.add(new Alati("Deform"));
		
		
		ArrayList<Materijal> materijali = new ArrayList<Materijal>();
		materijali.add(new Materijal("Drvo"));
		materijali.add(new Materijal("Metal"));
		materijali.add(new Materijal("Kamen"));
		materijali.add(new Materijal("Plastika"));
		
		ArrayList<Kamera> kamere = new ArrayList<Kamera>();
		kamere.add(new Kamera("Front"));
		kamere.add(new Kamera("Back"));
		kamere.add(new Kamera("Top"));
		kamere.add(new Kamera("Side"));
		
		ArrayList<Objekat> objekti = new ArrayList<Objekat>();
		objekti.add(new Objekat("Sekira"));
		objekti.add(new Objekat("Oklop"));
		objekti.add(new Objekat("Mac"));
		objekti.add(new Objekat("Sanduk"));
		
		ArrayList<Render> renderi = new ArrayList<Render>();
		renderi.add(new Render(
				"Render 1", 
				new ArrayList<Materijal>(Arrays.asList(materijali.get(0), materijali.get(2))), 
				new ArrayList<Kamera>(Arrays.asList(kamere.get(1), kamere.get(2))), 
				new ArrayList<Objekat>(Arrays.asList(objekti.get(2), objekti.get(3)))
				));
		renderi.add(new Render(
				"Render 2", 
				new ArrayList<Materijal>(Arrays.asList(materijali.get(1), materijali.get(2), materijali.get(3))), 
				new ArrayList<Kamera>(Arrays.asList(kamere.get(0), kamere.get(1))), 
				new ArrayList<Objekat>(Arrays.asList(objekti.get(1), objekti.get(2), objekti.get(3)))
				));
		renderi.add(new Render(
				"Render 3", 
				new ArrayList<Materijal>(Arrays.asList(materijali.get(2), materijali.get(3))), 
				new ArrayList<Kamera>(Arrays.asList(kamere.get(0))), 
				new ArrayList<Objekat>(Arrays.asList(objekti.get(1), objekti.get(2), objekti.get(3)))
				));
		
		
		ArrayList<Softver> softveri = new ArrayList<Softver>();
		softveri.add(new Softver(
				"Photoshop",
				new ArrayList<Cetkica>(Arrays.asList(cetkice.get(1), cetkice.get(3))),
				"PSD",
				new ArrayList<Alati>(Arrays.asList(alati.get(0), alati.get(1))),
				renderi.get(0)
				));
		softveri.add(new Softver(
				"Substance Painter",
				new ArrayList<Cetkica>(Arrays.asList(cetkice.get(0))),
				"SPP",
				new ArrayList<Alati>(Arrays.asList(alati.get(0))),
				renderi.get(0)
				));
		softveri.add(new Softver(
				"3ds Max",
				new ArrayList<Cetkica>(Arrays.asList(cetkice.get(0), cetkice.get(1), cetkice.get(2))),
				"MAX",
				new ArrayList<Alati>(Arrays.asList(alati.get(0), alati.get(1), alati.get(2), alati.get(3))),
				renderi.get(0)
				));
		
		
		ArrayList<Zaposleni> zaposleni = new ArrayList<Zaposleni>();
		zaposleni.add(new Zaposleni(
				"Ognjen", 
				"Markovic", 
				111111, 
				"1.1.2000.", 
				"ognjen@email.com", 
				new Adresa(26, "Futoska", "Novi Sad"), 
				new ArrayList<Softver>(Arrays.asList(softveri.get(0), softveri.get(1)))
				));
		zaposleni.add(new Zaposleni(
				"Vuksa", 
				"Vasiljevic", 
				222222, 
				"6.6.1999.", 
				"vuksa@email.com", 
				new Adresa(2, "Maksima Gorkog", "Novi Sad"), 
				new ArrayList<Softver>(Arrays.asList(softveri.get(2)))
				));
		zaposleni.add(new Zaposleni(
				"Filip", 
				"Zekic", 
				333333, 
				"12.12.1999.", 
				"filip@email.com", 
				new Adresa(16, "Bulevar Oslobodjenja", "Novi Sad"), 
				new ArrayList<Softver>(Arrays.asList(softveri.get(0), softveri.get(1), softveri.get(2)))
				));
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		
		//Postavljanje visine i sirine i pocetnih koordinata za prozor
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (screenSize.getWidth()*0.75);
		int height = (int) (screenSize.getHeight()*0.75);
		
		int startX = (int) (screenSize.getWidth()*0.25/2);
		int startY = (int) (screenSize.getHeight()*0.25/2);

		
		setTitle("OISISI PROJEKAT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(startX, startY, width, height); 
		setBounds(100,100,873,565); //TODO OVO JE SAMO ZA TEST, OTKOMENTARISATI LINIJU IZNAD
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Open");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Exit");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Edit");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Delete");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_2 = new JMenu("Help");
		menuBar.add(mnNewMenu_2);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
	}
}
