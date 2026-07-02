package futbol;

import java.util.Random;

public class Club {
	// defino atributos
	// identificacion del equipo
	private String nombre;
	private int nivel;
	private int posicion;

	// arreglo de jugadores, su plantel basicamente
	private Jugador[] jugadores;

	// el atributo aleatorio para los jugadores
	private Random generador = new Random();

	// posicion en la tabla
	private int puntos;
	private int partidosJugados;
	private int partidosGanados;
	private int partidosPerdidos;
	private int partidosEmpatados;

	// goles anotados, recibidos y diferencia de gol
	private int golesAFavor = 0;
	private int golesEnContra = 0;

	/**
	 * pre: Debe tener un nombre. Su nivel debe estar comprendido entre 1 y 10. La
	 * cantidad de jugadores no puede ser menor a cero. post: inicializa el club con
	 * los parametros dados.
	 * 
	 * @param nombre    nombre del club.
	 * @param nivel     numero entero del 1 al 10 que define que tan bueno es el
	 *                  nivel de juego del equipo.
	 * @param jugadores Arreglo de jugadores.
	 */
	public Club(String nombre, int nivel, Jugador[] jugadores) {
		// en caso de que el nivel sea mayor o menor a los limites
		if (nivel < 1 || nivel > 10) {
			throw new Error("El nivel es invalido.");
		}
		// en caso de que no tenga nombre
		if (nombre == null || nombre.isBlank()) {
			throw new Error("El club no tiene nombre.");
		}
		// en caso de que no tenga jugadores
		if (jugadores == null || jugadores.length <= 0) {
			throw new Error("El club no tiene jugadores");
		}
		// en caso de que supere el limite de entre 1 y 3 jugadores
		if (jugadores.length != 3) {
			throw new Error("El club debe tener estrictamente 3 jugadores.");
		}
		this.nombre = nombre;
		this.nivel = nivel;
		// asigno el arreglo de jugadores al club
		this.jugadores = jugadores;
		// le asigno el club a los jugadores
		for (int i = 0; i < jugadores.length; i++) {
			jugadores[i].asignarClub(this);
		}
	}

	/**
	 * @return el nombre del club.
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * @return los puntos del club.
	 */
	public int getPuntos() {
		return this.puntos;
	}

	/**
	 * @return el nivel del club.
	 */
	public int getNivel() {
		return this.nivel;
	}

	/**
	 * @return la cantidad de partidos jugados.
	 */
	public int getPartidosJugados() {
		return partidosJugados;
	}

	/**
	 * @return la cantidad de partidos ganados.
	 */
	public int getPartidosGanados() {
		return partidosGanados;
	}

	/**
	 * @return la cantidad de partidos perdidos.
	 */
	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}

	/**
	 * @return la cantidad de partidos empatados.
	 */
	public int getPartidosEmpatados() {
		return partidosEmpatados;
	}

	/**
	 * @return la cantidad de goles anotados.
	 */
	public int getGolesAFavor() {
		return golesAFavor;
	}

	/**
	 * @return la cantidad de goles recibidos.
	 */
	public int getGolesEnContra() {
		return golesEnContra;
	}

	/**
	 * @return la diferencia de gol del club (los goles a favor menos los goles en
	 *         contra).
	 */
	public int getDiferenciaDeGol() {
		return this.golesAFavor - this.golesEnContra;
	}

	/**
	 * @return El arreglo de jugadores.
	 */
	public Jugador[] getJugadores() {
		return this.jugadores;
	}

	/**
	 * @return la posicion del equipo en la tabla.
	 */
	public int getPosicion() {
		return this.posicion;
	}

	/**
	 * pre: posicion comprendida entre 1 y 20. post: le asigna la posicion al club.
	 * Modificando el atributo posicion.
	 * 
	 * @param posicion la posicion en la tabla.
	 */
	public void asignarPosicion(int posicion) {
		if (posicion < 1) {
			throw new Error("Posicion invalida.");
		}
		this.posicion = posicion;
	}

	/**
	 * pre: Se debe jugar un partido para poder utilizarla. post: Se suma un partido
	 * a partidos jugados, y tambien los goles recibidos y anotados.
	 * 
	 * @param golesAFavor   goles anotados.
	 * @param golesEnContra goles recibidos.
	 */
	private void actualizarEstadisticasBasicas(int golesAFavor, int golesEnContra) {
		// sumo el partido jugado
		this.partidosJugados++;
		// sumo los goles recibidos y anotados
		this.golesAFavor += golesAFavor;
		this.golesEnContra += golesEnContra;
	}

	/**
	 * pre: Se debe jugar un partido. post: Se suman tres puntos, un partido ganado
	 * y un partido jugado. Ademas, se suman los goles recibidos y anotados.
	 * 
	 * @param golesAFavor   los goles que este equipo anoto durante el partido.
	 * @param golesEnContra los goles que este equipo recibio durante el partido.
	 */
	public void victoria(int golesAFavor, int golesEnContra) {
		// sumo tres puntos
		this.puntos += 3;
		// agrego un partido ganado y las estadisticas basicas
		this.partidosGanados++;
		actualizarEstadisticasBasicas(golesAFavor, golesEnContra);
	}

	/**
	 * pre: Se debe jugar un partido. post: Se suma un partido perdido y un partido
	 * jugado. Ademas, se suman los goles recibidos y anotados.
	 * 
	 * @param golesAFavor   los goles que este equipo anoto durante el partido.
	 * @param golesEnContra los goles que este equipo recibio durante el partido.
	 */
	public void derrota(int golesAFavor, int golesEnContra) {
		// agrego un partido perdido
		this.partidosPerdidos++;
		// agrego estadisticas basicas
		actualizarEstadisticasBasicas(golesAFavor, golesEnContra);
	}

	/**
	 * pre: Se debe jugar un partido. post: Se suma un punto, un partido empatado y
	 * un partido jugado. Ademas, se suman los goles recibidos y anotados.
	 * 
	 * @param golesAFavor   los goles que este equipo anoto durante el partido.
	 * @param golesEnContra los goles que este equipo recibio durante el partido.
	 */
	public void empate(int golesAFavor, int golesEnContra) {
		// sumo un punto
		this.puntos++;
		// agrego un partido empatado y estadisticas basicas
		this.partidosEmpatados++;
		actualizarEstadisticasBasicas(golesAFavor, golesEnContra);
	}

	/**
	 * pre: El club ha anotado un gol. post: Se genera un numero aleatorio del
	 * partido entre 1 y 150 a la vez que cada jugador genera un numero aleatorio
	 * entre 1 y su media. Si el numero de partido es mayor que cualquier numero de
	 * jugador, entonces ningun jugador aumenta sus goles. En caso de que uno o mas
	 * jugadores tengan un numero mas alto que el numero partido, entonces el
	 * jugador con el numero mas alto anotara el gol.
	 */
	public void registrarGoleador() {
		// genero los numeros de los jugadores
		int jugador1 = generador.nextInt(1, this.jugadores[0].getMedia() + 1);
		int jugador2 = generador.nextInt(1, this.jugadores[1].getMedia() + 1);
		int jugador3 = generador.nextInt(1, this.jugadores[2].getMedia() + 1);
		// genero el numero random del partido
		int golDeEquipo = generador.nextInt(20, 151);
		// evaluo si alguno hace el gol
		if (golDeEquipo < jugador1 || golDeEquipo < jugador2 || golDeEquipo < jugador3) {
			// evaluo en caso de que el primer jugador haya metido el gol
			if (jugador1 >= jugador2 && jugador1 >= jugador3) {
				jugadores[0].anotarGol();
			}
			// evaluo si el segundo metio gol.
			else if (jugador2 >= jugador3) {
				jugadores[1].anotarGol();
			}
			// entonces el tercer jugador anoto
			else {
				jugadores[2].anotarGol();
			}

		}
	}
}
