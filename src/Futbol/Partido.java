package Futbol;

import java.util.Random;

public class Partido {
	// defino atributos
	// los clubes que se enfrentan
	private Club local;
	private Club visitante;
	
	// el atributo aleatorio para los partidos
	private Random generador = new Random();

	/**
	 * pre: Los clubes deben ser diferentes. Los clubes no pueden ser null. post:
	 * Inicializa el constructor con los dos clubes a enfrentar.
	 * 
	 * @param local     el equipo local.
	 * @param visitante el equipo visitante.
	 */
	public Partido(Club local, Club visitante) {
		// en caso de que los clubes sean null.
		if (local == null || visitante == null) {
			throw new Error("Un club no puede ser null.");
		}
		// en caso de que ambos clubes sean los mismos
		if (local == visitante) {
			throw new Error("Los clubes son iguales.");
		}
		this.local = local;
		this.visitante = visitante;
	}

	/**
	 * pre: Club correctamente inicializado. post: Se generaran ,de forma aleatoria,
	 * entre 2 y 6 chances de gol. Dependiendo del nivel del club, las
	 * probabilidades de que la chance sea gol aumentaran o disminuiran. Al
	 * finalizar la simulacion, se retornan los goles anotados por el club.
	 * 
	 * @param club club al que se le generaran los goles.
	 * @return la cantidad de goles que anotara.
	 */
	public int generarGoles(Club club) {
		// declaro variable que representa el nivel del club
		double nivel = club.getNivel();
		// declaro variable que representa la probabilidad de gol
		double probabilidadDeGol = nivel / (nivel+6);
		// genero las chances de gol
		int chances = this.generador.nextInt(2, 6);
		// inicializo acumulador
		int goles = 0;
		// recorro un for para evaluar si fue gol o no.
		for (int i = 0; i < chances; i++) {
			if (generador.nextDouble() < probabilidadDeGol) {
				goles++;
			}
		}
		return goles;
	}

	/**
	 * post: Se desarrolla el partido,
	 * el nivel de cada equipo determina la probabilidad de ganar. Al terminar el
	 * partido, los puntos y goles se modifican en ambos clubes.
	 */
	public void simularPartido() {
		// genero los goles de ambos clubes y los guardo en variables
		int golesLocal = generarGoles(local);
		int golesVisitante = generarGoles(visitante);
		// si el local tiene mas goles
		if (golesLocal > golesVisitante) {
			local.victoria(golesLocal, golesVisitante);
			visitante.derrota(golesVisitante, golesLocal);
		} // si el visitante tiene mas goles
		else if (golesVisitante > golesLocal) {
			local.derrota(golesLocal, golesVisitante);
			visitante.victoria(golesVisitante, golesLocal);
		} // si empatan
		else {
			local.empate(golesLocal, golesVisitante);
			visitante.empate(golesVisitante, golesLocal);
		}
	}
	
	/**
	 * @return el nombre de ambos equipos para poder utilizarlo en el fixture.
	 */
	public String mostrarPartido() {
		return this.local.getNombre() + " vs " + this.visitante.getNombre();
	}
}
