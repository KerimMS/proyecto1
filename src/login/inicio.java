package login;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import javax.swing.*;

import Admin.MenuAdmin;
import funciones.funcionVe;
import menuCobro.ListaLoginVendedor;
import menuCobro.MenuVenCo;

public class inicio implements Serializable {
//comenzara por el menu usando swing
	// atributo
	JFrame inicio = new JFrame();
	JPanel p1 = new JPanel();
	JLabel l1 = new JLabel();
	JLabel l2 = new JLabel();
	JTextField t1 = new JTextField();
	JPasswordField t2 = new JPasswordField(); // para que no se mire la contreseña se usa password
	JButton b1 = new JButton();
	funcionVe lV = new funcionVe();
	

	// metodo
	private void frame() {
		inicio.setTitle("login");
		inicio.setLocationRelativeTo(null);
		// otro metodo para definir el tamaño de la ventana, inicio.setSize(200,150);
		// x, y ancho, alto
		inicio.setBounds(500, 300, 500, 500);
		inicio.setVisible(true);
		p1.setBackground(Color.orange);
		// tamaño del frame
		p1.setBounds(500, 300, 500, 500);
		p1.setLayout(null);
		inicio.add(p1);
		etiquetas();

	}

//etiquetas y jtextfiels
	private void etiquetas() {
		//etiquetas
		l1.setText("Usuario: ");
		l1.setFont(new Font("Sering", Font.PLAIN, 24));
		l1.setBounds(50, 100, 100, 80);
		l1.setVisible(true); // se agrega a veces
		p1.add(l1);

		l2.setText("Contraseña: ");
		l2.setFont(new Font("Sering", Font.PLAIN, 25));
		l2.setBounds(50, 230, 180, 80);
		l2.setVisible(true);
		p1.add(l2);

		// jtextflied
		t1.setBounds(200, 115, 200, 40);
		t2.setBounds(200, 255, 200, 40);
		
		p1.add(t1);
		p1.add(t2);

	}

	private void botones() {
		b1.setText("ingresar");
		b1.setBounds(200,380,100,40);
		p1.add(b1);
		
		//funcionalidad
		ActionListener ingresar = new ActionListener() {
        // terminar de configurar el boton
		@Override
		public void actionPerformed(ActionEvent e) {
			
			// inicio sesion admin
			if (t1.getText().equals("Admin") && t2.getText().equals("Admin")) {
				JOptionPane.showMessageDialog(null, "Bienvenido");
				inicio.setVisible(false);
				
			 MenuAdmin mp = new MenuAdmin();
				
				try {
					mp.ejecutar();
					
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				
			}
			else {
				if (t1.getText().equals(lV) && t2.getText().equals(lV));{
					JOptionPane.showMessageDialog(null, "Bienvenido");
					inicio.setVisible(false);
					
					MenuVenCo Mv = new MenuVenCo();
					
					try {
						Mv.ejecutar();
						
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				}//else {
					//JOptionPane.showMessageDialog(null, "Usuario Equivocado o no existente");
				//}
			
			}
			//maria
			//bhfjkdf45*
		}
	};

	
	//accion evento
	b1.addActionListener(ingresar);
		
	}
	
	public void ejecutar() {
		frame();
		etiquetas();
		botones();
	}

	public static void main(String[] args) {
		inicio p1 = new inicio();
		p1.ejecutar();

	}

}
