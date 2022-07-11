package funciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conexioBD.AccDB;
import constructores.clientes;
public class funcionCli {
	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	AccDB acceso = new AccDB();
	clientes c = new clientes();
	Object [][] listar;
	
	public void crear (String nombre, int nit, String correo, String genero) {
    	String sql = "insert into clientes(nombre,nit,correo,genero)values(?,?,?,?)";
    	
    	try {
    		con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, nombre);
            ps.setInt(2, nit);
            ps.setString(3, correo);
            ps.setString(4, genero);
            ps.executeUpdate();
    	}
    	catch (Exception e) {
			System.out.println(e);
		}
    }
    
    public void modificar(clientes c) {
    	String sql = "update clientes set nombre=?, nit=?, correo=?, genero=? where id_C=?";
        
    	try {
    		con = acceso.Conectar();
            ps = con.prepareStatement(sql);            
            ps.setString(1, c.getNombre());
            ps.setInt(2, c.getNit());
            ps.setString(3, c.getCorreo());
            ps.setString(4, c.getGenero());
            ps.setInt(5, c.getCodigo());
            ps.executeUpdate();
    	}
    	catch (Exception e) {
			System.out.println(e);
		}
    }
    
    public void eliminar(int id_C) {
        String sql = "delete from clientes where id_C=?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_C);
            ps.executeUpdate();
        } catch (Exception e) {
        	System.out.println(e);
        }
    }
    
    public Object[][] listar() {
    	
    	String sql = "select * from clientes";  
    	int filas = 0;
    	
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
            	filas++;
            	
            }
            
            listar = new Object[filas][5];
            int y =0;
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {            	
            	listar[y][0] = rs.getInt(1);
            	listar[y][1] = rs.getString(2);
            	listar[y][2] = rs.getInt(3);
            	listar[y][3] = rs.getString(4);
            	listar[y][4] = rs.getString(5);
            	y++;            	
            }
        } catch (Exception e) {        	
            System.out.println(e);
        }
    	
    	return listar;
    }

}
