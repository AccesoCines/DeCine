package vista;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

import com.toedter.calendar.JDateChooser;

import modelo.Cargo;
import modelo.Empleado;

import java.awt.Rectangle;

public class VAltaEmpl extends JPanel {

	private JPanel contentPane;
	private JTextField txtnombre;
	private JTextField txtapellido;
	private JTextField txtnaci;
	private JComboBox txtcargo;
	private JDateChooser txtfecCont;
	private JDateChooser txtfecNac;
	private JDateChooser txtfecFinCon;
	private String bbdd;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VAltaEmpl() {
	    //setTitle ("Alta empleados"); //TODO pasar al parent
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 800,800));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		contentPane.setBackground(new Color(233, 69, 75));
		
		txtnombre = new JTextField();
		txtnombre.setBounds(296, 200, 336, 31);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);
		
		txtapellido = new JTextField();
		txtapellido.setBounds(296, 250, 336, 31);
		contentPane.add(txtapellido);
		txtapellido.setColumns(10);
		
		JComboBox txtcargo = new JComboBox();
		txtcargo.setBounds(296, 300, 336, 31);
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
		cancelar.setBounds(37, 599, 181, 80);
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
				
				Empleado emple = new Empleado(txtnombre.getText(), txtapellido.getText(), car, (Date) txtfecCont.getDate(), (Date)txtfecNac.getDate(), txtnaci.getText(), (Date)txtfecFinCon.getDate(), true);
	
				emple.guardarEmpleado(bbdd);
				
				//TO DO PROBAR SI FUNSIONA
			}
		});
		ok.setIcon(new ImageIcon(VAltaEmpl.class.getResource("/imagenes/BOTONES/botOK.png")));
		ok.setBounds(651, 50, 91, 80);
		contentPane.add(ok);
		ok.setContentAreaFilled(false);
		
		JDateChooser txtfecCont = new JDateChooser();
		txtfecCont.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtfecCont.setBounds(296, 350, 205, 31);
		contentPane.add(txtfecCont);
		
		JDateChooser txtfecNac = new JDateChooser();
		txtfecNac.setBounds(296, 400, 205, 31);
		contentPane.add(txtfecNac);
		
		txtnaci = new JTextField();
		txtnaci.setBounds(296, 450, 336, 31);
		contentPane.add(txtnaci);
		txtnaci.setColumns(10);
		
		JDateChooser txtfecFinCon = new JDateChooser();
		txtfecFinCon.setBounds(296, 500, 203, 31);
		contentPane.add(txtfecFinCon);
		
		JLabel nombre = new JLabel("Nombre:");
		nombre.setForeground(new Color(255, 255, 255));
		nombre.setFont(new Font("Tahoma", Font.PLAIN, 25));
		nombre.setBounds(50, 200, 112, 31);
		contentPane.add(nombre);
		
		JLabel apellido = new JLabel("Apellido:");
		apellido.setForeground(Color.WHITE);
		apellido.setFont(new Font("Tahoma", Font.PLAIN, 25));
		apellido.setBounds(50, 250, 134, 31);
		contentPane.add(apellido);
		
		JLabel cargo = new JLabel("Cargo:");
		cargo.setForeground(Color.WHITE);
		cargo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cargo.setBounds(50, 300, 112, 31);
		contentPane.add(cargo);
		
		JLabel fecCon = new JLabel("Fecha contrataci\u00F3n:");
		fecCon.setForeground(Color.WHITE);
		fecCon.setFont(new Font("Tahoma", Font.PLAIN, 25));
		fecCon.setBounds(50, 350, 225, 31);
		contentPane.add(fecCon);
		
		JLabel fecNac = new JLabel("Fecha nacimiento: ");
		fecNac.setForeground(Color.WHITE);
		fecNac.setFont(new Font("Tahoma", Font.PLAIN, 25));
		fecNac.setBounds(50, 400, 225, 31);
		contentPane.add(fecNac);
		
		JLabel nacionalidad = new JLabel("Nacionalidad: ");
		nacionalidad.setForeground(Color.WHITE);
		nacionalidad.setFont(new Font("Tahoma", Font.PLAIN, 25));
		nacionalidad.setBounds(50, 450, 225, 31);
		contentPane.add(nacionalidad);
		
		JLabel fecFinCon = new JLabel("Fecha fin contrato: ");
		fecFinCon.setForeground(Color.WHITE);
		fecFinCon.setFont(new Font("Tahoma", Font.PLAIN, 25));
		fecFinCon.setBounds(50, 500, 225, 31);
		contentPane.add(fecFinCon);
		
		JLabel altaEmple = new JLabel("| Alta empleados");
		altaEmple.setFont(new Font("Tahoma", Font.BOLD, 25));
		altaEmple.setForeground(new Color(255, 255, 255));
		altaEmple.setBounds(50, 50, 225, 31);
		contentPane.add(altaEmple);
		
		JLabel lblCine = new JLabel("cine");
		lblCine.setForeground(Color.WHITE);
		lblCine.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblCine.setBounds(75, 100, 225, 31);
		contentPane.add(lblCine);
		
		JButton okey = new JButton("");
		okey.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		okey.setBorder(null);
		okey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

	}
	

	public JPanel getPanelVentana() {
		return this;
	}
}
