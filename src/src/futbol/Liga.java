package futbol;

/*
 * ------------------------------------------------
 * ------------- SUMULADOR DE FUTBOL --------------
 * ------------------------------------------------
 */
public class Liga {
	// defino atributos
	// los equipos de torneo, ordenados en un arreglo de Club
	private Club[] clubes;
	// todos los partidos del torneo
	private Partido[][] fixture;

	/**
	 * post: inicializa el constructor.
	 */
	public Liga(Club[] clubes) {
		// asigno la cantidad de clubes que tiene el torneo
		this.clubes = clubes;
		// asigno 19 fechas, de 10 partidos cada una
		this.fixture = new Partido[clubes.length - 1][clubes.length / 2];
		// genero el fixture
		generarFixture();
	}

	/**
	 * pre: Clubes correctamente inicializados. Cantidad de clubes mayor o igual a
	 * 2. post: Se genera un fixture de todos contra todos. Sin repetir partidos.
	 */
	private void generarFixture() {
		// en caso que no hayaal menos 2 equipos
		if (this.clubes.length < 2 || this.clubes.length % 2 != 0) {
			throw new Error("La cantidad de clubes es impar o menor a 2.");
		}
		// creo un arreglo auxiliar para armar el fixture
		Club[] enfrentamientos = new Club[this.clubes.length];
		// recorro los clubes originales y los asigno a enfrentamientos
		for (int i = 0; i < this.clubes.length; i++) {
			enfrentamientos[i] = clubes[i];
		}
		// voy armando las diferentes fechas
		for (int i = 0; i < enfrentamientos.length - 1; i++) {
			// los partidos de cada fecha
			for (int j = 0; j < enfrentamientos.length / 2; j++) {
				// el local sera el primer club
				if (i % 2 == 0) {
					this.fixture[i][j] = new Partido(enfrentamientos[j],
							enfrentamientos[enfrentamientos.length - j - 1]);
				} // el rival sera el segundo club
				else {
					fixture[i][j] = new Partido(enfrentamientos[enfrentamientos.length - 1 - j], enfrentamientos[j]);
				}
			}
			// roto los equipos para que las fechas varien
			Club ultimo = enfrentamientos[enfrentamientos.length - 1];
			// corro todos los equipos una posición hacia la derecha, excepto el primero
			for (int j = enfrentamientos.length - 1; j > 1; j--) {
				enfrentamientos[j] = enfrentamientos[j - 1];
			}
			// cambio el ultimo elemento
			enfrentamientos[1] = ultimo;
		}
	}

	/**
	 * post: imprime en pantalla todos los enfrentamientos de todas las fechas.
	 */
	public void mostrarFixture() {
		// recorro las fechas del fixture y las plasmo en pantalla
		for (int i = 0; i < fixture.length; i++) {
			System.out.println("Fecha " + (i + 1));
			for (int j = 0; j < fixture[i].length; j++) {
				System.out.println(fixture[i][j].mostrarPartido());
			}
			System.out.println();
		}
	}

	/**
	 * post: Se simula la fecha deseada.
	 * 
	 * @param fecha fecha a simular.
	 */
	public void jugarFecha(int fecha) {
		// recorro los partidos de dicha fecha
		for (int i = 0; i < fixture[fecha].length; i++) {
			this.fixture[fecha][i].simularPartido();
		}
	}

	/**
	 * post: Recorre todo el fixture simulando todos los partidos de todas las
	 * fechas.
	 */
	public void jugarTorneo() {
		// recorro el fixture
		for (int i = 0; i < fixture.length; i++) {
			System.out.println("====== FECHA " + (i + 1) + " ======");
			System.out.println();
			jugarFecha(i);
			System.out.println();
		}
	}

	/**
	 * pre: Torneo inicializado. post: Ordena a los clubes en base a los puntos, en
	 * caso de tener los mismos puntos se define por diferencia de gol.
	 */
	public void ordenarTabla() {
		// boolean para parar el ordenamiento
		boolean huboIntercambios = true;
		// ordeno por burbujeo
		while (huboIntercambios) {
			huboIntercambios = false;
			for (int i = 0; i < clubes.length - 1; i++) {
				// para controlar los intercambios
				boolean intercambiar = false;
				// en caso de que el de la izquierda tenga mas puntos que el de la derecha
				if (clubes[i].getPuntos() < clubes[i + 1].getPuntos()) {
					intercambiar = true;
				} // en caso de que tengan los mismos puntos
				else if (clubes[i].getPuntos() == clubes[i + 1].getPuntos()
						&& clubes[i].getDiferenciaDeGol() < clubes[i + 1].getDiferenciaDeGol()) {
					intercambiar = true;
				} // si corresponde, se intercambia
				if (intercambiar) {
					Club aux = clubes[i];
					clubes[i] = clubes[i + 1];
					clubes[i + 1] = aux;
					huboIntercambios = true;
				}
			}
		}
		// asigno la posicion
		for (int i = 0; i < clubes.length; i++) {
			clubes[i].asignarPosicion(i + 1);
		}
	}

	/**
	 * pre: el torneo debe haber sido jugado post: muestra la tabla de posiciones
	 * ordenada. Se veran en orden la posicion, el equipo, los puntos, los partidos
	 * jugados, los partidos ganados, los partidos perdidos, los perdidos empatados,
	 * los goles a favor, los goles en contra y la diferencia de gol.
	 */
	public void mostrarTabla() {
		// imprimo las estadisticas
		System.out.println("\t========== TABLA DEL TORNEO ==========");
		System.out.println();
		System.out.println("Pos:\t Equipo:\t\tPts\tPJ\tPG\tPE\tPP\tGF\tGC\tDG\t");
		for (int i = 0; i < clubes.length; i++) {
			System.out.println(clubes[i].getPosicion() + "\t" + clubes[i].getNombre() + "\t" + clubes[i].getPuntos()
					+ "\t" + clubes[i].getPartidosJugados() + "\t" + clubes[i].getPartidosGanados() + "\t"
					+ clubes[i].getPartidosEmpatados() + "\t" + clubes[i].getPartidosPerdidos() + "\t"
					+ clubes[i].getGolesAFavor() + "\t" + clubes[i].getGolesEnContra() + "\t"
					+ clubes[i].getDiferenciaDeGol());
		}
	}

	/**
	 * pre: Todos los equipos deben tener sus jugadores inicializados. post: se crea
	 * un arreglo con todos los jugadores del torneo.
	 * 
	 * @return Todos los jugadores del torneo.
	 */
	private Jugador[] jugadoresDelTorneo() {
		// creo un arreglo de todos los jugaodres de tamaño tres veces mayor a la
		// cantidad de clubes.
		Jugador[] jugadores = new Jugador[clubes.length * 3];
		// declaro una variable que servira como indice para jugadores
		int indice = 0;
		// recorro el arreglo almacenando a los jugadores
		for (int i = 0; i < clubes.length; i++) {
			// creo un arreglo llamado plantel, que contendra los jugadores del club en la
			// posicion i.
			Jugador[] plantel = clubes[i].getJugadores();
			// ahora si, recorro plantel y aumento una al indice cada vez que asigne un
			// jugador al arreglo jugadores.
			for (int j = 0; j < plantel.length; j++) {
				jugadores[indice] = plantel[j];
				indice++;
			}
		}
		return jugadores;
	}

	/**
	 * pre: Invocar el metodo jugadoresDelTorneo correctamente. post: Se ordena el
	 * arreglo en base a la cantidad de goles de los jugadores.
	 * 
	 * @return El arreglo de los goleadores.
	 */
	private Jugador[] ordenarGoleadores() {
		// invoco el metodo jugadores del torneo y lo asigno a la variable goleadores.
		Jugador[] goleadores = jugadoresDelTorneo();
		// declaro una variable que detiene el ordenamiento
		boolean huboIntercambio = true;
		// ordeno por burbujeo
		while (huboIntercambio) {
			huboIntercambio = false;
			for (int i = 0; i < goleadores.length - 1; i++) {
				// declaro variable para controlar los intercambios.
				boolean intercambiar = false;
				if (goleadores[i + 1].getGoles() > goleadores[i].getGoles()) {
					intercambiar = true;
				}
				// intercambio en caso de ser necesario
				if (intercambiar) {
					Jugador aux = goleadores[i];
					goleadores[i] = goleadores[i + 1];
					goleadores[i + 1] = aux;
					huboIntercambio = true;
				}
			}
		}
		// asigno las posiciones
		for (int i = 0; i < 8; i++) {
			goleadores[i].asignarPosicionEnTablaDeGoleadores(i + 1);
		}
		return goleadores;
	}

	/**
	 * post: Se plasma los 8 mayores goleadores del torneo, se indica su posicion en
	 * la tabla, su nombre, club al que pertenece y la cantidad de goles anotados.
	 */
	public void mostrarGoleadores() {
		// ordeno los goleadores
		Jugador[] tablaGol = ordenarGoleadores();
		// imprimo las estadisticas de los jugadores.

		System.out.println();
		System.out.println("\t========== TABLA DE GOLEADORES ========== ");
		System.out.println();
		System.out.println("Pos:\t Nombre:\t\t Equipo\t\t\t Goles:");
		for (int i = 0; i < 8; i++) {
			System.out.println(tablaGol[i].getPosicionEnTablaDeGoleadores() + " \t " + tablaGol[i].getNombre() + " \t "
					+ tablaGol[i].getClub().getNombre() + " \t " + tablaGol[i].getGoles());
		}
	}
}
