import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
	private File archivo = new File("users.txt");
	
	public Login() throws IOException {

		//Crear ventana
		this.setVisible(true);
		this.setSize(500,700);
		this.setLayout(null);
		this.setTitle("Formulario inicial");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//INICIO DE LA APLICACION
		crearDocumentoTxt();
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
		
		if (actual.equals("login")) {
			panel = login();
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		
		if (actual.equals("menu")) {
			panel = menu();
			
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
		
		JLabel etiqueSplash = new JLabel("Splash"); //PRUEBA DE SPLASH PANFU
		etiqueSplash.setSize(200,50);
		etiqueSplash.setLocation(10,10);
		etiqueSplash.setForeground(Color.black);
		etiqueSplash.setFont(new Font("Arial Bold",Font.PLAIN,20));
		splash.add(etiqueSplash);
		
		try {
			this.add(splash);
			Thread.sleep(5000);
			this.remove(splash);
		}catch(InterruptedException ex) {
			
		}
		
		anterior = actual;
		actual = "login";
		
		limpiarPaneles();
		
		return splash;
	}
	
	public JPanel login() {
		anterior = actual;
		actual = "login";
		
		JPanel login = new JPanel();
		login.setSize(500,700);
		login.setBackground(Color.decode("#B3FFF1"));
		login.setVisible(true);
		login.setLayout(null);
		login.setLocation(0,0);
		
		//SUBTITULOS Y ELEMENTOS PARA INGRESAR DATOS//////////////////////////////////////////////////////
		
		JLabel etiqueTitulo = new JLabel("Accede a tu cuenta");
		etiqueTitulo.setSize(200,50);
		etiqueTitulo.setLocation(10,10);
		etiqueTitulo.setForeground(Color.black);
		etiqueTitulo.setFont(new Font("Arial Bold",Font.PLAIN,20));
		login.add(etiqueTitulo);
		
		JLabel etiqueNombreUsuario = new JLabel("Nombre de usuario");
		etiqueNombreUsuario.setSize(200,50);
		etiqueNombreUsuario.setLocation(10,60);
		etiqueNombreUsuario.setForeground(Color.black);
		etiqueNombreUsuario.setFont(new Font("Arial Bold",Font.PLAIN,20));
		login.add(etiqueNombreUsuario);
		
		JTextField ingreNombre = new JTextField();
		ingreNombre.setSize(200,40);
		ingreNombre.setLocation(10,110);
		login.add(ingreNombre);
		
		JLabel etiqueContrasena = new JLabel("Contraseña");
		etiqueContrasena.setSize(200,50);
		etiqueContrasena.setLocation(10,170);
		etiqueContrasena.setForeground(Color.black);
		etiqueContrasena.setFont(new Font("Arial Bold",Font.PLAIN,20));
		login.add(etiqueContrasena);
		
		JTextField ingreContrasena = new JTextField();
		ingreContrasena.setSize(200,40);
		ingreContrasena.setLocation(10,220);
		login.add(ingreContrasena);
		
		//BOTONES//
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setSize(150,50);
		btnCancelar.setLocation(10,300);
		login.add(btnCancelar);
		
		JButton btnInicarSesion = new JButton("Iniciar Sesión");
		btnInicarSesion.setSize(150,50);
		btnInicarSesion.setLocation(200,300);
		login.add(btnInicarSesion);
		
		//ACCIONES DE LOS BOTONES///////////////////////////////////////////////////////////////////////
		btnInicarSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				anterior = actual;
				actual = "menu";
				limpiarPaneles();
				
			}
		});
		
		return login;
	}
	
	public JPanel menu() {
		
		JPanel menu = new JPanel();
		menu.setSize(500,700);
		//menu.setBackground(Color.decode("#B3FFF1"));
		menu.setBackground(Color.red);
		menu.setVisible(true);
		menu.setLayout(null);
		menu.setLocation(0,0);
		
		
		
		return menu;
	}
	
	public void crearDocumentoTxt() throws IOException {//CREA EL DOCUMENTO DE TEXTO SI NO EXISTE Y AGREGA UN USUARIO PREDIFINIDO
		if (!archivo.exists()) {
			FileWriter escritor;
			PrintWriter linea;
			
			try {
				archivo.createNewFile();
				escritor = new FileWriter(archivo,true);
				linea = new PrintWriter(escritor);
				linea.println("Jonathan"+"-"+"Soto Muños"+"-"+"jsoto@uabcs.mx"+"-"+"password123");
				linea.close();
				escritor.close();
			}catch(Exception e) {}
		}
	}
	
}