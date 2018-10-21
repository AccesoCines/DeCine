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
import javax.swing.JButton;

public class VVerPelicula extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VVerPelicula frame = new VVerPelicula();
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
		
		JTextArea txtSinopsis = new JTextArea();
		txtSinopsis.setLineWrap(true);
		txtSinopsis.setColumns(10);
		txtSinopsis.setBounds(311, 444, 372, 84);
		contentPane.add(txtSinopsis);
		
		JPanel panel = new JPanel();
		panel.setBounds(80, 610, 836, 330);
		contentPane.add(panel);
		
		JLabel lblsinDatos = new JLabel("(sin datos)");
		lblsinDatos.setForeground(Color.WHITE);
		lblsinDatos.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblsinDatos.setBounds(311, 165, 205, 31);
		contentPane.add(lblsinDatos);
		
		JLabel label = new JLabel("(sin datos)");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(311, 253, 205, 31);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("(sin datos)");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_1.setBounds(311, 297, 205, 31);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("(sin datos)");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_2.setBounds(311, 347, 205, 31);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("(sin datos)");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_3.setBounds(311, 391, 205, 31);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("(sin datos)");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_4.setBounds(311, 209, 205, 31);
		contentPane.add(label_4);
		
		JButton volver = new JButton("");
		volver.setContentAreaFilled(false);
		volver.setBounds(726, 164, 138, 89);
		contentPane.add(volver);
		volver.setIcon(new ImageIcon(getClass().getResource("/imagenes/BOTONES/botVOLVER.png")));
		
		setLocationRelativeTo(null);
	}
}
