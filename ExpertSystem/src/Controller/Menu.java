package Controller;

import java.util.Scanner;

import Seccion1.Ventas;

public class Menu {

	
	public static void main(String[] args) {
		
		Ventas ventas = new Ventas();
		
		System.out.println("------------------");
		System.out.println("Bienvenido Experto");
		System.out.println("------------------");
		
		Menu.showOptions();
		
		Scanner scanner = new Scanner(System.in);
		int menu = scanner.nextInt();
		
		switch (menu) {
		
			case 1:
				ventas.saleProcess();
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				break;
		}
	}
	
	public static void showOptions() {
		
		System.out.println("1) Realizar Venta");
		System.out.println("2) Visualizacion de estantes");
		System.out.println("3) Gastos Totales");
		System.out.println("------------------\n");
		System.out.print("Selecciona una opcion: ");
	}

}
