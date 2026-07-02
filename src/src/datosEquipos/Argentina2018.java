package datosEquipos;

import futbol.Club;

/*
 * TORNEO ARGENTINO 2018/19.
 */
public class Argentina2018 {

	/**
	 * post: Se importan todos los clubes de el torneo argentino 2018/19, para
	 * usarlo de parametro en el constructor de la liga.
	 * 
	 * @return Todos los clubes de dicho torneo.
	 */
	public static Club[] importar() {
		// declaro variable para almacenar los clubes.
		Club[] clubes = new Club[26];
		clubes[0] = new Club("Racing Club ---------", 10);
		clubes[1] = new Club("Boca Juniors --------", 10);
		clubes[2] = new Club("River Plate ---------", 10);
		clubes[3] = new Club("San Lorenzo ---------", 6);
		clubes[4] = new Club("Independiente -------", 9);
		clubes[5] = new Club("Aldosivi ------------", 5);
		clubes[6] = new Club("Lanus ---------------", 7);
		clubes[7] = new Club("Velez Sarsfield -----", 8);
		clubes[8] = new Club("Rosario Central -----", 6);
		clubes[9] = new Club("Estudiantes (LP)-----", 5);
		clubes[10] = new Club("Tigre --------------", 5);
		clubes[11] = new Club("Gimnasia (LP) ------", 5);
		clubes[12] = new Club("Belgrano -----------", 4);
		clubes[13] = new Club("San Martin (SJ) ----", 3);
		clubes[14] = new Club("Banfield -----------", 6);
		clubes[15] = new Club("Argentinos Juniors -", 6);
		clubes[16] = new Club("Colon --------------", 5);
		clubes[17] = new Club("Godoy Cruz ---------", 6);
		clubes[18] = new Club("Newell's Old Boys --", 4);
		clubes[19] = new Club("Atlético Tucumán ---", 9);
		clubes[20] = new Club("Defensa y Justicia -", 9);
		clubes[21] = new Club("Huracán ------------", 8);
		clubes[22] = new Club("Talleres -----------", 7);
		clubes[23] = new Club("Unión --------------", 7);
		clubes[24] = new Club("San Martin (T) -----", 3);
		clubes[25] = new Club("Patronato ----------", 5);
		return clubes;
	}

}
