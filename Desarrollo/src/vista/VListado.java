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
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
		//Hasta aqu� y sobreescribir todo

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
		alta.setBounds(533, 50, 100, 80);
		alta.setContentAreaFilled(false);
		contentPane.add(alta);

		JButton modificacion = new JButton("");
		modificacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		modificacion.setBorder(null);
		modificacion.setBounds(533, 350,228, 80);
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
		baja.setBounds(533, 150,107, 80);
		baja.setIcon(new ImageIcon(getClass().getResource("../imagenes/BOTONES/botBAJA.png")));
		baja.setContentAreaFilled(false);
		contentPane.add(baja);

		JButton historico = new JButton("");
		historico.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		historico.setBorder(null);
		historico.setBounds(533, 250,174, 80);
		historico.setIcon(new ImageIcon(getClass().getResource("../imagenes/BOTONES/botHIST.png")));
		historico.setContentAreaFilled(false);
		contentPane.add(historico);
		
		JComboBox cbCines = new JComboBox();
		cbCines.setModel(new DefaultComboBoxModel(new String[] {"Pr\u00EDncipe", "Zubiarte 3D", "Azul"}));
		cbCines.setSize(350, 40);
		cbCines.setLocation(146, 75);
		cbCines.setBorder(new LineBorder(Color.WHITE, 3, true));
		cbCines.setForeground(Color.WHITE);
		cbCines.setBackground(new Color(233, 69, 75));
		cbCines.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cbCines.setSelectedIndex(-1);
		contentPane.add(cbCines);
		
		JComboBox cbEmpleados = new JComboBox();
		cbEmpleados.setForeground(Color.WHITE);
		cbEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cbEmpleados.setBorder(new LineBorder(Color.WHITE, 3, true));
		cbEmpleados.setBackground(new Color(233, 69, 75));
		cbEmpleados.setBounds(146, 152, 350, 40);
		cbEmpleados.setSelectedIndex(-1);
		contentPane.add(cbEmpleados);
		
		JComboBox cbPeliculas = new JComboBox();
		cbPeliculas.setForeground(Color.WHITE);
		cbPeliculas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cbPeliculas.setBorder(new LineBorder(Color.WHITE, 3, true));
		cbPeliculas.setBackground(new Color(233, 69, 75));
		cbPeliculas.setBounds(146, 225, 350, 40);
		cbPeliculas.setSelectedIndex(-1);
		contentPane.add(cbPeliculas);
		
		JComboBox cbSalas = new JComboBox();
		cbSalas.setForeground(Color.WHITE);
		cbSalas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cbSalas.setBorder(new LineBorder(Color.WHITE, 3, true));
		cbSalas.setBackground(new Color(233, 69, 75));
		cbSalas.setBounds(146, 300, 350, 40);
		cbSalas.setSelectedIndex(-1);
		contentPane.add(cbSalas);
		
		JButton btnInfo = new JButton("");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String cine = elegirBBDD(cbCines.getSelectedItem().toString());
					if(!cine.equals("")) {	
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
		btnInfo.setBounds(50, 350, 100, 80);
		btnInfo.setIcon(new ImageIcon(getClass().getResource("../imagenes/BOTONES/Info.png")));
		btnInfo.setContentAreaFilled(false);
		contentPane.add(btnInfo);
		
		JLabel lblCine = new JLabel("Cine ");
		lblCine.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCine.setLabelFor(cbCines);
		lblCine.setForeground(Color.WHITE);
		lblCine.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCine.setBounds(10, 80, 126, 31);
		contentPane.add(lblCine);
		
		JLabel lblEmpleado = new JLabel("Empleado ");
		lblEmpleado.setLabelFor(cbEmpleados);
		lblEmpleado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmpleado.setForeground(Color.WHITE);
		lblEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEmpleado.setBounds(10, 155, 126, 31);
		contentPane.add(lblEmpleado);
		
		JLabel lblPelcula = new JLabel("Pel\u00EDcula ");
		lblPelcula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPelcula.setLabelFor(cbPeliculas);
		lblPelcula.setForeground(Color.WHITE);
		lblPelcula.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPelcula.setBounds(10, 230, 126, 31);
		contentPane.add(lblPelcula);
		
		JLabel lblSala = new JLabel("Sala ");
		lblSala.setLabelFor(cbSalas);
		lblSala.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSala.setForeground(Color.WHITE);
		lblSala.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSala.setBounds(10, 305, 126, 31);
		contentPane.add(lblSala);

		setLocationRelativeTo(null);

		empleados = DB4o.mostrarListEmple();
		model = (DefaultTableModel) table.getModel();
		for (Empleado e : empleados) {

			model.insertRow(model.getRowCount(), new Object[] { e.getNombre(), e.getApellido() });
		}
		
	}
	
	private String elegirBBDD(String nombreBd) {
		switch (nombreBd) {
			case "Pr�ncipe":
				return "sqlite";
			case "Zubiarte 3D":
				return "db4o";
			case "Azul":
				return "postgre";
			default:
				JOptionPane.showMessageDialog(getParent(), "Debes elegir un cine en el desplegable", "Error", JOptionPane.ERROR_MESSAGE);
				return "";
		}
	}
}
