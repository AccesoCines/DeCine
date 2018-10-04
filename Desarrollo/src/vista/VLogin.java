package vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VLogin extends JFrame {
 

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField JPassword;
	private JTextField textField;
	private JButton btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VLogin().setVisible(true);
        
            }
        });
		
	}

	/**
	 * Create the frame.
	 */
	public VLogin() {
		
			btn = new JButton("");
				btn.addActionListener( new ActionListener () { 
				public void actionPerformed( ActionEvent evento ) { 
					String usuario = textField.getText();
			        String contrasena = new String(JPassword.getPassword()); 
		
				
				if(textField.getText().equals("cines1510") && JPassword.equals("12345")){
					
				}
				}
				});
	
		getContentPane().setBackground(new Color(255, 99, 71));
		getContentPane().setLayout(null);
		
		JPassword = new JPasswordField();
		JPassword.setBounds(157, 113, 230, 22);
		getContentPane().add(JPassword);
	
		JPassword.setBounds(157, 113, 230, 22);
		getContentPane().add(JPassword);
		
		textField = new JTextField();
		textField.setBounds(157, 78, 230, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDecine = new JLabel("DeCine");
		lblDecine.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDecine.setBounds(341, 13, 124, 16);
		getContentPane().add(lblDecine);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(71, 80, 74, 19);
		getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(71, 116, 74, 16);
		getContentPane().add(lblContrasea);
		
		btn = new JButton("");
		btn.setVerticalAlignment(SwingConstants.TOP);
		btn.setBackground(new Color(240, 240, 240));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn.setIcon(new ImageIcon("D:\\Desktop\\cine\\DeCine\\Desarrollo\\src\\imagenes\\BOTONES\\botENTRAR.png"));
		btn.setBounds(12, 195, 768, 250);
		btn.setContentAreaFilled(false);
		
		getContentPane().add(btn);

		
		// Poner icono ventana
	    setIconImage(new ImageIcon(getClass().getResource("../imagenes/icono.png")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 979, 505);
	
		
			}
}
