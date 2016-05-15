package view;

import controler.Kontroler;
import controler.Kontroler;

public class Konzola {
	private Kontroler kontroler;
	
	public Konzola(Kontroler kontroler){
		this.kontroler=kontroler;
		System.out.println("Lista korisnika:");
		System.out.println(kontroler.listaSvihKorisnikaSaAutomobilima());
	}
	public void osveziStanje(String tekst){
		System.out.println("PROMENA");
		System.out.println(kontroler.listaSvihKorisnikaSaAutomobilima());
	}
}
