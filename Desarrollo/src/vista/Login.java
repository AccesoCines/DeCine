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

	private VAltaPeliculas ap;
	
public Login() {
	contentPane = ap;
}
	private JPanel contentPane;
	
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				VAltaPeliculas ap = new VAltaPeliculas();
			
				
			}
		});
	}
		
}