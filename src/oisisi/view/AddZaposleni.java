package oisisi.view;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import oisisi.MainApp;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Color;

public class AddZaposleni extends JDialog {

	private JPanel contentPane;
	public static JTextField txtIme;
	public static JTextField txtIme_1;
	public static JTextField txtJmbg;
	public static JTextField txtEmail;
	public static JTextField txtUnesiteUlicu;
	public static JTextField txtUnesiteBroj;
	public static JTextField txtUnesiteGrad;
	public static JTextField txtDan;
	public static JTextField txtMesec;
	public static JTextField txtGodina;
	public static JList<String> list = new JList<String>();

	public AddZaposleni() {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		int startX = (int) ((screenSize.getWidth()-750)/2);
		int startY = (int) ((screenSize.getHeight()-400)/2);
		
		setBounds(startX, startY, 750, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{200, 500, 0};
		gbl_contentPane.rowHeights = new int[]{40, 40, 40, 40, 40, 40, 70, 40, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Unesite ime:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		txtIme_1 = new JTextField();
		txtIme_1.setSize(200, 50);
		GridBagConstraints gbc_txtIme_1 = new GridBagConstraints();
		gbc_txtIme_1.fill = GridBagConstraints.BOTH;
		gbc_txtIme_1.insets = new Insets(0, 0, 5, 0);
		gbc_txtIme_1.gridx = 1;
		gbc_txtIme_1.gridy = 0;
		contentPane.add(txtIme_1, gbc_txtIme_1);
		txtIme_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Unesite prezime:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtIme = new JTextField();
		GridBagConstraints gbc_txtIme = new GridBagConstraints();
		gbc_txtIme.fill = GridBagConstraints.BOTH;
		gbc_txtIme.insets = new Insets(0, 0, 5, 0);
		gbc_txtIme.gridx = 1;
		gbc_txtIme.gridy = 1;
		contentPane.add(txtIme, gbc_txtIme);
		txtIme.setColumns(1);
		
		JLabel lblNewLabel_2 = new JLabel("Unesite jmbg");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtJmbg = new JTextField();
		GridBagConstraints gbc_txtJmbg = new GridBagConstraints();
		gbc_txtJmbg.fill = GridBagConstraints.BOTH;
		gbc_txtJmbg.insets = new Insets(0, 0, 5, 0);
		gbc_txtJmbg.gridx = 1;
		gbc_txtJmbg.gridy = 2;
		contentPane.add(txtJmbg, gbc_txtJmbg);
		txtJmbg.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Unesite datum rodjenja:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		txtDan = new JTextField();
		txtDan.setForeground(Color.LIGHT_GRAY);
		txtDan.setText("Dan...");
		panel.add(txtDan);
		txtDan.setColumns(10);
		
		txtMesec = new JTextField();
		txtMesec.setForeground(Color.LIGHT_GRAY);
		txtMesec.setText("Mesec...");
		panel.add(txtMesec);
		txtMesec.setColumns(10);
		
		txtGodina = new JTextField();
		txtGodina.setForeground(Color.LIGHT_GRAY);
		txtGodina.setText("Godina...");
		panel.add(txtGodina);
		txtGodina.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Unesite email:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.fill = GridBagConstraints.BOTH;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 4;
		contentPane.add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Unesite adresu stanovanja(Ulica, Broj, Grad):");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 5;
		contentPane.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		
		txtUnesiteUlicu = new JTextField();
		txtUnesiteUlicu.setForeground(Color.LIGHT_GRAY);
		//txtUnesiteUlicu.setText("Ulica...");
		panel_1.add(txtUnesiteUlicu);
		txtUnesiteUlicu.setColumns(10);
		
		txtUnesiteBroj = new JTextField();
		txtUnesiteBroj.setForeground(Color.LIGHT_GRAY);
		//txtUnesiteBroj.setText("Broj...");
		panel_1.add(txtUnesiteBroj);
		txtUnesiteBroj.setColumns(10);
		
		txtUnesiteGrad = new JTextField();
		txtUnesiteGrad.setForeground(Color.LIGHT_GRAY);
		//txtUnesiteGrad.setText("Grad...");
		panel_1.add(txtUnesiteGrad);
		txtUnesiteGrad.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Unesite softvere:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		String[] listValues = new String[MainApp.softveri.size()];
		
		for(int i = 0; i < MainApp.softveri.size(); i++) {
			listValues[i] = MainApp.softveri.get(i).getNaziv();
		}
		
		list.setModel(new AbstractListModel() {
			
			public int getSize() {
				return listValues.length;
			}
			public Object getElementAt(int index) {
				return listValues[index];
			}
		});
		
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.insets = new Insets(0, 0, 5, 0);
		gbc_list.gridx = 1;
		gbc_list.gridy = 6;
		contentPane.add(list, gbc_list);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 7;
		contentPane.add(panel_2, gbc_panel_2);
	}

}
