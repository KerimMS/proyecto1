package funciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import constructores.sucursal;
import conexioBD.AccDB;
public class funcionSu {
	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	AccDB acceso = new AccDB();
	sucursal s = new sucursal();
	Object [][] listar;
	
	public void crear (String nombre, String direccion, String correo, int telefono) {
    	String sql = "insert into sucursales(nombre,direccion,correo,telefono)values(?,?,?,?)";
    	
    	try {
    		con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, nombre);
            ps.setString(2, direccion);
            ps.setString(3, correo);
            ps.setInt(4, telefono);
            ps.executeUpdate();
    	}
    	catch (Exception e) {
			System.out.println(e);
		}
    }
    
    public void modificar(sucursal s) {
    	String sql = "update sucursales set nombre=?, direccion=?, correo=?, telefono=? where id_s=?";
        
    	try {
    		con = acceso.Conectar();
            ps = con.prepareStatement(sql);            
            ps.setString(1, s.getNombre());
            ps.setString(2, s.getDireccion());
            ps.setString(3, s.getCorreo());
            ps.setInt(4, s.getTelefono());
            ps.setInt(5, s.getCodigo());
            ps.executeUpdate();
    	}
    	catch (Exception e) {
			System.out.println(e);
		}
    }
    
    public void eliminar(int id_s) {
        String sql = "delete from sucursales where id_s=?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_s);
            ps.executeUpdate();
        } catch (Exception e) {
        	System.out.println(e);
        }
    }
    
    public Object[][] listar() {
    	
    	String sql = "select * from sucursales";  
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
            	listar[y][2] = rs.getString(3);
            	listar[y][3] = rs.getString(4);
            	listar[y][4] = rs.getInt(5);
            	y++;            	
            }
        } catch (Exception e) {        	
            System.out.println(e);
        }
    	
    	return listar;
    }

}
