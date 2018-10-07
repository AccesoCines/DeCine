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
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controlador.DB4o;
import modelo.Empleado;

import java.awt.Color;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VListado extends JFrame {

	private JPanel contentPane;

	private static ArrayList<Empleado> empleados;
	private static DefaultTableModel model;
	private static JTable table;

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
				empleados = DB4o.mostrarListEmple();
				model = (DefaultTableModel) table.getModel();
				for (Empleado e : empleados) {

					model.insertRow(model.getRowCount(), new Object[] { e.getNombre(), e.getApellido() });
				}
			}

		});

	}

	public VListado() {

		// Poner icono ventana
		setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());

		setExtendedState(Frame.NORMAL);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		getContentPane().setBackground(new Color(233, 69, 75));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(380, 217, -337, -153);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "New column", "New column", "New column", "New column", "New column" }));
		table.setBounds(285, 472, 497, 268);
		contentPane.add(table);

		JButton alta = new JButton("");
		alta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VAltaEmpl ae = new VAltaEmpl();
				ae.setVisible(true);

				dispose();
			}
		});
		alta.setIcon(new ImageIcon(VListado.class.getResource("/vista/botALTA.png")));
		alta.setBounds(12, 62, 51, 51);
		contentPane.add(alta);

		JButton modificacion = new JButton("");
		modificacion.setIcon(new ImageIcon(VListado.class.getResource("/imagenes/BOTONES/botMODIFICAC.png")));
		modificacion.setBounds(0, 522, 124, 153);
		contentPane.add(modificacion);

		JButton baja = new JButton("");
		baja.setIcon(new ImageIcon(VListado.class.getResource("/imagenes/BOTONES/botBAJA.png")));
		baja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		baja.setBounds(29, 184, 150, 97);
		contentPane.add(baja);

		JButton historico = new JButton("");
		historico.setIcon(new ImageIcon(VListado.class.getResource("/imagenes/BOTONES/botHIST.png")));
		historico.setBounds(0, 317, 158, 133);
		contentPane.add(historico);

		setLocationRelativeTo(null);

	}
}
