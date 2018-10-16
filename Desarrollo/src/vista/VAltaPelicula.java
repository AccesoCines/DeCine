package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import com.toedter.calendar.JYearChooser;

import modelo.Cargo;
import modelo.Pelicula;

import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class VAltaPelicula extends JFrame {

	private JPanel contentPane;
	private JTextField txtDirector;
	private JTextField txtDuracion;
	private JTextField txtTitulo;
	private JTextField txtActorPrincipal;
	private JTextField txtActorSecundario;
	private JDateChooser txtFechaInicio;
	private JDateChooser txtFechaFin;
	private static VAltaPelicula frame;
	private JTextField txtTrailer;
	private JYearChooser txtAnyoEstreno;
	private JTextArea txtSinopsis;
	private String bbdd;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VAltaPelicula();
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
		txtDirector.setBounds(275, 188, 350, 25);
		contentPane.add(txtDirector);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				VListado vl = new VListado();
				vl.setVisible(true);
			}
		});
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBounds(50, 647, 181, 80);
		contentPane.add(btnCancelar);
		btnCancelar.setIcon(new ImageIcon(VAltaEmpl.class.getResource("/imagenes/BOTONES/botCANCELAR.png")));
		
		JButton btnOk = new JButton("");
		btnOk.setContentAreaFilled(false);
		btnOk.setBounds(669, 34, 91, 80);
		contentPane.add(btnOk);
		btnOk.setIcon(new ImageIcon(VAltaEmpl.class.getResource("/imagenes/BOTONES/botOK.png")));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = txtTitulo.getText();
				int anyo = txtAnyoEstreno.getValue();
				int duracion=0;
				try {
					duracion = Integer.parseInt(txtDuracion.getText());
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(getParent(), "Comprueba que la duración "
							+ "es un número", "Error", JOptionPane.WARNING_MESSAGE);
					
				}
				String director = txtDirector.getText();
				String actorPrin = txtActorPrincipal.getText();
				String actorSecun = txtActorSecundario.getText();
				Date fechaIni = (Date) txtFechaInicio.getDate();
				Date fechaFin = (Date) txtFechaFin.getDate();
				String trailer = txtTrailer.getText();
				String sinopsis = txtSinopsis.getText();
				
				if(titulo.equals("") || director.equals("") || actorPrin.equals("")
						|| actorSecun.equals("") || fechaIni.toString().equals("") ||
						fechaFin.toString().equals("") || trailer.equals("") ||
						sinopsis.equals("") || anyo==0 || duracion==0) {
					JOptionPane.showMessageDialog(getParent(), "Debes rellenar todos los campos"
							, "Error", JOptionPane.WARNING_MESSAGE);
				}else {
					Pelicula p = new Pelicula(titulo,anyo,director,actorPrin,actorSecun,sinopsis,
							duracion,trailer,fechaIni,fechaFin,true);
					boolean correcto = p.guardarPelicula(bbdd);
					if(correcto) {
						JOptionPane.showMessageDialog(getParent(), "Guardado correctamente!"
								, "Guardado", JOptionPane.PLAIN_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(getParent(), "Error al guardar la película"
								, "Error", JOptionPane.WARNING_MESSAGE);
					}
					
				}
			}
		});
		
		txtDuracion = new JTextField();
		txtDuracion.setColumns(10);
		txtDuracion.setBounds(275, 292, 95, 25);
		contentPane.add(txtDuracion);
		
		JLabel titulo = new JLabel("T\u00EDtulo: ");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		titulo.setBounds(50, 120, 112, 25);
		contentPane.add(titulo);
		
		JLabel anyoEstreno = new JLabel("A\u00F1o de estreno:");
		anyoEstreno.setForeground(Color.WHITE);
		anyoEstreno.setFont(new Font("Tahoma", Font.PLAIN, 25));
		anyoEstreno.setBounds(50, 156, 192, 25);
		contentPane.add(anyoEstreno);
		
		JLabel director = new JLabel("Director:");
		director.setForeground(Color.WHITE);
		director.setFont(new Font("Tahoma", Font.PLAIN, 25));
		director.setBounds(50, 188, 112, 25);
		contentPane.add(director);
		
		JLabel actorPrincipal = new JLabel("Actor principal:");
		actorPrincipal.setForeground(Color.WHITE);
		actorPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		actorPrincipal.setBounds(50, 220, 225, 25);
		contentPane.add(actorPrincipal);
		
		JLabel actorSecundario = new JLabel("Actor secundario:");
		actorSecundario.setForeground(Color.WHITE);
		actorSecundario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		actorSecundario.setBounds(50, 256, 204, 25);
		contentPane.add(actorSecundario);
		
		JLabel sinopsis = new JLabel("Sinopsis:");
		sinopsis.setForeground(Color.WHITE);
		sinopsis.setFont(new Font("Tahoma", Font.PLAIN, 25));
		sinopsis.setBounds(50, 436, 125, 25);
		contentPane.add(sinopsis);
		
		JLabel duracion = new JLabel("Duraci\u00F3n:");
		duracion.setForeground(Color.WHITE);
		duracion.setFont(new Font("Tahoma", Font.PLAIN, 25));
		duracion.setBounds(50, 292, 155, 25);
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
		txtTitulo.setBounds(275, 120, 350, 25);
		contentPane.add(txtTitulo);
		
		txtAnyoEstreno = new JYearChooser();
		txtAnyoEstreno.setBounds(275, 156, 95, 25);
		contentPane.add(txtAnyoEstreno);
		
		txtActorPrincipal = new JTextField();
		txtActorPrincipal.setBounds(275, 220, 350, 25);
		contentPane.add(txtActorPrincipal);
		txtActorPrincipal.setColumns(10);
		
		txtActorSecundario = new JTextField();
		txtActorSecundario.setBounds(275, 256, 350, 25);
		contentPane.add(txtActorSecundario);
		txtActorSecundario.setColumns(10);
		
		JLabel trailer = new JLabel("Trailer: ");
		trailer.setForeground(Color.WHITE);
		trailer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		trailer.setBounds(50, 400, 120, 25);
		contentPane.add(trailer);
		
		JLabel fechaInicio = new JLabel("Fecha inicio:");
		fechaInicio.setForeground(Color.WHITE);
		fechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 25));
		fechaInicio.setBounds(50, 328, 172, 25);
		contentPane.add(fechaInicio);
		
		JLabel fechaFin = new JLabel("Fecha fin:");
		fechaFin.setForeground(Color.WHITE);
		fechaFin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		fechaFin.setBounds(50, 364, 155, 25);
		contentPane.add(fechaFin);
		
		txtFechaInicio = new JDateChooser();
		txtFechaInicio.setBounds(275, 328, 204, 25);
		contentPane.add(txtFechaInicio);
		
		txtFechaFin = new JDateChooser();
		txtFechaFin.setBounds(275, 364, 204, 25);
		contentPane.add(txtFechaFin);
		
		txtSinopsis = new JTextArea();
		txtSinopsis.setBounds(275, 436, 464, 186);
		contentPane.add(txtSinopsis);
		
		txtTrailer = new JTextField();
		txtTrailer.setColumns(10);
		txtTrailer.setBounds(275, 400, 350, 25);
		contentPane.add(txtTrailer);
		
		setLocationRelativeTo(null);
	}

	public void setBbdd(String bbdd) {
		this.bbdd = bbdd;
	}
}
