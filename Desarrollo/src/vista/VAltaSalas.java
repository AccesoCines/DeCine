package vista;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.Rectangle;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JCheckBox;
import com.toedter.calendar.JYearChooser;
import javax.swing.JSpinner;

public class VAltaSalas extends JPanel {
	private JTextField txtDiscapacidad;
	private JTextField txtDimPantalla;
	private JTextField txtAnoInaug;
	private JTextField txtResponsable;


	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VAltaSalas panel = new VAltaSalas();
					panel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public VAltaSalas() {
		setBounds(new Rectangle(0, 0, 800, 800));
		setLayout(null);
		
		JLabel cine = new JLabel("Cine");
		cine.setBounds(100, 150, 300, 31);
		add(cine);
		cine.setForeground(Color.WHITE);
		cine.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel numSala = new JLabel("N\u00FAmero Sala:");
		numSala.setBounds(50, 266, 300, 31);
		add(numSala);
		numSala.setForeground(new Color(255, 255, 255));
		numSala.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel aforo = new JLabel("Aforo:");
		aforo.setBounds(50, 316, 300, 31);
		add(aforo);
		aforo.setForeground(Color.WHITE);
		aforo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel dimPant = new JLabel("Dimensiones pantalla:");
		dimPant.setBounds(50, 366, 300, 31);
		add(dimPant);
		dimPant.setForeground(Color.WHITE);
		dimPant.setFont(new Font("Tahoma", Font.PLAIN, 25));	
		
		JCheckBox discapacitados = new JCheckBox("Accesible discapacitados: ");
		discapacitados.setBounds(50, 416, 325, 31);
		discapacitados.setForeground(Color.WHITE);
		discapacitados.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(discapacitados);
		
		JLabel anyoInaguracion = new JLabel("A\u00F1o inauguraci\u00F3n:");
		anyoInaguracion.setBounds(50, 466, 300, 31);
		add(anyoInaguracion);
		anyoInaguracion.setForeground(Color.WHITE);
		anyoInaguracion.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel responsable = new JLabel("Responsable:");
		responsable.setBounds(50, 516, 300, 31);
		add(responsable);
		responsable.setForeground(Color.WHITE);
		responsable.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		
		
		JComboBox txtResponsable_1 = new JComboBox();
		txtResponsable_1.setBounds(450, 516, 300, 31);
		add(txtResponsable_1);
		
		JButton ok = new JButton("");
		ok.setIcon(new ImageIcon(VAltaSalas.class.getResource("/imagenes/BOTONES/botOK.png")));
		ok.setBounds(659, 50, 91, 80);
		ok.setContentAreaFilled(false);
		add(ok);
		
		JButton cancelar = new JButton("");
		cancelar.setBounds(50,670,181,80);
		cancelar.setIcon(new ImageIcon(VAltaSalas.class.getResource("/imagenes/BOTONES/botCANCELAR.png")));
		cancelar.setContentAreaFilled(false);
		add(cancelar);
		
		JLabel label = new JLabel("| Alta Sala");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(50, 50, 300, 31);
		add(label);
		
		JComboBox txtDimensiones = new JComboBox();
		txtDimensiones.setBounds(450, 366, 300, 31);
		add(txtDimensiones);
		
		JYearChooser txtAnyoInagu = new JYearChooser();
		txtAnyoInagu.setBounds(450, 466, 300, 31);
		add(txtAnyoInagu);
		
		JSpinner txtNumSala = new JSpinner();
		txtNumSala.setBounds(450, 275, 300, 31);
		add(txtNumSala);
		
		JSpinner txtAforo = new JSpinner();
		txtAforo.setBounds(450, 321, 300, 31);
		add(txtAforo);
		
	
	}
}
