package Commons;

public class Producto {
	
	private int idProducto;
	
	private String nombre;
	
	private int cantidadVendidos;
	
	private double precio;

	public Producto(int idProducto, int cantidadVendidos) {
		this.idProducto = idProducto;
		this.cantidadVendidos = cantidadVendidos;
	}
	public Producto() {
		
	}
	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the cantidadVendidos
	 */
	public int getCantidadVendidos() {
		return cantidadVendidos;
	}

	/**
	 * @param cantidadVendidos the cantidadVendidos to set
	 */
	public void setCantidadVendidos(int cantidadVendidos) {
		this.cantidadVendidos = cantidadVendidos;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
