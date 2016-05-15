package controler;

import java.util.ArrayList;
import java.util.LinkedList;

import controler.exception.LosaSifraException;
import controler.exception.RazliciteSifreException;
import controler.exception.ZauzetoKorisnickoImeException;
import model.Automobil;
import model.Korisnici;
import model.Korisnik;
import model.PlaceniKorisnik;
import view.OsnovniProzor;

public class KorisnickiKontroler {

	
	private static KorisnickiKontroler instanca;
	private Korisnici korisnici;
	private ArrayList<Kontroler> kontroleri=new ArrayList<>();
	
	public KorisnickiKontroler(Korisnici korisnici) {
		this.korisnici=korisnici;
	}
	
	public void dodajKontrolera(Kontroler kontroler){
		kontroleri.add(kontroler);
	}
	public LinkedList<Automobil> procitajSveAutomobileOdKorisnika(String korisnickoIme){
		return nadjiKorisnika(korisnickoIme).getAutomobili();
	}
	public  void registrujKorisnika(String korisnickoIme, String sifra, String ponovljenaSifra, String biografija)
			throws ZauzetoKorisnickoImeException, RazliciteSifreException {
		if (!sifra.equals(ponovljenaSifra)) {
			throw new RazliciteSifreException();
		}
		korisnici.dodajKorisnika(korisnickoIme, sifra, biografija);
	}

	public String[] podaciOKorisniku(PlaceniKorisnik k){
		return k.podaci();
	}
	public Korisnik nadjiKorisnika(String korisnickoIme){
		return korisnici.nadjiKorisnika(korisnickoIme);
	}
	public  boolean proveriSifruKorisnika(String korisnickoIme, String sifra) {
		return korisnici.dobraSifra(korisnickoIme, sifra);
	}
	
	public LinkedList<Korisnik> listaSvihKorisnika(){
		return korisnici.korisnici;
	}
	
}
