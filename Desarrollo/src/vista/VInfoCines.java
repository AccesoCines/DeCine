package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class VInfoCines extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VInfoCines frame = new VInfoCines();
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
	public VInfoCines() {
setBounds(new Rectangle(0, 0, 800, 800));
		
		// Poner icono ventana
		setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());
		
		setExtendedState(Frame.NORMAL);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(new Rectangle(0, 0, 800, 800));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		getContentPane().setBackground(new Color(233, 69, 75));
		contentPane.setLayout(null);
		
		JButton cancelar = new JButton("");
		cancelar.setBorderPainted(false);
		cancelar.setIcon(new ImageIcon(getClass().getResource("/imagenes/BOTONES/botCANCELAR.png")));
		cancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				vista.VInfoCines.this.dispose();
				}
		});
		cancelar.setBounds(71, 593, 244, 107);
		contentPane.add(cancelar);
		cancelar.setContentAreaFilled(false);
		
		
		JButton volver = new JButton("");
		volver.setBorderPainted(false);
		volver.setIcon(new ImageIcon(getClass().getResource("/imagenes/BOTONES/botVOLVER.png")));
		volver.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				VCines vcines = new VCines();
				vcines.setVisible(true);
				VInfoCines.this.dispose();
				}
		});
		volver.setBounds(485, 593, 244, 107);
		contentPane.add(volver);
		volver.setContentAreaFilled(false);
		
		JLabel label = new JLabel("");
		label.setBounds(71, 71, 69, 20);
		contentPane.add(label);
		

		
	}
}
