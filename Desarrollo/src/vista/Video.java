package vista;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;


public class Video extends JFrame {

	private static JPanel contentPane;
	private static JWebBrowser wb;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Video frame = new Video();
					frame.setVisible(true);
					NativeInterface.open();
					contentPane.add(wb);
					
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
	public Video() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		wb = new JWebBrowser();
		
		wb.setBarsVisible(false);
		wb.navigate("http://www.sensacine.com/_video/iblogvision.aspx?cmedia=19558059");
	
	}

}
