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
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import com.toedter.calendar.JYearChooser;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import modelo.Columna;
import modelo.Pelicula;
import modelo.Proyeccion;
import modelo.Tabla;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class VVerDatosPelicula extends JFrame {

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
	private JTable table;
	private static DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//VVerDatosPelicula frame = new VVerDatosPelicula();
					//frame.setVisible(true);
					
					
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
	public VVerDatosPelicula() {
		
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
		lblTtulo_1.setBounds(24, 165, 205, 31);
		contentPane.add(lblTtulo_1);
		
		JLabel lblAoDeEstreno = new JLabel("A\u00F1o de estreno:");
		lblAoDeEstreno.setForeground(Color.WHITE);
		lblAoDeEstreno.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAoDeEstreno.setBounds(24, 211, 205, 31);
		contentPane.add(lblAoDeEstreno);
		
		JLabel lblDirector = new JLabel("Director:");
		lblDirector.setForeground(Color.WHITE);
		lblDirector.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDirector.setBounds(24, 255, 205, 31);
		contentPane.add(lblDirector);
		
		JLabel lblActorPrincipal = new JLabel("Actor principal:");
		lblActorPrincipal.setForeground(Color.WHITE);
		lblActorPrincipal.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblActorPrincipal.setBounds(24, 297, 205, 31);
		contentPane.add(lblActorPrincipal);
		
		JLabel lblActorSecundario = new JLabel("Actor secundario:");
		lblActorSecundario.setForeground(Color.WHITE);
		lblActorSecundario.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblActorSecundario.setBounds(24, 349, 228, 31);
		contentPane.add(lblActorSecundario);
		
		JLabel lblDuracin = new JLabel("Duraci\u00F3n:");
		lblDuracin.setForeground(Color.WHITE);
		lblDuracin.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDuracin.setBounds(24, 393, 228, 31);
		contentPane.add(lblDuracin);
		
		JLabel lblTrailer = new JLabel("Trailer:");
		lblTrailer.setForeground(Color.WHITE);
		lblTrailer.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTrailer.setBounds(411, 538, 105, 31);
		contentPane.add(lblTrailer);
		
		JLabel lblSinopsis = new JLabel("Sinopsis:");
		lblSinopsis.setForeground(Color.WHITE);
		lblSinopsis.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblSinopsis.setBounds(24, 435, 228, 31);
		contentPane.add(lblSinopsis);
		
		txtSinopsis = new JTextArea();
		txtSinopsis.setLineWrap(true);
		txtSinopsis.setColumns(10);
		txtSinopsis.setBounds(166, 444, 722, 84);
		contentPane.add(txtSinopsis);
		
		/*panelTrailer = new JPanel();
		panelTrailer.setBounds(80, 610, 836, 330);
		contentPane.add(panelTrailer);
		panelTrailer.setLayout(null);
		*/
		txtTitulo = new JLabel("(sin datos)");
		txtTitulo.setForeground(Color.WHITE);
		txtTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtTitulo.setBounds(262, 165, 316, 31);
		contentPane.add(txtTitulo);
		
		txtDirector = new JLabel("(sin datos)");
		txtDirector.setForeground(Color.WHITE);
		txtDirector.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtDirector.setBounds(262, 255, 316, 31);
		contentPane.add(txtDirector);
		
		txtActorPrin = new JLabel("(sin datos)");
		txtActorPrin.setForeground(Color.WHITE);
		txtActorPrin.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtActorPrin.setBounds(262, 297, 316, 31);
		contentPane.add(txtActorPrin);
		
		txtActorSecun = new JLabel("(sin datos)");
		txtActorSecun.setForeground(Color.WHITE);
		txtActorSecun.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtActorSecun.setBounds(262, 349, 316, 31);
		contentPane.add(txtActorSecun);
		
		txtDuracion = new JLabel("(sin datos)");
		txtDuracion.setForeground(Color.WHITE);
		txtDuracion.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtDuracion.setBounds(262, 393, 316, 31);
		contentPane.add(txtDuracion);
		
		txtAnyo = new JLabel("(sin datos)");
		txtAnyo.setForeground(Color.WHITE);
		txtAnyo.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtAnyo.setBounds(262, 211, 316, 31);
		contentPane.add(txtAnyo);
		
		JButton volver = new JButton("");
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VVerDatosPelicula.this.dispose();
			}
		});
	
		volver.setContentAreaFilled(false);
		volver.setBounds(750, 45, 138, 89);
		contentPane.add(volver);
		volver.setIcon(new ImageIcon(getClass().getResource("/imagenes/BOTONES/botVOLVER.png")));
		
		
		wb = new JWebBrowser();
		wb.setBarsVisible(false);
		wb.setBounds(119, 579, 769, 364);
		//wb.navigate("http://www.sensacine.com/_video/iblogvision.aspx?cmedia=19558059");
		NativeInterface.open();
		contentPane.add(wb);
		
		JPanel panel = new JPanel();
		panel.setBounds(588, 166, 300, 256);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 300, 256);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Sala", "Fecha inicio", "Fecha fin", "Hora"
			}
		));
		
		
		setLocationRelativeTo(null);
	}
	
	public void cargarDatos(String bbdd, Pelicula p) throws ParseException {
		txtTitulo.setText(p.getTitulo());
		txtSinopsis.setText(p.getSinopsis());
		txtDirector.setText(p.getDirector());
		txtActorPrin.setText(p.getActorPrincipal());
		txtActorSecun.setText(p.getActorSecundario());
		txtDuracion.setText(String.valueOf(p.getDuracion()));
		txtAnyo.setText(String.valueOf(p.getAnoEstreno()));
		wb.navigate(p.getTrailer());
		model = (DefaultTableModel) table.getModel();
		if(bbdd.equals("postgre")) {
			for(Proyeccion pr:Pelicula.cargarProyecciones(bbdd, p)) {
				model.addRow(new Object[]{pr.getSala().getNumero(),p.getFechaInicio(),p.getFechaFin(),pr.getHora()});
			
			}
		}
		
	}
}
