package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VLogin extends JFrame {
 

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	public VLogin() {
		getContentPane().setBackground(new Color(255, 99, 71));
		getContentPane().setLayout(null);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(157, 113, 116, 22);
		getContentPane().add(passwordField_1);
		
		textField = new JTextField();
		textField.setBounds(157, 78, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDecine = new JLabel("DeCine");
		lblDecine.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDecine.setBounds(341, 13, 124, 16);
		getContentPane().add(lblDecine);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(71, 80, 74, 19);
		getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(71, 116, 74, 16);
		getContentPane().add(lblContrasea);
		
		JButton btnNewButton = new JButton("DeCine");
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setIcon(new ImageIcon("D:\\Desktop\\cine\\DeCine\\Desarrollo\\src\\imagenes\\BOTONES\\botENTRAR.png"));
		btnNewButton.setBounds(12, 195, 768, 250);
		btnNewButton.setContentAreaFilled(false);
		
		getContentPane().add(btnNewButton);

		
		// Poner icono ventana
	    setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 979, 505);
	
		
			}
}
