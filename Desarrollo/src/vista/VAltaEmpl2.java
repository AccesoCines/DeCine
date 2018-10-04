package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class VAltaEmpl2 extends JFrame {

	private JPanel contentPane;
	private JTextField jNombre;
	private JTextField jApellido;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VAltaEmpl2 frame = new VAltaEmpl2();
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
	public VAltaEmpl2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAltaEmpleados = new JLabel("Alta empleados");
		lblAltaEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAltaEmpleados.setForeground(Color.WHITE);
		lblAltaEmpleados.setBounds(12, 0, 113, 35);
		contentPane.add(lblAltaEmpleados);
		
		JLabel lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(12, 48, 56, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(12, 75, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cargo:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(12, 103, 56, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha contrataci\u00F3n: ");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(12, 132, 133, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha nacimiento:");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(12, 162, 113, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad: ");
		lblNacionalidad.setForeground(Color.WHITE);
		lblNacionalidad.setBounds(12, 192, 95, 16);
		contentPane.add(lblNacionalidad);
		
		JLabel lblFechaFinContrato = new JLabel("Fecha fin contrato: ");
		lblFechaFinContrato.setForeground(Color.WHITE);
		lblFechaFinContrato.setBounds(12, 224, 113, 16);
		contentPane.add(lblFechaFinContrato);
		
		jNombre = new JTextField();
		jNombre.setBounds(141, 45, 260, 22);
		contentPane.add(jNombre);
		jNombre.setColumns(10);
		
		jApellido = new JTextField();
		jApellido.setBounds(141, 72, 260, 22);
		contentPane.add(jApellido);
		jApellido.setColumns(10);
		
		JComboBox jCargo = new JComboBox();
		jCargo.setBounds(141, 100, 260, 22);
		contentPane.add(jCargo);
		JComboBox.DataSource = [Enum].GetValues(GetType(Cargo));
		JComboBox.SelectedItem = Cargo.jCargo;
		
		textField = new JTextField();
		textField.setBounds(141, 129, 260, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(141, 159, 260, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(141, 189, 260, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(141, 221, 260, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		
	  
	}
}
