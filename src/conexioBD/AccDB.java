package conexioBD;

import java.sql.Connection;
import java.sql.DriverManager;

public class AccDB {
	Connection con;
	String url="jdbc:mysql://localhost:3306/DBproyecto"; //cambiar evalti por la bd del proyecto ventas
	String user="root";
	String pass="";
	public Connection Conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,pass);
		} catch (Exception e){
			System.out.println(e);
			System.out.println("Error");
		}
		return con;
	}
	//public static void main(String[] args) { //conexion correcta en esta parte
		//AccDB o = new AccDB();
		//System.out.println(o.Conectar());
	//}
}

