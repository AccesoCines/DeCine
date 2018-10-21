
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class VVerCartelera extends JFrame {

	private JPanel contentPane;
	private static VVerCartelera vCart;

	/**
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vCart = new VVerCartelera();
					vCart.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VVerCartelera() {

		// Poner icono ventana
		setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());

		// setBounds(0, 0, 800, 800);

		setExtendedState(Frame.NORMAL);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();

		contentPane.setBackground(new Color(233, 69, 75));
		contentPane.setForeground(new Color(233, 69, 75));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton volver = new JButton("New button");
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VCines cines = new VCines();
				cines.setVisible(true);

				VVerCartelera.this.dispose();

			}
		});
		volver.setBounds(68, 553, 158, 89);
		contentPane.add(volver);
		volver.setContentAreaFilled(false);
		;
		setBounds(100, 100, 800, 800);
		volver.setIcon(new ImageIcon(getClass().getResource("/imagenes/BOTONES/botVOLVER.png")));

		JLabel lblLCartelera = new JLabel("l Cartelera");
		lblLCartelera.setForeground(Color.WHITE);
		lblLCartelera.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblLCartelera.setBounds(50, 70, 169, 31);
		contentPane.add(lblLCartelera);

		JLabel label = new JLabel("cine");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label.setBounds(121, 140, 45, 31);
		contentPane.add(label);

		JLabel lblTtulo = new JLabel("T\u00EDtulo 1");
		lblTtulo.setForeground(Color.WHITE);
		lblTtulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTtulo.setBounds(68, 230, 273, 31);
		contentPane.add(lblTtulo);

		JLabel lblTtulo_1 = new JLabel("T\u00EDtulo 2");
		lblTtulo_1.setForeground(Color.WHITE);
		lblTtulo_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTtulo_1.setBounds(68, 278, 273, 31);
		contentPane.add(lblTtulo_1);

		JLabel lblTtulo_2 = new JLabel("T\u00EDtulo 3");
		lblTtulo_2.setForeground(Color.WHITE);
		lblTtulo_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTtulo_2.setBounds(68, 322, 273, 31);
		contentPane.add(lblTtulo_2);

		JLabel lblTtulo_3 = new JLabel("T\u00EDtulo 4");
		lblTtulo_3.setForeground(Color.WHITE);
		lblTtulo_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTtulo_3.setBounds(68, 366, 273, 31);
		contentPane.add(lblTtulo_3);

		JLabel lblTtulo_4 = new JLabel("T\u00EDtulo 5");
		lblTtulo_4.setForeground(Color.WHITE);
		lblTtulo_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTtulo_4.setBounds(68, 410, 273, 31);
		contentPane.add(lblTtulo_4);

		JLabel lblTtulo_5 = new JLabel("T\u00EDtulo 6");
		lblTtulo_5.setForeground(Color.WHITE);
		lblTtulo_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTtulo_5.setBounds(68, 450, 273, 31);
		contentPane.add(lblTtulo_5);

		JLabel lblTtulo_6 = new JLabel("T\u00EDtulo 7");
		lblTtulo_6.setForeground(Color.WHITE);
		lblTtulo_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTtulo_6.setBounds(408, 230, 273, 31);
		contentPane.add(lblTtulo_6);

		JLabel lblTtulo_7 = new JLabel("T\u00EDtulo 8");
		lblTtulo_7.setForeground(Color.WHITE);
		lblTtulo_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTtulo_7.setBounds(408, 278, 273, 31);
		contentPane.add(lblTtulo_7);

		JLabel lblTtulo_8 = new JLabel("T\u00EDtulo 9");
		lblTtulo_8.setForeground(Color.WHITE);
		lblTtulo_8.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTtulo_8.setBounds(408, 322, 273, 31);
		contentPane.add(lblTtulo_8);

		JLabel lblTtulo_9 = new JLabel("T\u00EDtulo 10");
		lblTtulo_9.setForeground(Color.WHITE);
		lblTtulo_9.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTtulo_9.setBounds(408, 366, 273, 31);
		contentPane.add(lblTtulo_9);

		JLabel lblTtulo_10 = new JLabel("T\u00EDtulo 11");
		lblTtulo_10.setForeground(Color.WHITE);
		lblTtulo_10.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTtulo_10.setBounds(408, 410, 273, 31);
		contentPane.add(lblTtulo_10);

		JLabel lblTtulo_11 = new JLabel("T\u00EDtulo 12");
		lblTtulo_11.setForeground(Color.WHITE);
		lblTtulo_11.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTtulo_11.setBounds(408, 450, 273, 31);
		contentPane.add(lblTtulo_11);

		setLocationRelativeTo(null);

	}
}
