package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class VAltaEmpl extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VAltaEmpl frame = new VAltaEmpl();
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
	public VAltaEmpl() {
		// Poner icono ventana
	    setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alta empleados");
		lblNewLabel.setBounds(5, 5, 422, 19);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(5, 48, 56, 16);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(5, 77, 56, 16);
		contentPane.add(lblApellido);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(5, 108, 56, 16);
		contentPane.add(lblCargo);
		
		JLabel lblFechaContratacin = new JLabel("Fecha contratacion: ");
		lblFechaContratacin.setBounds(5, 137, 134, 16);
		contentPane.add(lblFechaContratacin);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento:");
		lblFechaNacimiento.setBounds(5, 166, 114, 16);
		contentPane.add(lblFechaNacimiento);
		
		JLabel lblNewLabel_1 = new JLabel("Nacionalidad:");
		lblNewLabel_1.setBounds(5, 195, 114, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblFechaFinContrato = new JLabel("Fecha fin contrato: ");
		lblFechaFinContrato.setBounds(5, 224, 114, 16);
		contentPane.add(lblFechaFinContrato);
		
		textField = new JTextField();
		textField.setBounds(131, 45, 148, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(141, 74, 148, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(113, 105, 148, 22);
		contentPane.add(comboBox);
		

	}
}
