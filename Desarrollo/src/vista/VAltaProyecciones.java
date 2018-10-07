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
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

import controlador.GestorBBDD;
import modelo.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.ScrollPane;
import java.awt.Scrollbar;

public class VAltaProyecciones extends JFrame {

	private JPanel contentPane;
	private static JComboBox cbPeliculas;
	private static JComboBox cbSalas;
	private ArrayList<JPanel> paneles = new ArrayList<>();
	private int x = 334;
	private int contadorPaneles = 5;
	private JButton btnGuardar;
	private static VAltaProyecciones  frame;
	private JSpinner.DateEditor de;
	private static ArrayList<Pelicula> peliculas;
	private static ArrayList<Sala> salas;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VAltaProyecciones();
					
					peliculas = new Pelicula().cargarPeliculas();
					String[] pelis = new String[peliculas.size()];
					int i = 0;
					for(Pelicula p :peliculas) {
						pelis[i] = p.getTitulo();
						i++;
					}
					DefaultComboBoxModel dfb = new DefaultComboBoxModel(pelis);
					cbPeliculas.setModel(dfb);
					if(peliculas!=null) cbPeliculas.setModel(dfb);
					
					salas = new Sala().cargarSalas();
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
		setTitle("Horarios proyección");
		setExtendedState(Frame.NORMAL);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBackground(new Color(233, 69, 75));
		contentPane.setBounds(new Rectangle(0, 0, 500, 500));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("| Horarios proyección");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(100, 50, 500, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblPelcula = new JLabel("Película");
		lblPelcula.setForeground(Color.WHITE);
		lblPelcula.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPelcula.setBounds(100, 135, 288, 31);
		contentPane.add(lblPelcula);
		
		JLabel lblSala = new JLabel("Sala");
		lblSala.setForeground(Color.WHITE);
		lblSala.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSala.setBounds(440, 135, 288, 31);
		contentPane.add(lblSala);
		
		cbPeliculas = new JComboBox();
		cbPeliculas.setModel(new DefaultComboBoxModel(new String[] {"Prueba", "Prueba2"}));
		cbPeliculas.setBorder(new LineBorder(Color.WHITE, 3, true));
		cbPeliculas.setForeground(Color.WHITE);
		cbPeliculas.setBackground(new Color(233, 69, 75));
		cbPeliculas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cbPeliculas.setBounds(100, 184, 225, 31);
		contentPane.add(cbPeliculas);
		
		cbSalas = new JComboBox();
		cbSalas.setModel(new DefaultComboBoxModel(new String[] {"Prueba", "Prueba2"}));
		cbSalas.setBorder(new LineBorder(Color.WHITE));
		cbSalas.setForeground(Color.WHITE);
		cbSalas.setBackground(new Color(233, 69, 75));
		cbSalas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cbSalas.setBounds(440, 184, 225, 31);
		contentPane.add(cbSalas);
		
		JButton btnAadirPase = new JButton("Añadir pase");
		btnAadirPase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contadorPaneles>0) {
					JPanel panel = new JPanel();
					panel.setOpaque(false);
					panel.setBounds(100, x, 564, 59);
					contentPane.add(panel);
					panel.setLayout(null);
					
					JLabel lblHora = new JLabel("\u00B7 Hora");
					lblHora.setBounds(10, 10, 93, 31);
					lblHora.setForeground(Color.WHITE);
					lblHora.setFont(new Font("Tahoma", Font.PLAIN, 25));
					panel.add(lblHora);
					
					JSpinner spinner = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.MINUTE));
					spinner.setFont(new Font("Tahoma", Font.PLAIN, 25));
					de = new JSpinner.DateEditor(spinner, "hh:mm a");
					de.getTextField().setEditable(false);
					spinner.setEditor(de);
					spinner.setBounds(113, 10, 159, 31);
					panel.add(spinner);
					
					contentPane.add(panel);
					paneles.add(panel);
					panel.repaint();
					x+=65;
					contadorPaneles--;
					if(x>540) btnGuardar.setBounds(100, x+30, 160, 31);
					panel.revalidate();
				}
			}
		});
		btnAadirPase.setBounds(100, 263, 160, 31);
		contentPane.add(btnAadirPase);

		
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pelicula peli = peliculas.get(cbPeliculas.getSelectedIndex());
				Sala sala = salas.get(cbSalas.getSelectedIndex());
				Time hora = new Time(new Date().getTime());
				ArrayList<java.sql.Time> horas = new ArrayList<>();
				for(JPanel jp :paneles) {
					Component[] components = jp.getComponents();
					for(Component comp:components) {
						if(comp instanceof JSpinner) {
							JSpinner spinner =(JSpinner) comp;
		                    Date d = (Date)spinner.getValue();						
			                hora = new Time(d.getTime());
						}
                    }
					peli.añadirProyeccion(new Proyeccion(sala,peli,hora,true));
				}
				boolean correcto = peli.guardarProyecciones();
				if(correcto) javax.swing.JOptionPane.showMessageDialog(null ,"Guardado correctamente!");
			}
		});
		btnGuardar.setBounds(100, 541, 160, 31);
		contentPane.add(btnGuardar);
		
		
	}
}
