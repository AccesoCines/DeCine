package vista;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import com.toedter.calendar.JYearChooser;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VAltaSalas extends JFrame {

	private JPanel contentPane;
	private String bbdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VAltaSalas frame = new VAltaSalas();
					frame.setVisible(true);
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
		
		// Poner icono ventana
		setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());
		
		setExtendedState(Frame.NORMAL);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(new Color(233, 69, 75));
		
		JLabel cine = new JLabel("Cine");
		cine.setForeground(Color.WHITE);
		cine.setFont(new Font("Tahoma", Font.BOLD, 25));
		cine.setBounds(100, 140, 300, 31);
		contentPane.add(cine);
		
		JLabel numSala = new JLabel("N\u00FAmero Sala:");
		numSala.setForeground(Color.WHITE);
		numSala.setFont(new Font("Tahoma", Font.PLAIN, 25));
		numSala.setBounds(50, 256, 300, 31);
		contentPane.add(numSala);
		
		JLabel aforo = new JLabel("Aforo:");
		aforo.setForeground(Color.WHITE);
		aforo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		aforo.setBounds(50, 306, 300, 31);
		contentPane.add(aforo);
		
		JLabel dimPantalla = new JLabel("Dimensiones pantalla:");
		dimPantalla.setForeground(Color.WHITE);
		dimPantalla.setFont(new Font("Tahoma", Font.PLAIN, 25));
		dimPantalla.setBounds(50, 356, 300, 31);
		contentPane.add(dimPantalla);
		
		JCheckBox accDiscapac = new JCheckBox(" Accesible discapacitados ");
		accDiscapac.setContentAreaFilled(false);
		accDiscapac.setForeground(Color.WHITE);
		accDiscapac.setFont(new Font("Tahoma", Font.PLAIN, 25));
		accDiscapac.setBounds(50, 406, 325, 31);
		contentPane.add(accDiscapac);
		
		JLabel anyoInag = new JLabel("A\u00F1o inauguraci\u00F3n:");
		anyoInag.setForeground(Color.WHITE);
		anyoInag.setFont(new Font("Tahoma", Font.PLAIN, 25));
		anyoInag.setBounds(50, 456, 300, 31);
		contentPane.add(anyoInag);
		
		JLabel responsable = new JLabel("Responsable:");
		responsable.setForeground(Color.WHITE);
		responsable.setFont(new Font("Tahoma", Font.PLAIN, 25));
		responsable.setBounds(50, 506, 300, 31);
		contentPane.add(responsable);
		
		JComboBox txtResponsable = new JComboBox();
		txtResponsable.setBounds(450, 506, 300, 31);
		contentPane.add(txtResponsable);
		


		JButton btnCancelar = new JButton("");
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBounds(50, 637, 181, 80);
		contentPane.add(btnCancelar);
		btnCancelar.setIcon(new ImageIcon(getClass().getResource("/imagenes/BOTONES/botCANCELAR.png")));
		
		JLabel altaSala = new JLabel("| Alta Sala");
		altaSala.setForeground(Color.WHITE);
		altaSala.setFont(new Font("Tahoma", Font.BOLD, 25));
		altaSala.setBounds(50, 40, 300, 31);
		contentPane.add(altaSala);
		
		JComboBox txtDimPantalla = new JComboBox();
		txtDimPantalla.setBounds(450, 356, 300, 31);
		txtDimPantalla.addItem("Extreme Digital Cinema");
		txtDimPantalla.addItem("Cinemascope");
		txtDimPantalla.addItem("IMAX");
		contentPane.add(txtDimPantalla);
		
		JYearChooser txtAnyoInag = new JYearChooser();
		txtAnyoInag.setBounds(450, 456, 300, 31);
		contentPane.add(txtAnyoInag);
		
		JSpinner txtNumSala = new JSpinner();
		txtNumSala.setBounds(450, 265, 300, 31);
		contentPane.add(txtNumSala);
		
		JSpinner txtAforo = new JSpinner();
		txtAforo.setBounds(450, 311, 300, 31);
		contentPane.add(txtAforo);
		
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean dis = accDiscapac.isSelected();
				int responsable = txtResponsable.getSelectedIndex();
				String pantalla = txtDimPantalla.getSelectedItem().toString();
				int numero = (int) txtNumSala.getValue();
				int anyo = txtAnyoInag.getValue();
			}
		});
		button.setContentAreaFilled(false);
		button.setBounds(659, 37, 91, 80);
		contentPane.add(button);
		button.setIcon(new ImageIcon(getClass().getResource("/imagenes/BOTONES/botOK.png")));
		
		setLocationRelativeTo(null);
	}

	public void setbbdd(String bbdd) {
		// TODO Auto-generated method stub
		this.bbdd = bbdd;
	}
}
