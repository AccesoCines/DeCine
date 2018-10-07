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

public class VAltaSalas extends JPanel {

	/**
	 * Create the panel.
	 */

private JPanel contentPane;
private JTextField txtnumSala;
private JTextField txtaforo;
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
    	
	contentPane.setBackground(new Color(233, 69, 75));
	
	txtnumSala = new JTextField();
	txtnumSala.setBounds(184, 135, 205, 22);
	contentPane.add(txtnumSala);
	txtnumSala.setColumns(10);
	
	txtaforo = new JTextField();
	txtaforo.setBounds(184, 191, 204, 22);
	contentPane.add(txtaforo);
	txtaforo.setColumns(10);
	
	JComboBox txtresponsable = new JComboBox();
	txtresponsable.setBounds(184, 245, 205, 22);
	contentPane.add(txtresponsable);
	
	JButton cancelar = new JButton("");
	cancelar.setIcon(new ImageIcon(VAltaSalas.class.getResource("/imagenes/BOTONES/botCANCELAR.png")));
	cancelar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	cancelar.setBounds(37, 599, 157, 99);
	contentPane.add(cancelar);
	
	JButton ok = new JButton("");
	ok.setIcon(new ImageIcon(VAltaSalas.class.getResource("/imagenes/BOTONES/botOK.png")));
	ok.setBounds(641, 44, 104, 92);
	contentPane.add(ok);


	
	JLabel numSala = new JLabel("Nº Sala:");
	numSala.setForeground(new Color(255, 255, 255));
	numSala.setFont(new Font("Tahoma", Font.PLAIN, 25));
	numSala.setBounds(24, 126, 112, 31);
	contentPane.add(numSala);
	
	JLabel afo = new JLabel("Aforo:");
	afo.setForeground(Color.WHITE);
	afo.setFont(new Font("Tahoma", Font.PLAIN, 25));
	afo.setBounds(23, 182, 134, 31);
	contentPane.add(afo);
	
	JLabel discap = new JLabel("Discapacidad:");
	discap.setForeground(Color.WHITE);
	discap.setFont(new Font("Tahoma", Font.PLAIN, 25));
	discap.setBounds(24, 236, 112, 31);
	contentPane.add(discap);

	JLabel dimensiones = new JLabel("Dimensiones pantalla:");
	dimensiones.setForeground(Color.WHITE);
	dimensiones.setFont(new Font("Tahoma", Font.PLAIN, 25));
	dimensiones.setBounds(24, 292, 112, 31);
	contentPane.add(dimensiones);
	
	JLabel Inauguracion = new JLabel("Fecha inauguraci\u00F3n:");
	Inauguracion.setForeground(Color.WHITE);
	Inauguracion.setFont(new Font("Tahoma", Font.PLAIN, 25));
	Inauguracion.setBounds(24, 295, 225, 31);
	contentPane.add(Inauguracion);
	
	
	JLabel nacionalidad = new JLabel("Nacionalidad: ");
	nacionalidad.setForeground(Color.WHITE);
	nacionalidad.setFont(new Font("Tahoma", Font.PLAIN, 25));
	nacionalidad.setBounds(24, 398, 225, 31);
	contentPane.add(nacionalidad);
	
	JLabel fecFinCon = new JLabel("Fecha fin contrato: ");
	fecFinCon.setForeground(Color.WHITE);
	fecFinCon.setFont(new Font("Tahoma", Font.PLAIN, 25));
	fecFinCon.setBounds(24, 456, 225, 31);
	contentPane.add(fecFinCon);
	
	JLabel altaEmple = new JLabel("| Alta empleados");
	altaEmple.setFont(new Font("Tahoma", Font.BOLD, 25));
	altaEmple.setForeground(new Color(255, 255, 255));
	altaEmple.setBounds(24, 30, 225, 31);
	contentPane.add(altaEmple);
	
	//setLocationRelativeTo(null);

}
}
