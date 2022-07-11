package constructores;
import conexioBD.AccDB;
public class clientes {
	
	private int id_C;
	private String nombre;
	private int nit;
	private String correo;
	private String genero;
	
	public int getCodigo() {
		return id_C;
	}
	public void setCodigo(int id_C) {
		this.id_C = id_C;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNit() {
		return nit;
	}
	public void setNit(int nit) {
		this.nit = nit;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}

