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

public class VVerSala extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VVerSala frame = new VVerSala();
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
	public VVerSala() {
		
		// Poner icono ventana
		setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().setBackground(new Color(233, 69, 75));
		setContentPane(contentPane);
		getContentPane().setBackground(new Color(233, 69, 75));
		
		JLabel lblLSala = new JLabel("l Sala");
		lblLSala.setBounds(50, 70, 134, 31);
		lblLSala.setForeground(Color.WHITE);
		lblLSala.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblLSala);
		
		JLabel label = new JLabel("cine");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label.setBounds(120, 124, 145, 37);
		contentPane.add(label);
		
		setLocationRelativeTo(null);
	}

}
