package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
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
				model = (DefaultTableModel)table.getModel();
				for(Empleado e : empleados) {
					
					model.insertRow(model.getRowCount(), new Object[] {e.getNombre(),e.getApellido()});
				}
			}
			
		});
		
		
	}

	/**
	 * Create the frame.
	 */
	public VListado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(380, 217, -337, -153);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
		
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(81, 74, 339, 128);
		contentPane.add(table);
		
		
	
	}
}
