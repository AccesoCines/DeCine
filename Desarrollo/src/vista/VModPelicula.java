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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import com.toedter.calendar.JDateChooser;

import controlador.GestorBBDD;
import modelo.Pelicula;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import javax.swing.JTextArea;

public class VModPelicula extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtAnyoEstreno;
	private JTextField txtDirector;
	private JTextField txtActorPrincipal;
	private JTextField txtActorSecundario;
	private JTextField txtDuracion;
	private static VModPelicula frame;
	private JTextField txtTrailer;
	private JTextArea txtSinopsis;
	private JDateChooser txtFecIni;
	private JDateChooser txtFecFin;
	private String bbdd;
	private Pelicula pelicula;
	private String cine;
	private JLabel txtCine;
	private int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VModPelicula();
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
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		txtCine = new JLabel("cine");
		txtCine.setForeground(Color.WHITE);
		txtCine.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtCine.setBounds(100, 102, 225, 31);
		contentPane.add(txtCine);
		
		JButton btnOk = new JButton("");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = txtTitulo.getText();
				int anyo=0;
				int duracion=0;
				try {
					anyo = Integer.parseInt(txtAnyoEstreno.getText());
					duracion = Integer.parseInt(txtDuracion.getText());
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(getParent(), "Comprueba que el a�o y la duraci�n "
							+ "son n�meros", "Error", JOptionPane.WARNING_MESSAGE);
					
				}
				String director = txtDirector.getText();
				String actorPrin = txtActorPrincipal.getText();
				String actorSecun = txtActorSecundario.getText();
				java.util.Date fechaIniU = txtFecIni.getDate();
				Date fechaIni = new Date(fechaIniU.getTime());
				java.util.Date fechaFinU = txtFecFin.getDate();
				Date fechaFin = new Date(fechaFinU.getTime());
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
							duracion,trailer,fechaIni,fechaFin,true,id);
					boolean correcto = p.modificarPelicula(bbdd);
					if(correcto) {
						JOptionPane.showMessageDialog(getParent(), "Guardado correctamente!"
								, "Guardado", JOptionPane.PLAIN_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(getParent(), "Error al guardar la pel\u00edcula"
								, "Error", JOptionPane.WARNING_MESSAGE);
					}
					
				}
			}
		});
		btnOk.setContentAreaFilled(false);
		btnOk.setBounds(670, 30, 91, 80);
		contentPane.add(btnOk);
		btnOk.setIcon(new ImageIcon(getClass().getResource("/imagenes/BOTONES/botOK.png")));
		
		JLabel titulo = new JLabel("T\u00EDtulo: ");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		titulo.setBounds(50, 144, 112, 25);
		contentPane.add(titulo);
		
		JLabel anyoEstreno = new JLabel("A\u00F1o de estreno:");
		anyoEstreno.setForeground(Color.WHITE);
		anyoEstreno.setFont(new Font("Tahoma", Font.PLAIN, 25));
		anyoEstreno.setBounds(50, 180, 192, 25);
		contentPane.add(anyoEstreno);
		
		JLabel director = new JLabel("Director:");
		director.setForeground(Color.WHITE);
		director.setFont(new Font("Tahoma", Font.PLAIN, 25));
		director.setBounds(50, 216, 112, 25);
		contentPane.add(director);
		
		JLabel actorPrincipal = new JLabel("Actor principal:");
		actorPrincipal.setForeground(Color.WHITE);
		actorPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		actorPrincipal.setBounds(50, 252, 181, 25);
		contentPane.add(actorPrincipal);
		
		JLabel actorSecundario = new JLabel("Actor secundario:");
		actorSecundario.setForeground(Color.WHITE);
		actorSecundario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		actorSecundario.setBounds(50, 288, 204, 25);
		contentPane.add(actorSecundario);
		
		JLabel sinopsis = new JLabel("Sinopsis:");
		sinopsis.setForeground(Color.WHITE);
		sinopsis.setFont(new Font("Tahoma", Font.PLAIN, 25));
		sinopsis.setBounds(50, 468, 186, 25);
		contentPane.add(sinopsis);
		
		JLabel duracion = new JLabel("Duraci\u00F3n:");
		duracion.setForeground(Color.WHITE);
		duracion.setFont(new Font("Tahoma", Font.PLAIN, 25));
		duracion.setBounds(50, 324, 153, 25);
		contentPane.add(duracion);
		
		JLabel trailer = new JLabel("Trailer: ");
		trailer.setForeground(Color.WHITE);
		trailer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		trailer.setBounds(50, 432, 171, 25);
		contentPane.add(trailer);
		
		JLabel fechaInicio = new JLabel("Fecha inicio:");
		fechaInicio.setForeground(Color.WHITE);
		fechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 25));
		fechaInicio.setBounds(50, 360, 181, 25);
		contentPane.add(fechaInicio);
		
		JLabel fechaFin = new JLabel("Fecha fin:");
		fechaFin.setForeground(Color.WHITE);
		fechaFin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		fechaFin.setBounds(50, 396, 171, 25);
		contentPane.add(fechaFin);
		
		txtTitulo = new JTextField();
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(252, 144, 380, 25);
		contentPane.add(txtTitulo);
		
		txtAnyoEstreno = new JTextField();
		txtAnyoEstreno.setColumns(10);
		txtAnyoEstreno.setBounds(252, 180, 112, 25);
		contentPane.add(txtAnyoEstreno);
		
		txtDirector = new JTextField();
		txtDirector.setColumns(10);
		txtDirector.setBounds(252, 216, 380, 25);
		contentPane.add(txtDirector);
		
		txtActorPrincipal = new JTextField();
		txtActorPrincipal.setColumns(10);
		txtActorPrincipal.setBounds(252, 252, 380, 25);
		contentPane.add(txtActorPrincipal);
		
		txtActorSecundario = new JTextField();
		txtActorSecundario.setColumns(10);
		txtActorSecundario.setBounds(251, 288, 381, 25);
		contentPane.add(txtActorSecundario);
		
		txtDuracion = new JTextField();
		txtDuracion.setColumns(10);
		txtDuracion.setBounds(252, 324, 112, 25);
		contentPane.add(txtDuracion);
		
		txtFecIni = new JDateChooser();
		txtFecIni.setBounds(252, 360, 204, 25);
		contentPane.add(txtFecIni);
		
		txtFecFin = new JDateChooser();
		txtFecFin.setBounds(252, 396, 204, 25);
		contentPane.add(txtFecFin);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				VListado vl = new VListado();
				vl.setVisible(true);
			}
		});
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBounds(23, 666, 181, 80);
		contentPane.add(btnCancelar);
		btnCancelar.setIcon(new ImageIcon(getClass().getResource("/imagenes/BOTONES/botCANCELAR.png")));

		
		txtTrailer = new JTextField();
		txtTrailer.setColumns(10);
		txtTrailer.setBounds(252, 432, 380, 25);
		contentPane.add(txtTrailer);
		
		txtSinopsis = new JTextArea();
		txtSinopsis.setLineWrap(true);
		txtSinopsis.setColumns(10);
		txtSinopsis.setBounds(252, 468, 380, 223);
		contentPane.add(txtSinopsis);
		
		setLocationRelativeTo(null);
		
	}

	public void setBbdd(String bbdd) {
		this.bbdd = bbdd;
	}

	public void setPelicula(Pelicula pelicula) {
		this.id = pelicula.getId();
		txtTitulo.setText(pelicula.getTitulo());
		txtAnyoEstreno.setText(String.valueOf(pelicula.getAnoEstreno()));
		txtDirector.setText(pelicula.getDirector());
		txtActorPrincipal.setText(pelicula.getActorPrincipal());
		txtActorSecundario.setText(pelicula.getActorSecundario());
		txtDuracion.setText(String.valueOf(pelicula.getDuracion()));
		txtFecIni.setDate(pelicula.getFechaInicio());
		txtFecFin.setDate(pelicula.getFechaFin());
		txtTrailer.setText(pelicula.getTrailer());
		txtSinopsis.setText(pelicula.getSinopsis());
	}

	public void setCine(String cine) {
		// TODO Auto-generated method stub
		this.cine=cine;
		txtCine.setText(cine);
	}
}
