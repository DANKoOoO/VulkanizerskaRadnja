package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

class RadnjaTest {

	protected Radnja radnja;

	@Test
	@DisplayName("DodajGumu - ispravno")
	void testDodajGumu() {
		AutoGuma a = new AutoGuma("good-year", 18, 220, 80);
		radnja.dodajGumu(a);
		
		assertEquals(1, radnja.pronadjiGumu("good-year").size());
		assertEquals(a, radnja.pronadjiGumu("good-year").get(0));
	}
	
	@Test
	@DisplayName("DodajGumu - null")
	void testDodajGumuNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> radnja.dodajGumu(null) );
	}
	
	@Test
	@DisplayName("DodajGumu - duplikat")
	void testDodajGumuDuplikat() {
		AutoGuma a = new AutoGuma("good-year", 18, 220, 80);
		radnja.dodajGumu(a);
		
		RuntimeException e = assertThrows(java.lang.RuntimeException.class,
				() -> radnja.dodajGumu(a) );
		assertEquals("Guma vec postoji", e.getMessage());
	}
	
	

	@Test
	@DisplayName("PronadjiGumu - ispravno")
	void testPronadjiGumu() {
		AutoGuma a = new AutoGuma("good-year", 18, 220, 80);
		radnja.dodajGumu(a);
		
		assertEquals(a, radnja.pronadjiGumu("good-year").get(0));
	}
	
	
	@Test
	@DisplayName("PronadjiGumu - vise elemenata")
	void testPronadjiGumuViseEl() {
		AutoGuma a1 = new AutoGuma("good-year", 15, 150, 50);
		AutoGuma a2 = new AutoGuma("good-year", 16, 150, 50);
		AutoGuma a3 = new AutoGuma("micheline", 15, 151, 50);
		AutoGuma a4 = new AutoGuma("good-year", 15, 150, 51);
		AutoGuma a5 = new AutoGuma("micheline", 15, 150, 52);
		radnja.dodajGumu(a1);
		radnja.dodajGumu(a2);
		radnja.dodajGumu(a3);
		radnja.dodajGumu(a4);
		radnja.dodajGumu(a5);
		
		assertEquals(3, radnja.pronadjiGumu("good-year").size());
		
	}
	
	@Test
	@DisplayName("PronadjiGumu - null")
	void testPronadjiGumuNull() {
		AutoGuma a = new AutoGuma("good-year", 16, 180, 60);
		
		radnja.dodajGumu(a);
		
		assertEquals(null, radnja.pronadjiGumu(null));
		
	}
	
	@Test
	@DisplayName("PronadjiGumu - Ne postoji trazena")
	void testPronadjiGumuNePostoji() {
		AutoGuma a = new AutoGuma("good-year", 16, 180, 60);
		
		radnja.dodajGumu(a);
		
		assertEquals(0, radnja.pronadjiGumu("asd").size());
		
	}

}
