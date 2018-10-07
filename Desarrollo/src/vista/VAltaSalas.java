package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JYearChooser;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Font;

public class VAltaSalas extends JPanel {
	private JTextField txtAforo;

	/**
	 * Create the panel.
	 */
	public VAltaSalas() {
		
		setBounds(0, 0, 800, 800);
		setLayout(null);
		
		JLabel altaSala = new JLabel("| Alta salas");
		altaSala.setFont(new Font("Tahoma", Font.PLAIN, 25));
		altaSala.setForeground(Color.WHITE);
		altaSala.setBounds(23, 28, 114, 16);
		add(altaSala);
		
		JLabel numero = new JLabel("N\u00FAmero: ");
		numero.setFont(new Font("Tahoma", Font.PLAIN, 25));
		numero.setForeground(Color.WHITE);
		numero.setBounds(23, 83, 56, 16);
		add(numero);
		
		JComboBox txtNumero = new JComboBox();
		txtNumero.setBounds(169, 85, 101, 22);
		add(txtNumero);
		
		JLabel aforo = new JLabel("Aforo: ");
		aforo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		aforo.setForeground(Color.WHITE);
		aforo.setBounds(23, 136, 56, 16);
		add(aforo);
		
		txtAforo = new JTextField();
		txtAforo.setBounds(118, 133, 101, 22);
		add(txtAforo);
		txtAforo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Dimensi\u00F3n pantalla:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(23, 195, 56, 16);
		add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(118, 192, 101, 22);
		add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("A\u00F1o inaguraci\u00F3n:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(23, 262, 56, 16);
		add(lblNewLabel_2);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(118, 256, 101, 22);
		add(yearChooser);
		
		JLabel lblDiscapacidad = new JLabel("Discapacidad:");
		lblDiscapacidad.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDiscapacidad.setForeground(Color.WHITE);
		lblDiscapacidad.setBounds(23, 325, 56, 16);
		add(lblDiscapacidad);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBounds(118, 321, 113, 25);
		add(checkBox);
		
		JLabel lblNewLabel_3 = new JLabel("Responsable:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(23, 377, 56, 16);
		add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(118, 374, 101, 22);
		add(comboBox);
		

	}
}
