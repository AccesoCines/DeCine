package vista;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.Rectangle;

public class VAltaEmpl extends JFrame {

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
	    
	    setTitle ("Alta empleados");
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 225, 31));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.setBackground(new Color(233, 69, 75));
		
		txtnombre = new JTextField();
		txtnombre.setBounds(184, 135, 205, 22);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);
		
		txtapellido = new JTextField();
		txtapellido.setBounds(184, 191, 204, 22);
		contentPane.add(txtapellido);
		txtapellido.setColumns(10);
		
		JComboBox txtcargo = new JComboBox();
		txtcargo.setBounds(184, 245, 205, 22);
		contentPane.add(txtcargo);
		
		JButton cancelar = new JButton("");
		cancelar.setIcon(new ImageIcon(VAltaEmpl.class.getResource("/imagenes/BOTONES/botCANCELAR.png")));
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cancelar.setBounds(37, 599, 157, 99);
		contentPane.add(cancelar);
		
		JButton ok = new JButton("");
		ok.setIcon(new ImageIcon(VAltaEmpl.class.getResource("/imagenes/BOTONES/botOK.png")));
		ok.setBounds(641, 44, 104, 92);
		contentPane.add(ok);
		
		JDateChooser txtfecCont = new JDateChooser();
		txtfecCont.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtfecCont.setBounds(274, 306, 205, 22);
		contentPane.add(txtfecCont);
		
		JDateChooser txtfecNac = new JDateChooser();
		txtfecNac.setBounds(274, 358, 205, 22);
		contentPane.add(txtfecNac);
		
		txtnaci = new JTextField();
		txtnaci.setBounds(274, 407, 205, 22);
		contentPane.add(txtnaci);
		txtnaci.setColumns(10);
		
		JDateChooser txtfecFinCon = new JDateChooser();
		txtfecFinCon.setBounds(274, 465, 203, 22);
		contentPane.add(txtfecFinCon);
		
		JLabel nombre = new JLabel("Nombre:");
		nombre.setForeground(new Color(255, 255, 255));
		nombre.setFont(new Font("Tahoma", Font.PLAIN, 25));
		nombre.setBounds(24, 126, 112, 31);
		contentPane.add(nombre);
		
		JLabel apellido = new JLabel("Apellido:");
		apellido.setForeground(Color.WHITE);
		apellido.setFont(new Font("Tahoma", Font.PLAIN, 25));
		apellido.setBounds(23, 182, 134, 31);
		contentPane.add(apellido);
		
		JLabel cargo = new JLabel("Cargo:");
		cargo.setForeground(Color.WHITE);
		cargo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cargo.setBounds(24, 236, 112, 31);
		contentPane.add(cargo);
		
		JLabel fecCon = new JLabel("Fecha contrataci\u00F3n:");
		fecCon.setForeground(Color.WHITE);
		fecCon.setFont(new Font("Tahoma", Font.PLAIN, 25));
		fecCon.setBounds(24, 295, 225, 31);
		contentPane.add(fecCon);
		
		JLabel fecNac = new JLabel("Fecha nacimiento: ");
		fecNac.setForeground(Color.WHITE);
		fecNac.setFont(new Font("Tahoma", Font.PLAIN, 25));
		fecNac.setBounds(24, 349, 225, 31);
		contentPane.add(fecNac);
		
		JLabel nacionalidad = new JLabel("Nacionalidad: ");
		nacionalidad.setForeground(Color.WHITE);
		nacionalidad.setFont(new Font("Tahoma", Font.PLAIN, 25));
		nacionalidad.setBounds(24, 398, 225, 31);
		contentPane.add(nacionalidad);
		
		JLabel fecFinCon = new JLabel("Fecha fin contrato: ");
		fecFinCon.setForeground(Color.WHITE);
		fecFinCon.setFont(new Font("Tahoma", Font.PLAIN, 25));
		fecFinCon.setBounds(24, 456, 225, 31);
		contentPane.add(fecFinCon);
		
		JLabel altaEmple = new JLabel("| Alta empleados");
		altaEmple.setFont(new Font("Tahoma", Font.BOLD, 25));
		altaEmple.setForeground(new Color(255, 255, 255));
		altaEmple.setBounds(24, 30, 225, 31);
		contentPane.add(altaEmple);
		
		setLocationRelativeTo(null);

	}
}
