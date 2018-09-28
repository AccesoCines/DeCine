package vista;


import java.io.File;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;

public class Login extends JFrame {
	
	public Login() {
		
		// Poner icono ventana
	    setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
	}

	private JPanel contentPane;
	
	public static void main(String[] args) {
		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				BufferedImage fotFondo = null;
				File f;
				try {
					f = new File(getClass().getResource("PantallaPrincipal.png").toURI());
					fotFondo =  ImageIO.read(f);
				
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
