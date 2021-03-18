package auto_radnja.gume;
/**
 * Klasas koja predstavlja automobilske gume.
 * 
 * AutoGuma ima privatni atribut markaModela tipa String i
 * 	atribute: precnik, sirina i visina koji su tipa integer.
 *  
 * @author danko
 * 
 * @version 0.1
 */
public class AutoGuma {
	/**
	 * Marka i model gume kao String.
	 */
	private String markaModel = null;
	/**
	 * Precik gume kao integer.
	 */
	private int precnik = -1;
	/**
	 * Sirina gume kao integer.
	 */
	private int sirina = -1;
	/**
	 * Visina gume kao integer.
	 */
	private int visina = -1;

	/**
	 * Prazan konstruktor.
	 */
	public AutoGuma() {
	}

	/**
	 * Konstruktor koji inicijalizuje objekat i postavlja vrednosti za marku i model gume,
	 * 	precnik gume, sirinu gume i visinu gume.
	 * 
	 * @param markaModel Marka i model gume kao String
	 * @param precnik Precnik gume kao integer
	 * @param sirina Sirina gume kao integer
	 * @param visina Visina gume kao integer
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}
	
	/**
	 * Vraca marku i model gume.
	 * 
	 * @return Vraca marku i model gume kao String
	 */
	public String getMarkaModel() {
		return markaModel;
	}
	
	/**
	 * Postavlja marku i model gume na novu vrednost.
	 * 
	 * @param markaModel Marka i model gume kao String
	 * 
	 * @throws java.lang.NullPointerException Ako je uneta vrednost za marku i model null vrednost
	 * @throws java.lang.RuntimeException Ako uneta vrednost za marku i model ima manje od 3 znaka
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length() < 3)
			throw new RuntimeException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}

	/**
	 * Vraca precnik gume.
	 * 
	 * @return Vraca precnik gume kao integer
	 */
	public int getPrecnik() {
		return precnik;
	}

	/**
	 * Postavlja precnik gume na novu vrednost.
	 * 
	 * @param precnik Precnik gume kao integer
	 * 
	 * @throws java.lang.RuntimeException Ako je uneta vrednost za precnik manja od 13 ili veca od 22
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 || precnik > 22)
			throw new RuntimeException("Precnik van opsega");
		this.precnik = precnik;
	}
	
	/**
	 * Vraca sirinu gume.
	 * 
	 * @return Vraca sirinu gume kao integer.
	 */
	public int getSirina() {
		return sirina;
	}

	/**
	 * Postavlja sirinu gume na novu vrednost.
	 * 
	 * @param sirina Sirina gume kao integer
	 * 
	 * @throws java.lang.RuntimeException Ako je uneta vrednost za sirinu manja od 135 i veca od 355
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 || sirina > 355)
			throw new RuntimeException("Sirina van opsega");
		this.sirina = sirina;
	}

	/**
	 * Vraca visinu gume.
	 * 
	 * @return Vraca visinu gume kao integer
	 */
	public int getVisina() {
		return visina;
	}

	/**
	 * Postavlja visinu gume na novu vrednost.
	 * 
	 * @param visina Visina gume kao integer
	 * 
	 * @throws java.lang.RuntimeException Ako je uneta vrednost za visinu manja od 25 ili veca od 95
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new RuntimeException("Visina van opsega");
		this.visina = visina;
	}
	
	/**
	 * @return Vraca String sa svim podacima o gumi
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina="
				+ visina + "]";
	}
	
	/**
	 * Poredi 2 gume i vraca true ako su iste ili false ako nisu.
	 * Gume se porede po svim parametrima (marka i model, precnik, sirina, visina).
	 * 
	 * @return
	 * <ul>
	 * 		<li>true ako su oba objekta klase AutoGuma i imaju iste vrednosti za marku i model, precnik, sirinu i visinu </li>
	 * 		<li>false u svim ostalim slucajevima </li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}
}