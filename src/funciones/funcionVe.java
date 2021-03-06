package funciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.MysqlConnection;

import constructores.vendedor;
import conexioBD.AccDB;
public class funcionVe {
	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	AccDB acceso = new AccDB();
	vendedor v = new vendedor();
	Object [][] listar;
	
	public void crear ( String nombre, int id_caja, int ventas, String genero, String contrasena) {
    	String sql = "insert into vendedores(nombre,id_caja,ventas,genero,contrasena)values(?,?,?,?,?)";
    	
    	try {
    		con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, nombre);
            ps.setInt(2, id_caja);
            ps.setInt(3, ventas);
            ps.setString(4, genero);
            ps.setString(5, contrasena);
           //ps.setInt(6, codigo_v);
            ps.executeUpdate();
    	}
    	catch (Exception e) {
			System.out.println(e);
		}
    }
    
    public void modificar(vendedor v) {
    	String sql = "update vendedores set nombre=?, id_caja=?, ventas=?, genero=?, contrasena=? where codigo_v=?";
        
    	try {
    		con = acceso.Conectar();
            ps = con.prepareStatement(sql);            
            
            ps.setString(1, v.getNombre());
            ps.setInt(2, v.getCaja());
            ps.setInt(3, v.getVentas());
            ps.setString(4, v.getGenero());
            ps.setString(5, v.getContrasena());
            ps.setInt(6, v.getCodigo());
            ps.executeUpdate();
    	}
    	catch (Exception e) {
			System.out.println(e);
		}
    }
    
    public void eliminar(int codigo_v) {
        String sql = "delete from vendedores where codigo_v=?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo_v);
            ps.executeUpdate();
        } catch (Exception e) {
        	System.out.println(e);
        }
    }
    
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

    
}
