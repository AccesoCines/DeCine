package vista;


import java.io.File;


import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Frame;

public class VCines extends JFrame {

	private JPanel contentPane;
	public static JRadioButton rbPrincipe;
	public static JRadioButton rbZubiarte;
	public static JRadioButton rbAzul;
	private JButton btnEntrarCines;
	private JButton btnInfoCines;
	private JButton cancelar;
	private JButton volver;
	private JButton btnCartelera;
	private static String[] nombres;
	public static boolean verdadero;
	public static ButtonGroup grupoBotones;
	public static VCines verCines;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VCines frame = new VCines();
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
	public VCines() {
		
		// Poner icono ventana
		setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());
		
	//	setBounds(0, 0, 800, 800);
		
		setExtendedState(Frame.NORMAL);	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		
	
		contentPane.setBackground(new Color(233, 69, 75));
		contentPane.setForeground(new Color(233, 69, 75));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setBounds(100, 100, 800, 800);

	/*
		JButton btnEntrarCines = new JButton("");
		btnEntrarCines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TO DO CAMBIAR VENTANA A LA QUE VA
				if (rbZubiarte.isSelected() || rbPrincipe.isSelected() || rbAzul.isSelected()) {
					
					
				}
					
					
					
					
					
				else {
					
		
							try {
								String cine = elegirBBDD(cbCines.getSelectedItem().toString());
								if(!cine.equals("")) {	
									vmd.setBbdd(elegirBBDD(cbCines.getSelectedItem().toString()));
									vmd.cargarFormulario();
									vmd.setVisible(true);
									jframe.dispose();
								}
							}catch(NullPointerException ex ) {
								JOptionPane.showMessageDialog(getParent(), "Debes elegir un cine en el desplegable", "Error", JOptionPane.WARNING_MESSAGE);
							}						
					});
		
		
		
				
			VAltaSalas salas = new VAltaSalas();
			salas.setVisible(true);
			VCines.this.dispose();		
			}
		});
		
		*/
		//btnEntrarCines.setContentAreaFilled(false);
	//	btnEntrarCines.setBounds(231, 123, 107, 89);
	//	contentPane.add(btnEntrarCines);
	//	btnEntrarCines.setIcon(new ImageIcon(VAltaEmpl.class.getResource("/imagenes/CLAQUETAS/clac CARTELERA.png")));
		
		
		
		
		JButton btnCartelera;
		btnCartelera = new JButton("");
		btnCartelera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VVerCartelera cartel = new VVerCartelera();
				cartel.setVisible(true);
				VCines.this.dispose();					
			}
		});
		btnCartelera.setContentAreaFilled(false);
		btnCartelera.setBounds(179, 123, 107, 89);
		contentPane.add(btnCartelera);
		btnCartelera.setIcon(new ImageIcon(getClass().getResource("/imagenes/CLAQUETAS/clac cartelera.png")));

		
		
		
		
		
		
		 btnInfoCines = new JButton("");
		btnInfoCines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//VInfoCine cines = new VInfoCine();
				//cines.setVisible(true);
				//VCines.this.dispose();
				
			//	if (VCines.rbZubiarte.isSelected()) {
			//		VInfoCine.textFieldNombreCine.setText("Zubiardfdfd");
				VInfoCine mod= new VInfoCine();

				VInfoCine.textFieldNombreCine.setText("Zubiarte 3D");
				VCines.this.setVisible(false);
				VCines.this.dispose();
				mod.setLocationRelativeTo(null);
				    mod.setVisible(true);		

			
/*			
 * 	VInfoCine mod= new VInfoCine();
				if ((rbZubiarte).isEnabled()) {
					verdadero = true;	
				}else {
					
					verdadero = false;
				}
				if (verdadero == true) {
					mod.setVisible(true);
					VInfoCine.textFieldNombreCine.setText("Zubiarte");
					VCines.this.setVisible(false);
					VCines.this.dispose();
					mod.setLocationRelativeTo(null);
					    mod.setVisible(true);		
				}else {
					
					mod.setVisible(true);
					VInfoCine.textFieldNombreCine.setText("Zubiarte");
					VCines.this.setVisible(false);
					VCines.this.dispose();
					mod.setLocationRelativeTo(null);
					    mod.setVisible(true);		
				}
 */
							//	}
				
			}
		});
		
		
		btnInfoCines.setContentAreaFilled(false);
		btnInfoCines.setBounds(441, 123, 107, 89);
		contentPane.add(btnInfoCines);
		btnInfoCines.setIcon(new ImageIcon(getClass().getResource("/imagenes/CLAQUETAS/clac infocine.png")));

		JButton cancelar = new JButton("");
		cancelar.setBorderPainted(false);
		cancelar.setIcon(new ImageIcon(getClass().getResource("/imagenes/BOTONES/botCANCELAR.png")));
		cancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				VCines.this.dispose();
				}
		});
		cancelar.setBounds(37, 599, 244, 107);
		contentPane.add(cancelar);
		cancelar.setContentAreaFilled(false);
		
		
//		
//	
//		btnEntrarCines.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				
//				String texto="Seleccionar cine";
//				btnEntrarCines.setToolTipText(texto);
//				
//				
//		
//			}
//		});
		
		
		
		
		
		
	/*	
		JCheckBox checkBoxPrincipe = new JCheckBox("  PRï¿½NCIPE (Cine Comercial)");
		checkBoxPrincipe.setForeground(Color.WHITE);
		checkBoxPrincipe.setFont(new Font("Tahoma", Font.PLAIN, 50));
		checkBoxPrincipe.setBounds(551, 732, 2000, 46);
		contentPane.add(checkBoxPrincipe);
		checkBoxPrincipe.setContentAreaFilled(false);
		
		JCheckBox checkBoxAzul = new JCheckBox("  AZUL (Cine Experimental)");
		checkBoxAzul.setForeground(Color.WHITE);
		checkBoxAzul.setFont(new Font("Tahoma", Font.PLAIN, 50));
		checkBoxAzul.setBounds(551, 809, 2000, 46);
		contentPane.add(checkBoxAzul);
		checkBoxAzul.setContentAreaFilled(false);
		
		
		JCheckBox checkBoxJunior = new JCheckBox("  JUNIOR YELMO (Cine Infantil)");
		checkBoxJunior.setForeground(Color.WHITE);
		checkBoxJunior.setFont(new Font("Tahoma", Font.PLAIN, 50));
		checkBoxJunior.setBounds(551, 885, 2000, 46);
		contentPane.add(checkBoxJunior);
		checkBoxJunior.setContentAreaFilled(false);
		
		
		*/
		
		
		
		
		
		JRadioButton rbPrincipe = new JRadioButton("  PR\u00CDNCIPE (Cine Comercial)");
		rbPrincipe.setForeground(Color.WHITE);
		rbPrincipe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rbPrincipe.setBounds(198, 317, 482, 46);
		contentPane.add(rbPrincipe);
		rbPrincipe.setContentAreaFilled(false);
		
		
		JRadioButton rbZubiarte = new JRadioButton("  ZUBIARTE 3D (Cine documental)");
		rbZubiarte.setForeground(Color.WHITE);
		rbZubiarte.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rbZubiarte.setBounds(198, 388, 482, 46);
		contentPane.add(rbZubiarte);
		rbZubiarte.setContentAreaFilled(false);
		
		
		JRadioButton rbAzul = new JRadioButton("  AZUL (Cine Experimental)");
		rbAzul.setForeground(Color.WHITE);
		rbAzul.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rbAzul.setBounds(198, 455, 482, 46);
		contentPane.add(rbAzul);
		rbAzul.setContentAreaFilled(false);
		
		String [] nombres = {"Cinesa Zubiarte 3D", "Cine Príncipe", "Cine Azul" };
		
		
		
		
		  ButtonGroup grupoBotones = new ButtonGroup();
		  grupoBotones.add(rbPrincipe);
		  grupoBotones.add(rbZubiarte);
		  grupoBotones.add(rbAzul);
		//    if (rbPrincipe.isSelected() || rbZubiarte.isSelected() || rbAzul.isSelected()) {
		 //   }else
		  //  {

		  //  }
		    
	}
}
