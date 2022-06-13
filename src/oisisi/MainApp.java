package oisisi;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import oisisi.model.Adresa;
import oisisi.model.Alati;
import oisisi.model.Cetkica;
import oisisi.model.Kamera;
import oisisi.model.Materijal;
import oisisi.model.Objekat;
import oisisi.model.Render;
import oisisi.model.Softver;
import oisisi.model.Zaposleni;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

public class MainApp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
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
				"1.1.1999.", 
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
		
		//Postavljanje visine i sirine i pocetnih koordinata za prozor
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (screenSize.getWidth()*0.75);
		int height = (int) (screenSize.getHeight()*0.75);
		
		int startX = (int) (screenSize.getWidth()*0.25/2);
		int startY = (int) (screenSize.getHeight()*0.25/2);
		
		Border emptyBorder = BorderFactory.createEmptyBorder();

		frame = new JFrame();
		frame.setTitle("OISISI PROJEKAT");
		frame.setBounds(startX, startY, width, height); 
		//frame.setBounds(100,100,873,565); //TODO OVO JE SAMO ZA TEST, OTKOMENTARISATI LINIJU IZNAD
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        JMenuItem addMenuItem = new JMenuItem();
        addMenuItem.setText("Add");
        addMenuItem.setIcon(new ImageIcon("./resources/add.png"));
        addMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
        JMenuItem editMenuItem = new JMenuItem();
        editMenuItem.setText("Edit");
        editMenuItem.setIcon(new ImageIcon("./resources/edit.png"));
        editMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
        JMenuItem saveMenuItem = new JMenuItem();
        saveMenuItem.setText("Delete");
        saveMenuItem.setIcon(new ImageIcon("./resources/delete.png"));
        saveMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
		
		JToolBar toolBarTop = new JToolBar();
		toolBarTop.setFloatable(false);
		toolBarTop.add(addMenuItem);
		toolBarTop.add(editMenuItem);
		toolBarTop.add(saveMenuItem);
		toolBarTop.setBorder(emptyBorder);
		frame.getContentPane().add(toolBarTop, BorderLayout.NORTH);
		
		JToolBar toolBarBottom = new JToolBar();
		toolBarBottom.setFloatable(false);
		toolBarBottom.setToolTipText("");
		frame.getContentPane().add(toolBarBottom, BorderLayout.SOUTH);
		
		LocalDate date = LocalDate.now();
		JLabel lblNewLabel = new JLabel(date.toString());
		toolBarBottom.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Zaposleni", null, tabbedPane_1, null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Softver", null, tabbedPane_2, null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mntmNewMenuItem_1 = new JMenu("Open");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Zaposleni");
		mntmNewMenuItem_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Softveri");
		mntmNewMenuItem_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Exit");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Edit");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Help");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_2 = new JMenu("Help");
		menuBar.add(mnNewMenu_2);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
	}

}
