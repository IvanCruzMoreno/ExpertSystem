package Commons;

public class Producto implements Comparable<Producto>{
	
	private int idProducto;
	
	private String nombre;
	
	private int cantidadStock;
	
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
	/**
	 * @return the cantidadStock
	 */
	public int getCantidadStock() {
		return cantidadStock;
	}
	/**
	 * @param cantidadStock the cantidadStock to set
	 */
	public void setCantidadStock(int cantidadStock) {
		this.cantidadStock = cantidadStock;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (obj instanceof Producto) {
	        Producto o = (Producto) obj;
	        return o.idProducto == this.idProducto;
	    }
	    return false;
	}
	@Override
	public int compareTo(Producto o) {
		String a=new String(String.valueOf(this.getCantidadVendidos()));
		String b=new String(String.valueOf(o.getCantidadVendidos()));
		return b.compareTo(a);
	}
	
}
