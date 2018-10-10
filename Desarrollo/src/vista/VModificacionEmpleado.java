package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import java.awt.Font;

public class VModificacionEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VModificacionEmpleado frame = new VModificacionEmpleado();
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
	public VModificacionEmpleado() {
		
		setBounds(new Rectangle(0, 0, 800, 800));
		
		// Poner icono ventana
		setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());
		
		setExtendedState(Frame.NORMAL);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(70, -48, 205, 22);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(71, 8, 204, 22);
		contentPane.add(textField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(70, 61, 205, 22);
		contentPane.add(comboBox);
		
		JButton button = new JButton("");
		button.setContentAreaFilled(false);
		button.setBounds(-251, 363, 244, 107);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setContentAreaFilled(false);
		button_1.setBounds(331, -192, 126, 99);
		contentPane.add(button_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(70, 121, 205, 22);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(70, 173, 205, 22);
		contentPane.add(dateChooser_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(70, 222, 205, 22);
		contentPane.add(textField_2);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(70, 280, 203, 22);
		contentPane.add(dateChooser_2);
		
		JLabel label = new JLabel("Nombre:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label.setBounds(-238, -59, 112, 31);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Apellido:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_1.setBounds(-238, -3, 134, 31);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Cargo:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_2.setBounds(-238, 51, 112, 31);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Fecha contrataci\u00F3n:");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_3.setBounds(-238, 110, 225, 31);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Fecha nacimiento: ");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_4.setBounds(-238, 164, 225, 31);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Nacionalidad: ");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_5.setBounds(-238, 213, 225, 31);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Fecha fin contrato: ");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_6.setBounds(-238, 271, 225, 31);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("| Alta empleados");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_7.setBounds(-238, -186, 225, 31);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("cine");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_8.setBounds(-172, -124, 225, 31);
		contentPane.add(label_8);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(326, 152, 205, 22);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(327, 208, 204, 22);
		contentPane.add(textField_4);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(326, 261, 205, 22);
		contentPane.add(comboBox_1);
		
		JButton button_2 = new JButton("");
		button_2.setContentAreaFilled(false);
		button_2.setBounds(5, 563, 244, 107);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setContentAreaFilled(false);
		button_3.setBounds(587, 8, 126, 99);
		contentPane.add(button_3);
		
		JDateChooser dateChooser_3 = new JDateChooser();
		dateChooser_3.setBounds(326, 321, 205, 22);
		contentPane.add(dateChooser_3);
		
		JDateChooser dateChooser_4 = new JDateChooser();
		dateChooser_4.setBounds(326, 373, 205, 22);
		contentPane.add(dateChooser_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(326, 422, 205, 22);
		contentPane.add(textField_5);
		
		JDateChooser dateChooser_5 = new JDateChooser();
		dateChooser_5.setBounds(326, 480, 203, 22);
		contentPane.add(dateChooser_5);
		
		JLabel label_9 = new JLabel("Nombre:");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_9.setBounds(18, 141, 112, 31);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("Apellido:");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_10.setBounds(18, 197, 134, 31);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("Cargo:");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_11.setBounds(18, 251, 112, 31);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("Fecha contrataci\u00F3n:");
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_12.setBounds(18, 310, 225, 31);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("Fecha nacimiento: ");
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_13.setBounds(18, 364, 225, 31);
		contentPane.add(label_13);
		
		JLabel label_14 = new JLabel("Nacionalidad: ");
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_14.setBounds(18, 413, 225, 31);
		contentPane.add(label_14);
		
		JLabel label_15 = new JLabel("Fecha fin contrato: ");
		label_15.setForeground(Color.WHITE);
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_15.setBounds(18, 471, 225, 31);
		contentPane.add(label_15);
		
		JLabel label_16 = new JLabel("| Alta empleados");
		label_16.setForeground(Color.WHITE);
		label_16.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_16.setBounds(18, 14, 225, 31);
		contentPane.add(label_16);
		
		JLabel label_17 = new JLabel("cine");
		label_17.setForeground(Color.WHITE);
		label_17.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_17.setBounds(84, 76, 225, 31);
		contentPane.add(label_17);
	}
}
