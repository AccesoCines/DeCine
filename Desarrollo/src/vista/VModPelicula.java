package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import com.toedter.calendar.JDateChooser;

public class VModPelicula extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtAnyoEstreno;
	private JTextField txtDirector;
	private JTextField txtActorPrincipal;
	private JTextField txtActorSecundario;
	private JTextField txtDuracion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VModPelicula frame = new VModPelicula();
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
	public VModPelicula() {
		
		setBounds(new Rectangle(0, 0, 800, 800));
		
		// Poner icono ventana
		setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());
		
		setExtendedState(Frame.NORMAL);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		getContentPane().setBackground(new Color(233, 69, 75));
		contentPane.setLayout(null);
		
		JLabel modificacionPelicula = new JLabel("| Modificaci\u00F3n pel\u00EDcula");
		modificacionPelicula.setForeground(Color.WHITE);
		modificacionPelicula.setFont(new Font("Tahoma", Font.BOLD, 25));
		modificacionPelicula.setBounds(50, 41, 330, 31);
		contentPane.add(modificacionPelicula);
		
		JLabel cine = new JLabel("cine");
		cine.setForeground(Color.WHITE);
		cine.setFont(new Font("Tahoma", Font.BOLD, 25));
		cine.setBounds(100, 102, 225, 31);
		contentPane.add(cine);
		
		JButton btnOk = new JButton("");
		btnOk.setContentAreaFilled(false);
		btnOk.setBounds(603, 50, 126, 99);
		contentPane.add(btnOk);
		btnOk.setIcon(new ImageIcon(VAltaEmpl.class.getResource("/imagenes/BOTONES/botOK.png")));
		
		JLabel titulo = new JLabel("T\u00EDtulo: ");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		titulo.setBounds(50, 167, 112, 31);
		contentPane.add(titulo);
		
		JLabel anyoEstreno = new JLabel("A\u00F1o de estreno:");
		anyoEstreno.setForeground(Color.WHITE);
		anyoEstreno.setFont(new Font("Tahoma", Font.PLAIN, 25));
		anyoEstreno.setBounds(50, 211, 192, 31);
		contentPane.add(anyoEstreno);
		
		JLabel director = new JLabel("Director:");
		director.setForeground(Color.WHITE);
		director.setFont(new Font("Tahoma", Font.PLAIN, 25));
		director.setBounds(50, 257, 112, 31);
		contentPane.add(director);
		
		JLabel actorPrincipal = new JLabel("Actor principal:");
		actorPrincipal.setForeground(Color.WHITE);
		actorPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		actorPrincipal.setBounds(50, 301, 225, 31);
		contentPane.add(actorPrincipal);
		
		JLabel actorSecundario = new JLabel("Actor secundario:");
		actorSecundario.setForeground(Color.WHITE);
		actorSecundario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		actorSecundario.setBounds(50, 346, 225, 31);
		contentPane.add(actorSecundario);
		
		JLabel sinopsis = new JLabel("Sinopsis:");
		sinopsis.setForeground(Color.WHITE);
		sinopsis.setFont(new Font("Tahoma", Font.PLAIN, 25));
		sinopsis.setBounds(50, 390, 225, 31);
		contentPane.add(sinopsis);
		
		JLabel duracion = new JLabel("Duraci\u00F3n:");
		duracion.setForeground(Color.WHITE);
		duracion.setFont(new Font("Tahoma", Font.PLAIN, 25));
		duracion.setBounds(50, 434, 225, 31);
		contentPane.add(duracion);
		
		JLabel trailer = new JLabel("Trailer: ");
		trailer.setForeground(Color.WHITE);
		trailer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		trailer.setBounds(50, 490, 225, 31);
		contentPane.add(trailer);
		
		JLabel fechaInicio = new JLabel("Fecha inicio:");
		fechaInicio.setForeground(Color.WHITE);
		fechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 25));
		fechaInicio.setBounds(50, 534, 225, 31);
		contentPane.add(fechaInicio);
		
		JLabel fechaFin = new JLabel("Fecha fin:");
		fechaFin.setForeground(Color.WHITE);
		fechaFin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		fechaFin.setBounds(50, 578, 225, 31);
		contentPane.add(fechaFin);
		
		txtTitulo = new JTextField();
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(315, 167, 204, 22);
		contentPane.add(txtTitulo);
		
		txtAnyoEstreno = new JTextField();
		txtAnyoEstreno.setColumns(10);
		txtAnyoEstreno.setBounds(315, 211, 204, 22);
		contentPane.add(txtAnyoEstreno);
		
		txtDirector = new JTextField();
		txtDirector.setColumns(10);
		txtDirector.setBounds(315, 257, 204, 22);
		contentPane.add(txtDirector);
		
		txtActorPrincipal = new JTextField();
		txtActorPrincipal.setColumns(10);
		txtActorPrincipal.setBounds(315, 301, 204, 22);
		contentPane.add(txtActorPrincipal);
		
		txtActorSecundario = new JTextField();
		txtActorSecundario.setColumns(10);
		txtActorSecundario.setBounds(315, 346, 205, 22);
		contentPane.add(txtActorSecundario);
		
		JTextPane txtSinopsis = new JTextPane();
		txtSinopsis.setBounds(315, 390, 204, 22);
		contentPane.add(txtSinopsis);
		
		txtDuracion = new JTextField();
		txtDuracion.setColumns(10);
		txtDuracion.setBounds(315, 434, 205, 22);
		contentPane.add(txtDuracion);
		
		JDateChooser txtFecIni = new JDateChooser();
		txtFecIni.setBounds(315, 534, 204, 22);
		contentPane.add(txtFecIni);
		
		JDateChooser txtFecFin = new JDateChooser();
		txtFecFin.setBounds(315, 578, 204, 22);
		contentPane.add(txtFecFin);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBounds(60, 633, 244, 107);
		contentPane.add(btnCancelar);
		btnCancelar.setIcon(new ImageIcon(VAltaEmpl.class.getResource("/imagenes/BOTONES/botCANCELAR.png")));
		
		setLocationRelativeTo(null);
		
	}
}
