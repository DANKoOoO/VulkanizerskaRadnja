package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {

	private AutoGuma ag;
	@BeforeEach
	void setUp() throws Exception {
		ag = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		ag = null;
	}

	@Test
	@DisplayName("Prazan konstruktor")
	void testAutoGuma() {
		assertNotNull(ag);
	}

	@Test
	@DisplayName("Parametrizovan konstruktor")
	void testAutoGumaStringIntIntInt() {
		ag = new AutoGuma("guma", 15, 150, 40);
		assertNotNull(ag);
		assertEquals("guma", ag.getMarkaModel());
		assertEquals(15, ag.getPrecnik());
		assertEquals(150, ag.getSirina());
		assertEquals(40, ag.getVisina());
	}

	@Test
	@DisplayName("SetMarkaModel - ispravno")
	void testSetMarkaModel() {
		ag.setMarkaModel("good-year");
		assertEquals("good-year", ag.getMarkaModel());
	}

	@Test
	@DisplayName("SetMarkaModel - null")
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> ag.setMarkaModel(null));
	}

	
	@Test
	@DisplayName("SetMarkaModel - kratko ime")
	void testSetMarkaModelShort() {
		assertThrows(java.lang.RuntimeException.class,
				() -> ag.setMarkaModel("x"));
	}

	@Test
	@DisplayName("SetPrecnik - ispravno")
	void testSetPrecnik() {
		ag.setPrecnik(15);
		assertEquals(15, ag.getPrecnik());
	}

	@Test
	@DisplayName("SetPrecnik - premala vrednost")
	void testSetPrecnikLow() {
		assertThrows(java.lang.RuntimeException.class,
				() -> ag.setPrecnik(2));
	}
	
	@Test
	@DisplayName("SetPrecnik - prevelika vrednost")
	void testSetPrecnikHigh() {
		assertThrows(java.lang.RuntimeException.class,
				() -> ag.setPrecnik(1000));
	}
	
	@Test
	@DisplayName("SetSirina - ispravno")
	void testSetSirina() {
		ag.setSirina(200);
		assertEquals(200, ag.getSirina());
	}
	
	@Test
	@DisplayName("SetSirina - premala vrednost")
	void testSetSirinaLow() {
		assertThrows(java.lang.RuntimeException.class,
				() -> ag.setSirina(2));
	}
	
	@Test
	@DisplayName("SetSirina - prevelika vrednost")
	void testSetSirinaHigh() {
		assertThrows(java.lang.RuntimeException.class,
				() -> ag.setSirina(1000));
	}

	@Test
	@DisplayName("SetVisina - ispravno")
	void testSetVisina() {
		ag.setVisina(50);
		assertEquals(50, ag.getVisina());
	}
	
	@Test
	@DisplayName("SetVisina - premala vrednost")
	void testSetVisinaLow() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> ag.setVisina(2));
	}
	
	@Test
	@DisplayName("SetVisina - prevelika vrednost")
	void testSetVisinaHigh() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> ag.setVisina(1000));
	}

	@Test
	void testToString() {
		ag.setMarkaModel("good-year");
		ag.setPrecnik(18);
		ag.setSirina(220);
		ag.setVisina(80);
		String s = ag.toString();
		assertTrue(s.contains("markaModel=good-year"));
		assertTrue(s.contains("precnik=18"));
		assertTrue(s.contains("sirina=220"));
		assertTrue(s.contains("visina=80"));
	}

	@ParameterizedTest
	@CsvSource({
		"good-year, 17, 200, 60, good-year, 17, 200, 60, true",
		"good-year, 15, 200, 60, good-year, 17, 200, 60, false",
		"good-year, 17, 220, 60, good-year, 17, 200, 60, false",
		"good-year, 17, 200, 65, good-year, 17, 200, 60, false",
		"gggg, 17, 200, 60, good-year, 17, 200, 60, false",
	})
	void testEqualsObject(String marka1, int precnik1, int sirina1, int visina1, String marka2, int precnik2, int sirina2, int visina2, boolean eq) {
		ag = new AutoGuma(marka1, precnik1, sirina1, visina1);
		AutoGuma ag1 = new AutoGuma(marka2,precnik2,sirina2, visina2);
		assertEquals(eq, ag.equals(ag1));
	}

}
