package oisisi;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import oisisi.model.Adresa;
import oisisi.model.Alati;
import oisisi.model.Cetkica;
import oisisi.model.Kamera;
import oisisi.model.Materijal;
import oisisi.model.Objekat;
import oisisi.model.Render;
import oisisi.model.Softver;
import oisisi.model.Zaposleni;
import oisisi.view.About;
import oisisi.view.AddSoftver;
import oisisi.view.AddZaposleni;
import oisisi.view.DeleteSoftveri;
import oisisi.view.DeleteSoftveriFinal;
import oisisi.view.DeleteZaposleni;
import oisisi.view.DeleteZaposleniFinal;
import oisisi.view.EditSoftver;
import oisisi.view.EditZaposleni;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainApp {

	private JFrame frame;
	private JTable table_1;
	
	private String[] podaciTabelaZaposleni = {"Ime", "Prezime", "Jmbg", "Datum rodjenja", "Email", "Adresa stanovanja", "Softveri"};
	private Object[][] podaciZaposleni;
	
	private String[] podaciTabelaSoftveri = {"Naziv", "Cetkice", "Fajl format", "Alati za animaciju", "Render"};
	private Object[][] podaciSoftveri;
	
	
	//Podaci stavljeni ovde da mogu sve funkcije da im pristupe
	public static ArrayList<Cetkica> cetkice = new ArrayList<Cetkica>();
	public static ArrayList<Alati> alati = new ArrayList<Alati>();
	public static ArrayList<Materijal> materijali = new ArrayList<Materijal>();
	public static ArrayList<Kamera> kamere = new ArrayList<Kamera>();
	public static ArrayList<Objekat> objekti = new ArrayList<Objekat>();
	public static ArrayList<Render> renderi = new ArrayList<Render>();
	public static ArrayList<Softver> softveri = new ArrayList<Softver>();
	public static ArrayList<Zaposleni> zaposleni = new ArrayList<Zaposleni>();
	
	int selectedTabIndex = 0;
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	private final JPanel popupErrorPanel = new JPanel();
	private JTable table_2;
	
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
		
		initializeData();
		
		//Postavljanje visine i sirine i pocetnih koordinata za prozor
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
        
        JMenuItem deleteMenuItem = new JMenuItem();
        deleteMenuItem.setText("Delete");
        deleteMenuItem.setIcon(new ImageIcon("./resources/delete.png"));
        deleteMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
		
		JToolBar toolBarTop = new JToolBar();
		toolBarTop.setFloatable(false);
		toolBarTop.add(addMenuItem);
		toolBarTop.add(editMenuItem);
		toolBarTop.add(deleteMenuItem);
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
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Zaposleni", null, scrollPane, null);
		
		table_1 = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
	    
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setFillsViewportHeight(true);
		table_1.setModel(new DefaultTableModel(podaciZaposleni, podaciTabelaZaposleni));
		
		scrollPane.setViewportView(table_1);
		
		addMenuItem.addActionListener(
				new ActionListener(){
	                public void actionPerformed(ActionEvent e){
	                	selectedTabIndex = tabbedPane.getSelectedIndex();
	                	
	                	if(selectedTabIndex == 0) {
	                		addZaposleni();
	                	}
	                	
	                	if(selectedTabIndex == 1) {
	                		addSoftveri();
	                	}
	                }
	            });
		
		editMenuItem.addActionListener(
				new ActionListener(){
	                public void actionPerformed(ActionEvent e){
	                	selectedTabIndex = tabbedPane.getSelectedIndex();
	                	
	                	if(selectedTabIndex == 0) {
	                		int selectedRowIndex = table_1.getSelectedRow();
	                		editZaposleni(selectedRowIndex);
	                	}
	                	
	                	if(selectedTabIndex == 1) {
	                		int selectedRowIndex = table_2.getSelectedRow();
	                		System.out.println(selectedRowIndex);
	                		editSoftveri(selectedRowIndex);
	                	}
	                }
	            });
		
		deleteMenuItem.addActionListener(
				new ActionListener(){
	                public void actionPerformed(ActionEvent e){
	                	selectedTabIndex = tabbedPane.getSelectedIndex();
	                	
	                	if(selectedTabIndex == 0) {
	                		int selectedRowIndex = table_1.getSelectedRow();
	                		deleteZaposleni(selectedRowIndex);
	                	}
	                	
	                	if(selectedTabIndex == 1) {
	                		int selectedRowIndex = table_2.getSelectedRow();
	                		deleteSoftveri(selectedRowIndex);
	                	}
	                	
	                }
	            });
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("Softveri", null, scrollPane_1, null);
		
		table_2 = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
	    
		table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_2.setModel(new DefaultTableModel( podaciSoftveri, podaciTabelaSoftveri));
		table_2.setFillsViewportHeight(true);
		
		scrollPane_1.setViewportView(table_2);
		
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
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Delete");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_2 = new JMenu("Help");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("About");
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
		
		mntmNewMenuItem.addActionListener(
				new ActionListener(){
	                public void actionPerformed(ActionEvent e){
	                	selectedTabIndex = tabbedPane.getSelectedIndex();
	                	
	                	if(selectedTabIndex == 0) {
	                		addZaposleni();
	                	}
	                	if(selectedTabIndex == 1) {
	                		addSoftveri();
	                	}
	                }
	            });
		
		mntmNewMenuItem_5.addActionListener(
				new ActionListener(){
	                public void actionPerformed(ActionEvent e){
	                	tabbedPane.setSelectedIndex(0);
	                }
	            });
		
		mntmNewMenuItem_6.addActionListener(
				new ActionListener(){
	                public void actionPerformed(ActionEvent e){
	                	tabbedPane.setSelectedIndex(1);
	                }
	            });
		
		mntmNewMenuItem_2.addActionListener(
				new ActionListener(){
	                public void actionPerformed(ActionEvent e){
	                	System.exit(0);
	                }
	            });
		
		mntmNewMenuItem_3.addActionListener(
				new ActionListener(){
	                public void actionPerformed(ActionEvent e){
	                	selectedTabIndex = tabbedPane.getSelectedIndex();
	                	
	                	if(selectedTabIndex == 0) {
	                		int selectedRowIndex = table_1.getSelectedRow();
	                		editZaposleni(selectedRowIndex);
	                	}
	                	
	                	if(selectedTabIndex == 1) {
	                		int selectedRowIndex = table_2.getSelectedRow();
	                		editSoftveri(selectedRowIndex);
	                	}
	                }
	            });
		
		mntmNewMenuItem_4.addActionListener(
				new ActionListener(){
	                public void actionPerformed(ActionEvent e){
	                	selectedTabIndex = tabbedPane.getSelectedIndex();
	                	
	                	if(selectedTabIndex == 0) {
	                		int selectedRowIndex = table_1.getSelectedRow();
	                		deleteZaposleni(selectedRowIndex);
	                	}
	                	
	                	if(selectedTabIndex == 1) {
	                		int selectedRowIndex = table_2.getSelectedRow();
	                		deleteSoftveri(selectedRowIndex);
	                	}
	                }
	            });
		
		mntmNewMenuItem_7.addActionListener(
				new ActionListener(){
	                public void actionPerformed(ActionEvent e){
	                	about();
	                }
	            });
		
		updateZaposleni();
		updateSoftveri();
		
		// MODALNI PROZORI ------------------------------------------
		popupErrorPanel.add(new JLabel("Greska! Niste izabrali softver ili zaposlenog! Izaberite i pokusajte ponovo.", SwingConstants.CENTER));
		
	}
	
	private void about() {
		About aboutFrame = new About();
		aboutFrame.setVisible(true);
	}
	
	
	private void addZaposleni() {
		
		AddZaposleni addZaposleniFrame = new AddZaposleni();
		
		JButton cancelButton = new JButton("CANCEL");
		addZaposleniFrame.getContentPane().add(cancelButton);
		
		JButton okButton = new JButton("OK");
		addZaposleniFrame.getContentPane().add(okButton);
		
		cancelButton.addActionListener(
				new ActionListener(){
	                public void actionPerformed(ActionEvent e){
	                	addZaposleniFrame.dispose();
	                }
	            });
		
		okButton.addActionListener(
				new ActionListener(){
	                public void actionPerformed(ActionEvent e){
	                	
	                	String ime = AddZaposleni.txtIme_1.getText();
	                	String prezime = AddZaposleni.txtIme.getText();
	                	String jmbg = AddZaposleni.txtJmbg.getText();
	                	String datum = AddZaposleni.txtDan.getText() + "." + AddZaposleni.txtMesec.getText() + "." + AddZaposleni.txtGodina.getText();
	                	String email = AddZaposleni.txtEmail.getText();
	                	String broj = AddZaposleni.txtUnesiteBroj.getText();
	                	String ulica = AddZaposleni.txtUnesiteUlicu.getText();
	                	String grad = AddZaposleni.txtUnesiteGrad.getText();
	                	List<String> softveriList = AddZaposleni.list.getSelectedValuesList();

	                	
	                	if(!ime.isEmpty() && !prezime.isEmpty() && !jmbg.isEmpty() && !datum.isEmpty() && !email.isEmpty() && !broj.isEmpty() && !ulica.isEmpty() && !grad.isEmpty() ) {
	                		
	                		zaposleni.add(new Zaposleni(ime, prezime, jmbg, datum, email, new Adresa(Integer.parseInt(broj), ulica, grad), softveriList));
		                	
		                	updateZaposleni();
		                
		                	addZaposleniFrame.dispose();
	                	}
	                }
	            });
		
		addZaposleniFrame.pack();
		addZaposleniFrame.setModal(true);
		addZaposleniFrame.setVisible(true);
	}
	
	private void editZaposleni(int selectedRowIndex) {

		if(selectedRowIndex == -1) {
			final JDialog dialog = new JDialog(frame, "GRESKA!", true);
			dialog.setBounds((int) (screenSize.getWidth()*0.7/2), (int) (screenSize.getHeight()*0.7/2), (int) (screenSize.getWidth()*0.1), (int) (screenSize.getHeight()*0.1));
			dialog.getContentPane().add(popupErrorPanel);
			dialog.pack();
			dialog.setModal(true);
			dialog.setVisible(true);
		} else {
			EditZaposleni editZaposleniFrame = new EditZaposleni(selectedRowIndex);
			
			JButton cancelButton = new JButton("CANCEL");
			editZaposleniFrame.getContentPane().add(cancelButton);
			
			JButton okButton = new JButton("OK");
			editZaposleniFrame.getContentPane().add(okButton);
			
			cancelButton.addActionListener(
					new ActionListener(){
		                public void actionPerformed(ActionEvent e){
		                	editZaposleniFrame.dispose();
		                }
		            });
			
			okButton.addActionListener(
					new ActionListener(){
		                public void actionPerformed(ActionEvent e){
		                	
		                	String ime = EditZaposleni.txtIme_1.getText();
		                	String prezime = EditZaposleni.txtIme.getText();
		                	String jmbg = EditZaposleni.txtJmbg.getText();
		                	String datum = EditZaposleni.txtDan.getText() + "." + EditZaposleni.txtMesec.getText() + "." + EditZaposleni.txtGodina.getText();
		                	String email = EditZaposleni.txtEmail.getText();
		                	String broj = EditZaposleni.txtUnesiteBroj.getText();
		                	String ulica = EditZaposleni.txtUnesiteUlicu.getText();
		                	String grad = EditZaposleni.txtUnesiteGrad.getText();
		                	List<String> softveriList = EditZaposleni.list.getSelectedValuesList();

		                	
		                	if(!ime.isEmpty() && !prezime.isEmpty() && !jmbg.isEmpty() && !datum.isEmpty() && !email.isEmpty() && !broj.isEmpty() && !ulica.isEmpty() && !grad.isEmpty() ) {
		                		Zaposleni editedZaposleni = new Zaposleni(ime, prezime, jmbg, datum, email, new Adresa(Integer.parseInt(broj), ulica, grad), softveriList);
			                	
		                		zaposleni.remove(selectedRowIndex);
		                		zaposleni.add(selectedRowIndex, editedZaposleni);
		                		
			                	updateZaposleni();
			                
			                	editZaposleniFrame.dispose();
		                	}
		                }
		            });
			
			editZaposleniFrame.pack();
			editZaposleniFrame.setModal(true);
			editZaposleniFrame.setVisible(true);
		}

	}
	
	private void deleteZaposleni(int selectedRowIndex) {
		
		if(selectedRowIndex == -1) {
			final JDialog dialog = new JDialog(frame, "GRESKA!", true);
			dialog.setBounds((int) (screenSize.getWidth()*0.7/2), (int) (screenSize.getHeight()*0.7/2), (int) (screenSize.getWidth()*0.1), (int) (screenSize.getHeight()*0.1));
			dialog.getContentPane().add(popupErrorPanel);
			dialog.pack();
			dialog.setModal(true);
			dialog.setVisible(true);
		} else {
			DeleteZaposleni deleteZaposleniFrame = new DeleteZaposleni(selectedRowIndex);
			
			JButton cancelButton = new JButton("CANCEL");
			deleteZaposleniFrame.getContentPane().add(cancelButton);
			
			JButton okButton = new JButton("OK");
			deleteZaposleniFrame.getContentPane().add(okButton);
			
			cancelButton.addActionListener(
					new ActionListener(){
		                public void actionPerformed(ActionEvent e){
		                	deleteZaposleniFrame.dispose();
		                }
		            });
			
			okButton.addActionListener(
					new ActionListener(){
		                public void actionPerformed(ActionEvent e){
		                	
		                	DeleteZaposleniFinal deleteZaposleniFinalFrame = new DeleteZaposleniFinal(selectedRowIndex);
		        			
		        			JButton cancelButton = new JButton("CANCEL");
		        			deleteZaposleniFinalFrame.getContentPane().add(cancelButton);
		        			
		        			JButton okButton = new JButton("OK");
		        			deleteZaposleniFinalFrame.getContentPane().add(okButton);
		        			
		        			cancelButton.addActionListener(
		        					new ActionListener(){
		        		                public void actionPerformed(ActionEvent e){
		        		                	deleteZaposleniFinalFrame.dispose();
		        		                	deleteZaposleniFrame.dispose();
		        		                }
		        		            });
		        			
		        			okButton.addActionListener(
		        					new ActionListener(){
		        		                public void actionPerformed(ActionEvent e){
		        	                		zaposleni.remove(selectedRowIndex);
		        		                	updateZaposleni();
		        		                	deleteZaposleniFinalFrame.dispose();
		        		                	deleteZaposleniFrame.dispose();
		        		                }
		        		            });
		        			
		        			deleteZaposleniFinalFrame.pack();
		        			deleteZaposleniFinalFrame.setModal(true);
		        			deleteZaposleniFinalFrame.setVisible(true);
		                }
		            });
			
			deleteZaposleniFrame.pack();
			deleteZaposleniFrame.setModal(true);
			deleteZaposleniFrame.setVisible(true);
		}
	}
	
	private void updateZaposleni() {
		
		podaciZaposleni = null;
		
		podaciZaposleni = new Object[zaposleni.size()][7];
		
		for (int i = 0; i < zaposleni.size(); i++) {
			String[] podaci = {
					zaposleni.get(i).getIme(),
					zaposleni.get(i).getPrezime(),
					zaposleni.get(i).getJmbgToString(),
					zaposleni.get(i).getDatumRodjenja(),
					zaposleni.get(i).getEmail(),
					zaposleni.get(i).getAdresaStanovanjaToString(),
					zaposleni.get(i).getSoftveriToString(),
					};
			podaciZaposleni[i] = podaci;
		}
		
		table_1.setModel(new DefaultTableModel(podaciZaposleni, podaciTabelaZaposleni));
		
	}
	
	//---softveri
	private void addSoftveri() {
		
		AddSoftver addSoftveriFrame = new AddSoftver();
		
		JButton cancelButton = new JButton("CANCEL");
		addSoftveriFrame.getContentPane().add(cancelButton);
		
		JButton okButton = new JButton("OK");
		addSoftveriFrame.getContentPane().add(okButton);
		
		cancelButton.addActionListener(
				new ActionListener(){
	                public void actionPerformed(ActionEvent e){
	                	addSoftveriFrame.dispose();
	                }
	            });
		
		okButton.addActionListener(
				new ActionListener(){
	                public void actionPerformed(ActionEvent e){
	                	
	                	String naziv = AddSoftver.textField.getText();
	                	List<String> cetkiceList = AddSoftver.list1.getSelectedValuesList();
	                	String fajlFormat = AddSoftver.textField_1.getText();
	                	List<String> alatiList = AddSoftver.list2.getSelectedValuesList();
	                	int render = AddSoftver.list3.getSelectedIndex();
	                	
	                	if(!naziv.isEmpty() && !cetkiceList.isEmpty() && !fajlFormat.isEmpty() && !alatiList.isEmpty() && render >= 0) {
	                		
	                		softveri.add(new Softver(
	                				naziv,
	                				cetkiceList,
	                				fajlFormat,
	                				alatiList,
	                				render
	                				));
	                		
		                	updateSoftveri();
		                
		                	addSoftveriFrame.dispose();
	                	}
	                }
	            });
		
		addSoftveriFrame.pack();
		addSoftveriFrame.setModal(true);
		addSoftveriFrame.setVisible(true);
	}
	
	private void editSoftveri(int selectedRowIndex) {

		if(selectedRowIndex == -1) {
			final JDialog dialog = new JDialog(frame, "GRESKA!", true);
			dialog.setBounds((int) (screenSize.getWidth()*0.7/2), (int) (screenSize.getHeight()*0.7/2), (int) (screenSize.getWidth()*0.1), (int) (screenSize.getHeight()*0.1));
			dialog.getContentPane().add(popupErrorPanel);
			dialog.pack();
			dialog.setModal(true);
			dialog.setVisible(true);
		} else {
			EditSoftver editSoftveriFrame = new EditSoftver(selectedRowIndex);
			
			JButton cancelButton = new JButton("CANCEL");
			editSoftveriFrame.getContentPane().add(cancelButton);
			
			JButton okButton = new JButton("OK");
			editSoftveriFrame.getContentPane().add(okButton);
			
			cancelButton.addActionListener(
					new ActionListener(){
		                public void actionPerformed(ActionEvent e){
		                	editSoftveriFrame.dispose();
		                }
		            });
			
			okButton.addActionListener(
					new ActionListener(){
		                public void actionPerformed(ActionEvent e){
		                	
		                	String naziv = EditSoftver.textField.getText();
		                	List<String> cetkiceList = EditSoftver.list1.getSelectedValuesList();
		                	String fajlFormat = EditSoftver.textField_1.getText();
		                	List<String> alatiList = EditSoftver.list2.getSelectedValuesList();
		                	int render = EditSoftver.list3.getSelectedIndex();
		                	
		                	if(!naziv.isEmpty() && !cetkiceList.isEmpty() && !fajlFormat.isEmpty() && !alatiList.isEmpty() && render >= 0) {
		                		
		                		Softver editedSoftver = new Softver( naziv, cetkiceList, fajlFormat, alatiList, render);
		                		
		                		softveri.remove(selectedRowIndex);
		                		softveri.add(selectedRowIndex, editedSoftver);
		                		
			                	updateSoftveri();
			                
			                	editSoftveriFrame.dispose();
		                	}
		                }
		            });
			
			editSoftveriFrame.pack();
			editSoftveriFrame.setModal(true);
			editSoftveriFrame.setVisible(true);
		}

	}
	
	private void deleteSoftveri(int selectedRowIndex) {
		
		if(selectedRowIndex == -1) {
			final JDialog dialog = new JDialog(frame, "GRESKA!", true);
			dialog.setBounds((int) (screenSize.getWidth()*0.7/2), (int) (screenSize.getHeight()*0.7/2), (int) (screenSize.getWidth()*0.1), (int) (screenSize.getHeight()*0.1));
			dialog.getContentPane().add(popupErrorPanel);
			dialog.pack();
			dialog.setModal(true);
			dialog.setVisible(true);
		} else {
			DeleteSoftveri deleteSoftveriFrame = new DeleteSoftveri(selectedRowIndex);
			
			JButton cancelButton = new JButton("CANCEL");
			deleteSoftveriFrame.getContentPane().add(cancelButton);
			
			JButton okButton = new JButton("OK");
			deleteSoftveriFrame.getContentPane().add(okButton);
			
			cancelButton.addActionListener(
					new ActionListener(){
		                public void actionPerformed(ActionEvent e){
		                	deleteSoftveriFrame.dispose();
		                }
		            });
			
			okButton.addActionListener(
					new ActionListener(){
		                public void actionPerformed(ActionEvent e){
		                	
		                	DeleteSoftveriFinal deleteSoftveriFinalFrame = new DeleteSoftveriFinal(selectedRowIndex);
		        			
		        			JButton cancelButton = new JButton("CANCEL");
		        			deleteSoftveriFinalFrame.getContentPane().add(cancelButton);
		        			
		        			JButton okButton = new JButton("OK");
		        			deleteSoftveriFinalFrame.getContentPane().add(okButton);
		        			
		        			cancelButton.addActionListener(
		        					new ActionListener(){
		        		                public void actionPerformed(ActionEvent e){
		        		                	deleteSoftveriFinalFrame.dispose();
		        		                	deleteSoftveriFrame.dispose();
		        		                }
		        		            });
		        			
		        			okButton.addActionListener(
		        					new ActionListener(){
		        		                public void actionPerformed(ActionEvent e){
		        	                		softveri.remove(selectedRowIndex);
		        		                	updateSoftveri();
		        		                	deleteSoftveriFinalFrame.dispose();
		        		                	deleteSoftveriFrame.dispose();
		        		                }
		        		            });
		        			
		        			deleteSoftveriFinalFrame.pack();
		        			deleteSoftveriFinalFrame.setModal(true);
		        			deleteSoftveriFinalFrame.setVisible(true);
		                }
		            });
			
			deleteSoftveriFrame.pack();
			deleteSoftveriFrame.setModal(true);
			deleteSoftveriFrame.setVisible(true);
		}
	}
	
	private void updateSoftveri() {
		
		podaciSoftveri = null;
		
		podaciSoftveri = new Object[softveri.size()][5];
		
		for (int i = 0; i < softveri.size(); i++) {
			
			String[] podaci = {
					softveri.get(i).getNaziv(),
					softveri.get(i).getCetkiceToString(),
					softveri.get(i).getFajlFormat(),
					softveri.get(i).getAlatiZaAnimacijuToString(),
					softveri.get(i).getRenderToString(),
					};
			podaciSoftveri[i] = podaci;
		}
		
		table_2.setModel(new DefaultTableModel(podaciSoftveri, podaciTabelaSoftveri));
		
	}

	private void initializeData() {
		
		//Ubacivanje pocetnih objekata u aplikaciju
		cetkice.add(new Cetkica("Standard", "Standardna visenamenska cetkica", new Color(128, 128, 128)));
		cetkice.add(new Cetkica("Smooth", "Ublazavanje neravnina na povrsini", new Color(255, 0, 0)));
		cetkice.add(new Cetkica("Deform", "Deformacija povrsina", new Color(0, 255, 0)));
		cetkice.add(new Cetkica("Remove", "Udubljivanje povrsina", new Color(0, 0, 255)));
		
		
		alati.add(new Alati("Translate"));
		alati.add(new Alati("Scale"));
		alati.add(new Alati("Rotate"));
		alati.add(new Alati("Deform"));
		
		
		materijali.add(new Materijal("Drvo"));
		materijali.add(new Materijal("Metal"));
		materijali.add(new Materijal("Kamen"));
		materijali.add(new Materijal("Plastika"));
		
		
		kamere.add(new Kamera("Front"));
		kamere.add(new Kamera("Back"));
		kamere.add(new Kamera("Top"));
		kamere.add(new Kamera("Side"));
		
		
		objekti.add(new Objekat("Sekira"));
		objekti.add(new Objekat("Oklop"));
		objekti.add(new Objekat("Mac"));
		objekti.add(new Objekat("Sanduk"));
		
		
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
		
		
		softveri.add(new Softver(
				"Photoshop",
				new ArrayList<Cetkica>(Arrays.asList(cetkice.get(1), cetkice.get(3))),
				".PSD",
				new ArrayList<Alati>(Arrays.asList(alati.get(0), alati.get(1))),
				renderi.get(0)
				));
		softveri.add(new Softver(
				"Substance Painter",
				new ArrayList<Cetkica>(Arrays.asList(cetkice.get(0))),
				".SPP",
				new ArrayList<Alati>(Arrays.asList(alati.get(0))),
				renderi.get(2)
				));
		softveri.add(new Softver(
				"3ds Max",
				new ArrayList<Cetkica>(Arrays.asList(cetkice.get(0), cetkice.get(1), cetkice.get(2))),
				".MAX",
				new ArrayList<Alati>(Arrays.asList(alati.get(0), alati.get(1), alati.get(2), alati.get(3))),
				renderi.get(1)
				));
		
		
		
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
	}

}
