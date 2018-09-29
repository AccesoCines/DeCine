package vista;


import java.io.File;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Cines extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cines frame = new Cines();
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
	public Cines() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setForeground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	//	JButton botonAlta = new JButton(new ImageIcon("botALTA.png"));
	//	botonAlta.setBounds (0, 0, 0, 0);
	//	contentPane.add(botonAlta);
		
		/*Método mostrado por Gregg Bolinger en JavaRanch*/ImageIcon icon = new ImageIcon("..\\imagenes\\imagenesBOTONES\\botALTA.png");
		Image img = icon.getImage(); //convertimos icon en una imagen
		Image otraimg = img.getScaledInstance(200,100,java.awt.Image.SCALE_SMOOTH); //creamos una imagen nueva dándole las dimensiones que queramos a la antigua
		ImageIcon otroicon = new ImageIcon(otraimg);
		JButton botonAlta = new JButton(new ImageIcon("C:\\Users\\Susana\\Desktop\\DeCine\\Desarrollo\\src\\imagenes\\BOTONES\\botALTA.png"));
		botonAlta.setSelectedIcon(new ImageIcon("..\\imagenes\\imagenesBOTONES\\botALTA.png"));
		botonAlta.setContentAreaFilled(false);
		botonAlta.setBorderPainted(false);
		botonAlta.setContentAreaFilled(false);
		botonAlta.setBorderPainted(false);
		botonAlta.setBounds(new Rectangle(50,50,100,75));
		
		
		
		botonAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		botonAlta.setBounds(82, 21, 278, 125);
		contentPane.add(botonAlta);
		
		

		
		JComboBox comboBoxTodos = new JComboBox();
		comboBoxTodos.setModel(new DefaultComboBoxModel(new String[] {"Películas", "Empleados", "Salas"}));
		comboBoxTodos.setMaximumRowCount(100);
		comboBoxTodos.setBounds(0, 145, 424, 84);
		contentPane.add(comboBoxTodos);
		comboBoxTodos.addItem("Películas");
		comboBoxTodos.addItem("Empleados");
		comboBoxTodos.addItem("Salas");
		
	}
}
