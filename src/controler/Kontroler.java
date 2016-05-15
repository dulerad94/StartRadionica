package controler;

import java.util.LinkedList;

import controler.exception.LosaSifraException;
import controler.exception.NePlacaException;
import controler.exception.RazliciteSifreException;
import controler.exception.ZauzetoKorisnickoImeException;
import model.Automobil;
import model.Korisnici;
import model.Korisnik;
import model.PlaceniKorisnik;
import view.GlavniProzor;
import view.GlavniProzorPlaceniKorisnik;
import view.Konzola;
import view.LogIn;
import view.LogInLogUp;
import view.LogUp;
import view.OsnovniProzor;
import view.Profil;

public class Kontroler {

	private OsnovniProzor frame;
	private Konzola konzola;
	private static Kontroler instanca;
	private Korisnici korisnici;
//	private KorisnickiKontroler korisnickiKontroler;
	private Korisnik trenutniKorisnik;
	
	public static Kontroler getInstanca(Korisnici korisnici) {
		if (instanca == null) {
			instanca = new Kontroler(korisnici);
		}
		return instanca;
	}

	protected Kontroler(Korisnici korisnici) {
		predjiNaLogInLogUp();
	//	this.korisnickiKontroler=korisnickiKontroler;
		this.korisnici=korisnici;
		korisnici.dodajKontrolera(this);
	}
	public void setKonzola(Konzola konzola){
		this.konzola=konzola;
	}
	public void setFrame(OsnovniProzor frame){
		this.frame=frame;
	}
	public Korisnik getTrenutniKorisnik(){
		return trenutniKorisnik;
	}
	public void predjiNaLogInLogUp() {
		frame = new LogInLogUp(this);
		omoguciFrame();
	}

	public void predjiNaLogIn() {
		frame = new LogIn(this);
		omoguciFrame();
	}

	public void predjiNaLogUp() {
		frame = new LogUp(this);
		omoguciFrame();
	}

	public void predjiNaGlavniProzor() {
		if(korisnikPlatio())
			frame = new GlavniProzorPlaceniKorisnik(this);
		else frame=new GlavniProzor(this);
		omoguciFrame();
	}


	public void predjiNaProfil() throws NePlacaException {
		if (!korisnikPlatio())
			throw new NePlacaException();
		frame = new Profil(this);
		omoguciFrame();
	}

	private void omoguciFrame() {
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public String dodajAuto(String markaIModel, int kubikaza) {
		return dodajAuto(markaIModel,kubikaza,trenutniKorisnik.getKorisnickoIme());
	}
	public String dodajAuto(String markaIModel, int konjskaSnaga,String korisnik){
		Korisnik k=korisnici.nadjiKorisnika(korisnik);
		Automobil a=new Automobil(markaIModel, konjskaSnaga);
		korisnici.dodajAuto(k, a);
		obavestiSveZainteresovane(a.toString());
		return a.toString();
	}
	public void registrujKorisnika(String korisnickoIme, String sifra, String ponovljenaSifra, String biografija)
			throws ZauzetoKorisnickoImeException, RazliciteSifreException {
		if (!sifra.equals(ponovljenaSifra)) {
			throw new RazliciteSifreException();
		}
		korisnici.dodajKorisnika(korisnickoIme, sifra, biografija);
		obavestiSveZainteresovane("IME;"+korisnickoIme);
	}

	public void ulogujSe(String korisnickoIme, String sifra) throws LosaSifraException {
		if (!proveriSifruKorisnika(korisnickoIme, sifra)) {
			throw new LosaSifraException();
		}
		trenutniKorisnik = korisnici.nadjiKorisnika(korisnickoIme);
	}
	public String procitajSveAutomobileOdKorisnika(){
		 return procitajSveAutomobileOdKorisnika(trenutniKorisnik.getKorisnickoIme());
	}
	public String procitajSveAutomobileOdKorisnika(String korisnickoIme){
		LinkedList<Automobil> automobili=korisnici.procitajSveAutomobileOdKorisnika(korisnickoIme);
		 String tekst="";
		 for (int i = 0; i < automobili.size(); i++) {
			tekst+=automobili.get(i)+"\n";
		 }
		 return tekst;
	}
	
	private boolean proveriSifruKorisnika(String korisnickoIme, String sifra) {
		return korisnici.dobraSifra(korisnickoIme, sifra);
	}

	public  String[] podaciOTrenutomKorisniku() {
		PlaceniKorisnik korisnik = (PlaceniKorisnik) trenutniKorisnik;
		return korisnik.podaci();
	}

	private boolean korisnikPlatio() {
		return (trenutniKorisnik instanceof PlaceniKorisnik);
	}

	public void izlogujSe() {
		trenutniKorisnik=null;
	}
	public LinkedList<Korisnik> listaSvihKorisnika(){
		return korisnici.korisnici;
	}

	public void obavestiSveZainteresovane(String tekst) {
		frame.osveziStanje(tekst);
		konzola.osveziStanje(tekst);
	}
	public String listaSvihKorisnikaSaAutomobilima(){
		String tekst="";
		for (int i = 0; i < korisnici.korisnici.size(); i++) {
			Korisnik k=korisnici.korisnici.get(i);
			tekst+=k.getKorisnickoIme()+"\n";
			for (int j = 0; j < k.getAutomobili().size(); j++) {
				tekst+="\t"+k.getAutomobili().get(i).toString()+"\n";
			}
		}
		return tekst;
	}
}
