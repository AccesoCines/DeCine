package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class VModSala extends JPanel {

	/**
	 * Create the panel.
	 */
	public VModSala() {
		setLayout(null);
		
		setBounds(0, 0, 800, 800);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(35, 29, 56, 16);
		add(lblNewLabel);
		

	}

}
