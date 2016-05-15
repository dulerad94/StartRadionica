package model;

import java.util.LinkedList;

public class Korisnik {
	protected String korisnickoIme;
	protected String sifra;
	protected LinkedList<Automobil> automobili;
	
	public Korisnik(String korisnickoIme, String sifra) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.sifra = sifra;
		automobili=new LinkedList<>();
	}
	public Korisnik(String korisnickoIme, String sifra,LinkedList<Automobil> automobili) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.sifra = sifra;
		this.automobili=automobili;
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public String getSifra() {
		return sifra;
	}
	public LinkedList<Automobil> getAutomobili(){
		return automobili;
	}
	public void dodajAutomobil(Automobil a){
		automobili.add(a);
	}
	public void izbaciAutomobil(Automobil a){
		automobili.remove(a);
	}
	
}
