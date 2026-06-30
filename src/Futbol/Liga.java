package Futbol;

/*
 * ------------------------------------------------
 * ----- INSPIRADO EN EL TORNEO APERTURA 2006 -----
 * ------------- simulador de futbol --------------
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
	public Liga() {
		// asigno la cantidad de clubes que tiene el torneo
		this.clubes = new Club[20];
		// asigno 19 fechas, de 10 partidos cada una
		this.fixture = new Partido[19][10];
		// inicializo cada club
		inicializarClubes();
		generarFixture();
	}

	/**
	 * post: Inicializa el arreglo de clubes con los equipos del torneo apertura
	 * 2006. Se asigna el nivel y nombre de cada uno.
	 */
	private void inicializarClubes() {
		// todos los clubes del torneo apertura 2006
		this.clubes[0] = new Club("Estudiantes (LP) ----", 10);
		this.clubes[1] = new Club("Boca Juniors --------", 10);
		this.clubes[2] = new Club("River Plate ---------", 10);
		this.clubes[3] = new Club("San Lorenzo ---------", 9);
		this.clubes[4] = new Club("Independiente -------", 9);
		this.clubes[5] = new Club("Arsenal -------------", 8);
		this.clubes[6] = new Club("Lanus ---------------", 8);
		this.clubes[7] = new Club("Velez Sarsfield -----", 8);
		this.clubes[8] = new Club("Rosario Central -----", 7);
		this.clubes[9] = new Club("Racing Club ---------", 7);
		this.clubes[10] = new Club("Gimnasia (J) -------", 5);
		this.clubes[11] = new Club("Gimnasia (LP) ------", 6);
		this.clubes[12] = new Club("Belgrano -----------", 5);
		this.clubes[13] = new Club("Nueva Chicago ------", 4);
		this.clubes[14] = new Club("Banfield -----------", 4);
		this.clubes[15] = new Club("Argentinos Juniors -", 6);
		this.clubes[16] = new Club("Colon --------------", 5);
		this.clubes[17] = new Club("Godoy Cruz ---------", 4);
		this.clubes[18] = new Club("Newell's Old Boys --", 3);
		this.clubes[19] = new Club("Quilmes ------------", 2);
	}

	/**
	 * pre: Clubes correctamente inicializados. post: Se genera un fixture de 19
	 * fechas todos contra todos. Sin repetir partidos.
	 */
	public void generarFixture() {
		// en caso que no hayaal menos 2 equipos
		if (this.clubes.length < 2) {
			throw new Error("No hay cantidad suficiente de equipos para armar el fixture.");
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
			jugarFecha(i);
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
		System.out.println("Pos:\t Equipo:\t\tPts\tPJ\tPG\tPE\tPP\tGF\tGC\tDG\t");
		for (int i = 0; i < clubes.length; i++) {
			System.out.println(clubes[i].getPosicion() + "\t" + clubes[i].getNombre() + "\t" + clubes[i].getPuntos()
					+ "\t" + clubes[i].getPartidosJugados() + "\t" + clubes[i].getPartidosGanados() + "\t"
					+ clubes[i].getPartidosEmpatados() + "\t" + clubes[i].getPartidosPerdidos() + "\t"
					+ clubes[i].getGolesAFavor() + "\t" + clubes[i].getGolesEnContra() + "\t"
					+ clubes[i].getDiferenciaDeGol());
		}
	}

	/*
	 * probando los metodoooooos
	 */
	public static void main(String[] arms) {
		Liga argentina = new Liga();
		argentina.mostrarFixture();
		argentina.jugarTorneo();
		argentina.ordenarTabla();
		argentina.mostrarTabla();
		System.out.println();
		System.out.println("Santiago Lopez 2026.");
		System.out.println("Gracias profes por probar este mini torneo, trate de utilizar todo lo que se nos enseño.");
		System.out.println("Cualquier consejo o critica acerca de como esta construido el codigo se agradece.");
		System.out.println("¿Pudieron salir campeones? :)");
	}
}
