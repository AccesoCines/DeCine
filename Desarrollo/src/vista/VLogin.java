package vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VLogin extends JFrame {

	private JPanel fondo;
	private JPasswordField passwordField;
	private JPasswordField JPassword;
	private JTextField JUsuario;
	private JButton btn;

	public static void main(String[] args) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new VLogin().setVisible(true);

			}

		});
	}
	
	public VLogin() {

		setTitle("ACCESO");
		setExtendedState(Frame.MAXIMIZED_BOTH);

		btn = new JButton("");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				String Usuario = "administrador";
				String Contrasenya = "cines1510";

				String Pass = new String(JPassword.getPassword());

				if (JUsuario.getText().equals(Usuario) && Pass.equals(Contrasenya)) {

					VListado vl = new VListado();
					vl.setVisible(true);

					dispose();

				}

			}
		});

		btn.setVerticalAlignment(SwingConstants.TOP);
		btn.setBackground(new Color(240, 240, 240));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		btn.setIcon(new ImageIcon(getClass().getResource("../imagenes/BOTONES/botENTRAR.png")));
		btn.setBounds(0, 365, 189, 113);
		btn.setContentAreaFilled(false);

		getContentPane().add(btn);

		getContentPane().setBackground(new Color(233, 69, 75));
		getContentPane().setLayout(null);

		JPassword = new JPasswordField();
		JPassword.setBounds(157, 113, 230, 22);
		getContentPane().add(JPassword);

		JPassword.setBounds(157, 113, 230, 22);
		getContentPane().add(JPassword);

		JUsuario = new JTextField();
		JUsuario.setBounds(155, 78, 230, 22);
		getContentPane().add(JUsuario);
		JUsuario.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(26, 79, 74, 19);
		getContentPane().add(lblUsuario);

		JLabel lblContrasenya = new JLabel("Contrase\u00F1a:");
		lblContrasenya.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContrasenya.setBounds(26, 115, 88, 16);
		getContentPane().add(lblContrasenya);

		JLabel imagen = new JLabel("");
		imagen.setBackground(new Color(233, 69, 75));
		imagen.setIcon(new ImageIcon(VLogin.class.getResource("/imagenes/CLAQUETAS/PantallaPrincipal.png")));
		imagen.setBounds(0, 0, 1921, 1011);
		getContentPane().add(imagen);

		// Poner icono ventana
		setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1591, 751);

	}
}
