package oisisi.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import oisisi.MainApp;
import java.awt.GridBagLayout;

public class DeleteSoftveriFinal extends JDialog {

	private JPanel contentPane;

	public DeleteSoftveriFinal(int selectedRowIndex) {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		int startX = (int) ((screenSize.getWidth()-750)/2);
		int startY = (int) ((screenSize.getHeight()-100)/2);
		
		setBounds(startX, startY, 750, 100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{100, 300, 0};
		gbl_contentPane.rowHeights = new int[]{40, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("UKOLIKO NASTAVITE, OVA AKCIJA SE NE MOZE OPOZVATI!");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
	}

}
