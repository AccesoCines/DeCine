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
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class VInfoCine extends JFrame {

	private JPanel contentPane;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VInfoCine frame = new VInfoCine();
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
	public VInfoCine() {
		
		setBounds(new Rectangle(0, 0, 800, 800));
		
		// Poner icono ventana
		setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());
		
		setExtendedState(Frame.NORMAL);
		
		//TODO ARRAY CON DATOS DEL CINE QUE SE CARGUE EN EL PANEL
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		getContentPane().setBackground(new Color(233, 69, 75));
		contentPane.setLayout(null);
		
		JLabel lblCine = new JLabel("Cine");
		lblCine.setForeground(Color.WHITE);
		lblCine.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCine.setBounds(169, 126, 127, 25);
		contentPane.add(lblCine);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setForeground(Color.WHITE);
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDireccin.setBounds(169, 225, 127, 25);
		contentPane.add(lblDireccin);
		
		JLabel lblFechaFundacin = new JLabel("Fecha fundaci\u00F3n: ");
		lblFechaFundacin.setForeground(Color.WHITE);
		lblFechaFundacin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblFechaFundacin.setBounds(169, 333, 199, 25);
		contentPane.add(lblFechaFundacin);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono: ");
		lblTelfono.setForeground(Color.WHITE);
		lblTelfono.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTelfono.setBounds(169, 443, 127, 25);
		contentPane.add(lblTelfono);
		
		JLabel lblInformacinDel = new JLabel("| Informaci\u00F3n del cine");
		lblInformacinDel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblInformacinDel.setForeground(Color.WHITE);
		lblInformacinDel.setBounds(59, 45, 252, 38);
		contentPane.add(lblInformacinDel);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(169, 481, 277, 22);
		contentPane.add(textField_3);
		
		JLabel label = new JLabel("Cine");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label.setBounds(280, 169, 127, 25);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Direcci\u00F3n:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_1.setBounds(280, 263, 127, 25);
		contentPane.add(label_1);
	}
}
