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
import javax.swing.JTextPane;
import javax.swing.JTable;

public class VVerHistorico extends JFrame {

	private JPanel contentPane;
	private JTable tabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VVerHistorico frame = new VVerHistorico();
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
	public VVerHistorico() {
		
		// Poner icono ventana
				setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());
				
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		getContentPane().setBackground(new Color(233, 69, 75));
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel historico = new JLabel("l Hist\u00F3rico");
		historico.setForeground(Color.WHITE);
		historico.setFont(new Font("Tahoma", Font.PLAIN, 25));
		historico.setBounds(68, 63, 145, 37);
		contentPane.add(historico);
		
		tabla = new JTable();
		tabla.setBounds(598, 263, -484, 312);
		contentPane.add(tabla);
		
		setLocationRelativeTo(null);
	}
}
