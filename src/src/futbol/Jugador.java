package futbol;

/*
 * Los jugadores que tendra cada equipo.
 */
public class Jugador {
	// defino atributos privados
	private String nombre;
	// la media de habilidad del jugador
	private int media;
	// la cantidad de goles anotados y su posicion en la tabla de goleadores
	private int goles;
	private int posicionEnTablaDeGoleadores;
	
	// el club al que pertenece el jugador
	private Club club;
	

	/**
	 * pre: El jugador debe tener un nombre. Su media debe estar comprendida entre 1
	 * y 100. La cantidad de goles se inicializa siempre en cero.
	 * post: Se inicializa el constructor con los parametros dados.
	 * @param nombre Nombre del jugador.
	 * @param media La media del jugador, indica la probabilidad de que este sea el que meta el gol.
	 */
	public Jugador(String nombre, int media) {
		// en caso de que no tenga nombre
		if (nombre == null || nombre.isBlank()) {
			throw new Error("El jugador no tiene nombre");
		}
		// en caso de que la media sobrepase los limites
		if (media < 1 || media > 100) {
			throw new Error("Media invalida.");
		}
		this.nombre = nombre;
		this.media = media;
		this.goles = 0;
	}

	/**
	 * @return El nombre del jugador.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return La media del jugador.
	 */
	public int getMedia() {
		return media;
	}

	/**
	 * @return La cantidad de goles anotados por el jugador.
	 */
	public int getGoles() {
		return goles;
	}
	
	/**
	 * @return Su posicion en la tabla.
	 */
	public int getPosicionEnTablaDeGoleadores() {
		return posicionEnTablaDeGoleadores;
	}
	
	
	/**
	 * @return El club al que pertenece el jugador.
	 */
	public Club getClub() {
		return this.club;
	}
	
	/**
	 * pre: que el club sea distinto de null.
	 * post: Le asigna un club al jugador.
	 * @param club Club al que pertenece el jugador
	 */
	public void asignarClub(Club club) {
		if (club == null) {
			throw new Error("No hay club.");
		}
	    this.club = club;
	}

	/**
	 * post: Suma un gol a su cantidad de goles actuales.
	 */
	public void anotarGol() {
		this.goles++;
	}
	
	/**
	 * pre: Posicion mayor a 0.
	 * post: Se le asigna en el atribito la posicion indicada por parametro.
	 * @param posicion La posicion del jugador en la tabla de goleadores.
	 */
	public void asignarPosicionEnTablaDeGoleadores(int posicion) {
		// en caso de que la posicion sea menor a cero
		if (posicion < 1) {
			throw new Error("Posicion invalida.");
		}
		this.posicionEnTablaDeGoleadores = posicion;
	}
}
