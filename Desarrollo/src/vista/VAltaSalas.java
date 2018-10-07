package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.Rectangle;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.JCheckBox;

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
		

private JTextField txtnumSala;
private JTextField txtaforo;
private JTextField txtDiscapacidad;
private JTextField txtDimPantalla;
private JTextField txtAnoInaug;
private JTextField txtResponsable;
private JTextField txtDim;
private JTextField txtInaug;



/**
 * Launch the application.
 */
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				VAltaSalas panel = new VAltaSalas();
				panel.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}

/**
 * Create the frame.
 */
public VAltaSalas() {
	setBounds(new Rectangle(0, 0, 800, 800));
	setLayout(null);
	
	JLabel lblCine = new JLabel("Cine");
	lblCine.setBounds(100, 150, 300, 31);
	add(lblCine);
	lblCine.setForeground(Color.WHITE);
	lblCine.setFont(new Font("Tahoma", Font.BOLD, 25));
	
	JLabel numSala = new JLabel("N� Sala:");
	numSala.setBounds(50, 266, 300, 31);
	add(numSala);
	numSala.setForeground(new Color(255, 255, 255));
	numSala.setFont(new Font("Tahoma", Font.PLAIN, 25));
	
	JLabel afo = new JLabel("Aforo:");
	afo.setBounds(50, 316, 300, 31);
	add(afo);
	afo.setForeground(Color.WHITE);
	afo.setFont(new Font("Tahoma", Font.PLAIN, 25));
	
	JLabel dimensiones = new JLabel("Dimensiones pantalla:");
	dimensiones.setBounds(50, 366, 300, 31);
	add(dimensiones);
	dimensiones.setForeground(Color.WHITE);
	dimensiones.setFont(new Font("Tahoma", Font.PLAIN, 25));	
	
	JCheckBox discap = new JCheckBox("Discapacidad");
	discap.setBounds(50, 416, 300, 31);
	discap.setForeground(Color.WHITE);
	discap.setFont(new Font("Tahoma", Font.PLAIN, 25));
	add(discap);
	
	JLabel Inauguracion = new JLabel("A\u00F1o inauguraci\u00F3n:");
	Inauguracion.setBounds(50, 466, 300, 31);
	add(Inauguracion);
	Inauguracion.setForeground(Color.WHITE);
	Inauguracion.setFont(new Font("Tahoma", Font.PLAIN, 25));
	
	JLabel lblResponsable = new JLabel("Responsable:");
	lblResponsable.setBounds(50, 516, 300, 31);
	add(lblResponsable);
	lblResponsable.setForeground(Color.WHITE);
	lblResponsable.setFont(new Font("Tahoma", Font.PLAIN, 25));
	
	txtnumSala = new JTextField();
	add(txtnumSala);
	txtnumSala.setBounds(new Rectangle(450, 266, 300, 31));
	txtnumSala.setColumns(10);
	
	txtaforo = new JTextField();
	txtaforo.setBounds(450, 316, 300, 31);
	add(txtaforo);
	txtaforo.setColumns(10);
	
	txtDim = new JTextField();
	txtDim.setBounds(450, 366, 300, 31);
	add(txtDim);
	txtDim.setColumns(10);
	
	txtInaug = new JTextField();
	txtInaug.setBounds(450, 466, 300, 31);
	add(txtInaug);
	txtInaug.setColumns(10);
	
	
	
	JComboBox comboBox = new JComboBox();
	comboBox.setBounds(450, 516, 300, 31);
	add(comboBox);
	
	JButton ok = new JButton("");
	ok.setIcon(new ImageIcon(VAltaSalas.class.getResource("/imagenes/BOTONES/botOK.png")));
	ok.setBounds(659, 50, 91, 80);
	ok.setContentAreaFilled(false);
	add(ok);
	
	JButton cancelar = new JButton("");
	cancelar.setBounds(50,670,181,80);
	cancelar.setIcon(new ImageIcon(VAltaSalas.class.getResource("/imagenes/BOTONES/botCANCELAR.png")));
	cancelar.setContentAreaFilled(false);
	add(cancelar);
	
	JLabel label = new JLabel("| Alta Sala");
	label.setForeground(Color.WHITE);
	label.setFont(new Font("Tahoma", Font.BOLD, 25));
	label.setBounds(50, 50, 300, 31);
	add(label);
	

}
}
