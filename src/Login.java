import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {
	
	//VARIABLES GLOBALES
	private String anterior, actual;
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
		
		//Splash
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
		splash.setSize(800,800);
		splash.setLocation(0,0);
		
		//logo
		
		 File file = new File("\"C:\\Users\\panfu\\eclipse-workspace\\Examen Unidad 2\\src\\amongus.jpg\"");
	        BufferedImage bufferedImage = ImageIO.read(file);

	        ImageIcon imageIcon = new ImageIcon(bufferedImage);
	        JFrame jFrame = new JFrame();

	        jFrame.setLayout(new FlowLayout());
	        
	        jFrame.setSize(500, 500);
	        JLabel jLabel = new JLabel();

	        jLabel.setIcon(imageIcon);
	        jFrame.add(jLabel);
	        jFrame.setVisible(true);


		
		//textos splash
		JLabel splash1 = new JLabel("Creado por: "); //PRUEBA DE SPLASH PANFU
		splash1.setSize(200,50);
		splash1.setLocation(190,560);
		splash1.setForeground(Color.black);
		splash1.setFont(new Font("ABeeZee",Font.PLAIN,20));
		splash.add(splash1);
		
		JLabel splash2 = new JLabel("Adriana Noemi Garcia Benitez"); 
		splash2.setSize(300,50);
		splash2.setLocation(110,580);
		splash2.setForeground(Color.black);
		splash2.setFont(new Font("ABeeZee",Font.PLAIN,20));
		splash.add(splash2);
		
		JLabel splash3 = new JLabel("David Alejandro Castro Montaño"); 
		splash3.setSize(300,50);
		splash3.setLocation(100,600);
		splash3.setForeground(Color.black);
		splash3.setFont(new Font("ABeeZee",Font.PLAIN,20));
		splash.add(splash3);
		
		
		
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
		etiqueTitulo.setFont(new Font("ABeeZee",Font.PLAIN,20));
		login.add(etiqueTitulo);
		
		JLabel etiqueNombreUsuario = new JLabel("Nombre de usuario");
		etiqueNombreUsuario.setSize(200,50);
		etiqueNombreUsuario.setLocation(10,60);
		etiqueNombreUsuario.setForeground(Color.black);
		etiqueNombreUsuario.setFont(new Font("ABeeZee",Font.PLAIN,20));
		login.add(etiqueNombreUsuario);
		
		JTextField ingreNombre = new JTextField();
		ingreNombre.setSize(200,40);
		ingreNombre.setLocation(10,110);
		login.add(ingreNombre);
		
		JLabel etiqueContrasena = new JLabel("Contraseña");
		etiqueContrasena.setSize(200,50);
		etiqueContrasena.setLocation(10,170);
		etiqueContrasena.setForeground(Color.black);
		etiqueContrasena.setFont(new Font("ABeeZee",Font.PLAIN,20));
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