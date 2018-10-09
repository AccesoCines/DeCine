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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Frame;

public class VCines extends JFrame {

	private JPanel contentPane;
	private JRadioButton rbPrincipe;
	private JRadioButton rbZubiarte;
	private JRadioButton rbAzul;
	private JRadioButton rbYelmo;
	private JLabel lbAdvertenciaCines;
	private ButtonGroup btnGroup;
	private JButton botonCartelera;

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
		
		setBounds(0, 0, 800, 800);
		
		setExtendedState(Frame.NORMAL);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		
	/*	
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 800, 800));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(new Color(233, 69, 75));
*/
		
		contentPane.setBackground(new Color(233, 69, 75));
		contentPane.setForeground(new Color(233, 69, 75));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setBounds(100, 100, 1200, 1200);

		
	//	JButton botonAlta = new JButton(new ImageIcon("botALTA.png"));
	//	botonAlta.setBounds (0, 0, 0, 0);
	//	contentPane.add(botonAlta);
		
		/*M�todo mostrado por Gregg Bolinger en JavaRanch*/ImageIcon icon = new ImageIcon("..\\imagenes\\imagenesBOTONES\\botALTA.png");
		Image img = icon.getImage(); //convertimos icon en una imagen
		 //creamos una imagen nueva d�ndole las dimensiones que queramos a la antigua		
		Image otraimg = img.getScaledInstance(452,350,java.awt.Image.SCALE_SMOOTH);
		ImageIcon otroicon = new ImageIcon(otraimg);
		
		JButton botonCartelera = new JButton(new ImageIcon(VCines.class.getResource("/imagenes/CLAQUETAS/clac cartelera.png")));
		botonCartelera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				System.out.println("He pulsado");
				

				if ( rbPrincipe.isSelected()) {
					
					lbAdvertenciaCines.setVisible(false);
					
				}
				else
				{
					lbAdvertenciaCines.setVisible(true);
					
				}
				
			}
		});
		//botonCartelera.setFont(new Font("Tahoma", Font.PLAIN, 50));
		botonCartelera.setBounds(new Rectangle(100, 100, 452, 350));
		botonCartelera.setAlignmentX(Component.CENTER_ALIGNMENT);
		botonCartelera.setPreferredSize(new Dimension(452, 350));
		botonCartelera.setSelectedIcon(new ImageIcon("..\\imagenes\\imagenesBOTONES\\botALTA.png"));
		botonCartelera.setContentAreaFilled(false);
		botonCartelera.setContentAreaFilled(false);
		botonCartelera.setBorderPainted(false);

		
		botonCartelera.setBounds(133, 177, 131, 97);
		contentPane.add(botonCartelera);
		botonCartelera.setMargin(null);

		
		
	
		botonCartelera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				
				
		
			}
		});
		
		
		Image img2 = icon.getImage(); //convertimos icon en una imagen
		Image otraimg2 = img.getScaledInstance(452,350,java.awt.Image.SCALE_SMOOTH); //creamos una imagen nueva d�ndole las dimensiones que queramos a la antigua		
		ImageIcon otroicon2 = new ImageIcon(otraimg2);
		JButton btBotonSalas = new JButton(new ImageIcon(VCines.class.getResource("/imagenes/CLAQUETAS/clac SALAS.png")));
		btBotonSalas.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btBotonSalas.setContentAreaFilled(false);
		btBotonSalas.setBorderPainted(false);
		//botonSalas.setBorderPainted(false);
		
		btBotonSalas.setBounds(1028, 18, 657, 520);
		contentPane.add(btBotonSalas);
		
		
		btBotonSalas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});

		
		
		
	/*	
		JCheckBox checkBoxPrincipe = new JCheckBox("  PR�NCIPE (Cine Comercial)");
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
		rbPrincipe.setBounds(159, 329, 2000, 46);
		contentPane.add(rbPrincipe);
		rbPrincipe.setContentAreaFilled(false);
		
		
		JRadioButton rbZubiarte = new JRadioButton("  ZUBIARTE 3D (Cine documental)");
		rbZubiarte.setForeground(Color.WHITE);
		rbZubiarte.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rbZubiarte.setBounds(159, 400, 2000, 46);
		contentPane.add(rbZubiarte);
		rbZubiarte.setContentAreaFilled(false);
		
		
		JRadioButton rbAzul = new JRadioButton("  AZUL (Cine Experimental)");
		rbAzul.setForeground(Color.WHITE);
		rbAzul.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rbAzul.setBounds(159, 467, 2000, 46);
		contentPane.add(rbAzul);
		rbAzul.setContentAreaFilled(false);
		
		
		JRadioButton rbYelmo = new JRadioButton("  JUNIOR YELMO (Cine Infantil)");
		rbYelmo.setForeground(Color.WHITE);
		rbYelmo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rbYelmo.setBounds(159, 542, 2000, 46);
		contentPane.add(rbYelmo);
		rbYelmo.setContentAreaFilled(false);
		
		 
		
		
		  ButtonGroup btnGroup = new ButtonGroup();
		    btnGroup.add(rbPrincipe);
		    btnGroup.add(rbZubiarte);
		    btnGroup.add(rbAzul);
		    btnGroup.add(rbYelmo);
		    
		    
		    
		    
		    JLabel lbAdvertenciaCines = new JLabel("Seleccionar Cine");
		    lbAdvertenciaCines.setVisible(false);
		    lbAdvertenciaCines.setBackground(Color.GREEN);
		    lbAdvertenciaCines.setHorizontalAlignment(SwingConstants.CENTER);
		    lbAdvertenciaCines.setFont(new Font("Tahoma", Font.PLAIN, 25));
		    lbAdvertenciaCines.setBounds(294, 220, 242, 51);
		    contentPane.add(lbAdvertenciaCines);


		    setLocationRelativeTo(null);
		
	}
	

	
	
	
	
	
}
