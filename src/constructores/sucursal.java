package constructores;
import conexioBD.AccDB;
public class sucursal {

	private int id_s;
	private String nombre;
	private String direccion;
	private String correo;
	private int telefono;
	
	public int getCodigo() {
		return id_s;
	}
	public void setCodigo(int id_s) {
		this.id_s = id_s;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
}