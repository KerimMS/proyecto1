package constructores;
import conexioBD.AccDB;
public class producto {

	private int ID_P;
	private String nombre;
	private String descripcion;
	private int cantidad;
	private double precio;
	
	public int getCodigo() {
		return ID_P;
	}
	public void setCodigo(int ID_P) {
		this.ID_P = ID_P;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
