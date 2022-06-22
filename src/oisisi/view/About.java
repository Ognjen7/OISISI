package oisisi.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.TextArea;
import java.awt.Toolkit;

public class About extends JDialog {
	
	String about = "Vuksa Vasiljevic\r\n"
			+ "Imam 21 godinu, zavrsio sam opsti smer u gimnaziji \"Svetozar Markovic\" i trenutno sam na trecoj godini studija na Fakultetu Tehnickih Nauka u Novom Sadu.\r\n"
			+ "Igram kosarku, igrice i jugio\r\n\r\n"
			+ "Filip Zekic\r\n"
			+ "29.04.1997, rodno mesto: Novi Sad, mesto prebivalista: Prvomajska 18 Beška\r\n"
			+ "Zavrsio gimnaziju Isidora Sekulić, prirodno matematički smer\r\n"
			+ "Trenutno student treće godine studija Animacije u inzenjerstvu na Fakultetu tehnickih nauka u Novom Sadu.\r\n"
			+ "Pored fakulteta, bavim se stilizovanim modelovanjem karaktera za igrice, kolekcije i reklame i vlasnik sam studija za animaciju i modelovanje Sirius 3D\r\n"
			+ "U slobodno vreme sam se takmicarski bavio igranjem strategijske kartaske igrice hearthstone, ali trenutno je igram iz razonode, kao i druge igrice slicnog zanra.\r\n\r\n"
			+ "Ognjen Markovic\r\n"
			+ "Imam 22 godine I rodjen sam u Sapcu. 3. Sam godina Fakulteta Tehnickih nauka u Novom Sadu. Bavim se 3d modelovanjem vec 4 godine za strane kompanije.\r\n"
			+ "U slobodno vreme igram igrice, gledam filmove I serije I citam.";

	public About() {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		int width = (int) (screenSize.getWidth()*0.5);
		int height = (int) (screenSize.getHeight()*0.5);
		
		int startX = (int) (screenSize.getWidth()*0.5/2);
		int startY = (int) (screenSize.getHeight()*0.5/2);
		
		setBounds(startX, startY, width, height);
		getContentPane().setLayout(new BorderLayout());
		{
			TextArea textArea = new TextArea();
			textArea.setText(about);
			getContentPane().add(textArea, BorderLayout.CENTER);
		}
	}

}
