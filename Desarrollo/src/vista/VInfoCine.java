package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VInfoCine extends JFrame {

	private JPanel contentPane;
	private String bbdd;
	private static VInfoCine frame;
	public static JTextField textFieldNombreCine;
	public static JLabel txtTipo;
	public static JLabel txtFechFund;
	public static  JLabel txtDireccion;
	public static JLabel txtTelefono;
	public static JLabel txtNumSalas;
	public static JTextField textFieldFUND;
	public static JTextField textFielTipoCine;
	public static JTextField textFieldDirecc;
	public static JTextField textFieldTel;
	public static JTextField textFieldNumSalas;
	
	

	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VInfoCine frame = new VInfoCine();
					frame.setVisible(true);	

				} catch (Exception e) {
					e.printStackTrace();					
					}
				
			}
		});
		
	
	}


	public VInfoCine() {
		
		setBounds(new Rectangle(0, 0, 800, 800));
		
		// Poner icono ventana
		setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());
		
		setExtendedState(Frame.NORMAL);
		
		//TODO ARRAY CON DATOS DEL CINE QUE SE CARGUE EN EL PANEL
		/*
		String[] tipo = {"Cine documental","Cine comercial", "Cine experimental" };
		String[] fechaFund = {"2003", "1950", "1980"};
		String[] direcciones = {"Centro comercial Zubiarte. 48009 Bilbao (Vizcaya)", "San Juan Kalea, 10", "Plaza Zaldiaran 10"};
		String[] telefonos = {"944235490", "943510306", "945253801"};
		*/
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		getContentPane().setBackground(new Color(233, 69, 75));
		contentPane.setLayout(null);
		
		JLabel lblInformacinDel = new JLabel("| Informaci\u00F3n del cine");
		lblInformacinDel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblInformacinDel.setForeground(Color.WHITE);
		lblInformacinDel.setBounds(59, 45, 354, 47);
		contentPane.add(lblInformacinDel);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTipo.setBounds(106, 205, 401, 25);
		contentPane.add(lblTipo);
		
		JLabel fechaFundacion = new JLabel("Fecha fundaci\u00F3n: ");
		fechaFundacion.setForeground(Color.WHITE);
		fechaFundacion.setFont(new Font("Tahoma", Font.BOLD, 25));
		fechaFundacion.setBounds(106, 299, 310, 25);
		contentPane.add(fechaFundacion);
		
		JLabel direccion = new JLabel("Direcci\u00F3n:");
		direccion.setForeground(Color.WHITE);
		direccion.setFont(new Font("Tahoma", Font.BOLD, 25));
		direccion.setBounds(107, 395, 127, 25);
		contentPane.add(direccion);
		
		JLabel telefono = new JLabel("Tel\u00E9fono: ");
		telefono.setForeground(Color.WHITE);
		telefono.setFont(new Font("Tahoma", Font.BOLD, 25));
		telefono.setBounds(103, 491, 127, 25);
		contentPane.add(telefono);
		
		
		
		JLabel numSalas = new JLabel("N\u00FAmero de salas:");
		numSalas.setForeground(Color.WHITE);
		numSalas.setFont(new Font("Tahoma", Font.BOLD, 25));
		numSalas.setBounds(106, 587, 373, 25);
		contentPane.add(numSalas);
		
		JButton volver = new JButton("New button");
		volver.setBorder(null);
		volver.setContentAreaFilled(false);;
		volver.setBounds(50, 647, 155, 90);
		contentPane.add(volver);
		volver.setIcon(new ImageIcon(getClass().getResource("/imagenes/BOTONES/botVOLVER.png")));
		
		textFieldNombreCine = new JTextField();
		textFieldNombreCine.setBackground(Color.BLACK);
		textFieldNombreCine.setForeground(Color.WHITE);
		textFieldNombreCine.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldNombreCine.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textFieldNombreCine.setBounds(93, 108, 656, 66);
		contentPane.add(textFieldNombreCine);
		
		textFieldFUND = new JTextField();
		textFieldFUND.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textFieldFUND.setBounds(142, 339, 585, 26);
		contentPane.add(textFieldFUND);
		textFieldFUND.setColumns(10);
		
		textFielTipoCine = new JTextField();
		textFielTipoCine.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textFielTipoCine.setColumns(10);
		textFielTipoCine.setBounds(139, 247, 585, 26);
		contentPane.add(textFielTipoCine);
		
		textFieldDirecc = new JTextField();
		textFieldDirecc.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textFieldDirecc.setColumns(10);
		textFieldDirecc.setBounds(139, 436, 585, 26);
		contentPane.add(textFieldDirecc);
		
		textFieldTel = new JTextField();
		textFieldTel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textFieldTel.setColumns(10);
		textFieldTel.setBounds(139, 534, 585, 26);
		contentPane.add(textFieldTel);
		
		textFieldNumSalas = new JTextField();
		textFieldNumSalas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textFieldNumSalas.setColumns(10);
		textFieldNumSalas.setBounds(139, 628, 585, 26);
		contentPane.add(textFieldNumSalas);
		
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VCines cines = new VCines();
				cines.setVisible(true);
				
				VInfoCine.this.dispose();
			}
		});
		
		setLocationRelativeTo(null);
		
		
	}
	public void setcine (String cin) {
		
		textFieldNombreCine.setText(cin);
	}


	public void setBBDD(String bbdd) {
		this.bbdd = bbdd;
		
	}
	
	public void inaugu (String n) {
		txtFechFund.setText(n);
	}
}
