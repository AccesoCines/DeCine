
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

public class VVerCartelera extends JFrame {

	private JPanel contentPane;
	private static VVerCartelera vCart;


	/**
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vCart  = new VVerCartelera();
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
		
	//	setBounds(0, 0, 800, 800);
		
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
		volver.setContentAreaFilled(false);;
		setBounds(100, 100, 800, 800);
		volver.setIcon(new ImageIcon(getClass().getResource("/imagenes/BOTONES/botVOLVER.png")));

		
		


		
		
		
		
		
		
		
		
	}
}
