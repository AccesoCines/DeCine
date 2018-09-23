package vista;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ParaFondos extends JPanel {

	private BufferedImage imagen;

	public ParaFondos(BufferedImage imagen) {
		
	setLayout(new BorderLayout());
	this.imagen = imagen;

	}
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		if (imagen != null) {
			
			g.drawImage(imagen, 0, 0, this);
		}
	}

}
