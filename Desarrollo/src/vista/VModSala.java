package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JYearChooser;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VModSala extends JPanel {

	/**
	 * Create the panel.
	 */
	public VModSala() {
		setLayout(null);
		
		setBounds(0, 0, 800, 800);
		
		JLabel modificacionSalas = new JLabel("| Modificaci\u00F3n salas");
		modificacionSalas.setForeground(Color.WHITE);
		modificacionSalas.setFont(new Font("Tahoma", Font.BOLD, 25));
		modificacionSalas.setBounds(35, 29, 284, 36);
		add(modificacionSalas);
		
		JLabel numeroSala = new JLabel("N\u00FAmero Sala:");
		numeroSala.setForeground(Color.WHITE);
		numeroSala.setFont(new Font("Tahoma", Font.PLAIN, 25));
		numeroSala.setBounds(53, 218, 300, 31);
		add(numeroSala);
		
		JLabel aforo = new JLabel("Aforo:");
		aforo.setForeground(Color.WHITE);
		aforo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		aforo.setBounds(53, 276, 300, 31);
		add(aforo);
		
		JLabel dimPantalla = new JLabel("Dimensiones pantalla:");
		dimPantalla.setForeground(Color.WHITE);
		dimPantalla.setFont(new Font("Tahoma", Font.PLAIN, 25));
		dimPantalla.setBounds(53, 332, 300, 31);
		add(dimPantalla);
		
		JCheckBox discapacidad = new JCheckBox("Accesible discapacitados:");
		discapacidad.setForeground(Color.WHITE);
		discapacidad.setFont(new Font("Tahoma", Font.PLAIN, 25));
		discapacidad.setBounds(53, 382, 327, 31);
		add(discapacidad);
		
		JLabel anyoInag = new JLabel("A\u00F1o inauguraci\u00F3n:");
		anyoInag.setForeground(Color.WHITE);
		anyoInag.setFont(new Font("Tahoma", Font.PLAIN, 25));
		anyoInag.setBounds(53, 432, 300, 31);
		add(anyoInag);
		
		JLabel responsable = new JLabel("Responsable:");
		responsable.setForeground(Color.WHITE);
		responsable.setFont(new Font("Tahoma", Font.PLAIN, 25));
		responsable.setBounds(53, 482, 300, 31);
		add(responsable);
		
		JLabel cine = new JLabel("Cine");
		cine.setForeground(Color.WHITE);
		cine.setFont(new Font("Tahoma", Font.BOLD, 25));
		cine.setBounds(102, 115, 300, 31);
		add(cine);
		
		JComboBox txtResponsable = new JComboBox();
		txtResponsable.setBounds(397, 487, 300, 31);
		add(txtResponsable);
		
		JYearChooser txtAnyoInag = new JYearChooser();
		txtAnyoInag.setBounds(397, 441, 300, 31);
		add(txtAnyoInag);
		
		JComboBox txtDimPant = new JComboBox();
		txtDimPant.setBounds(397, 332, 300, 31);
		add(txtDimPant);
		
		JSpinner txtAforo = new JSpinner();
		txtAforo.setBounds(397, 276, 300, 31);
		add(txtAforo);
		
		JComboBox txtNumSala = new JComboBox();
		txtNumSala.setBounds(397, 218, 300, 31);
		add(txtNumSala);
		
		JButton ok = new JButton("");
		ok.setBounds(647, 50, 108, 88);
		ok.setIcon(new ImageIcon(VAltaSalas.class.getResource("/imagenes/BOTONES/botOK.png")));
		ok.setContentAreaFilled(false);
		add(ok);
		
		JButton cancelar = new JButton("");
		cancelar.setBounds(50, 699, 178, 88);
		cancelar.setIcon(new ImageIcon(VAltaSalas.class.getResource("/imagenes/BOTONES/botCANCELAR.png")));
		cancelar.setContentAreaFilled(false);
		add(cancelar);
		

	}
}
