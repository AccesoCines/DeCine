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
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class VInfoCine extends JFrame {

	private JPanel contentPane;

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
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		getContentPane().setBackground(new Color(233, 69, 75));
		contentPane.setLayout(null);
		
		JButton btnVerSalas = new JButton("");
		btnVerSalas.setBounds(50, 225, 86, 86);
		contentPane.add(btnVerSalas);
		
		JButton btnListadoEmpleados = new JButton("");
		btnListadoEmpleados.setBounds(50, 64, 86, 86);
		contentPane.add(btnListadoEmpleados);
		
		JLabel lblCine = new JLabel("cine");
		lblCine.setForeground(Color.WHITE);
		lblCine.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCine.setBounds(208, 69, 127, 25);
		contentPane.add(lblCine);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setForeground(Color.WHITE);
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDireccin.setBounds(208, 134, 127, 25);
		contentPane.add(lblDireccin);
		
		JLabel lblFechaFundacin = new JLabel("Fecha fundaci\u00F3n: ");
		lblFechaFundacin.setForeground(Color.WHITE);
		lblFechaFundacin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblFechaFundacin.setBounds(208, 206, 199, 25);
		contentPane.add(lblFechaFundacin);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono: ");
		lblTelfono.setForeground(Color.WHITE);
		lblTelfono.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTelfono.setBounds(208, 276, 127, 25);
		contentPane.add(lblTelfono);
	}
}
