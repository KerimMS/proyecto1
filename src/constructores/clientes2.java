package constructores;

import java.sql.Connection;
import java.sql.DriverManager;
import conexioBD.AccDB;

public class clientes2 {
	 public int id_C;
	 public String nombre;
	 public int nit;
	 public String correo;
	 public String genero;
	 
	public clientes2(int id_C, String nombre, int nit, String correo, String genero) {
		
		this.id_C = id_C;
		this.nombre = nombre;
		this.nit = nit;
		this.correo = correo;
		this.genero = genero;
	}
	

}
