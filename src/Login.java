import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
		
//		File file = new File("\"C:\\Users\\panfu\\eclipse-workspace\\Examen Unidad 2\\src\\amongus.jpg\"");
//        BufferedImage bufferedImage = ImageIO.read(file);
//
//        ImageIcon imageIcon = new ImageIcon(bufferedImage);
//        JFrame jFrame = new JFrame();
//
//        jFrame.setLayout(new FlowLayout());
//        
//        jFrame.setSize(500, 500);
//        JLabel jLabel = new JLabel();
//
//        jLabel.setIcon(imageIcon);
//        jFrame.add(jLabel);
//        jFrame.setVisible(true);
		
        ImageIcon icono = new ImageIcon("\"C:\\Users\\panfu\\eclipse-workspace\\Examen Unidad 2\\src\\amongus.jpg\"");
        JLabel imagen = new JLabel(icono);
        getContentPane().add(imagen, BorderLayout.CENTER);
        
        setVisible(true);



		
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
			Thread.sleep(2000);
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
		etiqueTitulo.setLocation(150,10);
		etiqueTitulo.setForeground(Color.black);
		etiqueTitulo.setFont(new Font("ABeeZee",Font.BOLD,20));
		login.add(etiqueTitulo);
		
		JLabel etiqueNombreUsuario = new JLabel("Nombre de usuario");
		etiqueNombreUsuario.setSize(200,50);
		etiqueNombreUsuario.setLocation(150,350);
		etiqueNombreUsuario.setForeground(Color.black);
		etiqueNombreUsuario.setFont(new Font("ABeeZee",Font.PLAIN,20));
		login.add(etiqueNombreUsuario);
		
		JTextField ingreNombre = new JTextField();
		ingreNombre.setSize(390,40);
		ingreNombre.setLocation(40,390);
		login.add(ingreNombre);
		
		JLabel etiqueContrasena = new JLabel("Contraseña de acceso:");
		etiqueContrasena.setSize(250,50);
		etiqueContrasena.setLocation(135,420);
		etiqueContrasena.setForeground(Color.black);
		etiqueContrasena.setFont(new Font("ABeeZee",Font.PLAIN,20));
		login.add(etiqueContrasena);
		
		JTextField ingreContrasena = new JTextField();
		ingreContrasena.setSize(390,40);
		ingreContrasena.setLocation(40,460);
		login.add(ingreContrasena);
		
		//BOTONES//
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setSize(150,50);
		btnCancelar.setLocation(40,520);
		login.add(btnCancelar);
		
		JButton btnInicarSesion = new JButton("Iniciar Sesión");
		btnInicarSesion.setSize(150,50);
		btnInicarSesion.setLocation(280,520);
		login.add(btnInicarSesion);
		//ACCIONES DE LOS BOTONES///////////////////////////////////////////////////////////////////////
				btnInicarSesion.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String contraseñaTemp = new String(((JPasswordField) ingreContrasena).getPassword());
						
						if (ingreNombre.getText().length()==0 || contraseñaTemp.length()==0) {
							JOptionPane.showMessageDialog(null,"Faltan campos por llenar","Error al iniciar sesión",JOptionPane.WARNING_MESSAGE);
						}else if (archivo.exists()){
							try {
								if (buscadorDeCorreoYContraseña(ingreNombre.getText(),contraseñaTemp)) {
									JOptionPane.showMessageDialog(null,"Bienvenido al sistema"," ",JOptionPane.INFORMATION_MESSAGE);
									anterior = actual;
									actual = "menu";
									try {
										limpiarPaneles();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}else {
									JOptionPane.showMessageDialog(null,"El usuario y/o contraseña son erroneos","Error al iniciar sesión",JOptionPane.ERROR_MESSAGE);
								}
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
						
						
						
					}
				});
		
		return login;
	}
	
	public JPanel menu() {
		
		JPanel menu = new JPanel();
		menu.setSize(500,700);
		menu.setBackground(Color.decode("#B3FFF1"));
		menu.setVisible(true);
		menu.setLayout(null);
		menu.setLocation(0,0);
		
		
		JLabel us = new JLabel("Bienvenido:");
		us.setSize(250,50);
		us.setLocation(135,420);
		us.setForeground(Color.black);
		us.setFont(new Font("ABeeZee",Font.PLAIN,20));
		menu.add(us);
		
		JMenuBar bar = new JMenuBar();
		
		JMenu cuenta = new JMenu ("Cuenta");
		bar.add(cuenta);
		JMenu user = new JMenu ("Usuario");
		bar.add(user);
		JMenu ayuda = new JMenu ("Ayuda");
		bar.add(ayuda);
		
		this.add(bar);
		
		
		//MenuItem
		JMenuItem iniciar = new JMenuItem("Inicio de sesion");
		JMenuItem cerrar = new JMenuItem("Cerrar Sesion");
		JMenuItem cambiar = new JMenuItem("Cambiar Usuario");
		JMenuItem creaUs = new JMenuItem("Como crear usuario?");
		JMenuItem acceso = new JMenuItem("Como acceder al sistema?");
		
		return menu;
	}
		public boolean buscadorDeCorreoYContraseña(String correo,String contraseña) throws IOException {
			boolean resultado=false;
			BufferedReader bf = new BufferedReader(new FileReader(archivo));
			String temp = bf.readLine();
			String[] buscador = temp.split("-");
			
			while(temp!=null) {
				
				if (buscador[2].equals(correo)) {
					if(buscador[3].equals(contraseña)) {
						resultado = true;
					}
				}
		
				temp = bf.readLine();//iterador
				if(temp!=null)
					buscador = temp.split("-");
		}
		};
	
	//crear un file en caso de que no exista
	public void crearDocumentoTxt() throws IOException {
		if (!archivo.exists()) {
			FileWriter escritor;
			PrintWriter linea;
			
			try {
				archivo.createNewFile();
				escritor = new FileWriter(archivo,true);
				linea = new PrintWriter(escritor);
				linea.println("Jonathan"+"-"+"Soto Muñoz"+"-"+"jsoto@uabcs.mx"+"-"+"password123");
				linea.close();
				escritor.close();
			}catch(Exception e) {}
		}
	}
	
}