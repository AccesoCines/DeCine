package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import com.toedter.calendar.JYearChooser;

import modelo.Empleado;
import modelo.Sala;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VModificacionSala extends JFrame {

	private JPanel contentPane;
	private String bbdd;
	private Sala sala;
	private int id;
	private JLabel cine;
	private JSpinner txtNumSala;
	private JSpinner txtAforo;
	private JComboBox txtDimPant;
	private JCheckBox txtAccDiscapacitados;
	private JYearChooser txtAnyoInag;
	private JComboBox txtResponsable;
	private ArrayList<Empleado> responsables;

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
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		txtAccDiscapacitados = new JCheckBox("Accesible discapacitados:");
		txtAccDiscapacitados.setForeground(Color.WHITE);
		txtAccDiscapacitados.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtAccDiscapacitados.setBounds(33, 353, 327, 31);
		txtAccDiscapacitados.setBackground(new Color(233, 69, 75));
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
		
		cine = new JLabel("Cine");
		cine.setForeground(Color.WHITE);
		cine.setFont(new Font("Tahoma", Font.BOLD, 25));
		cine.setBounds(82, 107, 300, 31);
		contentPane.add(cine);
		
		txtResponsable = new JComboBox();
		txtResponsable.setBounds(377, 458, 300, 31);
		contentPane.add(txtResponsable);
		
		txtAnyoInag = new JYearChooser();
		txtAnyoInag.setBounds(377, 412, 300, 31);
		contentPane.add(txtAnyoInag);
		
		txtDimPant = new JComboBox();
		txtDimPant.addItem("Extreme Digital Cinema");
		txtDimPant.addItem("Cinemascope");
		txtDimPant.addItem("IMAX");
		txtDimPant.setBounds(377, 303, 300, 31);
		contentPane.add(txtDimPant);
		
		txtAforo = new JSpinner(new SpinnerNumberModel(50, 1, 1000, 5));
		txtAforo.setBounds(377, 247, 300, 31);
		contentPane.add(txtAforo);
		
		txtNumSala = new JSpinner(new SpinnerNumberModel(0, 0, 1000, 1));
		txtNumSala.setBounds(377, 189, 300, 31);
		contentPane.add(txtNumSala);
		
		JButton btnOk = new JButton("");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean dis = txtAccDiscapacitados.isSelected();
				Empleado responsable = responsables.get(txtResponsable.getSelectedIndex());
				String pantalla = txtDimPant.getSelectedItem().toString();
				int numero = (int) txtNumSala.getValue();
				int anyo = txtAnyoInag.getValue();
				int aforo = (int) txtAforo.getValue();
				Sala s = new Sala(numero,aforo,pantalla,anyo,dis,responsable,true,id);
				boolean correcto = s.modificarSala(bbdd);
				if(correcto) {
					JOptionPane.showMessageDialog(getParent(), "Guardado correctamente!"
							, "Guardado", JOptionPane.PLAIN_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(getParent(), "Error al guardar la pel�cula"
							, "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnOk.setContentAreaFilled(false);
		btnOk.setBounds(616, 50, 108, 88);
		contentPane.add(btnOk);
		btnOk.setIcon(new ImageIcon(getClass().getResource("/imagenes/BOTONES/botOK.png")));
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBounds(51, 602, 178, 88);
		contentPane.add(btnCancelar);
		btnCancelar.setIcon(new ImageIcon(getClass().getResource("/imagenes/BOTONES/botCANCELAR.png")));
		
		setLocationRelativeTo(null);
	}

	public void setSala(Sala sala) {
		// TODO Auto-generated method stub
		this.id = sala.getId();
		txtNumSala.setValue(sala.getNumero());
		txtAforo.setValue(sala.getAforo());
		txtDimPant.setSelectedItem(sala.getDimPantalla());
		txtAccDiscapacitados.setSelected(sala.isDiscapacidad());
		txtAnyoInag.setValue(sala.getAnoInauguracion());
		txtResponsable.setSelectedItem(sala.getResponsable().getNombre()+" "+sala.getResponsable().getApellido());
		
	}

	public void setBbdd(String bbdd) {
		// TODO Auto-generated method stub
		this.bbdd = bbdd;
		
	}

	public void setCine(String cine) {
		// TODO Auto-generated method stub
		this.cine.setText(cine);
	}

	public void setResponsables(String bbdd2) {
		this.bbdd = bbdd2;
		responsables = Empleado.cargarEmpleadosResp(bbdd2); 
		for(Empleado res: responsables) {
			txtResponsable.addItem(res.getNombre()+" "+res.getApellido());
		}
		
	}

}
