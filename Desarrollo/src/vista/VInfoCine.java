package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

public class VInfoCine extends JFrame {

	private JPanel contentPane;
	private static VInfoCine frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VInfoCine frame = new VInfoCine();
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
	public VInfoCine() {
		
		setBounds(new Rectangle(0, 0, 800, 800));
		
		// Poner icono ventana
		setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());
		
		setExtendedState(Frame.NORMAL);
		
		//TODO ARRAY CON DATOS DEL CINE QUE SE CARGUE EN EL PANEL
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		getContentPane().setBackground(new Color(233, 69, 75));
		contentPane.setLayout(null);
		
		JLabel cine = new JLabel("Cine");
		cine.setForeground(Color.WHITE);
		cine.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cine.setBounds(169, 126, 127, 25);
		contentPane.add(cine);
		
		JLabel direccion = new JLabel("Direcci\u00F3n:");
		direccion.setForeground(Color.WHITE);
		direccion.setFont(new Font("Tahoma", Font.PLAIN, 25));
		direccion.setBounds(169, 249, 127, 25);
		contentPane.add(direccion);
		
		JLabel fechaFundacion = new JLabel("Fecha fundaci\u00F3n: ");
		fechaFundacion.setForeground(Color.WHITE);
		fechaFundacion.setFont(new Font("Tahoma", Font.PLAIN, 25));
		fechaFundacion.setBounds(169, 356, 199, 25);
		contentPane.add(fechaFundacion);
		
		JLabel telefono = new JLabel("Tel\u00E9fono: ");
		telefono.setForeground(Color.WHITE);
		telefono.setFont(new Font("Tahoma", Font.PLAIN, 25));
		telefono.setBounds(169, 443, 127, 25);
		contentPane.add(telefono);
		
		JLabel lblInformacinDel = new JLabel("| Informaci\u00F3n del cine");
		lblInformacinDel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblInformacinDel.setForeground(Color.WHITE);
		lblInformacinDel.setBounds(59, 45, 252, 38);
		contentPane.add(lblInformacinDel);
		
		JLabel txtCine = new JLabel("Cine");
		txtCine.setForeground(Color.WHITE);
		txtCine.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtCine.setBounds(280, 169, 127, 25);
		contentPane.add(txtCine);
		
		JLabel txtDireccion = new JLabel("Direcci\u00F3n:");
		txtDireccion.setForeground(Color.WHITE);
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtDireccion.setBounds(280, 287, 127, 25);
		contentPane.add(txtDireccion);
		
		JLabel txtFechFund = new JLabel("Fecha fundaci\u00F3n: ");
		txtFechFund.setForeground(Color.WHITE);
		txtFechFund.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtFechFund.setBounds(280, 405, 199, 25);
		contentPane.add(txtFechFund);
		
		JLabel txtTelefono = new JLabel("Tel\u00E9fono: ");
		txtTelefono.setForeground(Color.WHITE);
		txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtTelefono.setBounds(280, 485, 127, 25);
		contentPane.add(txtTelefono);
		
		JButton volver = new JButton("New button");
		volver.setContentAreaFilled(false);;
		volver.setBounds(50, 647, 155, 90);
		contentPane.add(volver);
		volver.setIcon(new ImageIcon(getClass().getResource("/imagenes/BOTONES/botVOLVER.png")));
		
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
			}
		});
		
		
		
		JLabel numSalas = new JLabel("N\u00FAmero de salas:");
		numSalas.setForeground(Color.WHITE);
		numSalas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		numSalas.setBounds(169, 533, 199, 25);
		contentPane.add(numSalas);
		
		JLabel txtNumSalas = new JLabel("N\u00FAmero de salas:");
		txtNumSalas.setForeground(Color.WHITE);
		txtNumSalas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtNumSalas.setBounds(280, 584, 199, 25);
		contentPane.add(txtNumSalas);
		
		setLocationRelativeTo(null);
		
		
	}
}
