package auto_radnja;

import java.util.LinkedList;
import auto_radnja.gume.AutoGuma;

/**
 * Interfejs koji predstavlja vulkanizersku radnju.
 * 
 * @author danko
 * @version 0.1
 */
public interface Radnja {
	/**
	 * Dodaje novu gumu u radnju.
	 * Guma se dodaje na pocetak liste guma.
	 * 
	 * @param a AutoGuma koja se dodaje
	 * 
	 * @throws java.lang.NullPointerException ako je uneta guma null
	 * 
	 * @throws java.lang.RuntimeException ako uneta guma vec postoji u radnji
	 */
	void dodajGumu(AutoGuma a);
	
	/**
	 * Vraca listu guma koje imaju trazenu marku i model.
	 * 
	 * @param markaModel Marka i model gume kao String
	 * @return Vraca null ili listu guma
	 * 
	 * <ul>
	 * 		<li>null ako je prosledjen prazan String </li>
	 * 		<li>listu guma koje sadrze unetu marku i model </li>
	 * </ul>
	 */
	LinkedList<AutoGuma> pronadjiGumu(String markaModel);
}