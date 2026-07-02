package pruebasMain;

import datosEquipos.Argentina2006;
import datosEquipos.Argentina2018;
import futbol.Club;
import futbol.Liga;

public class Main {

	/*
	 * Probando los métodos.
	 */
	public static void main(String[] args) {

		// Importo los clubes
		Club[] clubes = Argentina2006.importar();

		// Creo la liga
		Liga argentina = new Liga(clubes);

		// Simulo el torneo
		argentina.jugarTorneo();

		// Muestro la tabla
		argentina.ordenarTabla();
		argentina.mostrarTabla();
		argentina.mostrarGoleadores();
		System.out.println();
		System.out.println("Santiago Lopez 2026.");
		System.out.println("Gracias profes por probar este mini torneo, trate de utilizar todo lo que se nos enseño.");
		System.out.println("Cualquier consejo o critica acerca de como esta construido el codigo se agradece.");
		System.out.println("¿Pudieron salir campeones? :)");
	}
}