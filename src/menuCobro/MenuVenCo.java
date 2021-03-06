package menuCobro;

	import java.awt.Color;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.*;

import login.inicio;
	

	public class MenuVenCo {
		JFrame principal = new JFrame();
		JTabbedPane pestañas = new JTabbedPane();
		JPanel ventas = new JPanel();
		JPanel tablas = new JPanel();
		VenCobros c = new VenCobros();

		private void menu() throws ClassNotFoundException {
			// Frame datos
			principal.setTitle("Modulo Administrador");
			principal.setLocationRelativeTo(null);
			principal.setBounds(500, 150, 900, 700);
			principal.setVisible(true);
			JButton cerrar = new JButton("Cerrar Sesion");
			cerrar.setBackground(Color.red);
			cerrar.setForeground(Color.white);
			cerrar.setBounds(700, 630, 150, 20);

			// Funcion cerrar
			ActionListener funcion_cerrar = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					inicio log = new inicio();
					log.ejecutar();
					principal.setVisible(false);
				}
			};

			// Acción del evento
			cerrar.addActionListener(funcion_cerrar);

			principal.add(cerrar);
			principal.add(pestañas);

			// colores de los paneles
			ventas.setBackground(Color.cyan);
			tablas.setBackground(Color.cyan);

			ventas.setLayout(null);
			tablas.setLayout(null);

			// agregamos los paneles
			pestañas.addTab("Ventas", ventas);
			pestañas.addTab("Tablas", tablas);
			
			c.ejecutar();
			ventas.add(c.filtro);
			ventas.add(c.ventas);
			

		}

		public void ejecutar() throws ClassNotFoundException {
			menu();
		}

}
