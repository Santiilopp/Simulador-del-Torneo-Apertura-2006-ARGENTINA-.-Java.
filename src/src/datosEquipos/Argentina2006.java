package datosEquipos;

import futbol.Club;
import futbol.Jugador;

/*
 * TORNEO APERTURA 2006.
 */
public class Argentina2006 {

	/**
	 * post: Se importan todos los clubes de el torneo apertura 2006, para usarlo de
	 * parametro en el constructor de la liga.
	 * 
	 * @return Todos los clubes de dicho torneo.
	 */
	public static Club[] importar() {
		// declaro variable para almacenar los clubes.
		Club[] clubes = new Club[20];
		clubes[0] = new Club("Estudiantes (LP) ----", 10, new Jugador[] { new Jugador("M. Pavone ------", 90),
				new Jugador("J. Sosa --------", 82), new Jugador("P. Lugüercio ---", 75) });
		clubes[1] = new Club("Boca Juniors --------", 10, new Jugador[] { new Jugador("M. Palermo -----", 97),
				new Jugador("R. Palacio -----", 90), new Jugador("G.B. Schelotto -", 82) });
		clubes[2] = new Club("River Plate ---------", 10, new Jugador[] { new Jugador("G. Higuain -----", 90),
				new Jugador("A. Ortega ------", 87), new Jugador("R. Falcao ------", 82) });
		clubes[3] = new Club("San Lorenzo ---------", 9, new Jugador[] { new Jugador("N. Silveira -----", 87),
				new Jugador("E. Lavezzi -----", 86), new Jugador("C. Ledesma -----", 81) });
		clubes[4] = new Club("Independiente -------", 9, new Jugador[] { new Jugador("D. Montenegro ---", 91),
				new Jugador("S. Aguero ------", 88), new Jugador("G. Denis -------", 82) });
		clubes[5] = new Club("Arsenal -------------", 8, new Jugador[] { new Jugador("S. Gonzalez -----", 81),
				new Jugador("A. Gomez -------", 84), new Jugador("L. Caruso ------", 75) });
		clubes[6] = new Club("Lanus ---------------", 8, new Jugador[] { new Jugador("C. Fabbiani -----", 89),
				new Jugador("C. Graf --------", 90), new Jugador("D. Valeri ------", 80) });
		clubes[7] = new Club("Velez Sarsfield -----", 8, new Jugador[] { new Jugador("M. Zarate -------", 95),
				new Jugador("D. Escudero ----", 81), new Jugador("J.M. Varea -----", 78) });
		clubes[8] = new Club("Rosario Central -----", 7, new Jugador[] { new Jugador("M. Ruben --------", 92),
				new Jugador("C. Gonzalez ----", 87), new Jugador("A. Di Maria ----", 89) });
		clubes[9] = new Club("Racing Club ---------", 7, new Jugador[] { new Jugador("D. Simeone ------", 79),
				new Jugador("C. Luna --------", 86), new Jugador("J. Villanueva --", 89) });
		clubes[10] = new Club("Gimnasia (J) -------", 5, new Jugador[] { new Jugador("M. Lobo ---------", 80),
				new Jugador("G. Balvorin ----", 86), new Jugador("G. Bartelt -----", 72) });
		clubes[11] = new Club("Gimnasia (LP) ------", 6, new Jugador[] { new Jugador("S. Silva --------", 89),
				new Jugador("A. Pierguidi ---", 84), new Jugador("Andres Guglielm.", 81) });
		clubes[12] = new Club("Belgrano -----------", 5, new Jugador[] { new Jugador("M. Campodonico --", 89),
				new Jugador("M. Gilgi -------", 81), new Jugador("P. Frangipane --", 75) });
		clubes[13] = new Club("Nueva Chicago ------", 4, new Jugador[] { new Jugador("F. Higuain ------", 90),
				new Jugador("M. Donda -------", 80), new Jugador("M. Hanuch ------", 74) });
		clubes[14] = new Club("Banfield -----------", 4, new Jugador[] { new Jugador("J. Sand ---------", 90),
				new Jugador("D. Cvitanich ---", 87), new Jugador("J. Datolo ------", 84) });
		clubes[15] = new Club("Argentinos Juniors -", 6, new Jugador[] { new Jugador("L. Pisculichi ---", 87),
				new Jugador("D. Gandin ------", 84), new Jugador("L. Nuñez -------", 87) });
		clubes[16] = new Club("Colon --------------", 5, new Jugador[] { new Jugador("E. Fuertes ------", 88),
				new Jugador("G. Denis -------", 85), new Jugador("G. Hernandez ---", 84) });
		clubes[17] = new Club("Godoy Cruz ---------", 4, new Jugador[] { new Jugador("I. Villar -------", 85),
				new Jugador("E. Perez -------", 79), new Jugador("M. Poy ---", 82) });
		clubes[18] = new Club("Newell's Old Boys --", 3, new Jugador[] { new Jugador("F. Belluschi -----", 87),
				new Jugador("I. Scocco ------", 91), new Jugador("I. Borghello ---", 82) });
		clubes[19] = new Club("Quilmes ------------", 2, new Jugador[] { new Jugador("M. Caneo ---------", 82),
				new Jugador("M. Turdo -------", 80), new Jugador("A. Risso -------", 75) });
		return clubes;
	}

}
