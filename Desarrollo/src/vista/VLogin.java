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
import java.awt.Rectangle;


public class VLogin extends JFrame {

	private JPanel fondo;
	private JPasswordField passwordField;
	private JTextField JUsuario;
	private JButton btn;
	private JPasswordField jPassw;
	private JButton btnTrans;

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
		
		jPassw = new JPasswordField();
		jPassw.setFont(new Font("Tahoma", Font.PLAIN, 25));
		jPassw.setBounds(new Rectangle(0, 0, 0, 31));
		jPassw.setBounds(188, 135, 230, 31);
		getContentPane().add(jPassw);

		getContentPane().setBackground(new Color(233, 69, 75));
		getContentPane().setLayout(null);
	//	btnTrans.setContentAreaFilled(false);

		
		
		btn = new JButton("");
		btn.setBorderPainted(false);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				String Usuario = "administrador";
				String Contrasenya = "cines1510";
				String Pass = new String(jPassw.getPassword());
				if (JUsuario.getText().equals(Usuario) && Pass.equals(Contrasenya)) {
					VListado vl = new VListado();
					vl.setVisible(true);
				}else {
					if(!JUsuario.getText().equals(Usuario)) {
						JOptionPane.showMessageDialog(null, "Usuario incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
					}else if(!Pass.equals(Contrasenya)){
						JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
	//btn.setBackground(new Color(240, 240, 240));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btn.setIcon(new ImageIcon(getClass().getResource("../imagenes/BOTONES/entrarAdminis.png")));
		btn.setBounds(33, 199, 266, 67);
		btn.setContentAreaFilled(false);
		getContentPane().add(btn);
		
		
	
		btnTrans = new JButton("");
		btnTrans.setBorderPainted(false);
		btnTrans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				
				}
			}
		);
	//btn.setBackground(new Color(240, 240, 240));
		btnTrans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnTrans.setIcon(new ImageIcon(getClass().getResource("")));
		btnTrans.setBounds(448, 453, 646, 312);
		btnTrans.setContentAreaFilled(false);
		getContentPane().add(btnTrans);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


		JUsuario = new JTextField();
		JUsuario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		JUsuario.setBounds(new Rectangle(0, 0, 0, 31));
		JUsuario.setBounds(188, 79, 230, 31);
		getContentPane().add(JUsuario);
		JUsuario.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(new Rectangle(0, 0, 0, 31));
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUsuario.setBounds(26, 79, 152, 31);
		getContentPane().add(lblUsuario);

		JLabel lblContrasenya = new JLabel("Contrase\u00F1a:");
		lblContrasenya.setBounds(new Rectangle(0, 0, 0, 31));
		lblContrasenya.setForeground(Color.WHITE);
		lblContrasenya.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblContrasenya.setBounds(26, 135, 152, 31);
		getContentPane().add(lblContrasenya);

		JLabel imagen = new JLabel("");
		imagen.setBackground(new Color(233, 69, 75));
		imagen.setIcon(new ImageIcon(VLogin.class.getResource("/imagenes/CLAQUETAS/PantallaPrincipal.png")));
		imagen.setBounds(281, 79, 1921, 1011);
		getContentPane().add(imagen);

		// Poner icono ventana
		setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1591, 751);

	}
}
