package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.bcel.internal.classfile.Field;

import java.awt.Color;

public class Login extends JFrame {
	public Login() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
	}

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	

	
	public static void main(String[] args) {
		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				BufferedImage fotFondo = null;
				try {
					File f = new File("PantallaPrincipal.png");
					 fotFondo =  ImageIO.read(f);
			
				
			} catch (Exception e) {
				e.printStackTrace();
			}		
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setSize(400,300);
					JPanel p = new ParaFondos(fotFondo);
					frame.getContentPane().add(p);
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		});
	}
}
