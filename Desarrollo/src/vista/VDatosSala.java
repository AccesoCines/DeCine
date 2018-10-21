package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class VDatosSala extends JFrame {

	private JPanel contentPane;
	private final JButton volver = new JButton("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VDatosSala frame = new VDatosSala();
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
	public VDatosSala() {
		
		// Poner icono ventana
		setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setBackground(new Color(233, 69, 75));
		contentPane.setLayout(null);
		
		JLabel lblDatosDe = new JLabel("| Datos de la sala");
		lblDatosDe.setForeground(Color.WHITE);
		lblDatosDe.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDatosDe.setBounds(51, 70, 330, 31);
		contentPane.add(lblDatosDe);
		
		JLabel lblCine = new JLabel("cine");
		lblCine.setForeground(Color.WHITE);
		lblCine.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblCine.setBounds(120, 140, 86, 31);
		contentPane.add(lblCine);
		
		JLabel lblNmero = new JLabel("N\u00FAmero: ");
		lblNmero.setForeground(Color.WHITE);
		lblNmero.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNmero.setBounds(70, 227, 136, 31);
		contentPane.add(lblNmero);
		
		JLabel lblAforo = new JLabel("Aforo:");
		lblAforo.setForeground(Color.WHITE);
		lblAforo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAforo.setBounds(70, 289, 136, 31);
		contentPane.add(lblAforo);
		
		JLabel lblDimensinPantalla = new JLabel("Dimensi\u00F3n pantalla: ");
		lblDimensinPantalla.setForeground(Color.WHITE);
		lblDimensinPantalla.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDimensinPantalla.setBounds(70, 355, 260, 31);
		contentPane.add(lblDimensinPantalla);
		
		JLabel lblAoInaguracin = new JLabel("A\u00F1o inauguraci\u00F3n: ");
		lblAoInaguracin.setForeground(Color.WHITE);
		lblAoInaguracin.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAoInaguracin.setBounds(70, 427, 260, 31);
		contentPane.add(lblAoInaguracin);
		
		JLabel lblDiscapacidad = new JLabel("Discapacidad");
		lblDiscapacidad.setForeground(Color.WHITE);
		lblDiscapacidad.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDiscapacidad.setBounds(103, 494, 260, 31);
		contentPane.add(lblDiscapacidad);
		
		JLabel lblResponsable = new JLabel("Responsable: ");
		lblResponsable.setForeground(Color.WHITE);
		lblResponsable.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblResponsable.setBounds(70, 569, 260, 31);
		contentPane.add(lblResponsable);
		
		JLabel lblsinDatos = new JLabel("(sin datos)");
		lblsinDatos.setForeground(Color.WHITE);
		lblsinDatos.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblsinDatos.setBounds(362, 227, 136, 31);
		contentPane.add(lblsinDatos);
		
		JLabel lblsinDatos_1 = new JLabel("(sin datos)");
		lblsinDatos_1.setForeground(Color.WHITE);
		lblsinDatos_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblsinDatos_1.setBounds(362, 289, 136, 31);
		contentPane.add(lblsinDatos_1);
		
		JLabel label = new JLabel("(sin datos)");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(362, 355, 136, 31);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("(sin datos)");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_1.setBounds(362, 427, 136, 31);
		contentPane.add(label_1);
		
		JCheckBox chckbxDiscapacidad = new JCheckBox("");
		chckbxDiscapacidad.setBounds(70, 494, 25, 25);
		contentPane.add(chckbxDiscapacidad);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(361, 577, 216, 25);
		contentPane.add(comboBox);
		
		volver.setContentAreaFilled(false);
		volver.setBounds(553, 101, 169, 80);
		contentPane.add(volver);
		volver.setIcon(new ImageIcon(getClass().getResource("/imagenes/BOTONES/botVOLVER.png")));
		
		setLocationRelativeTo(null);
	}
}
