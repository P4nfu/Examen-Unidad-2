import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {
	
	//VARIABLES GLOBALES
	private String anterior;
	private String actual;
	private JPanel panel;
	
	public Login() {
		
		//Crear ventana
		this.setVisible(true);
		this.setSize(500,700);
		this.setLayout(null);
		this.setTitle("Formulario inicial");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//INICIO DE LA APLICACION
		splash();
		
		this.repaint();
	}
	
	public void limpiarPaneles() {
		
		if (panel!=null) {
			this.remove(panel);
		}
		
		if (actual.equals("splash")){
			panel = splash(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		
	}
	
	public JPanel splash() {
		anterior = actual;
		actual = "splash";
		
		//splash
		JPanel splash = new JPanel();
		splash.setLayout(null);
		splash.setBackground(Color.decode("#B3FFF1"));
		splash.setVisible(true);
		splash.setSize(500,700);
		splash.setLocation(0,0);
		
		try {
			this.add(splash);
			Thread.sleep(5000);
			this.remove(splash);
		}catch(InterruptedException ex) {
			
		}
		
		return splash;
	}
	
	public JPanel pantallaSplash() {
		JPanel panelSplash = new JPanel();
		
		
		
		return panelSplash;
	}
	
}
