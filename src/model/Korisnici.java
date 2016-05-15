package model;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import controler.Kontroler;
import controler.exception.ZauzetoKorisnickoImeException;

public class Korisnici {
	public LinkedList<Korisnik> korisnici=new LinkedList<>();
	private static Korisnici instanca;
	private ArrayList<Kontroler> kontroleri=new ArrayList<>();
	public Korisnici(){
		
	}
	public static Korisnici getInstanca(){
		if(instanca==null)
			instanca=new Korisnici();
		return instanca;
	}
	public void dodajKontrolera(Kontroler kontroler){
		kontroleri.add(kontroler);
	}
	public LinkedList<Automobil> procitajSveAutomobileOdKorisnika(String korisnickoIme){
		return nadjiKorisnika(korisnickoIme).getAutomobili();
	}
	public String[] podaciOKorisniku(PlaceniKorisnik k){
		return k.podaci();
	}
	public void dodajKorisnika(String korisnickoIme, String sifra, String biografija) throws ZauzetoKorisnickoImeException{
		if(nadjiKorisnika(korisnickoIme)!=null){
			throw new ZauzetoKorisnickoImeException();
		}
		if(biografija.equals("")){
			korisnici.add(new Korisnik(korisnickoIme,sifra));
		}else {
			korisnici.add(new PlaceniKorisnik(korisnickoIme,sifra,biografija));
		}
		
	}
	public void dodajAuto(Korisnik k,Automobil a){
		k.dodajAutomobil(a);
	}
	public Korisnik nadjiKorisnika(String korisnickoIme){
		for (Korisnik korisnik : korisnici) {
			if(korisnik.getKorisnickoIme().equals(korisnickoIme)) return korisnik;
		}
		return null;
	}
	public boolean dobraSifra(String korisnickoIme, String sifra){
		return nadjiKorisnika(korisnickoIme).getSifra().equals(sifra);
	}
}
