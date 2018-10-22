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

	
		
		JButton btnCartelera;
		btnCartelera = new JButton("");
		btnCartelera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VVerCartelera vme = new VVerCartelera();
				vme.setVisible(true);
				if(rbZubiarte.isSelected()) {
					vme.setcine(rbZubiarte.getText());
					vme.setBBDD("db4o");		
				}
				if(rbAzul.isSelected()) {
					vme.setcine(rbAzul.getText());
					vme.setBBDD("postgre");
				}
				if(rbPrincipe.isSelected()) {
					vme.setcine(rbPrincipe.getText());
					vme.setBBDD("sqlite");
				}

				VCines.this.dispose();
			}
		});
		btnCartelera.setContentAreaFilled(false);
		btnCartelera.setBounds(179, 123, 107, 89);
		contentPane.add(btnCartelera);
		btnCartelera.setIcon(new ImageIcon(getClass().getResource("/imagenes/CLAQUETAS/clac cartelera.png")));

		
		String[] tipo = {"Cine documental","Cine comercial", "Cine experimental" };
		String[] fechaFund = {"2003", "1950", "1980"};
		String[] direcciones = {"Centro comercial Zubiarte. 48009 Bilbao (Vizcaya)", "San Juan Kalea, 10", "Plaza Zaldiaran 10"};
		String[] telefonos = {"944235490", "943510306", "945253801"};
		
			
		 btnInfoCines = new JButton("");
		btnInfoCines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VInfoCine mod= new VInfoCine();
				
				
				    
				    if(rbZubiarte.isSelected()) {
						VInfoCine vme = new VInfoCine();
						vme.setVisible(true);
						vme.setcine(rbZubiarte.getText());
						vme.textFieldFUND.setText("2003");
						vme.textFieldDirecc.setText("Centro comercial Zubiarte. 48009 Bilbao (Vizcaya)");
						vme.textFieldNumSalas.setText("10");
						vme.textFieldTel.setText("944359845");
						vme.textFielTipoCine.setText("Comercial");
						VCines.this.dispose();						
					}
				    
				    if(rbPrincipe.isSelected()) {
						VInfoCine vme = new VInfoCine();
						vme.setVisible(true);
						vme.setcine(rbPrincipe.getText());
						vme.textFieldFUND.setText("1950");
						vme.textFieldDirecc.setText("San Juan Kalea, 10");
						vme.textFieldNumSalas.setText("8");
						vme.textFieldTel.setText("943510306");
						vme.textFielTipoCine.setText("Documental");
						VCines.this.dispose();
					}
				 
				    if(rbAzul.isSelected()) {
						VInfoCine vme = new VInfoCine();
						vme.setVisible(true);
						vme.setcine(rbAzul.getText());
						vme.textFieldFUND.setText("1980");
						vme.textFieldDirecc.setText("Pza. Zaldiaran, 4");
						vme.textFieldNumSalas.setText("4");
						vme.textFieldTel.setText("945253801");
						vme.textFielTipoCine.setText("Experimental");
						VCines.this.dispose();
					}
				
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
				
			}});
		cancelar.setBounds(37, 599, 244, 107);
		contentPane.add(cancelar);
		cancelar.setContentAreaFilled(false);
		
		
		
		rbPrincipe = new JRadioButton("  PR\u00CDNCIPE (Cine Comercial)");
		rbPrincipe.setForeground(Color.WHITE);
		rbPrincipe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rbPrincipe.setBounds(198, 317, 482, 46);
		contentPane.add(rbPrincipe);
		rbPrincipe.setContentAreaFilled(false);
		
		
		
		rbZubiarte = new JRadioButton("  ZUBIARTE 3D (Cine documental)");
		rbZubiarte.setForeground(Color.WHITE);
		rbZubiarte.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rbZubiarte.setBounds(198, 388, 482, 46);
		contentPane.add(rbZubiarte);
		rbZubiarte.setContentAreaFilled(false);
		rbZubiarte.setActionCommand("zubi");
		
		
		rbAzul = new JRadioButton("  AZUL (Cine Experimental)");
		rbAzul.setForeground(Color.WHITE);
		rbAzul.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rbAzul.setBounds(198, 455, 482, 46);
		contentPane.add(rbAzul);
		rbAzul.setContentAreaFilled(false);
		
		
		  ButtonGroup grupoBotones = new ButtonGroup();
		  grupoBotones.add(rbPrincipe);
		  grupoBotones.add(rbZubiarte);
		  grupoBotones.add(rbAzul);
		  
		  setLocationRelativeTo(null);
		    
	}
}
