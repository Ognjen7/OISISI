package oisisi.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.AbstractListModel;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import oisisi.MainApp;
import oisisi.model.Softver;

public class EditSoftver extends JDialog {

	private JPanel contentPane;
	public static JTextField textField;
	public static JTextField textField_1;
	public static JList<String> list1 = new JList<String>();
	public static JList<String> list2 = new JList<String>();
	public static JList<String> list3 = new JList<String>();
	
	public static Softver softverEdit;
	
	public EditSoftver(int selectedRowIndex) {
		
		softverEdit = MainApp.softveri.get(selectedRowIndex);
		
		System.out.println(softverEdit.toString());

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		int startX = (int) ((screenSize.getWidth()-750)/2);
		int startY = (int) ((screenSize.getHeight()-400)/2);
		
		setBounds(startX, startY, 750, 400);
		//setBounds(0, 0, 750, 400);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{200, 500, 0};
		gbl_contentPane.rowHeights = new int[]{40, 80, 40, 80, 80, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Naziv");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		textField.setText(softverEdit.getNaziv());
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		contentPane.add(textField, gbc_textField);
		
		JLabel lblNewLabel_1 = new JLabel("Cetkice");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		GridBagConstraints gbc_list1 = new GridBagConstraints();
		gbc_list1.fill = GridBagConstraints.BOTH;
		gbc_list1.insets = new Insets(0, 0, 5, 0);
		gbc_list1.gridx = 1;
		gbc_list1.gridy = 1;
		contentPane.add(list1, gbc_list1);
		
		JLabel lblNewLabel_2 = new JLabel("Fajl format");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setText(softverEdit.getFajlFormat());
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		contentPane.add(textField_1, gbc_textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("Alati za animaciju");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		GridBagConstraints gbc_list2 = new GridBagConstraints();
		gbc_list2.fill = GridBagConstraints.BOTH;
		gbc_list2.insets = new Insets(0, 0, 5, 0);
		gbc_list2.gridx = 1;
		gbc_list2.gridy = 3;
		contentPane.add(list2, gbc_list2);
		
		JLabel lblNewLabel_4 = new JLabel("Render");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		GridBagConstraints gbc_list3 = new GridBagConstraints();
		gbc_list3.fill = GridBagConstraints.BOTH;
		gbc_list3.gridx = 1;
		gbc_list3.gridy = 4;
		list3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentPane.add(list3, gbc_list3);
		
		String[] list1Values = new String[MainApp.cetkice.size()];
		int[] list1SelectedValues = new int[softverEdit.getCetkice().size()];
		int list1SelectedValuesIndex = 0;
		
		for(int i = 0; i < MainApp.cetkice.size(); i++) {
			list1Values[i] = MainApp.cetkice.get(i).getNaziv();
			
			for(int j = 0; j < softverEdit.getCetkice().size(); j++) {
				if(MainApp.cetkice.get(i).getNaziv().equals(softverEdit.getCetkice().get(j).getNaziv())) {
					list1SelectedValues[list1SelectedValuesIndex] = i;
					list1SelectedValuesIndex++;
				}
			}
		}
		
		list1.setModel(new AbstractListModel() {
			public int getSize() {
				return list1Values.length;
			}
			public Object getElementAt(int index) {
				return list1Values[index];
			}
		});
		
		list1.setSelectedIndices(list1SelectedValues);
		
		String[] list2Values = new String[MainApp.alati.size()];
		int[] list2SelectedValues = new int[softverEdit.getAlatiZaAnimaciju().size()];
		int list2SelectedValuesIndex = 0;
		
		for(int i = 0; i < MainApp.alati.size(); i++) {
			list2Values[i] = MainApp.alati.get(i).getNaziv();
			
			for(int j = 0; j < softverEdit.getAlatiZaAnimaciju().size(); j++) {
				if(MainApp.alati.get(i).getNaziv().equals(softverEdit.getAlatiZaAnimaciju().get(j).getNaziv())) {
					list2SelectedValues[list2SelectedValuesIndex] = i;
					list2SelectedValuesIndex++;
				}
			}
		}
		
		list2.setModel(new AbstractListModel() {
			public int getSize() {
				return list2Values.length;
			}
			public Object getElementAt(int index) {
				return list2Values[index];
			}
		});
		
		list2.setSelectedIndices(list2SelectedValues);
		
		String[] list3Values = new String[MainApp.renderi.size()];
		int list3SelectedValue = 0;
		
		for(int i = 0; i < MainApp.renderi.size(); i++) {
			list3Values[i] = MainApp.renderi.get(i).getNaziv();
			
			if(MainApp.renderi.get(i).getNaziv().equals(softverEdit.getRender().getNaziv())) {
				list3SelectedValue = i;
			}
		}
		
		list3.setModel(new AbstractListModel() {
			public int getSize() {
				return list3Values.length;
			}
			public Object getElementAt(int index) {
				return list3Values[index];
			}
		});
		
		list3.setSelectedIndex(list3SelectedValue);
		
	}

}
