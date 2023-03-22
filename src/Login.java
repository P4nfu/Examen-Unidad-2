import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {
public Login() {
		
		//Crear ventana
		this.setVisible(true);
		this.setSize(500,700);
		this.setLayout(null);
		this.setTitle("Formulario inicial");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(150, 150);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		//colocar color al fondo
		this.getContentPane().setBackground(Color.decode("#B3FFF1"));
		
		//splat
		JPanel splat = new JPanel();
		splat.setLayout(null);
		splat.setBackground(Color.decode("#B3FFF1"));
		splat.setVisible(true);
		splat.setSize(500,700);
		splat.setLocation(0,0);
		this.add(splat);
		
		//inicio de sesion
		JPanel inicio = new JPanel();
		inicio.setLayout(null);
		inicio.setBackground(Color.decode("#B3FFF1"));
		inicio.setSize(500,700);
		inicio.setLocation(0,0);
		inicio.setVisible(true);
		
		//Una vez logeado el usuario le salta esta pantalla 
		JPanel inicioUsuario = new JPanel();
		inicioUsuario.setLayout(null);
		inicioUsuario.setBackground(Color.decode("#B3FFF1"));
		inicioUsuario.setSize(500,700);
		inicioUsuario.setLocation(0,0);
		inicioUsuario.setVisible(true);
		
		//Menu principal
		JPanel menu = new JPanel();
		menu.setLayout(null);
		menu.setBackground(Color.decode("#B3FFF1"));
		menu.setVisible(true);
		menu.setSize(500,700);
		menu.setLocation(0,0);
		this.add(menu);
		
		//mi cuenta personal
		JPanel cuenta = new JPanel();
		cuenta.setLayout(null);
		cuenta.setBackground(Color.decode("#B3FFF1"));
		cuenta.setSize(500,700);
		cuenta.setLocation(0,0);
		cuenta.setVisible(true);
		
		//lista de usuarios
		JPanel listaUs = new JPanel();
		listaUs.setLayout(null);
		listaUs.setBackground(Color.decode("#B3FFF1"));
		listaUs.setSize(500,700);
		listaUs.setLocation(0,0);
		listaUs.setVisible(true);
		
		//ayuda
		JPanel ayuda = new JPanel();
		ayuda.setLayout(null);
		ayuda.setBackground(Color.decode("#B3FFF1"));
		ayuda.setVisible(true);
		ayuda.setSize(500,700);
		ayuda.setLocation(0,0);
		this.add(ayuda);
		
		//panel de inicio de sesion

				JLabel etiqueTitulo = new JLabel("Iniciar sesión",JLabel.CENTER);
				etiqueTitulo.setFont(new Font("HELVETICA",Font.BOLD,35));
				etiqueTitulo.setSize(230,32);
				etiqueTitulo.setLocation(135,75);
				inicio.add(etiqueTitulo);
				
				JLabel etiqueUsuario = new JLabel("Escriba su nombre:");
				etiqueUsuario.setFont(new Font("Arial",Font.PLAIN,18));
				etiqueUsuario.setSize(300,23);
				etiqueUsuario.setLocation(100,150);
				inicio.add(etiqueUsuario);
				
				JTextField nombreUsuario = new JTextField();
				nombreUsuario.setSize(300,25);
				nombreUsuario.setLocation(100,180);
				inicio.add(nombreUsuario);
				
				JLabel etiqueContraseñaREG = new JLabel("Escriba su contraseña:");
				etiqueContraseñaREG.setFont(new Font("Arial",Font.PLAIN,18));
				etiqueContraseñaREG.setSize(300,23);
				etiqueContraseñaREG.setLocation(100,210);
				inicio.add(etiqueContraseñaREG);
				
				JPasswordField contraseñaINI = new JPasswordField();
				contraseñaINI.setSize(300,25);
				contraseñaINI.setLocation(100,240);
				inicio.add(contraseñaINI);
				
				JButton iniciarSesionBtn = new JButton("Iniciar sesión");
				iniciarSesionBtn.setSize(150,30);
				iniciarSesionBtn.setLocation(175,320);
				inicio.add(iniciarSesionBtn);
		
		
		
		
		
		this.repaint();
}
}
