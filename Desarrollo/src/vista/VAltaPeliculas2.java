package vista;

import javax.swing.JPanel;

import java.awt.EventQueue;

import javax.swing.JLabel;

public class VAltaPeliculas2 extends JPanel {
	
	/**
	 * Create the panel.
	 */
	public VAltaPeliculas2() {
		
		setLayout(null);
		
		setBounds(0, 0, 800, 800);	
		
		JLabel lblNewLabel = new JLabel("| Alta pel\u00EDculas");
		lblNewLabel.setBounds(20, 77, 83, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(24, 40, 45, 13);
		add(lblNewLabel_1);

	}

}
