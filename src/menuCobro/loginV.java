package menuCobro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.MysqlConnection;

import constructores.vendedor;
import conexioBD.AccDB;

public class loginV {
	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	AccDB acceso = new AccDB();
	vendedor v = new vendedor();
	
	public vendedor usuario (String nombre, int id_caja, int ventas, String genero, String contrasena) {
    	String sql = "select*from vendedores where nombre=? and contrasena=?";
    	vendedor usuario = null;
    	try {
    		con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            
            ps.setString(2, v.getNombre());
    		ps.setString(6, v.getContrasena());
    		rs = ps.executeQuery();
    	}
    	catch (Exception e) {
			System.out.println(e);
		}
    	return usuario;
    }
	
}
