package constructores;
import conexioBD.AccDB;
public class vendedor {
	
	private int codigo_v;
	private String nombre;
	private int id_caja;
	private int ventas;
	private String genero;
	private String contrasena;
	
	public int getCodigo() {
		return codigo_v;
	}
	public void setCodigo(int codigo_v) {
		this.codigo_v = codigo_v;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCaja() {
		return id_caja;
	}
	public void setCaja(int id_caja) {
		this.id_caja = id_caja;
	}
	public int getVentas() {
		return ventas;
	}
	public void setVentas(int ventas) {
		this.ventas = ventas;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
}

