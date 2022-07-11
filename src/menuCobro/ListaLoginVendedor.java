package menuCobro;

import java.util.ArrayList;
import java.util.List;

import constructores.vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import conexioBD.AccDB;
import constructores.vendedor;
 
public class ListaLoginVendedor {
	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	AccDB acceso = new AccDB();
	vendedor v = new vendedor();
	Object [][] listar;
	//login
    
public Object[][] listar() {
    	
    	String sql = "select * from vendedores";  
    	int filas = 0;
    	
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
            	filas++;
            	
            }
            
            listar = new Object[filas][6];
            int y =0;
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {            	
            	listar[y][0] = rs.getInt(1);
            	listar[y][1] = rs.getString(2);
            	listar[y][2] = rs.getInt(3);
            	listar[y][3] = rs.getInt(4);
            	listar[y][4] = rs.getString(5);
            	listar[y][5] = rs.getString(6);
            	y++;            	
            }
        } catch (Exception e) {        	
            System.out.println(e);
        }
    	
    	return listar;
    }
public static void main(String[] args) {
	ListaLoginVendedor p1 = new ListaLoginVendedor();
	System.out.println(p1.listar());
}
}
