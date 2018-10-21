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
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import com.toedter.calendar.JYearChooser;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import modelo.Pelicula;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VVerPelicula extends JFrame {

	private static JPanel contentPane;
	//private static VVerPelicula frame;
	private static JPanel panelTrailer;
	private JTextArea txtSinopsis;
	private JLabel txtTitulo;
	private JLabel txtDirector;
	private JLabel txtActorPrin;
	private JLabel txtActorSecun;
	private JLabel txtDuracion;
	private JLabel txtAnyo;
	private static JWebBrowser wb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VVerPelicula frame = new VVerPelicula();
					frame.setVisible(true);
					NativeInterface.open();
					contentPane.add(wb);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				NativeInterface.close();
			}
		}));
	}

	/**
	 * Create the frame.
	 */
	public VVerPelicula() {
		
		setBounds(new Rectangle(0, 0, 800, 800));
		
		// Poner icono ventana
		setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());
		
		setExtendedState(Frame.NORMAL);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1000, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(233, 69, 75));
		contentPane.setLayout(null);
		
		JLabel lblDatosDe = new JLabel("| Datos de la pel\u00EDcula");
		lblDatosDe.setForeground(Color.WHITE);
		lblDatosDe.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDatosDe.setBounds(57, 45, 330, 31);
		contentPane.add(lblDatosDe);
		
		JLabel lblTtulo = new JLabel("Cine");
		lblTtulo.setForeground(Color.WHITE);
		lblTtulo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTtulo.setBounds(119, 97, 330, 31);
		contentPane.add(lblTtulo);
		
		JLabel lblTtulo_1 = new JLabel("T\u00EDtulo:");
		lblTtulo_1.setForeground(Color.WHITE);
		lblTtulo_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTtulo_1.setBounds(71, 165, 205, 31);
		contentPane.add(lblTtulo_1);
		
		JLabel lblAoDeEstreno = new JLabel("A\u00F1o de estreno:");
		lblAoDeEstreno.setForeground(Color.WHITE);
		lblAoDeEstreno.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAoDeEstreno.setBounds(71, 209, 205, 31);
		contentPane.add(lblAoDeEstreno);
		
		JLabel lblDirector = new JLabel("Director:");
		lblDirector.setForeground(Color.WHITE);
		lblDirector.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDirector.setBounds(71, 253, 205, 31);
		contentPane.add(lblDirector);
		
		JLabel lblActorPrincipal = new JLabel("Actor principal:");
		lblActorPrincipal.setForeground(Color.WHITE);
		lblActorPrincipal.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblActorPrincipal.setBounds(71, 297, 205, 31);
		contentPane.add(lblActorPrincipal);
		
		JLabel lblActorSecundario = new JLabel("Actor secundario:");
		lblActorSecundario.setForeground(Color.WHITE);
		lblActorSecundario.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblActorSecundario.setBounds(71, 347, 228, 31);
		contentPane.add(lblActorSecundario);
		
		JLabel lblDuracin = new JLabel("Duraci\u00F3n:");
		lblDuracin.setForeground(Color.WHITE);
		lblDuracin.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDuracin.setBounds(71, 391, 228, 31);
		contentPane.add(lblDuracin);
		
		JLabel lblTrailer = new JLabel("Trailer:");
		lblTrailer.setForeground(Color.WHITE);
		lblTrailer.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTrailer.setBounds(411, 566, 105, 31);
		contentPane.add(lblTrailer);
		
		JLabel lblSinopsis = new JLabel("Sinopsis:");
		lblSinopsis.setForeground(Color.WHITE);
		lblSinopsis.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblSinopsis.setBounds(71, 435, 228, 31);
		contentPane.add(lblSinopsis);
		
		txtSinopsis = new JTextArea();
		txtSinopsis.setLineWrap(true);
		txtSinopsis.setColumns(10);
		txtSinopsis.setBounds(311, 444, 372, 84);
		contentPane.add(txtSinopsis);
		
		/*panelTrailer = new JPanel();
		panelTrailer.setBounds(80, 610, 836, 330);
		contentPane.add(panelTrailer);
		panelTrailer.setLayout(null);
		*/
		txtTitulo = new JLabel("(sin datos)");
		txtTitulo.setForeground(Color.WHITE);
		txtTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtTitulo.setBounds(311, 165, 205, 31);
		contentPane.add(txtTitulo);
		
		txtDirector = new JLabel("(sin datos)");
		txtDirector.setForeground(Color.WHITE);
		txtDirector.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtDirector.setBounds(311, 253, 205, 31);
		contentPane.add(txtDirector);
		
		txtActorPrin = new JLabel("(sin datos)");
		txtActorPrin.setForeground(Color.WHITE);
		txtActorPrin.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtActorPrin.setBounds(311, 297, 205, 31);
		contentPane.add(txtActorPrin);
		
		txtActorSecun = new JLabel("(sin datos)");
		txtActorSecun.setForeground(Color.WHITE);
		txtActorSecun.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtActorSecun.setBounds(311, 347, 205, 31);
		contentPane.add(txtActorSecun);
		
		txtDuracion = new JLabel("(sin datos)");
		txtDuracion.setForeground(Color.WHITE);
		txtDuracion.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtDuracion.setBounds(311, 391, 205, 31);
		contentPane.add(txtDuracion);
		
		txtAnyo = new JLabel("(sin datos)");
		txtAnyo.setForeground(Color.WHITE);
		txtAnyo.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtAnyo.setBounds(311, 209, 205, 31);
		contentPane.add(txtAnyo);
		
		JButton volver = new JButton("");
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VVerPelicula.this.dispose();
			}
		});
		volver.setContentAreaFilled(false);
		volver.setBounds(726, 164, 138, 89);
		contentPane.add(volver);
		volver.setIcon(new ImageIcon(getClass().getResource("/imagenes/BOTONES/botVOLVER.png")));
		
		
		wb = new JWebBrowser();
		wb.setBarsVisible(false);
		wb.setBounds(80, 610, 836, 330);
		//wb.navigate("http://www.sensacine.com/_video/iblogvision.aspx?cmedia=19558059");
		
		
		setLocationRelativeTo(null);
	}
	
	public void cargarDatos(Pelicula p) {
		txtTitulo.setText(p.getTitulo());
		txtSinopsis.setText(p.getSinopsis());
		txtDirector.setText(p.getDirector());
		txtActorPrin.setText(p.getActorPrincipal());
		txtActorSecun.setText(p.getActorSecundario());
		txtDuracion.setText(String.valueOf(p.getDuracion()));
		txtAnyo.setText(String.valueOf(p.getAnoEstreno()));
		wb.navigate(p.getTrailer());
	}
}
