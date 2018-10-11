package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.DB4o;
import controlador.GestorBBDD;
import modelo.Empleado;
import modelo.MetaDato;

public class VMetaDatos extends JFrame {

	private JPanel contentPane;
	private static DefaultTableModel model;
	private static JTable table;
	private static MetaDato metadatos;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VMetaDatos frame = new VMetaDatos();
					frame.setVisible(true);
					GestorBBDD gb = new GestorBBDD("postgre");
					metadatos = gb.cargarMetaDatos();
					model = (DefaultTableModel) table.getModel();
					for (MetaDato md : metadatos) {

						model.insertRow(model.getRowCount(), new Object[] { e.getNombre(), e.getApellido() });
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		
		JLabel lblMetadatos = new JLabel("| Metadatos");
		lblMetadatos.setForeground(Color.WHITE);
		lblMetadatos.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblMetadatos.setBounds(50, 50, 247, 31);
		contentPane.add(lblMetadatos);
		
		JLabel lblNombre = new JLabel("- Base de datos:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNombre.setBounds(50, 129, 250, 31);
		contentPane.add(lblNombre);
		
		JLabel label = new JLabel("- Base de datos:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label.setBounds(100, 170, 250, 31);
		contentPane.add(label);
		
		JLabel lblNo = new JLabel("Nombre:");
		lblNo.setForeground(Color.WHITE);
		lblNo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNo.setBounds(150, 211, 250, 31);
		contentPane.add(lblNo);
		
		JLabel lblDriver = new JLabel("Driver:");
		lblDriver.setForeground(Color.WHITE);
		lblDriver.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDriver.setBounds(150, 252, 250, 31);
		contentPane.add(lblDriver);
		
		JLabel lblUrl = new JLabel("Url:");
		lblUrl.setForeground(Color.WHITE);
		lblUrl.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUrl.setBounds(150, 293, 250, 31);
		contentPane.add(lblUrl);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUsuario.setBounds(150, 334, 250, 31);
		contentPane.add(lblUsuario);
		
		JLabel lblTablas = new JLabel("- Tablas:");
		lblTablas.setForeground(Color.WHITE);
		lblTablas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTablas.setBounds(100, 389, 250, 31);
		contentPane.add(lblTablas);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Esquema", "Nombre", "Clave primaria", "Nombre columna", "Tipo", "Nula"
			}
		));
		table.setBounds(50, 430, 700, 145);
		contentPane.add(table);
	}
}
