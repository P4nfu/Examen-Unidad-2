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
		
<<<<<<< HEAD
		if (actual.equals("cuenta personal")) {
			panel = miCuentaPersonal();
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		
		if (actual.equals("crear usuario")) {
			panel = crearUsuario();
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		
=======
>>>>>>> branch 'main' of https://github.com/P4nfu/Examen-Unidad-2.git
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
		JLabel splash1 = new JLabel("Creado por: ");
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
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setSize(150,50);
		btnCancelar.setLocation(40,520);
		login.add(btnCancelar);
		
		JButton btnInicarSesion = new JButton("Iniciar Sesión");
		btnInicarSesion.setBackground(Color.decode("#75D4F2"));
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
		
<<<<<<< HEAD
		itemUsuariosCrearUsua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				etiqueBienvenida.setVisible(false);
				
				anterior = actual;
				actual = "crear usuario";
				
				try {
					limpiarPaneles();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		this.repaint();
		this.revalidate();
=======
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
		
>>>>>>> branch 'main' of https://github.com/P4nfu/Examen-Unidad-2.git
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
		
<<<<<<< HEAD
		btnActualizarDatos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					actualizarDatos(ingreNombre.getText(),ingreApellidos.getText(),ingreCorreo.getText(),correoQueIngresoAlSistema,ingreContrasena.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		this.repaint();
		this.revalidate();
		return miCuenta;
	}
	
	public JPanel crearUsuario() {
		JPanel crearUsuario = new JPanel();
		crearUsuario.setSize(500,700);
		crearUsuario.setLocation(0,0);
		crearUsuario.setVisible(true);
		crearUsuario.setLayout(null);
		crearUsuario.setBackground(Color.decode("#B3FFF1"));
		
		JLabel etiqueTitulo = new JLabel("Crear Usuario");
		etiqueTitulo.setSize(200,30);
		etiqueTitulo.setLocation(10,50);
		etiqueTitulo.setFont(new Font("Arial",Font.PLAIN,20));
		crearUsuario.add(etiqueTitulo);
		
		//ELEMENTOS DE LA CUENTA DEL USUARIO//
		JLabel etiqueNombre = new JLabel("Nombre:");
		etiqueNombre.setSize(200,30);
		etiqueNombre.setLocation(10,100);
		etiqueNombre.setFont(new Font("Arial",Font.PLAIN,20));
		crearUsuario.add(etiqueNombre);
		
		JTextField ingreNombre = new JTextField();
		ingreNombre.setSize(200,30);
		ingreNombre.setLocation(10,140);
		crearUsuario.add(ingreNombre);
		
		JLabel etiqueApellidos = new JLabel("Apellidos:");
		etiqueApellidos.setSize(200,30);
		etiqueApellidos.setLocation(10,180);
		etiqueApellidos.setFont(new Font("Arial",Font.PLAIN,20));
		crearUsuario.add(etiqueApellidos);
		
		JTextField ingreApellidos = new JTextField();
		ingreApellidos.setSize(200,30);
		ingreApellidos.setLocation(10,220);
		crearUsuario.add(ingreApellidos);
		
		JLabel etiqueCorreo = new JLabel("Correo:");
		etiqueCorreo.setSize(200,30);
		etiqueCorreo.setLocation(10,260);
		etiqueCorreo.setFont(new Font("Arial",Font.PLAIN,20));
		crearUsuario.add(etiqueCorreo);
		
		JTextField ingreCorreo = new JTextField();
		ingreCorreo.setSize(200,30);
		ingreCorreo.setLocation(10,300);
		crearUsuario.add(ingreCorreo);
		
		JLabel etiqueContrasena = new JLabel("Contraseña:");
		etiqueContrasena.setSize(200,30);
		etiqueContrasena.setLocation(10,340);
		etiqueContrasena.setFont(new Font("Arial",Font.PLAIN,20));
		crearUsuario.add(etiqueContrasena);
		
		JPasswordField ingreContrasena = new JPasswordField();
		ingreContrasena.setSize(200,30);
		ingreContrasena.setLocation(10,380);
		crearUsuario.add(ingreContrasena);
		
		JLabel etiqueConfirmarContrasena = new JLabel("Confirmar Contraseña:");
		etiqueConfirmarContrasena.setSize(200,30);
		etiqueConfirmarContrasena.setLocation(10,420);
		etiqueConfirmarContrasena.setFont(new Font("Arial",Font.PLAIN,20));
		crearUsuario.add(etiqueConfirmarContrasena);
		
		JPasswordField ingreConfirmarContrasena = new JPasswordField();
		ingreConfirmarContrasena.setSize(200,30);
		ingreConfirmarContrasena.setLocation(10,460);
		crearUsuario.add(ingreConfirmarContrasena);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setSize(200,50);
		btnCancelar.setLocation(10,500);
		crearUsuario.add(btnCancelar);
		
		JButton btnActualizarDatos = new JButton("Crear Usuario");
		btnActualizarDatos.setSize(200,50);
		btnActualizarDatos.setLocation(250,500);
		crearUsuario.add(btnActualizarDatos);
		
		//ACCIONES DEL BARRA MENU/////////////////////////////////////////////////////////////////////////////
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actual = anterior;
				try {
					limpiarPaneles();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		this.repaint();
		this.revalidate();
		return crearUsuario;
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
					nombreQueIngresoAlSistema = buscador[0];
					apellidosQueIngresoAlSistema = buscador[1];
					correoQueIngresoAlSistema = buscador[2];
					contrasenaQueIngresoAlSistema = buscador[3];
				}
			}
	
			temp = bf.readLine();//iterador
			if(temp!=null)
				buscador = temp.split("-");
=======
				temp = bf.readLine();//iterador
				if(temp!=null)
					buscador = temp.split("-");
>>>>>>> branch 'main' of https://github.com/P4nfu/Examen-Unidad-2.git
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
	
<<<<<<< HEAD
	public void modificarArchivo(File fileAntiguo,String nuevoNombre,String nuevosApellidos,String nuevoCorreo,String antiguoCorreo,String nuevaContrasena) throws IOException {
		//NUEVO ARCHIVO Y LECTOR DEL DOCUMENTO TXT
		Random numaleatorio = new Random(3816L);
		String nFnuevo = "auxiliar"+".txt";
		System.out.println(nFnuevo+" <--------------");
		File nuevoArchivo = new File(nFnuevo);
		if (!nuevoArchivo.exists())
			nuevoArchivo.createNewFile();
		BufferedReader br;
		
		//ESCRITOR DE DOCUMENTO
		FileWriter escritor;
		PrintWriter txtLinea;
		
		try {
			
			if (fileAntiguo.exists()) {
				br = new BufferedReader(new FileReader(fileAntiguo));
				
				String linea;
				
				while((linea=br.readLine())!=null) {
					String[] buscador = linea.split("-");
					
					if (buscador[2].equals(antiguoCorreo)) {
						ingresarDatos(nuevoArchivo, nuevoNombre, nuevosApellidos, nuevoCorreo, nuevaContrasena);
						nombreQueIngresoAlSistema = nuevoNombre;
						apellidosQueIngresoAlSistema = nuevosApellidos;
						correoQueIngresoAlSistema = nuevoCorreo;
						contrasenaQueIngresoAlSistema = nuevaContrasena;
					}
					else {
						escritor = new FileWriter(nuevoArchivo,true);
						txtLinea = new PrintWriter(escritor);
						txtLinea.println(linea);
						txtLinea.close();
						escritor.close();
					}
				}
				br.close();
				
				if (fileAntiguo.delete()) {
					System.out.println("El archivo se borro");
				}else {
					System.out.println("No se borro el srchivo");
				}
				
				nuevoArchivo.renameTo(fileAntiguo);
				
			}
			
		}catch(Exception e) {}
		
	}
		
	public void ingresarDatos(File archivoIN,String nombre,String apellidos,String correo,String contrasena) throws IOException {
		FileWriter escritor;
		PrintWriter linea;
		
		if (archivoIN.exists()) {
			escritor = new FileWriter(archivoIN,true);
			linea = new PrintWriter(escritor);
			linea.println(nombre+"-"+apellidos+"-"+correo+"-"+contrasena);
			linea.close();
			escritor.close();
		}
		
	}
	
=======
>>>>>>> branch 'main' of https://github.com/P4nfu/Examen-Unidad-2.git
}