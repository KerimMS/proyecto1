package Admin;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.*;

import com.itextpdf.text.DocumentException;

import constructores.*;
import login.inicio;
public class MenuAdmin {
 JFrame principal = new JFrame();
 JTabbedPane pestañas = new JTabbedPane();
 
 //paneles para pestañas
 JPanel sucursales = new JPanel();
 JPanel clientes = new JPanel();
 JPanel vendedores = new JPanel();
 JPanel productos = new JPanel();
 
 menu_sucursales sm = new menu_sucursales();
 Menu_productos pm = new Menu_productos();
 Menu_clientes cm = new Menu_clientes();
 Menu_vendedores vm = new Menu_vendedores();
 
 private void valor_inicial() throws ClassNotFoundException {
		
		//Frame datos
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

				inicio log = new inicio ();
				
				log.ejecutar();
				principal.setVisible(false);
				
			}
		};

		// Acción del evento
		cerrar.addActionListener(funcion_cerrar);
		
		principal.add(cerrar);
		principal.add(pestañas);
	 
	 //colores paneles
     sucursales.setBackground(Color.DARK_GRAY);
     clientes.setBackground(Color.lightGray);
     vendedores.setBackground(Color.DARK_GRAY);
     productos.setBackground(Color.LIGHT_GRAY);
     
     sucursales.setLayout(null);
	 clientes.setLayout(null);
	 vendedores.setLayout(null);
	 productos.setLayout(null);
     
     //paneles agregados
	 pestañas.addTab("Sucursales",sucursales);
	 pestañas.addTab("Productos",productos);
	 pestañas.addTab("Clientes",clientes);
	 pestañas.addTab("Vendedores",vendedores);
	 
	 sm.ejecutar();
	 sucursales.add(sm.crear);
	 sucursales.add(sm.cargar);
	 sucursales.add(sm.actualizar);
	 sucursales.add(sm.eliminar);	
	 sucursales.add(sm.pdf);		
	 sucursales.add(sm.sp);
	 
	 pm.ejecutar();
	 productos.add(pm.crear);
	 productos.add(pm.cargar);
	 productos.add(pm.actualizar);
	 productos.add(pm.eliminar);	
	 productos.add(pm.pdf);		
	 productos.add(pm.sp);
	 
	 cm.ejecutar();
	 clientes.add(cm.crear);
	 clientes.add(cm.cargar);
	 clientes.add(cm.actualizar);
	 clientes.add(cm.eliminar);	
	 clientes.add(cm.pdf);		
	 clientes.add(cm.sp);
	 
	 vm.ejecutar();
	 vendedores.add(vm.crear);
	 vendedores.add(vm.cargar);
	 vendedores.add(vm.actualizar);
	 vendedores.add(vm.eliminar);	
	 vendedores.add(vm.pdf);		
	 vendedores.add(vm.sp);
	 
 }
 public void cerrar () {
		principal.setVisible(false);
		
	}
 public void ejecutar() throws ClassNotFoundException {
		valor_inicial(); 
 }
}


