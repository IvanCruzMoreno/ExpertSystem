package Seccion3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Conexion.Conectar;

public class GastosTotales {

	public static void gastosProcess() {
		
		Conectar conexion = new Conectar();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\n\n\n-- Gastos --\n");
		System.out.print("Gasto de agua: ");
		float agua = scanner.nextInt();
		 
		System.out.print("Gasto de luz: ");
		float luz = scanner.nextInt();
		
		System.out.print("Gasto de comida: ");
		float comida = scanner.nextInt();
		
		float gastosTotales = (agua + luz + comida);
		float ventas = getVentas(conexion);
		
		System.out.println("Las ventas fueron: " + ventas);
		
		if(gastosTotales <= ventas) {
			System.out.println("------------------");
			System.out.print("La ganancias fueron de: " + (ventas - gastosTotales));
			System.out.println("------------------");
		}else {
			System.out.println("------------------");
			System.out.println("Hubieron perdidas de: " + (gastosTotales - ventas));
			System.out.println("------------------");
		}
		
	}
	
	private static float getVentas(Conectar conexion) {
		
		float total = 0;
		
		try {
			
			Statement command = conexion.getConnection().createStatement();
			ResultSet registro = command.executeQuery("select idProducto,cantidadVendidos,precio from producto");
			while(registro.next()) {
				
				total+= (Integer.parseInt(registro.getString("cantidadVendidos")) * Float.parseFloat(registro.getString("precio")));
				//System.out.println(" " + registro.getString("idProducto") + " " + registro.getString("cantidadVendidos") + " " + registro.getString("precio"));
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return total;
	}
}
