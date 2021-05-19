package Controller;

import java.util.Scanner;
import Seccion1.Ventas;
import Seccion2.VisualizacionEstantes;
import Seccion3.GastosTotales;

public class Menu {

	public static void main(String[] args) {

		Ventas ventas = new Ventas();
		GastosTotales gastosTotales = new GastosTotales();
		VisualizacionEstantes visualizacionEstantes = new VisualizacionEstantes();

		System.out.println("------------------");
		System.out.println("Bienvenido Experto");
		System.out.println("------------------");

		Scanner scanner = new Scanner(System.in);
		int menu;

		do {
			Menu.showOptions();
			menu = scanner.nextInt();

			switch (menu) {

			case 1:
				ventas.saleProcess();
				break;
			case 2:
				visualizacionEstantes.acomodoProcess();
				break;
			case 3:
				gastosTotales.gastosProcess();
				break;
			default:
				break;
			}
		} while (menu != 4);
	}

	public static void showOptions() {

		System.out.println("1) Realizar Venta");
		System.out.println("2) Visualizacion de estantes");
		System.out.println("3) Gastos Totales");
		System.out.println("4) Salir");
		System.out.println("------------------\n");
		System.out.print("Selecciona una opcion: ");
	}

}
