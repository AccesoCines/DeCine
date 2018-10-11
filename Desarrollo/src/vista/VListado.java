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

import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class VListado extends JFrame {

	private JPanel contentPane;

	private static ArrayList<Empleado> empleados;
	private static DefaultTableModel model;
	private static JTable table;
	private JFrame jframe = this;
	private static String bbdd;
	private VMetaDatos vmd = new VMetaDatos();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VListado frame = new VListado();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		getContentPane().setBackground(new Color(233, 69, 75));
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 800, 800));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(new Color(233, 69, 75));
		//Hasta aquí y sobreescribir todo

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "New column", "New column", "New column", "New column", "New column" }));
		table.setBounds(50, 472, 700, 270);
		contentPane.add(table);

		JButton alta = new JButton("");
		alta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		alta.setBorder(null);
		alta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VAltaEmpl ae = new VAltaEmpl();
				jframe.setContentPane(ae);
				ae.setVisible(true);
				//jframe.setLayout(getLayout());
				//jframe.setContentPane(new VAltaEmpl());
				//jframe.repaint();

			}
		});
		alta.setIcon(new ImageIcon(VListado.class.getResource("../imagenes/BOTONES/botALTA.png")));
		alta.setBounds(50, 50, 100, 80);
		alta.setContentAreaFilled(false);
		contentPane.add(alta);

		JButton modificacion = new JButton("");
		modificacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		modificacion.setBorder(null);
		modificacion.setBounds(50, 350,228, 80);
		modificacion.setIcon(new ImageIcon(getClass().getResource("../imagenes/BOTONES/botMODIFICAC.png")));
		modificacion.setContentAreaFilled(false);
		contentPane.add(modificacion);

		JButton baja = new JButton("");
		baja.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		baja.setBorder(null);
		baja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		baja.setBounds(50, 150,107, 80);
		baja.setIcon(new ImageIcon(getClass().getResource("../imagenes/BOTONES/botBAJA.png")));
		baja.setContentAreaFilled(false);
		contentPane.add(baja);

		JButton historico = new JButton("");
		historico.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		historico.setBorder(null);
		historico.setBounds(50, 250,174, 80);
		historico.setIcon(new ImageIcon(getClass().getResource("../imagenes/BOTONES/botHIST.png")));
		historico.setContentAreaFilled(false);
		contentPane.add(historico);
		
		JComboBox cbCines = new JComboBox();
		cbCines.setModel(new DefaultComboBoxModel(new String[] {"Comercial", "Cl\u00E1sico", "Experimental"}));
		cbCines.setSize(350, 31);
		cbCines.setLocation(350, 74);
		cbCines.setBorder(new LineBorder(Color.WHITE, 3, true));
		cbCines.setForeground(Color.WHITE);
		cbCines.setBackground(new Color(233, 69, 75));
		cbCines.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(cbCines);
		
		JComboBox cbEmpleados = new JComboBox();
		cbEmpleados.setForeground(Color.WHITE);
		cbEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cbEmpleados.setBorder(new LineBorder(Color.WHITE, 3, true));
		cbEmpleados.setBackground(new Color(233, 69, 75));
		cbEmpleados.setBounds(350, 154, 350, 31);
		contentPane.add(cbEmpleados);
		
		JComboBox cbPeliculas = new JComboBox();
		cbPeliculas.setForeground(Color.WHITE);
		cbPeliculas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cbPeliculas.setBorder(new LineBorder(Color.WHITE, 3, true));
		cbPeliculas.setBackground(new Color(233, 69, 75));
		cbPeliculas.setBounds(350, 234, 350, 31);
		contentPane.add(cbPeliculas);
		
		JComboBox cbSalas = new JComboBox();
		cbSalas.setForeground(Color.WHITE);
		cbSalas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cbSalas.setBorder(new LineBorder(Color.WHITE, 3, true));
		cbSalas.setBackground(new Color(233, 69, 75));
		cbSalas.setBounds(350, 314, 350, 31);
		contentPane.add(cbSalas);
		
		JButton btnInfo = new JButton("");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cine = elegirBBDD(cbCines.getSelectedItem().toString());
				if(!cine.equals("")) {
					vmd.setBbdd(elegirBBDD(cbCines.getSelectedItem().toString()));
					vmd.cargarFormulario();
					vmd.setVisible(true);
					jframe.dispose();
				}
			}
		});
		btnInfo.setBounds(650, 380, 100, 80);
		btnInfo.setIcon(new ImageIcon(getClass().getResource("../imagenes/BOTONES/Info.png")));
		btnInfo.setContentAreaFilled(false);
		contentPane.add(btnInfo);

		setLocationRelativeTo(null);

		empleados = DB4o.mostrarListEmple();
		model = (DefaultTableModel) table.getModel();
		for (Empleado e : empleados) {

			model.insertRow(model.getRowCount(), new Object[] { e.getNombre(), e.getApellido() });
		}
		
	}
	
	private String elegirBBDD(String nombreBd) {
		switch (nombreBd) {
			case "Comercial":
				return "sqlite";
			case "Clásico":
				return "db4o";
			case "Experimental":
				return "postgre";
			default:
				JOptionPane.showMessageDialog(getParent(), "Debes elegir un cine en el desplegable", "Error", JOptionPane.ERROR_MESSAGE);
				return "";
		}
	}
}
