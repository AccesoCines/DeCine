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
	private JTextField txtApellido;
	private JTextField txtNacionalidad;
	private JTextField txtNombre;

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
		
		getContentPane().setBackground(new Color(233, 69, 75));
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(327, 208, 204, 22);
		contentPane.add(txtApellido);
		
		JComboBox txtCargo = new JComboBox();
		txtCargo.setBounds(326, 261, 205, 22);
		contentPane.add(txtCargo);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBounds(5, 563, 244, 107);
		contentPane.add(btnCancelar);
		btnCancelar.setIcon(new ImageIcon(VAltaEmpl.class.getResource("/imagenes/BOTONES/botCANCELAR.png")));
		
		JButton btnOk = new JButton("");
		btnOk.setContentAreaFilled(false);
		btnOk.setBounds(587, 8, 126, 99);
		contentPane.add(btnOk);
		btnOk.setIcon(new ImageIcon(VAltaEmpl.class.getResource("/imagenes/BOTONES/botOK.png")));
		
		JDateChooser txtFecCont = new JDateChooser();
		txtFecCont.setBounds(326, 321, 205, 22);
		contentPane.add(txtFecCont);
		
		JDateChooser txtFecNac = new JDateChooser();
		txtFecNac.setBounds(326, 373, 205, 22);
		contentPane.add(txtFecNac);
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setColumns(10);
		txtNacionalidad.setBounds(326, 422, 205, 22);
		contentPane.add(txtNacionalidad);
		
		JDateChooser txtFecFinCon = new JDateChooser();
		txtFecFinCon.setBounds(326, 480, 203, 22);
		contentPane.add(txtFecFinCon);
		
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
		
		JLabel lblModificacinEmpleado = new JLabel("| Modificaci\u00F3n empleado");
		lblModificacinEmpleado.setForeground(Color.WHITE);
		lblModificacinEmpleado.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblModificacinEmpleado.setBounds(18, 14, 330, 31);
		contentPane.add(lblModificacinEmpleado);
		
		JLabel label_17 = new JLabel("cine");
		label_17.setForeground(Color.WHITE);
		label_17.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_17.setBounds(84, 76, 225, 31);
		contentPane.add(label_17);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(327, 150, 204, 22);
		contentPane.add(txtNombre);
		
		
		setLocationRelativeTo(null);
	}
}
