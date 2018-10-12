package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import modelo.Cargo;
import modelo.Empleado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class VAltaEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField txtnombre;
	private JTextField txtapellido;
	private JTextField txtnaci;

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
		
		txtnombre = new JTextField();
		txtnombre.setColumns(10);
		txtnombre.setBounds(333, 157, 205, 22);
		contentPane.add(txtnombre);
		
		txtapellido = new JTextField();
		txtapellido.setColumns(10);
		txtapellido.setBounds(334, 213, 204, 22);
		contentPane.add(txtapellido);
		
		JComboBox txtcargo = new JComboBox();
		txtcargo.setBounds(333, 266, 205, 22);
		contentPane.add(txtcargo);
		
	
		JButton cancelar = new JButton("");
		cancelar.setIcon(new ImageIcon(VAltaEmpl.class.getResource("/imagenes/BOTONES/botCANCELAR.png")));
		cancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//TOODO FALTA PROBAR CUANDO EST� LA VENTANA DE LISTADOS
				((java.awt.Window) getParent()).dispose();
				VListado list = new VListado();
				list.setVisible(true);
				}
		});
		
		cancelar.setBounds(37, 599, 244, 107);
		contentPane.add(cancelar);
		cancelar.setContentAreaFilled(false);
		
		JButton ok = new JButton("");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtnombre.getText().toCharArray().length<2 ) {
					//validar campo +2 letras
					JOptionPane.showMessageDialog(null, "No admite menos de dos letras..", "Error en nombre", JOptionPane.ERROR_MESSAGE);
				}
				if (txtapellido.getText().toCharArray().length<2) {
					JOptionPane.showMessageDialog(null, "No admite menos de dos letras..", "Error en apellido", JOptionPane.ERROR_MESSAGE);
					
				}
				if (txtnaci.getText().toCharArray().length<2) {
					JOptionPane.showMessageDialog(null, "No admite menos de dos letras..", "Error en nacionalidad", JOptionPane.ERROR_MESSAGE);
				}
				Cargo car = Cargo.camarero;

			switch(txtcargo.getSelectedItem().toString()){
				case "camarero":
					car = Cargo.camarero;
					break;
				case "portero":
					car = Cargo.portero;
					break;
				case "acomodadorResponsableBar":
					car = Cargo.acomodadorResponsableBar;
					break;
				case "mantenimiento":
					car = Cargo.mantenimiento;
					break;
				case "responsableCine":
					car = Cargo.responsableCine;
					break;
				case "responsableSala":
					car = Cargo.responsableSala;
				break;
				}
				
				Empleado emple = new Empleado(txtnombre.getText(), txtapellido.getText(), car, txtfecCont., (Date)txtfecNac.getDate(), txtnaci.getText(), (Date)txtfecFinCon.getDate(), true);
	
				emple.guardarEmpleado();
				
				//TODO: PROBAR SI FUNSIONA
			}
		});
		
		ok.setIcon(new ImageIcon(VAltaEmpl.class.getResource("/imagenes/BOTONES/botOK.png")));
		ok.setBounds(619, 44, 126, 99);
		contentPane.add(ok);
		ok.setContentAreaFilled(false);
		
		JDateChooser txtfecCont = new JDateChooser();
		txtfecCont.setBounds(333, 326, 205, 22);
		contentPane.add(txtfecCont);
		
		JDateChooser txtfecNac = new JDateChooser();
		txtfecNac.setBounds(333, 378, 205, 22);
		contentPane.add(txtfecNac);
		
		txtnaci = new JTextField();
		txtnaci.setColumns(10);
		txtnaci.setBounds(333, 427, 205, 22);
		contentPane.add(txtnaci);
		
		JDateChooser txtfecFinCon = new JDateChooser();
		txtfecFinCon.setBounds(333, 485, 203, 22);
		contentPane.add(txtfecFinCon);
		
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
