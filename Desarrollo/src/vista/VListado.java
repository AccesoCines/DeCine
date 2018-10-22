package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controlador.DB4o;
import modelo.Empleado;
import modelo.Pelicula;
import modelo.Sala;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Cursor;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class VListado extends JFrame {

	private JPanel contentPane;

	private static DefaultTableModel model;
	private JFrame jframe = this;
	private static String bbdd;
	private VMetaDatos vmd = new VMetaDatos();
	private static VListado frame;
	private String cine;
	private ArrayList<Pelicula> peliculas = new ArrayList<>();
	private ArrayList<Empleado> empleados = new ArrayList<>();
	private ArrayList<Sala> salas = new ArrayList<>();
	private JComboBox<String> cbPeliculas;
	private JComboBox<String> cbEmpleados;
	private JComboBox<String> cbSalas;
	private int peliSeleccionada = 0;
	private int empleSeleccionado = 0;
	private int salaSeleccionada = 0;
	private boolean primeraVuelta = true;
	private boolean empleBool;
	private boolean peliBool;
	private boolean salaBool;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VListado();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}

		});

	}

	public VListado() {
		//Copiar para otras ventanas
		setBounds(new Rectangle(0, 0, 800, 800));
		setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());
		setExtendedState(Frame.NORMAL);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		getContentPane().setBackground(new Color(233, 69, 75));
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 800, 800));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(new Color(233, 69, 75));

		JButton alta = new JButton("");
		alta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		alta.setBorder(null); 
		alta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] opciones = { "Empleado", "Sala", "Pel\u00edcula" };
				int opcion = JOptionPane.showOptionDialog(frame, "Elige una opci\u00f3n", "Selecciona", JOptionPane.YES_NO_CANCEL_OPTION, 
						JOptionPane.PLAIN_MESSAGE, null, opciones, null);
				switch(opcion) {
					case 0:
						VAltaEmpleado valtae = new VAltaEmpleado();
						valtae.setBbdd(elegirBBDD(cine));
						valtae.setVisible(true);
						valtae.setBbdd(elegirBBDD(cine));
						//frame.dispose();
						break;
					case 1:
						VAltaSalas valtas = new VAltaSalas();
						valtas.cargarEmpleados(elegirBBDD(cine));
						valtas.setVisible(true);
						//frame.dispose();
						break;
					case 2:
						VAltaPelicula valtap = new VAltaPelicula();
						valtap.setVisible(true);
						valtap.setBbdd(elegirBBDD(cine));
						//frame.dispose();
						break;
				}
				
			}
		});
		alta.setIcon(new ImageIcon(VListado.class.getResource("../imagenes/BOTONES/botALTA.png")));
		alta.setBounds(51, 626, 100, 80);
		alta.setContentAreaFilled(false);
		contentPane.add(alta);

		JButton modificacion = new JButton("");
		modificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((cbEmpleados.getSelectedIndex()!=0 && cbPeliculas.getSelectedIndex()!=0)||
						(cbEmpleados.getSelectedIndex()!=0 && cbSalas.getSelectedIndex()!=0)||
						(cbPeliculas.getSelectedIndex()!=0 && cbSalas.getSelectedIndex()!=0)
					) {
					JOptionPane.showMessageDialog(getParent(), "S\u00f3lo puedes elegir un desplegable: "
							+ "\n Empleado o pel\u00edcula o sala.", "Error", JOptionPane.WARNING_MESSAGE);
				}else {
					if(cbEmpleados.getSelectedIndex()!=0) {
						VModificacionEmpleado.setBbdd(elegirBBDD(cine));
						VModificacionEmpleado vme = new VModificacionEmpleado();
						vme.setVisible(true);
						vme.setCine(cine);
						vme.setEmpleado(empleados.get(cbEmpleados.getSelectedIndex()-1));
						frame.dispose();
					}
					if(cbPeliculas.getSelectedIndex()!=0) {
						VModPelicula vmp = new VModPelicula();
						vmp.setVisible(true);
						vmp.setBbdd(elegirBBDD(cine));
						vmp.setCine(cine);
						vmp.setPelicula(peliculas.get(cbPeliculas.getSelectedIndex()-1));
						frame.dispose();
					}
					if(cbSalas.getSelectedIndex()!=0) {
						VModificacionSala vms = new VModificacionSala();
						vms.setVisible(true);
						vms.setBbdd(elegirBBDD(cine));
						vms.setCine(cine);
						vms.setResponsables(elegirBBDD(cine));
						vms.setSala(salas.get(cbSalas.getSelectedIndex()-1));
						frame.dispose();
					}
				}
			}
		});
		modificacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		modificacion.setBorder(null);
		modificacion.setBounds(460, 626,228, 80);
		modificacion.setIcon(new ImageIcon(getClass().getResource("../imagenes/BOTONES/botMODIFICAC.png")));
		modificacion.setContentAreaFilled(false);
		contentPane.add(modificacion);

		JButton baja = new JButton("");
		baja.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		baja.setBorder(null);
		baja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((cbEmpleados.getSelectedIndex()!=0 && cbPeliculas.getSelectedIndex()!=0)||
						(cbEmpleados.getSelectedIndex()!=0 && cbSalas.getSelectedIndex()!=0)||
						(cbPeliculas.getSelectedIndex()!=0 && cbSalas.getSelectedIndex()!=0)
					) {
					JOptionPane.showMessageDialog(getParent(), "S\u00f3lo puedes elegir un desplegable: "
							+ "\n Empleado o pel\u00edcula o sala.", "Error", JOptionPane.WARNING_MESSAGE);
				}else {
					if(cbEmpleados.getSelectedIndex()!=0) {
						int opcion = JOptionPane.showConfirmDialog(getParent(), "¿Quieres dar de baja este empleado?");
						Empleado emple = empleados.get(cbEmpleados.getSelectedIndex()-1);
						if(opcion==0) {
							boolean correcto = emple.bajaEmpleado(elegirBBDD(cine));
							if(correcto) {
								JOptionPane.showMessageDialog(getParent(), "¡Borrado correctamente!"
										, "Guardado", JOptionPane.PLAIN_MESSAGE);
							}else {
								JOptionPane.showMessageDialog(getParent(), "Error al borrar el empleado"
										, "Error", JOptionPane.WARNING_MESSAGE);
							}
						}
					}
					if(cbPeliculas.getSelectedIndex()!=0) {
						int opcion = JOptionPane.showConfirmDialog(getParent(), "¿Quieres dar de baja esta pelicula?");
						Pelicula peli = peliculas.get(cbPeliculas.getSelectedIndex()-1);
						if(opcion==0) {
							boolean correcto =peli.bajaPelicula(elegirBBDD(cine));
							if(correcto) {
								JOptionPane.showMessageDialog(getParent(), "Guardado correctamente!"
										, "Guardado", JOptionPane.PLAIN_MESSAGE);
							}else {
								JOptionPane.showMessageDialog(getParent(), "Error al borrar la pelicula"
										, "Error", JOptionPane.WARNING_MESSAGE);
							}
						}
					}
					if(cbSalas.getSelectedIndex()!=0) {
						int opcion = JOptionPane.showConfirmDialog(getParent(), "¿Quieres dar de baja esta sala?");
						Sala sala = salas.get(cbSalas.getSelectedIndex()-1);
						if(opcion==0) {
							boolean correcto =sala.bajaSala(elegirBBDD(cine));
							if(correcto) {
								JOptionPane.showMessageDialog(getParent(), "Guardado correctamente!"
										, "Guardado", JOptionPane.PLAIN_MESSAGE);
							}else {
								JOptionPane.showMessageDialog(getParent(), "Error al borrar la sala"
										, "Error", JOptionPane.WARNING_MESSAGE);
							}
						}
					}
				}
			}
		});
		baja.setBounds(257, 629,107, 80);
		baja.setIcon(new ImageIcon(getClass().getResource("../imagenes/BOTONES/botBAJA.png")));
		baja.setContentAreaFilled(false);
		contentPane.add(baja);

		JButton historico = new JButton("");
		historico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] opciones = { "Empleado", "Sala", "Pel\u00edcula" };
				int opcion = JOptionPane.showOptionDialog(frame, "Elige una opci\u00f3n", "Selecciona", JOptionPane.YES_NO_CANCEL_OPTION, 
						JOptionPane.PLAIN_MESSAGE, null, opciones, null);
				VVerHistorico vvh = new VVerHistorico();
				switch(opcion) {
					case 0:
						ArrayList<Empleado> empleados = Empleado.cargarEmpleadosBaja(elegirBBDD(cine));
						vvh.setEmpleados(empleados);
						vvh.setCine(cine);
						vvh.ponerModel("empleado");
						vvh.setVisible(true);
						frame.dispose();
						break;
					case 1:
						ArrayList<Sala> salas = Sala.cargarSalasBaja(elegirBBDD(cine));
						vvh.setSalas(salas);
						vvh.setCine(cine);
						vvh.ponerModel("sala");
						vvh.setVisible(true);
						frame.dispose();
						break;
					case 2:
						ArrayList<Pelicula> peliculas = new ArrayList<>();
						peliculas = Pelicula.cargarPeliculasBaja(elegirBBDD(cine));
						vvh.setPeliculas(peliculas);
						vvh.setCine(cine);
						vvh.ponerModel("pelicula");
						vvh.setVisible(true);
						frame.dispose();
						break;
					}
				
			}
		});
		historico.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		historico.setBorder(null);
		historico.setBounds(338, 132,174, 80);
		historico.setIcon(new ImageIcon(getClass().getResource("../imagenes/BOTONES/botHIST.png")));
		historico.setContentAreaFilled(false);
		contentPane.add(historico);
		
		JComboBox cbCines = new JComboBox();
		cbCines.setOpaque(false);
		cbCines.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					
					cine = e.getItem().toString();
					if(cine.equals("--Elige un cine--")) primeraVuelta=true;
					System.out.println(cine);
					//TODO se repiten
					cbPeliculas.removeAllItems();
					cbEmpleados.removeAllItems();
					cbSalas.removeAllItems();
					peliculas.clear();
					empleados.clear(); 
					salas.clear();
					
					peliculas = Pelicula.cargarPeliculas(elegirBBDD(cine));
					cbPeliculas.addItem("--Elige una pel\u00edcula--");
					for(Pelicula p:peliculas) {
						cbPeliculas.addItem(p.getTitulo());
					}
					cbPeliculas.setSelectedIndex(0);
					
					empleados = Empleado.cargarEmpleados(elegirBBDD(cine));
					cbEmpleados.addItem("--Elige un empleado--");
					for(Empleado emple:empleados) {
						cbEmpleados.addItem(emple.getNombre() + " " +emple.getApellido());
					}
					cbEmpleados.setSelectedIndex(0);
					
					salas = Sala.cargarSalas(elegirBBDD(cine));
					cbSalas.addItem("--Elige una sala--");
					for(Sala s:salas) {
						cbSalas.addItem(String.valueOf(s.getNumero()));
					}
					cbSalas.setSelectedIndex(0);
					primeraVuelta=false;
				}catch(Exception ex) {
					System.out.println(ex);
				}
				
			}
		});
		cbCines.setModel(new DefaultComboBoxModel(new String[] {"--Elige un cine--", "Principe", "Zubiarte 3D", "Azul"}));
		cbCines.setSize(350, 46); 
		cbCines.setLocation(343, 257);
		cbCines.setBorder(new LineBorder(Color.WHITE, 3, true));
		cbCines.setForeground(Color.WHITE);
		cbCines.setBackground(new Color(233, 69, 75));
		cbCines.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cbCines.setSelectedIndex(0);
		contentPane.add(cbCines);
		
		cbEmpleados = new JComboBox();
		cbEmpleados.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					empleSeleccionado = cbEmpleados.getSelectedIndex();
					empleBool = true;
				}catch(Exception exc) {
					System.out.println(exc);
				}
			}
		});
		cbEmpleados.setForeground(Color.WHITE);
		cbEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cbEmpleados.setBorder(new LineBorder(Color.WHITE, 3, true));
		cbEmpleados.setBackground(new Color(233, 69, 75));
		cbEmpleados.setBounds(343, 365, 350, 40);
		cbEmpleados.addItem("--Elige un empleado--");
		cbEmpleados.setSelectedIndex(0);
		contentPane.add(cbEmpleados);
		
		cbPeliculas = new JComboBox();
		cbPeliculas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					peliSeleccionada = cbPeliculas.getSelectedIndex();
					peliBool = true;
				}catch(Exception exc) {
					System.out.println(exc);
				}
			}
		});
		cbPeliculas.setForeground(Color.WHITE);
		cbPeliculas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cbPeliculas.setBorder(new LineBorder(Color.WHITE, 3, true));
		cbPeliculas.setBackground(new Color(233, 69, 75));
		cbPeliculas.setBounds(343, 458, 350, 40);
		cbPeliculas.addItem("--Elige una pelicula--");
		cbPeliculas.setSelectedIndex(0);
		contentPane.add(cbPeliculas);
		
		cbSalas = new JComboBox();
		cbSalas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					salaSeleccionada = cbSalas.getSelectedIndex();
					salaBool = true;
				}catch(Exception exc) {
					System.out.println(exc);
				}
			}
		});
		cbSalas.setForeground(Color.WHITE);
		cbSalas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cbSalas.setBorder(new LineBorder(Color.WHITE, 3, true));
		cbSalas.setBackground(new Color(233, 69, 75));
		cbSalas.setBounds(343, 550, 350, 40);
		cbSalas.addItem("--Elige una sala--");
		cbSalas.setSelectedIndex(0);
		contentPane.add(cbSalas);
		
		JButton btnInfo = new JButton("");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String cine = elegirBBDD(cbCines.getSelectedItem().toString());
					if(!cine.equals("--Elige un cine--")) {	
						vmd.setBbdd(elegirBBDD(cbCines.getSelectedItem().toString()));
						vmd.cargarFormulario();
						vmd.setVisible(true);
						jframe.dispose();
					}
				}catch(NullPointerException ex ) {
					JOptionPane.showMessageDialog(getParent(), "Debes elegir un cine en el desplegable", "Error", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnInfo.setBounds(551, 129, 100, 80);
		btnInfo.setIcon(new ImageIcon(getClass().getResource("../imagenes/BOTONES/Info.png")));
		btnInfo.setContentAreaFilled(false);
		contentPane.add(btnInfo);
		
		JLabel lblCine = new JLabel("Cine ");
		lblCine.setHorizontalAlignment(SwingConstants.LEFT);
		lblCine.setLabelFor(cbCines);
		lblCine.setForeground(Color.WHITE);
		lblCine.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCine.setBounds(133, 261, 126, 31);
		contentPane.add(lblCine);
		
		JLabel lblEmpleado = new JLabel("Empleado ");
		lblEmpleado.setLabelFor(cbEmpleados);
		lblEmpleado.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmpleado.setForeground(Color.WHITE);
		lblEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblEmpleado.setBounds(130, 368, 198, 31);
		contentPane.add(lblEmpleado);
		
		JLabel lblPelcula = new JLabel("Pel\u00EDcula ");
		lblPelcula.setHorizontalAlignment(SwingConstants.LEFT);
		lblPelcula.setLabelFor(cbPeliculas);
		lblPelcula.setForeground(Color.WHITE);
		lblPelcula.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPelcula.setBounds(133, 462, 126, 31);
		contentPane.add(lblPelcula);
		
		JLabel lblSala = new JLabel("Sala ");
		lblSala.setLabelFor(cbSalas);
		lblSala.setHorizontalAlignment(SwingConstants.LEFT);
		lblSala.setForeground(Color.WHITE);
		lblSala.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSala.setBounds(136, 563, 126, 31);
		contentPane.add(lblSala);
		
		JLabel label = new JLabel("");
		label.setBounds(66, 66, 56, 16);
		contentPane.add(label);
		
		JLabel lblGestinDe = new JLabel("| Gesti\u00F3n de cines");
		lblGestinDe.setHorizontalAlignment(SwingConstants.LEFT);
		lblGestinDe.setForeground(Color.WHITE);
		lblGestinDe.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblGestinDe.setBounds(36, 55, 592, 31);
		contentPane.add(lblGestinDe);
		
		JButton btProyecciones = new JButton("");
		btProyecciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String cine = cbCines.getSelectedItem().toString();
					if(!cine.equals("--Elige un cine--")) {	
						VAltaProyecciones vap = new VAltaProyecciones();
						vap.setBbdd(elegirBBDD(cine));
						vap.cargarDatos(elegirBBDD(cine));
						vap.setVisible(true);
						jframe.dispose();
					}
				}catch(NullPointerException ex ) {
					JOptionPane.showMessageDialog(getParent(), "Debes elegir un cine en el desplegable", "Error", JOptionPane.WARNING_MESSAGE);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btProyecciones.setIcon(new ImageIcon(getClass().getResource("../imagenes/BOTONES/proyecciones80alto.png")));
		btProyecciones.setContentAreaFilled(false);
		btProyecciones.setBorder(null);
		btProyecciones.setBounds(51, 132, 250, 80);
		contentPane.add(btProyecciones);

		setLocationRelativeTo(null);

	}
	private String elegirBBDD(String nombreBd) {
		switch (nombreBd) {
			case "Pr\u00edcipe":
			case "Prï¿½ncipe":
			case "Príncipe":
			case "Principe":
				return "sqlite";
			case "Zubiarte 3D":
				return "db4o";
			case "Azul":
				return "postgre";
			default:
				if(!primeraVuelta)
					JOptionPane.showMessageDialog(getParent(), "Debes elegir un cine en el desplegable", "Error", JOptionPane.ERROR_MESSAGE);
				return "";
		}
	}
}
