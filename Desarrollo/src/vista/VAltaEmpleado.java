package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import java.awt.Font;

public class VAltaEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VAltaEmpleado frame = new VAltaEmpleado();
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
	public VAltaEmpleado() {
		
		setBounds(new Rectangle(0, 0, 800, 800));
		
		// Poner icono ventana
		setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());
		
		setExtendedState(Frame.NORMAL);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(new Rectangle(0, 0, 800, 800));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		getContentPane().setBackground(new Color(233, 69, 75));
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(333, 157, 205, 22);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(334, 213, 204, 22);
		contentPane.add(textField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(333, 266, 205, 22);
		contentPane.add(comboBox);
		
		JButton button = new JButton("");
		button.setContentAreaFilled(false);
		button.setBounds(12, 568, 244, 107);
		contentPane.add(button);
		button.setIcon(new ImageIcon(VAltaEmpl.class.getResource("/imagenes/BOTONES/botCANCELAR.png")));
		
		JButton button_1 = new JButton("");
		button_1.setContentAreaFilled(false);
		button_1.setBounds(594, 13, 126, 99);
		contentPane.add(button_1);
		button_1.setIcon(new ImageIcon(VAltaEmpl.class.getResource("/imagenes/BOTONES/botOK.png")));
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(333, 326, 205, 22);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(333, 378, 205, 22);
		contentPane.add(dateChooser_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(333, 427, 205, 22);
		contentPane.add(textField_2);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(333, 485, 203, 22);
		contentPane.add(dateChooser_2);
		
		JLabel label = new JLabel("Nombre:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label.setBounds(25, 146, 112, 31);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Apellido:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_1.setBounds(25, 202, 134, 31);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Cargo:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_2.setBounds(25, 256, 112, 31);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Fecha contrataci\u00F3n:");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_3.setBounds(25, 315, 225, 31);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Fecha nacimiento: ");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_4.setBounds(25, 369, 225, 31);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Nacionalidad: ");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_5.setBounds(25, 418, 225, 31);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Fecha fin contrato: ");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_6.setBounds(25, 476, 225, 31);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("| Alta empleados");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_7.setBounds(25, 19, 225, 31);
		contentPane.add(label_7);
		
		JLabel lblCine = new JLabel("cine");
		lblCine.setForeground(Color.WHITE);
		lblCine.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblCine.setBounds(91, 81, 225, 31);
		contentPane.add(lblCine);
		
		setLocationRelativeTo(null);
	}
}
