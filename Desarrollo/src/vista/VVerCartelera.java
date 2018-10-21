
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import modelo.Pelicula;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VVerCartelera extends JFrame {

	private JPanel contentPane;
	private static VVerCartelera vCart;
	private JTable table;
	private JLabel lblcine;
	private String bbdd;
	private static DefaultTableModel model = new DefaultTableModel();
	private ArrayList<Pelicula> peliculas;

	/**
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vCart = new VVerCartelera();
					vCart.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VVerCartelera() {

		// Poner icono ventana
		setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());

		// setBounds(0, 0, 800, 800);

		setExtendedState(Frame.NORMAL);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();

		contentPane.setBackground(new Color(233, 69, 75));
		contentPane.setForeground(new Color(233, 69, 75));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton volver = new JButton("New button");
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VCines cines = new VCines();
				cines.setVisible(true);

				VVerCartelera.this.dispose();

			}
		});
		volver.setBounds(50, 640, 158, 89);
		contentPane.add(volver);
		volver.setContentAreaFilled(false);
		;
		setBounds(100, 100, 800, 800);
		volver.setIcon(new ImageIcon(getClass().getResource("/imagenes/BOTONES/botVOLVER.png")));

		JLabel lblLCartelera = new JLabel("l Cartelera");
		lblLCartelera.setForeground(Color.WHITE);
		lblLCartelera.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblLCartelera.setBounds(50, 70, 169, 31);
		contentPane.add(lblLCartelera);

		lblcine = new JLabel("cine");
		lblcine.setForeground(Color.WHITE);
		lblcine.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblcine.setBounds(121, 140, 601, 31);
		contentPane.add(lblcine);
		
		JPanel panel = new JPanel();
		panel.setBounds(52, 200, 670, 430);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 670, 430);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Pelicula p = peliculas.get(table.getSelectedRow());
	            VVerDatosPelicula vdp = new VVerDatosPelicula();
	            vdp.cargarDatos(p);
	            vdp.setVisible(true);
			}
		});
		scrollPane.setViewportView(table);

		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Titulo", "Director", "Actor principal","Duracion"
				}
			));
		setLocationRelativeTo(null);

		/*table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            Pelicula p = peliculas.get(table.getSelectedRow());
	            VVerDatosPelicula vdp = new VVerDatosPelicula();
	            vdp.cargarDatos(p);
	            vdp.setVisible(true);
	        }

	    });*/
	}

	public void setcine(String text) {
		this.lblcine.setText(text);
		System.out.println(text);
	}

	public void setBBDD(String bbdd) {
		try {
			peliculas = Pelicula.cargarPeliculas(bbdd);
			model = (DefaultTableModel) table.getModel();
			for(Pelicula p:peliculas) {
				model.addRow(new Object[]{p.getTitulo(),p.getDirector(),p.getActorPrincipal(),p.getDuracion()});
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
