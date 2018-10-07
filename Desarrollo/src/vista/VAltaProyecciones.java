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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Calendar;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import com.toedter.components.JSpinField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VAltaProyecciones extends JFrame {

	private JPanel contentPane;
	private static JComboBox cbPeliculas;
	private static JComboBox cbSalas;
	private ArrayList<JPanel> paneles = new ArrayList<>();
	private int x = 350;
	private int contadorPaneles = 5;
	private JButton btnGuardar;
	private static VAltaProyecciones  frame;
	private JSpinner.DateEditor de;
	private static ArrayList<Pelicula> peliculas;
	private static ArrayList<Sala> salas;
	private Time hora = new Time(new Date().getTime());
	
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
		
		JLabel lblNewLabel = new JLabel("| Horarios proyecci\u00F3n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(100, 50, 500, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblPelcula = new JLabel("Pel\u00EDcula");
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
		
		JButton btnAadirPase = new JButton("");
		btnAadirPase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGuardar.setEnabled(true);
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
					de = new JSpinner.DateEditor(spinner, "HH:mm");
					de.getTextField().setEditable(false);
					spinner.setEditor(de);
					spinner.setBounds(113, 10, 100, 31);
					panel.add(spinner);
					
					contentPane.add(panel);
					paneles.add(panel);
					panel.repaint();
					x+=65;
					contadorPaneles--;
					panel.revalidate();
				}
			}
		});
		btnAadirPase.setBounds(100, 263,130, 80);
		btnAadirPase.setIcon(new ImageIcon(getClass().getResource("../imagenes/BOTONES/botPASE.png")));
		btnAadirPase.setContentAreaFilled(false);
		contentPane.add(btnAadirPase);

		/*JButton btnQuitarPase = new JButton("");
		btnQuitarPase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGuardar.setEnabled(true);
				if(contadorPaneles == 0) {
					btnGuardar.setEnabled(false);
				}
			if(contadorPaneles>0) {
					paneles.remove(paneles.size()-1);
					contentPane.repaint();
					contentPane.revalidate();
					
					
					for(int i=0;i<paneles.size();i++) {
						remove(i);
						paneles.remove(i);
						contadorPaneles++;
						contentPane.revalidate();
					}
				}
			}
		});
		btnQuitarPase.setBounds(535, 263,130, 80);
		btnQuitarPase.setIcon(new ImageIcon(getClass().getResource("../imagenes/BOTONES/botPASE.png")));
		btnQuitarPase.setContentAreaFilled(false);
		contentPane.add(btnQuitarPase);*/

		
		
		btnGuardar = new JButton("");
		btnGuardar.setEnabled(false);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pelicula peli = peliculas.get(cbPeliculas.getSelectedIndex());
				Sala sala = salas.get(cbSalas.getSelectedIndex());
				
				ArrayList<java.sql.Time> horas = new ArrayList<>();
				LinkedHashSet<Time> horasSet = new LinkedHashSet<>();
				for(JPanel jp :paneles) {
					Component[] components = jp.getComponents();
					for(Component comp:components) {
						if(comp instanceof JSpinner) {
		                    try {
		                    	JSpinner spinner =(JSpinner) comp;
			                    Date d = (Date)spinner.getValue();		
			                    DateFormat df = new SimpleDateFormat("HH:mm");
			                    String fecha = df.format(d);
								Date date = new SimpleDateFormat("HH:mm").parse(fecha);
								hora = new Time(date.getTime());
								
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
			                
						}
                    }
					
					peli.añadirProyeccion(new Proyeccion(sala,peli,hora,true));
					horas.add(hora);
				}
				int n=-1;
				
				horasSet.addAll(horas);
				if(horasSet.size() != horas.size()) {
					javax.swing.JOptionPane.showMessageDialog(null ,"No puedes repetir pases","Error", JOptionPane.WARNING_MESSAGE);
				}else {
					boolean correcto = peli.guardarProyecciones();
					if(correcto) javax.swing.JOptionPane.showMessageDialog(null ,"Guardado correctamente!","OK",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnGuardar.setIcon(new ImageIcon(getClass().getResource("../imagenes/BOTONES/botOK.png")));
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setBounds(659, 50, 91, 80);
		contentPane.add(btnGuardar);
		
		JButton cancelar = new JButton("");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VListado vl = new VListado();
				dispose();	//TODO cerrar ventana
				
			}
		});
		cancelar.setBounds(50,670,181,80);
		cancelar.setIcon(new ImageIcon(VAltaSalas.class.getResource("/imagenes/BOTONES/botCANCELAR.png")));
		cancelar.setContentAreaFilled(false);
		getContentPane().add(cancelar);
		
		
		
		
	}
}
