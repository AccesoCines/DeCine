package vista;

import javax.swing.JPanel;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
		
		JButton cancelar = new JButton("");
		cancelar.setIcon(new ImageIcon(VAltaEmpl.class.getResource("/imagenes/BOTONES/botCANCELAR.png")));
		cancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//TOODO FALTA PROBAR CUANDO ESTÉ LA VENTANA DE LISTADOS
				((java.awt.Window) getParent()).dispose();
				VListado list = new VListado();
				list.setVisible(true);
				}
		});
		cancelar.setBounds(37, 599, 244, 107);
		contentPane.add(cancelar);
		cancelar.setContentAreaFilled(false);

	}

}
