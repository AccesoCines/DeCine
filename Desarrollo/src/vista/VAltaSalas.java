package vista;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.Rectangle;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.JCheckBox;

public class VAltaSalas extends JPanel {

	/**
	 * Create the panel.
	 */

private JTextField txtnumSala;
private JTextField txtaforo;
private JTextField txtDiscapacidad;
private JTextField txtDimPantalla;
private JTextField txtAnoInaug;
private JTextField txtResponsable;
private JTextField txtDim;
private JTextField txtInaug;



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
	
	JLabel lblCine = new JLabel("Cine");
	lblCine.setBounds(100, 150, 300, 31);
	add(lblCine);
	lblCine.setForeground(Color.WHITE);
	lblCine.setFont(new Font("Tahoma", Font.BOLD, 25));
	
	JLabel numSala = new JLabel("Nº Sala:");
	numSala.setBounds(50, 266, 300, 31);
	add(numSala);
	numSala.setForeground(new Color(255, 255, 255));
	numSala.setFont(new Font("Tahoma", Font.PLAIN, 25));
	
	JLabel afo = new JLabel("Aforo:");
	afo.setBounds(50, 316, 300, 31);
	add(afo);
	afo.setForeground(Color.WHITE);
	afo.setFont(new Font("Tahoma", Font.PLAIN, 25));
	
	JLabel dimensiones = new JLabel("Dimensiones pantalla:");
	dimensiones.setBounds(50, 366, 300, 31);
	add(dimensiones);
	dimensiones.setForeground(Color.WHITE);
	dimensiones.setFont(new Font("Tahoma", Font.PLAIN, 25));	
	
	JCheckBox discap = new JCheckBox("Discapacidad");
	discap.setBounds(50, 416, 300, 31);
	discap.setForeground(Color.WHITE);
	discap.setFont(new Font("Tahoma", Font.PLAIN, 25));
	add(discap);
	
	JLabel Inauguracion = new JLabel("A\u00F1o inauguraci\u00F3n:");
	Inauguracion.setBounds(50, 466, 300, 31);
	add(Inauguracion);
	Inauguracion.setForeground(Color.WHITE);
	Inauguracion.setFont(new Font("Tahoma", Font.PLAIN, 25));
	
	JLabel lblResponsable = new JLabel("Responsable:");
	lblResponsable.setBounds(50, 516, 300, 31);
	add(lblResponsable);
	lblResponsable.setForeground(Color.WHITE);
	lblResponsable.setFont(new Font("Tahoma", Font.PLAIN, 25));
	
	txtnumSala = new JTextField();
	add(txtnumSala);
	txtnumSala.setBounds(new Rectangle(450, 266, 300, 31));
	txtnumSala.setColumns(10);
	
	txtaforo = new JTextField();
	txtaforo.setBounds(450, 316, 300, 31);
	add(txtaforo);
	txtaforo.setColumns(10);
	
	txtDim = new JTextField();
	txtDim.setBounds(450, 366, 300, 31);
	add(txtDim);
	txtDim.setColumns(10);
	
	txtInaug = new JTextField();
	txtInaug.setBounds(450, 466, 300, 31);
	add(txtInaug);
	txtInaug.setColumns(10);
	
	
	
	JComboBox comboBox = new JComboBox();
	comboBox.setBounds(450, 516, 300, 31);
	add(comboBox);
	
	JButton ok = new JButton("");
	ok.setIcon(new ImageIcon(VAltaSalas.class.getResource("/imagenes/BOTONES/botOK.png")));
	ok.setBounds(659, 50, 91, 80);
	ok.setContentAreaFilled(false);
	add(ok);
	
	JButton cancelar = new JButton("");
	cancelar.setBounds(50,670,181,80);
	cancelar.setIcon(new ImageIcon(VAltaSalas.class.getResource("/imagenes/BOTONES/botCANCELAR.png")));
	ok.setContentAreaFilled(false);
	add(cancelar);
	
	JLabel label = new JLabel("| Alta Sala");
	label.setForeground(Color.WHITE);
	label.setFont(new Font("Tahoma", Font.BOLD, 25));
	label.setBounds(50, 50, 300, 31);
	add(label);
	

}
}
