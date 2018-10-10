package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import com.toedter.calendar.JYearChooser;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class VModificacionSala extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VModificacionSala frame = new VModificacionSala();
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
	public VModificacionSala() {
		
		setBounds(new Rectangle(0, 0, 800, 800));
		
		// Poner icono ventana
		setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());
		
		setExtendedState(Frame.NORMAL);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(new Color(233, 69, 75));
		
		JLabel modificacionSalas = new JLabel("| Modificaci\u00F3n salas");
		modificacionSalas.setForeground(Color.WHITE);
		modificacionSalas.setFont(new Font("Tahoma", Font.BOLD, 25));
		modificacionSalas.setBounds(23, 37, 284, 36);
		contentPane.add(modificacionSalas);
		
		JLabel numSala = new JLabel("N\u00FAmero Sala:");
		numSala.setForeground(Color.WHITE);
		numSala.setFont(new Font("Tahoma", Font.PLAIN, 25));
		numSala.setBounds(33, 189, 300, 31);
		contentPane.add(numSala);
		
		JLabel aforo = new JLabel("Aforo:");
		aforo.setForeground(Color.WHITE);
		aforo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		aforo.setBounds(33, 247, 300, 31);
		contentPane.add(aforo);
		
		JLabel dimPantalla = new JLabel("Dimensiones pantalla:");
		dimPantalla.setForeground(Color.WHITE);
		dimPantalla.setFont(new Font("Tahoma", Font.PLAIN, 25));
		dimPantalla.setBounds(33, 303, 300, 31);
		contentPane.add(dimPantalla);
		
		JCheckBox txtAccDiscapacitados = new JCheckBox("Accesible discapacitados:");
		txtAccDiscapacitados.setForeground(Color.WHITE);
		txtAccDiscapacitados.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtAccDiscapacitados.setBounds(33, 353, 327, 31);
		contentPane.add(txtAccDiscapacitados);
		
		JLabel anyoInag = new JLabel("A\u00F1o inauguraci\u00F3n:");
		anyoInag.setForeground(Color.WHITE);
		anyoInag.setFont(new Font("Tahoma", Font.PLAIN, 25));
		anyoInag.setBounds(33, 403, 300, 31);
		contentPane.add(anyoInag);
		
		JLabel responsable = new JLabel("Responsable:");
		responsable.setForeground(Color.WHITE);
		responsable.setFont(new Font("Tahoma", Font.PLAIN, 25));
		responsable.setBounds(33, 453, 300, 31);
		contentPane.add(responsable);
		
		JLabel cine = new JLabel("Cine");
		cine.setForeground(Color.WHITE);
		cine.setFont(new Font("Tahoma", Font.BOLD, 25));
		cine.setBounds(82, 107, 300, 31);
		contentPane.add(cine);
		
		JComboBox txtResponsable = new JComboBox();
		txtResponsable.setBounds(377, 458, 300, 31);
		contentPane.add(txtResponsable);
		
		JYearChooser txtAnyoInag = new JYearChooser();
		txtAnyoInag.setBounds(377, 412, 300, 31);
		contentPane.add(txtAnyoInag);
		
		JComboBox txtDimPant = new JComboBox();
		txtDimPant.setBounds(377, 303, 300, 31);
		contentPane.add(txtDimPant);
		
		JSpinner txtAforo = new JSpinner();
		txtAforo.setBounds(377, 247, 300, 31);
		contentPane.add(txtAforo);
		
		JComboBox txtNumSala = new JComboBox();
		txtNumSala.setBounds(377, 189, 300, 31);
		contentPane.add(txtNumSala);
		
		JButton btnOk = new JButton("");
		btnOk.setContentAreaFilled(false);
		btnOk.setBounds(616, 50, 108, 88);
		contentPane.add(btnOk);
		btnOk.setIcon(new ImageIcon(VAltaEmpl.class.getResource("/imagenes/BOTONES/botOK.png")));
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBounds(51, 602, 178, 88);
		contentPane.add(btnCancelar);
		btnCancelar.setIcon(new ImageIcon(VAltaEmpl.class.getResource("/imagenes/BOTONES/botCANCELAR.png")));
		
		setLocationRelativeTo(null);
	}

}
