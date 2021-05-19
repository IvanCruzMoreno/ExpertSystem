package Seccion1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Conexion.Conectar;

public class Ventas {

	
	public static void saleProcess() {
		
		Conectar conexion = new Conectar();
		Integer cantidadStock = null;
		
		getAllProductos(conexion);
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Producto a procesar: ");
		int producto = scanner.nextInt();
		 
		System.out.println("Cantidad del producto a procesar: ");
		int cantidad = scanner.nextInt();
		 
		
		cantidadStock = getProductoStock(conexion, producto);
		System.out.println("Cantidad en almacen: " + (cantidadStock - cantidad));
		
		if(cantidadStock != null && cantidadStock >= cantidad) {
			
			updateProductoStock(conexion, producto, cantidad, cantidadStock);
			updateProductoVendidos(conexion, producto, cantidad);
			
			showFactura(conexion, scanner, producto, cantidad);
			
		}else {
			System.err.println("-- No se pudo realizar la compra --");
		}
		 
	}

	private static void showFactura(Conectar conexion, Scanner scanner, int producto, int cantidad) {
		System.out.println("\n------------------");
		System.out.println("       Factura");
		System.out.println("------------------");
		
		System.out.println("Producto: " + producto);
		System.out.println("Cantidad " + cantidad);
		float total = getProductoPrecio(conexion, producto) * cantidad;
		System.out.println("Total: " + total);
		
		float efectivo;
		
		do {
			System.out.println("------------------");
			System.out.print("Recibo Efectivo: ");
			efectivo = scanner.nextFloat();
		}while(efectivo < total);
		
		System.out.println("Su cambio es de: " + (efectivo - total));
		System.out.println("------------------");
	}
	
	private static void updateProductoVendidos(Conectar conexion, int producto, int cantidad) {
		
		int currentVendidos = getProductoVendidos(conexion, producto) + cantidad;
		
		try {
			Statement command = conexion.getConnection().createStatement();
			command.executeUpdate("update producto set cantidadVendidos=" + currentVendidos +" where idProducto=" + producto);
			
			System.out.println("-- Update realizado con exito --");
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	

	private static void updateProductoStock(Conectar conexion, int producto, int cantidad, int cantidadStock) {
		
		int newStock = cantidadStock - cantidad;
		
		try {
			Statement command = conexion.getConnection().createStatement();
			command.executeUpdate("update producto set cantidadStock=" + newStock +" where idProducto=" + producto);
			
			System.out.println("-- Venta realizada con exito --");
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	private static void getAllProductos(Conectar conexion) {
		
		
		try {
			Statement command = conexion.getConnection().createStatement();
			ResultSet registro = command.executeQuery("select idProducto,nombre,precio,cantidadStock from producto");
			System.out.println("\n\n\n-- Productos que puedes comprar --\n");
			while(registro.next()) {
				System.out.println(" " + registro.getString("idProducto") + " " + registro.getString("nombre") + " " + registro.getString("precio") + " ---> " + registro.getString("cantidadStock"));
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
	}

	private static Integer getProductoStock(Conectar conexion, int producto) {
		
		Integer stock = null;
		
		try {
			Statement command = conexion.getConnection().createStatement();
			ResultSet registro = command.executeQuery("select cantidadStock from producto where idProducto="+producto);
			
			if(registro.next() == true) {
				stock = Integer.parseInt(registro.getString("cantidadStock"));
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return stock;
	}
	
	private static Float getProductoPrecio(Conectar conexion, int producto) {
		
		Float precio = null;
		
		try {
			Statement command = conexion.getConnection().createStatement();
			ResultSet registro = command.executeQuery("select precio from producto where idProducto="+producto);
			
			if(registro.next() == true) {
				precio = Float.parseFloat(registro.getString("precio"));
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return precio;
	}
	
	private static Integer getProductoVendidos(Conectar conexion, int producto) {
		
		Integer vendido = null;
		
		try {
			Statement command = conexion.getConnection().createStatement();
			ResultSet registro = command.executeQuery("select cantidadVendidos from producto where idProducto="+producto);
			
			if(registro.next() == true) {
				vendido = Integer.parseInt(registro.getString("cantidadVendidos"));
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return vendido;
	}
}
