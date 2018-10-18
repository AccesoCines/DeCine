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

import modelo.Cargo;
import modelo.Empleado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class VModificacionEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField txtApellido;
	private JTextField txtNacionalidad;
	private JTextField txtNombre;
	private JTextField textField;
	private static VModificacionEmpleado frame;
	private String bbdd;
	private JComboBox txtCargo;
	private JDateChooser txtFecCont;
	private JDateChooser txtFecNac;
	private JDateChooser txtFecFinCon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VModificacionEmpleado();
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		getContentPane().setBackground(new Color(233, 69, 75));
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(285, 250, 358, 31);
		contentPane.add(txtApellido);
		
		txtCargo = new JComboBox();
		txtCargo.setBounds(285, 300, 358, 31);
		contentPane.add(txtCargo);
		for(Cargo cargo:Cargo.values()) {
			txtCargo.addItem(cargo);	//TODO si da tiempo poner los textos bien
		}
		
		JButton btnCancelar = new JButton("");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				VListado vl = new VListado();
				vl.setVisible(true);
			}
		});
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBounds(50, 587, 181, 80);
		contentPane.add(btnCancelar);
		btnCancelar.setIcon(new ImageIcon(VAltaEmpl.class.getResource("/imagenes/BOTONES/botCANCELAR.png")));
		
		JButton btnOk = new JButton("");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText();
				String apellido = txtApellido.getText();
				Cargo cargo = (Cargo) txtCargo.getSelectedItem();
				Date fechaCont = (Date) txtFecCont.getDate();
				Date fechaNac = (Date) txtFecNac.getDate();
				Date fechaFinCon = (Date) txtFecFinCon.getDate();
				String nacionalidad = txtNacionalidad.getText();
				if(nombre.equals("") || apellido.equals("") ||txtCargo.getSelectedIndex()==-1
						|| nacionalidad.equals("") || fechaCont.toString().equals("")
						|| fechaNac.toString().equals("") || fechaFinCon.toString().equals("")) {
					JOptionPane.showMessageDialog(getParent(), "Debes rellenar todos los campos"
							, "Error", JOptionPane.WARNING_MESSAGE);
				}else {
					Empleado emple = new Empleado(nombre,apellido,cargo,fechaCont,fechaNac,nacionalidad,
							fechaFinCon,true);
					boolean correcto = emple.guardarEmpleado(bbdd);
				}
			}
		});
		btnOk.setContentAreaFilled(false);
		btnOk.setBounds(647, 50, 91, 80);
		contentPane.add(btnOk);
		btnOk.setIcon(new ImageIcon(VAltaEmpl.class.getResource("/imagenes/BOTONES/botOK.png")));
		
		txtFecCont = new JDateChooser();
		txtFecCont.setBounds(285, 350, 205, 31);
		contentPane.add(txtFecCont);
		
		txtFecNac = new JDateChooser();
		txtFecNac.setBounds(285, 400, 205, 31);
		contentPane.add(txtFecNac);
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setColumns(10);
		txtNacionalidad.setBounds(285, 450, 358, 31);
		contentPane.add(txtNacionalidad);
		
		txtFecFinCon = new JDateChooser();
		txtFecFinCon.setBounds(285, 500, 203, 31);
		contentPane.add(txtFecFinCon);
		
		JLabel label_9 = new JLabel("Nombre:");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_9.setBounds(50, 200, 112, 31);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("Apellido:");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_10.setBounds(50, 250, 134, 31);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("Cargo:");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_11.setBounds(50, 300, 112, 31);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("Fecha contrataci\u00F3n:");
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_12.setBounds(50, 350, 225, 31);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("Fecha nacimiento: ");
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_13.setBounds(50, 400, 225, 31);
		contentPane.add(label_13);
		
		JLabel label_14 = new JLabel("Nacionalidad: ");
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_14.setBounds(50, 450, 225, 31);
		contentPane.add(label_14);
		
		JLabel label_15 = new JLabel("Fecha fin contrato: ");
		label_15.setForeground(Color.WHITE);
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_15.setBounds(50, 500, 225, 31);
		contentPane.add(label_15);
		
		JLabel lblModificacinEmpleado = new JLabel("| Modificaci\u00F3n empleado");
		lblModificacinEmpleado.setForeground(Color.WHITE);
		lblModificacinEmpleado.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblModificacinEmpleado.setBounds(50, 50, 330, 31);
		contentPane.add(lblModificacinEmpleado);
		
		JLabel label_17 = new JLabel("cine");
		label_17.setForeground(Color.WHITE);
		label_17.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_17.setBounds(75, 100, 225, 31);
		contentPane.add(label_17);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(285, 200, 358, 31);
		contentPane.add(txtNombre);
		
		
		setLocationRelativeTo(null);
	}
}
