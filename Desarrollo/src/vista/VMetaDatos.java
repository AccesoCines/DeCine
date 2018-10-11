package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.DB4o;
import controlador.GestorBBDD;
import modelo.Columna;
import modelo.Empleado;
import modelo.MetaDato;
import modelo.Tabla;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VMetaDatos extends JFrame {

	private JPanel contentPane;
	private static DefaultTableModel model = new DefaultTableModel();
	private static JTable table;
	private static MetaDato metaDatos;
	private static JLabel txtNombre;
	private static JLabel txtDriver;
	private static JLabel txtUrl;
	private static JLabel txtUsuario;
	private static String bbdd;
	private static VMetaDatos frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VMetaDatos();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void cargarFormulario() {
		cargarMetaDatos();
		txtNombre.setText(metaDatos.getNombreBD());
		txtDriver.setText(metaDatos.getDriver());
		txtUrl.setText(metaDatos.getUrl());
		txtUsuario.setText(metaDatos.getUsuario());
		
		model = (DefaultTableModel) table.getModel();
		for(Tabla tabla:metaDatos.getTablas()) {
			for(Columna columna:tabla.getColumnas()) {
				model.addRow(new Object[]{tabla.getEsquema(), tabla.getNombre(), tabla.getClavePrimaria(),
						columna.getNombreCol(),columna.getTipo(),columna.isNula()?"Si":"No"});
			}
		}
	}
	
	private static void cargarMetaDatos() {
		GestorBBDD gb = new GestorBBDD(bbdd);
		metaDatos = gb.cargarMetaDatos();
	}
	

	public String getBbdd() {
		return bbdd;
	}



	public void setBbdd(String bbdd) {
		this.bbdd = bbdd;
	}



	/**
	 * Create the frame.
	 */
	public VMetaDatos() {
		
		setBounds(new Rectangle(0, 0, 800, 800));
		setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());
		setExtendedState(Frame.NORMAL);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		getContentPane().setBackground(new Color(233, 69, 75));
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 800, 800));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(new Color(233, 69, 75));
		
		setLocationRelativeTo(null);
		
		JLabel lblMetadatos = new JLabel("| Metadatos");
		lblMetadatos.setForeground(Color.WHITE);
		lblMetadatos.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblMetadatos.setBounds(50, 50, 247, 31);
		contentPane.add(lblMetadatos);
		
		JLabel label = new JLabel("- Base de datos:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label.setBounds(50, 134, 250, 31);
		contentPane.add(label);
		
		JLabel lblNo = new JLabel("Nombre:");
		lblNo.setForeground(Color.WHITE);
		lblNo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNo.setBounds(100, 175, 126, 31);
		contentPane.add(lblNo);
		
		JLabel lblDriver = new JLabel("Driver:");
		lblDriver.setForeground(Color.WHITE);
		lblDriver.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDriver.setBounds(100, 216, 126, 31);
		contentPane.add(lblDriver);
		
		JLabel lblUrl = new JLabel("Url:");
		lblUrl.setForeground(Color.WHITE);
		lblUrl.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUrl.setBounds(100, 257, 126, 31);
		contentPane.add(lblUrl);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUsuario.setBounds(100, 298, 126, 31);
		contentPane.add(lblUsuario);
		
		JLabel lblTablas = new JLabel("- Tablas y columnas:");
		lblTablas.setForeground(Color.WHITE);
		lblTablas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTablas.setBounds(50, 359, 250, 31);
		contentPane.add(lblTablas);

		
		JPanel panel = new JPanel();
		panel.setBounds(50, 400, 687, 327);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 687, 327);
		panel.add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Esquema", "Nombre tabla", "Clave primaria", "Nombre columna", "Tipo", "Nula"
			}
		));
		
		txtNombre = new JLabel("(sin datos)");
		txtNombre.setForeground(Color.WHITE);
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtNombre.setBounds(236, 175, 501, 31);
		contentPane.add(txtNombre);
		
		txtDriver = new JLabel("(sin datos)");
		txtDriver.setForeground(Color.WHITE);
		txtDriver.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtDriver.setBounds(236, 216, 501, 31);
		contentPane.add(txtDriver);
		
		txtUrl = new JLabel("(sin datos)");
		txtUrl.setForeground(Color.WHITE);
		txtUrl.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtUrl.setBounds(236, 257, 501, 31);
		contentPane.add(txtUrl);
		
		txtUsuario = new JLabel("(sin datos)");
		txtUsuario.setForeground(Color.WHITE);
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtUsuario.setBounds(236, 298, 501, 31);
		contentPane.add(txtUsuario);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VListado vl = new VListado();
				vl.setVisible(true);
				frame.dispose();
			}
		});
		button.setContentAreaFilled(false);
		button.setIcon(new ImageIcon(getClass().getResource("../imagenes/BOTONES/botVOLVER.png")));
		button.setBounds(600, 50, 137, 80);
		contentPane.add(button);
		
		
	}
}
