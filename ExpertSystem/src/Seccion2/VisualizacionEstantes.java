package Seccion2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import Commons.Producto;
import Conexion.Conectar;

public class VisualizacionEstantes {

	public void acomodoProcess() {
		Conectar conexion = new Conectar();

		List<Producto> rack1 = new ArrayList<Producto>();
		List<Producto> rack2 = new ArrayList<Producto>();
		List<Producto> rack3 = new ArrayList<Producto>();
		List<Producto> rack4 = new ArrayList<Producto>();
		List<Producto> bodega = new ArrayList<Producto>();

		int estant1 = 0;
		int estant2 = 0;
		int estant3 = 0;
		int estant4 = 0;

		try {
			Statement command = conexion.getConnection().createStatement();
			ResultSet view = command.executeQuery("SELECT * FROM producto ORDER by cantidadVendidos DESC;");
			System.out.println("\n\n\n-- Visualizacion de Estantes --\n");
			System.out.println(
					"\n\n\n-- Un momento, el sistema esta acomodando los productos conforme a las ventas... --\n");

			while (view.next()) {

				Producto producto = new Producto();
				producto.setNombre(view.getString("nombre"));
				producto.setCantidadVendidos(view.getInt("cantidadVendidos"));
				producto.setPrecio(view.getDouble("precio"));
				producto.setCantidadStock(view.getInt("cantidadStock"));

//				productos.add(producto);

				if (producto.getCantidadVendidos() > 100) {
					rack1.add(producto);
				} else if (producto.getCantidadVendidos() <= 100 && producto.getCantidadVendidos() >= 50) {
					rack2.add(producto);
				} else if (producto.getCantidadVendidos() <= 49 && producto.getCantidadVendidos() >= 25) {
					rack3.add(producto);
				} else if (producto.getCantidadVendidos() <= 24 && producto.getCantidadVendidos() >= 1) {
					rack4.add(producto);
				} else {
					bodega.add(producto);
				}

			}

			// :::::::::::::::::::::::::::::::::::::::::::::Estante 1
			Collections.sort(rack1);
			System.out.println("\n\t\t -- Estante 1 --\n");
			for (Producto producto : rack1) {
				estant1 = estant1 + producto.getCantidadStock();
			}

			if (estant1 > 200) {
				System.out.println("\nEl estante 1 solo soporta 200 productos");
				System.out.println("Moviendo a estante 2\n");
				rack2.add(rack1.get(rack1.size() - 1));
				rack1.remove(rack1.size() - 1);
			}

			System.out.println("Nombre \t\t\t Cantidad stock");
			for (Producto producto : rack1) {
				System.out.println(producto.getNombre() + " \t\t\t ---> " + producto.getCantidadStock());
			}

			// :::::::::::::::::::::::::::::::::::::::::::::Estante 2
			System.out.println("\n\t\t -- Estante 2 --\n");
			for (Producto producto : rack2) {
				estant2 = estant2 + producto.getCantidadStock();
			}

			if (estant2 > 200) {
				System.out.println("\nEl estante 2 solo soporta 200 productos");
				System.out.println("Moviendo a estante 3\n");
				rack3.add(rack2.get(rack2.size() - 1));
				rack2.remove(rack2.size() - 1);
			}
			
			System.out.println("Nombre \t\t\t Cantidad stock");
			for (Producto producto : rack2) {
				System.out.println(producto.getNombre() + " \t\t\t ---> " + producto.getCantidadStock());
			}

			// :::::::::::::::::::::::::::::::::::::::::::::Estante 3
			Collections.sort(rack3);
			System.out.println("\n\t\t -- Estante 3 --\n");
			for (Producto producto : rack3) {
				estant3 = estant3 + producto.getCantidadStock();
			}
			
			if (estant3 > 200) {
				System.out.println("\nEl estante 3 solo soporta 200 productos");
				System.out.println("Moviendo a estante 4\n");
				rack4.add(rack3.get(rack3.size() - 1));
				rack3.remove(rack3.size() - 1);
			}

			System.out.println("Nombre \t\t\t Cantidad stock");
			for (Producto producto : rack3) {
				System.out.println(producto.getNombre() + " \t\t\t ---> " + producto.getCantidadStock());
			}
			
			// :::::::::::::::::::::::::::::::::::::::::::::Estante 4
			Collections.sort(rack4);
			System.out.println("\n\t\t -- Estante 4 --\n");
			for (Producto producto4 : rack4) {
				estant4 = estant4 + producto4.getCantidadStock();
			}

			if (estant4 > 200) {
				System.out.println("\nEl estante 4 solo soporta 200 productos");
				System.out.println("Moviendo a bodega\n");
				bodega.add(rack4.get(rack4.size() - 1));
				rack4.remove(rack4.size() - 1);

			}

			System.out.println("Nombre \t\t\t Cantidad stock");
			for (Producto producto : rack4) {
				System.out.println(producto.getNombre() + " \t\t\t ---> " + producto.getCantidadStock());
			}

			// :::::::::::::::::::::::::::::::::::::::::::Bodega
			Collections.sort(bodega);
			System.out.println("\n\t\t -- Bodega --\n");
			System.out.println("Nombre \t\t\t Cantidad stock");
			for (Producto producto : bodega) {
				System.out.println(producto.getNombre() + " \t\t\t ---> " + producto.getCantidadStock());
			}

			System.out.println("\n");

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}
