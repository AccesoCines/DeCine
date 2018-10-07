package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JDateChooser;

public class VAltaPeliculas extends JPanel {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VAltaPeliculas frame = new VAltaPeliculas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public VAltaPeliculas() {
		
	
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		contentPane.setBackground(new Color(233, 69, 75));
		
		JLabel altaPeliculas = new JLabel("| Alta pel\u00EDculas");
		altaPeliculas.setForeground(Color.WHITE);
		altaPeliculas.setFont(new Font("Tahoma", Font.BOLD, 25));
		altaPeliculas.setBounds(24, 29, 225, 31);
		contentPane.add(altaPeliculas);
		
		JLabel titulo = new JLabel("T\u00EDtulo: ");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		titulo.setForeground(Color.WHITE);
		titulo.setBounds(24, 93, 225, 31);
		contentPane.add(titulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(242, 93, 365, 31);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel anyoEstreno = new JLabel("A\u00F1o de estreno: ");
		anyoEstreno.setFont(new Font("Tahoma", Font.PLAIN, 25));
		anyoEstreno.setForeground(Color.WHITE);
		anyoEstreno.setBounds(24, 153, 225, 31);
		contentPane.add(anyoEstreno);
		
		JLabel fechaInicio = new JLabel("Fecha inicio: ");
		fechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 25));
		fechaInicio.setForeground(Color.WHITE);
		fechaInicio.setBounds(24, 211, 225, 31);
		contentPane.add(fechaInicio);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(242, 153, 121, 31);
		contentPane.add(dateChooser);
		
		JLabel fechaFin = new JLabel("Fecha fin: ");
		fechaFin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		fechaFin.setForeground(Color.WHITE);
		fechaFin.setBounds(24, 267, 225, 31);
		contentPane.add(fechaFin);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(415, 349, 225, 31);
		contentPane.add(dateChooser_1);
		
		JLabel lblNewLabel_3 = new JLabel("G\u00E9nero:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(290, 431, 225, 31);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(395, 454, 225, 31);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Duraci\u00F3n:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(348, 403, 225, 31);
		contentPane.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(525, 302, 225, 31);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSinopsis = new JLabel("Sinopsis:");
		lblSinopsis.setForeground(Color.WHITE);
		lblSinopsis.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSinopsis.setBounds(24, 368, 225, 31);
		contentPane.add(lblSinopsis);
		
	}
}
