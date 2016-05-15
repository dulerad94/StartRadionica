package model;


public class PlaceniKorisnik extends Korisnik {
	private String biografija;

	public PlaceniKorisnik(String korisnickoIme, String sifra, String biografija) {
		super(korisnickoIme, sifra);
		this.biografija = biografija;
	}

	public String getBiografija() {
		return biografija;
	}
	

	public String[] podaci(){
		return new String[]{korisnickoIme,sifra,biografija};
	}
}
