package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Frame;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

import modelo.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import com.toedter.components.JSpinField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VAltaProyecciones extends JFrame {

	private JPanel contentPane;
	private static JComboBox cbPeliculas;
	private static JComboBox cbSalas;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VAltaProyecciones frame = new VAltaProyecciones();
					
					ArrayList<Pelicula> peliculas = new Pelicula().cargarPeliculas();
					String[] pelis = new String[peliculas.size()];
					int i = 0;
					for(Pelicula p :peliculas) {
						pelis[i] = p.getTitulo();
						i++;
					}
					DefaultComboBoxModel dfb = new DefaultComboBoxModel(pelis);
					cbPeliculas.setModel(dfb);
					if(peliculas!=null) cbPeliculas.setModel(dfb);
					
					ArrayList<Sala> salas = new Sala().cargarSalas();
					Integer[] salasAr = new Integer[salas.size()];
					int j = 0;
					for(Sala s : salas) {
						salasAr[j] = s.getNumero();
						j++;
					}
					dfb = new DefaultComboBoxModel(salasAr);
					if(salasAr!=null) cbSalas.setModel(dfb);
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
	public VAltaProyecciones() {
		setTitle("Horarios proyecci\u00F3n");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(233, 69, 75));
		contentPane.setBounds(new Rectangle(0, 0, 1000, 1000));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("| Horarios proyecci\u00F3n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(100, 50, 500, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblPelcula = new JLabel("Pel\u00EDcula");
		lblPelcula.setForeground(Color.WHITE);
		lblPelcula.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPelcula.setBounds(100, 169, 288, 31);
		contentPane.add(lblPelcula);
		
		JLabel lblSala = new JLabel("Sala");
		lblSala.setForeground(Color.WHITE);
		lblSala.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSala.setBounds(532, 161, 288, 31);
		contentPane.add(lblSala);
		
		cbPeliculas = new JComboBox();
		//cbPeliculas.setModel(new DefaultComboBoxModel(new String[] {"Prueba", "Prueba2"}));
		cbPeliculas.setBorder(new LineBorder(Color.WHITE, 3, true));
		cbPeliculas.setForeground(Color.WHITE);
		cbPeliculas.setBackground(new Color(233, 69, 75));
		cbPeliculas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cbPeliculas.setBounds(100, 243, 224, 31);
		contentPane.add(cbPeliculas);
		
		cbSalas = new JComboBox();
		//cbSalas.setModel(new DefaultComboBoxModel(new String[] {"Prueba", "Prueba2"}));
		cbSalas.setBorder(new LineBorder(Color.WHITE));
		cbSalas.setForeground(Color.WHITE);
		cbSalas.setBackground(new Color(233, 69, 75));
		cbSalas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cbSalas.setBounds(532, 243, 224, 31);
		contentPane.add(cbSalas);
		
		JButton btnAadirHoras = new JButton("A\u00F1adir horas");
		btnAadirHoras.setBounds(100, 325, 132, 23);
		contentPane.add(btnAadirHoras);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(100, 400, 656, 55);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSesin = new JLabel("Sesi\u00F3n");
		lblSesin.setBounds(0, 11, 72, 31);
		lblSesin.setForeground(Color.WHITE);
		lblSesin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(lblSesin);
		
		
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//java.sql.Time hora = spinField.g
				
			}
		});
		btnGuardar.setBounds(94, 840, 89, 23);
		contentPane.add(btnGuardar);
		
		
	}
}
