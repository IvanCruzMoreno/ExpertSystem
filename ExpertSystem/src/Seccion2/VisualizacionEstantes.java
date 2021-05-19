package Seccion2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Commons.Producto;
import Conexion.Conectar;

public class VisualizacionEstantes {

	public void acomodoProcess() {
		Conectar conexion = new Conectar();

		List<Producto> productos = new ArrayList<Producto>();

		try {
			Statement command = conexion.getConnection().createStatement();
			ResultSet view = command.executeQuery(
					"SELECT nombre, precio, cantidadVendidos FROM producto ORDER by cantidadVendidos DESC;");
			System.out.println("\n\n\n-- Visualizacion de Estantes --\n");
			System.out.println(
					"\n\n\n-- Un momento, el sistema esta acomodando los productos conforme a las ventas... --\n");
			System.out.println("\n\t\t -- Estante 1 --\n");
			System.out.println("Producto \t Precio");
			while (view.next()) {

				Producto producto = new Producto();
				producto.setNombre(view.getString("nombre"));
				producto.setCantidadVendidos(view.getInt("cantidadVendidos"));
				producto.setPrecio(view.getDouble("precio"));

				productos.add(producto);
			}

			for (Producto producto : productos) {
				if (producto.getCantidadVendidos() > 50) {
					System.out.println(producto.getNombre() + " \t $" + producto.getPrecio());
				}
			}
			System.out.println("\n\t\t -- Estante 2 --");
			System.out.println("Producto \t Precio");
			for (Producto producto : productos) {
				if (producto.getCantidadVendidos() <= 50 && producto.getCantidadVendidos() >= 25) {
					System.out.println(producto.getNombre() + " \t $" + producto.getPrecio());
				}
			}
			System.out.println("\n\t\t -- Estante 3 --");
			System.out.println("Producto \t Precio");
			for (Producto producto : productos) {
				if (producto.getCantidadVendidos() < 25) {
					System.out.println(producto.getNombre() + " \t $" + producto.getPrecio());
				}
			}
			System.out.println("\n");

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}
