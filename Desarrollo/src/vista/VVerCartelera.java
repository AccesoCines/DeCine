
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
import javax.swing.JTable;

public class VVerCartelera extends JFrame {

	private JPanel contentPane;
	private static VVerCartelera vCart;
	private JTable table;

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
		
		table = new JTable();
		table.setBounds(121, 473, 455, -241);
		contentPane.add(table);

		setLocationRelativeTo(null);

	}
}
