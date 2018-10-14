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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import java.awt.Font;
import com.toedter.calendar.JYearChooser;
import javax.swing.JTextPane;

public class VAltaPelicula extends JFrame {

	private JPanel contentPane;
	private JTextField txtDirector;
	private JTextField txtDuracion;
	private JTextField txtTitulo;
	private JTextField txtActorPrincipal;
	private JTextField txtActorSecundario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VAltaPelicula frame = new VAltaPelicula();
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
	public VAltaPelicula() {
		
		setBounds(new Rectangle(0, 0, 800, 800));
		
		// Poner icono ventana
		setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());
		
		setExtendedState(Frame.NORMAL);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		getContentPane().setBackground(new Color(233, 69, 75));
		contentPane.setLayout(null);
		
		txtDirector = new JTextField();
		txtDirector.setColumns(10);
		txtDirector.setBounds(349, 238, 204, 22);
		contentPane.add(txtDirector);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBounds(50, 620, 244, 107);
		contentPane.add(btnCancelar);
		btnCancelar.setIcon(new ImageIcon(VAltaEmpl.class.getResource("/imagenes/BOTONES/botCANCELAR.png")));
		
		JButton btnOk = new JButton("");
		btnOk.setContentAreaFilled(false);
		btnOk.setBounds(609, 38, 126, 99);
		contentPane.add(btnOk);
		btnOk.setIcon(new ImageIcon(VAltaEmpl.class.getResource("/imagenes/BOTONES/botOK.png")));
		
		txtDuracion = new JTextField();
		txtDuracion.setColumns(10);
		txtDuracion.setBounds(349, 415, 205, 22);
		contentPane.add(txtDuracion);
		
		JLabel titulo = new JLabel("T\u00EDtulo: ");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		titulo.setBounds(50, 148, 112, 31);
		contentPane.add(titulo);
		
		JLabel anyoEstreno = new JLabel("A\u00F1o de estreno:");
		anyoEstreno.setForeground(Color.WHITE);
		anyoEstreno.setFont(new Font("Tahoma", Font.PLAIN, 25));
		anyoEstreno.setBounds(50, 192, 192, 31);
		contentPane.add(anyoEstreno);
		
		JLabel director = new JLabel("Director:");
		director.setForeground(Color.WHITE);
		director.setFont(new Font("Tahoma", Font.PLAIN, 25));
		director.setBounds(50, 238, 112, 31);
		contentPane.add(director);
		
		JLabel actorPrincipal = new JLabel("Actor principal:");
		actorPrincipal.setForeground(Color.WHITE);
		actorPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		actorPrincipal.setBounds(50, 282, 225, 31);
		contentPane.add(actorPrincipal);
		
		JLabel actorSecundario = new JLabel("Actor secundario:");
		actorSecundario.setForeground(Color.WHITE);
		actorSecundario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		actorSecundario.setBounds(50, 327, 225, 31);
		contentPane.add(actorSecundario);
		
		JLabel sinopsis = new JLabel("Sinopsis:");
		sinopsis.setForeground(Color.WHITE);
		sinopsis.setFont(new Font("Tahoma", Font.PLAIN, 25));
		sinopsis.setBounds(50, 371, 225, 31);
		contentPane.add(sinopsis);
		
		JLabel duracion = new JLabel("Duraci\u00F3n:");
		duracion.setForeground(Color.WHITE);
		duracion.setFont(new Font("Tahoma", Font.PLAIN, 25));
		duracion.setBounds(50, 415, 225, 31);
		contentPane.add(duracion);
		
		JLabel altaPelicula = new JLabel("| Alta pel\u00EDcula");
		altaPelicula.setForeground(Color.WHITE);
		altaPelicula.setFont(new Font("Tahoma", Font.BOLD, 25));
		altaPelicula.setBounds(40, 34, 330, 31);
		contentPane.add(altaPelicula);
		
		JLabel cine = new JLabel("cine");
		cine.setForeground(Color.WHITE);
		cine.setFont(new Font("Tahoma", Font.BOLD, 25));
		cine.setBounds(106, 78, 225, 31);
		contentPane.add(cine);
		
		txtTitulo = new JTextField();
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(349, 148, 204, 22);
		contentPane.add(txtTitulo);
		
		JYearChooser txtAnyoEstreno = new JYearChooser();
		txtAnyoEstreno.setBounds(349, 192, 204, 22);
		contentPane.add(txtAnyoEstreno);
		
		txtActorPrincipal = new JTextField();
		txtActorPrincipal.setBounds(349, 280, 204, 22);
		contentPane.add(txtActorPrincipal);
		txtActorPrincipal.setColumns(10);
		
		txtActorSecundario = new JTextField();
		txtActorSecundario.setBounds(349, 327, 205, 22);
		contentPane.add(txtActorSecundario);
		txtActorSecundario.setColumns(10);
		
		JTextPane txtSinopsis = new JTextPane();
		txtSinopsis.setBounds(349, 371, 204, 22);
		contentPane.add(txtSinopsis);
		
		JLabel trailer = new JLabel("Trailer: ");
		trailer.setForeground(Color.WHITE);
		trailer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		trailer.setBounds(50, 471, 225, 31);
		contentPane.add(trailer);
		
		JLabel fechaInicio = new JLabel("Fecha inicio:");
		fechaInicio.setForeground(Color.WHITE);
		fechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 25));
		fechaInicio.setBounds(50, 515, 225, 31);
		contentPane.add(fechaInicio);
		
		JLabel fechaFin = new JLabel("Fecha fin:");
		fechaFin.setForeground(Color.WHITE);
		fechaFin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		fechaFin.setBounds(50, 559, 225, 31);
		contentPane.add(fechaFin);
		
		JDateChooser txtFechaInicio = new JDateChooser();
		txtFechaInicio.setBounds(349, 515, 204, 22);
		contentPane.add(txtFechaInicio);
		
		JDateChooser txtFechaFin = new JDateChooser();
		txtFechaFin.setBounds(349, 559, 204, 22);
		contentPane.add(txtFechaFin);
		
		setLocationRelativeTo(null);
	}
}
