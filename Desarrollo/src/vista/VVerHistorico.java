package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.GestorBBDD;
import modelo.*;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class VVerHistorico extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static DefaultTableModel model = new DefaultTableModel();
	private ArrayList<Empleado> empleados;
	private ArrayList<Sala> salas;
	private ArrayList<Pelicula> peliculas;
	private JLabel lblCine;
	
	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}

	public void setSalas(ArrayList<Sala> salas) {
		this.salas = salas;
	}

	public void setPeliculas(ArrayList<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VVerHistorico frame = new VVerHistorico();
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
	public VVerHistorico() {
		
		// Poner icono ventana
		setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());
				
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		getContentPane().setBackground(new Color(233, 69, 75));
		contentPane.setLayout(null);
		
		JLabel historico = new JLabel("l Hist\u00F3rico");
		historico.setForeground(Color.WHITE);
		historico.setFont(new Font("Tahoma", Font.PLAIN, 25));
		historico.setBounds(50, 70, 145, 37);
		contentPane.add(historico);
		
		
		lblCine = new JLabel("cine");
		lblCine.setForeground(Color.WHITE);
		lblCine.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCine.setBounds(120, 124, 145, 37);
		contentPane.add(lblCine);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 198, 673, 523);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Id", "Nombre"
					}
				));
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 673, 523);
		scrollPane.setViewportView(table);
		panel.add(scrollPane);
		
		
		setLocationRelativeTo(null);
	}
	
	public void ponerModel(String tipo) {
		switch(tipo) {
		case "empleado":
			table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Id", "Nombre", "Apellido", "Cargo", "Fecha Contrato",
						"Fecha Nacimiento","Nacionalidad","Fecha fin Contrato"
					}
				));
			model = (DefaultTableModel) table.getModel();
			for(Empleado emple:empleados) {
				model.addRow(new Object[]{emple.getId(),emple.getNombre(),emple.getApellido(),emple.getCargo().toString(),
						emple.getFechaContratacion().toString(),emple.getFechaNacimiento().toString(),emple.getNacionalidad(),
						emple.getFechaFinContrato().toString()});
				
			}
			break;
		case "sala":
			table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Id", "Número", "Aforo", "Ano inauguracion", "Pantalla", "Discapacidad",
						"Id responsable"
					}
				));
			model = (DefaultTableModel) table.getModel();
			for(Sala sala:salas) {
				model.addRow(new Object[]{sala.getId(),sala.getNumero(),sala.getAforo(),sala.getAnoInauguracion(),sala.getDimPantalla(),
						sala.isDiscapacidad(),sala.getResponsable().getNombre()});			
			}
			break;
		case "pelicula":
			table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Titulo", "Ano estreno", "Director", "Actor principal",
						"Actor secundario", "Duracion","Fecha inicio","Fecha fin"
					}
				));
			model = (DefaultTableModel) table.getModel();
			for(Pelicula peli:peliculas) {
				model.addRow(new Object[]{peli.getTitulo(),peli.getAnoEstreno(),peli.getDirector(),peli.getActorPrincipal(),
						peli.getActorSecundario(),peli.getDuracion(),peli.getFechaInicio().toString(),peli.getFechaFin().toString()});
				
			}
			break;
		}
	}

	public void setCine(String cine) {
		this.lblCine.setText(cine);
	}
}
