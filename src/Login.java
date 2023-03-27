import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

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
import javax.swing.border.Border;

public class Login extends JFrame {
	
	//VARIABLES GLOBALES
	private String anterior,actual,correoQueIngresoAlSistema,nombreQueIngresoAlSistema,apellidosQueIngresoAlSistema,contrasenaQueIngresoAlSistema;
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
	
	public void limpiarPaneles() throws IOException {
		
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
		
	}
	
	public JPanel splash() throws IOException {
		anterior = actual;
		actual = "splash";
		
		//splash
		JPanel splash = new JPanel();
		splash.setLayout(null);
		splash.setBackground(Color.decode("#B3FFF1"));
		splash.setVisible(true);
		splash.setSize(500,700);
		splash.setLocation(0,0);
		
		//textos splash
		JLabel splash1 = new JLabel("Creado por: "); //PRUEBA DE SPLASH PANFU
		splash1.setSize(200,50);
		splash1.setLocation(190,560);
		splash1.setForeground(Color.decode("#00290B"));
		splash1.setFont(new Font("ABeeZee",Font.BOLD,20));
		splash.add(splash1);
		
		JLabel splash2 = new JLabel("Adriana Noemi Garcia Benitez"); 
		splash2.setSize(300,50);
		splash2.setLocation(110,580);
		splash2.setForeground(Color.decode("#00290B"));
		splash2.setFont(new Font("ABeeZee",Font.PLAIN,20));
		splash.add(splash2);
		
		JLabel splash3 = new JLabel("David Alejandro Castro Montaño"); 
		splash3.setSize(300,50);
		splash3.setLocation(100,600);
		splash3.setForeground(Color.decode("#00290B"));
		splash3.setFont(new Font("ABeeZee",Font.PLAIN,20));
		splash.add(splash3);
		
		this.repaint();
		this.revalidate();
		
		try {
			this.add(splash);
			Thread.sleep(3000);
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
		etiqueTitulo.setSize(500,50);
		etiqueTitulo.setLocation(50,10);
		etiqueTitulo.setForeground(Color.decode("#00290B"));
		etiqueTitulo.setFont(new Font("ABeeZee",Font.BOLD,40));
		login.add(etiqueTitulo);
		
		JLabel etiqueNombreUsuario = new JLabel("Nombre de usuario");
		etiqueNombreUsuario.setSize(200,50);
		etiqueNombreUsuario.setLocation(37,338);
		etiqueNombreUsuario.setForeground(Color.decode("#00290B"));
		etiqueNombreUsuario.setFont(new Font("ABeeZee",Font.PLAIN,20));
		login.add(etiqueNombreUsuario);
		
		JTextField ingreNombre = new JTextField();
		ingreNombre.setSize(400,30);
		ingreNombre.setLocation(37,380);
		login.add(ingreNombre);
		
		JLabel etiqueContrasena = new JLabel("Contraseña");
		etiqueContrasena.setSize(200,50);
		etiqueContrasena.setLocation(37,400);
		etiqueContrasena.setForeground(Color.decode("#00290B"));
		etiqueContrasena.setFont(new Font("ABeeZee",Font.PLAIN,20));
		login.add(etiqueContrasena);
		
		JPasswordField ingreContrasena = new JPasswordField();
		ingreContrasena.setSize(400,30);
		ingreContrasena.setLocation(37,438);
		login.add(ingreContrasena);
		
		
		
		//BOTONES//
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setSize(150,50);
		btnCancelar.setLocation(37,500);
		btnCancelar.setBackground(Color.decode("#F7292C"));
		btnCancelar.setForeground(Color.decode("#731314"));
		login.add(btnCancelar);
		
		JButton btnInicarSesion = new JButton("Iniciar Sesión");
		btnInicarSesion.setSize(150,50);
		btnInicarSesion.setLocation(285,500);
		btnInicarSesion.setBackground(Color.decode("#7795FF"));
		btnInicarSesion.setForeground(Color.decode("#344270"));
		login.add(btnInicarSesion);
		
		JPanel deco1 = new JPanel ();
		deco1.setSize(450,250);
		deco1.setLocation(15,320);
		deco1.setBackground(Color.decode("#9BDEE6"));
		deco1.setVisible(true);
		login.add(deco1);
		
		//ACCIONES DE LOS BOTONES///////////////////////////////////////////////////////////////////////
		btnInicarSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String contraseñaTemp = new String(ingreContrasena.getPassword());
				
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
		
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ingreNombre.setText("");
				ingreContrasena.setText("");
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
		
		//BARRA DE MENU/////////////////////////////////////////////////////////////////////////////////////////////////////
		JMenuBar barra = new JMenuBar();
		barra.setSize(500,25);
		barra.setLocation(0,0);
		JMenu barraCuenta = new JMenu("Cuenta");
		JMenu barraUsuarios = new JMenu("Usuarios");
		JMenu barraAyuda = new JMenu("Ayuda");
		barra.add(barraCuenta);
		barra.add(barraUsuarios);
		barra.add(barraAyuda);
		JMenuItem itemCuentaMiCuenta = new JMenuItem("Mi cuenta"); //SE AÑADE A CUENTA 
		JMenuItem itemCuentaCerrarSesion = new JMenuItem("Cerrar sesión");//SE AÑADE A CUENTA
		barraCuenta.add(itemCuentaMiCuenta);
		barraCuenta.add(itemCuentaCerrarSesion);
		JMenuItem itemUsuariosListaDeUsua = new JMenuItem("Lista de usuarios");//SE AÑADE A USUARIOS
		JMenuItem itemUsuariosCrearUsua = new JMenuItem("Crear usuarios");//SE AÑADE A USUARIOS
		barraUsuarios.add(itemUsuariosListaDeUsua);
		barraUsuarios.add(itemUsuariosCrearUsua);
		JMenuItem itemAyudaPregunta = new JMenuItem("¿Como crear usuarios?");//SE AÑADE A AYUDA
		barraAyuda.add(itemAyudaPregunta);
		this.add(barra);
		//Fin de la barra menu
		
		//Bienvenida
		JLabel etiqueBienvenida = new JLabel("Bienvenido "+nombreQueIngresoAlSistema);
		etiqueBienvenida.setSize(200,40);
		etiqueBienvenida.setLocation(150,150);
		etiqueBienvenida.setFont(new Font("ABeeZee",Font.PLAIN,20));
		menu.add(etiqueBienvenida);
		
		//ACCIONES DEL BARRA MENU/////////////////////////////////////////////////////////////////////////////
		itemCuentaMiCuenta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				etiqueBienvenida.setVisible(false);
				
				anterior = actual;
				actual = "cuenta personal";
				
				try {
					limpiarPaneles();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
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
		return menu;
	}
	
	public JPanel miCuentaPersonal() {
		JPanel miCuenta = new JPanel();
		miCuenta.setSize(500,700);
		miCuenta.setLocation(0,0);
		miCuenta.setVisible(true);
		miCuenta.setLayout(null);
		miCuenta.setBackground(Color.decode("#B3FFF1"));
		
		//ELEMENTOS DE LA CUENTA DEL USUARIO//
		JLabel etiqueNombre = new JLabel("Nombre:");
		etiqueNombre.setSize(200,30);
		etiqueNombre.setLocation(10,100);
		etiqueNombre.setFont(new Font("ABeeZee",Font.PLAIN,20));
		miCuenta.add(etiqueNombre);
		
		JTextField ingreNombre = new JTextField(nombreQueIngresoAlSistema);
		ingreNombre.setSize(200,30);
		ingreNombre.setLocation(10,140);
		miCuenta.add(ingreNombre);
		
		JLabel etiqueApellidos = new JLabel("Apellidos:");
		etiqueApellidos.setSize(200,30);
		etiqueApellidos.setLocation(10,180);
		etiqueApellidos.setFont(new Font("ABeeZee",Font.PLAIN,20));
		miCuenta.add(etiqueApellidos);
		
		JTextField ingreApellidos = new JTextField(apellidosQueIngresoAlSistema);
		ingreApellidos.setSize(200,30);
		ingreApellidos.setLocation(10,220);
		miCuenta.add(ingreApellidos);
		
		JLabel etiqueCorreo = new JLabel("Correo:");
		etiqueCorreo.setSize(200,30);
		etiqueCorreo.setLocation(10,260);
		etiqueCorreo.setFont(new Font("ABeeZee",Font.PLAIN,20));
		miCuenta.add(etiqueCorreo);
		
		JTextField ingreCorreo = new JTextField(correoQueIngresoAlSistema);
		ingreCorreo.setSize(200,30);
		ingreCorreo.setLocation(10,300);
		miCuenta.add(ingreCorreo);
		
		JLabel etiqueContrasena = new JLabel("Contraseña:");
		etiqueContrasena.setSize(200,30);
		etiqueContrasena.setLocation(10,340);
		etiqueContrasena.setFont(new Font("ABeeZee",Font.PLAIN,20));
		miCuenta.add(etiqueContrasena);
		
		JTextField ingreContrasena = new JTextField(contrasenaQueIngresoAlSistema);
		ingreContrasena.setSize(200,30);
		ingreContrasena.setLocation(10,380);
		miCuenta.add(ingreContrasena);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setSize(200,50);
		btnCancelar.setLocation(10,420);
		miCuenta.add(btnCancelar);
		
		JButton btnActualizarDatos = new JButton("Actualizar Datos");
		btnActualizarDatos.setSize(200,50);
		btnActualizarDatos.setLocation(250,420);
		miCuenta.add(btnActualizarDatos);
		
		//ACCIONES DEL BARRA MENU/////////////////////////////////////////////////////////////////////////////
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				anterior = actual;
				actual = "menu";
				try {
					limpiarPaneles();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
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
		etiqueTitulo.setFont(new Font("ABeeZee",Font.PLAIN,20));
		crearUsuario.add(etiqueTitulo);
		
		//ELEMENTOS DE LA CUENTA DEL USUARIO//
		JLabel etiqueNombre = new JLabel("Nombre:");
		etiqueNombre.setSize(200,30);
		etiqueNombre.setLocation(10,100);
		etiqueNombre.setFont(new Font("ABeeZee",Font.PLAIN,20));
		crearUsuario.add(etiqueNombre);
		
		JTextField ingreNombre = new JTextField();
		ingreNombre.setSize(200,30);
		ingreNombre.setLocation(10,140);
		crearUsuario.add(ingreNombre);
		
		JLabel etiqueApellidos = new JLabel("Apellidos:");
		etiqueApellidos.setSize(200,30);
		etiqueApellidos.setLocation(10,180);
		etiqueApellidos.setFont(new Font("ABeeZee",Font.PLAIN,20));
		crearUsuario.add(etiqueApellidos);
		
		JTextField ingreApellidos = new JTextField();
		ingreApellidos.setSize(200,30);
		ingreApellidos.setLocation(10,220);
		crearUsuario.add(ingreApellidos);
		
		JLabel etiqueCorreo = new JLabel("Correo:");
		etiqueCorreo.setSize(200,30);
		etiqueCorreo.setLocation(10,260);
		etiqueCorreo.setFont(new Font("ABeeZee",Font.PLAIN,20));
		crearUsuario.add(etiqueCorreo);
		
		JTextField ingreCorreo = new JTextField();
		ingreCorreo.setSize(200,30);
		ingreCorreo.setLocation(10,300);
		crearUsuario.add(ingreCorreo);
		
		JLabel etiqueContrasena = new JLabel("Contraseña:");
		etiqueContrasena.setSize(200,30);
		etiqueContrasena.setLocation(10,340);
		etiqueContrasena.setFont(new Font("ABeeZee",Font.PLAIN,20));
		crearUsuario.add(etiqueContrasena);
		
		JPasswordField ingreContrasena = new JPasswordField();
		ingreContrasena.setSize(200,30);
		ingreContrasena.setLocation(10,380);
		crearUsuario.add(ingreContrasena);
		
		JLabel etiqueConfirmarContrasena = new JLabel("Confirmar Contraseña:");
		etiqueConfirmarContrasena.setSize(200,30);
		etiqueConfirmarContrasena.setLocation(10,420);
		etiqueConfirmarContrasena.setFont(new Font("ABeeZee",Font.PLAIN,20));
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
	//Menu de ayuda al usuario
	public JPanel ayudaUs() {
		JPanel ayudaUs = new JPanel();
		ayudaUs.setSize(500,700);
		ayudaUs.setLocation(0,0);
		ayudaUs.setVisible(true);
		ayudaUs.setLayout(null);
		ayudaUs.setBackground(Color.decode("#B3FFF1"));
		
		JLabel ayuda1 = new JLabel("Como crear un usuario?: ");
		ayuda1.setSize(200,30);
		ayuda1.setLocation(10,50);
		ayuda1.setFont(new Font("ABeeZee",Font.BOLD,40));
		ayuda1.add(ayudaUs);
		
		JLabel ayuda2 = new JLabel("1. Haz click en el apartado de Usuarios en");
		ayuda2.setSize(200,30);
		ayuda2.setLocation(20,50);
		ayuda2.setFont(new Font("ABeeZee",Font.PLAIN,20));
		ayuda2.add(ayudaUs);
		
		JLabel ayuda3 = new JLabel("1. Haz click en el apartado de Usuarios en");
		ayuda3.setSize(200,30);
		ayuda3.setLocation(20,50);
		ayuda3.setFont(new Font("ABeeZee",Font.PLAIN,20));
		ayuda3.add(ayudaUs);
		
		
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
		}
		bf.close();
		
		return resultado;
	}
	
	public void actualizarDatos(String nombre,String apellidos,String correo,String antiguoCorreo,String contrasena) throws IOException {
		
		if (correoQueIngresoAlSistema.equals(correo)) {
			JOptionPane.showMessageDialog(null,"Es necesario cambiar el correo para realizar modificaciones","La informacion no se pudo actualizar",JOptionPane.WARNING_MESSAGE);
		}else {
			modificarArchivo(archivo, nombre, apellidos, correo, antiguoCorreo, contrasena);
			JOptionPane.showMessageDialog(null,"Datos actualizados"," ",JOptionPane.INFORMATION_MESSAGE);
		}
		
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
	
}