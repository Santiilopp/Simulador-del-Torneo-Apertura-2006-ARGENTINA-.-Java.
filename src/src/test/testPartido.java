package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import futbol.Club;
import futbol.Partido;

class testPartido {

	@Test
	void test() {
		Club river = new Club("River Plate", 10);
		Club boca = new Club("Boca Juniors", 10);
		Partido superclasico = new Partido(river, boca);
		superclasico.simularPartido();
		assertEquals(3, river.getGolesAFavor());
		assertEquals(3, boca.getGolesAFavor());
	}

}
