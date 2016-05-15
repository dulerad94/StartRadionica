package controler;

import java.awt.EventQueue;

import model.Korisnici;
import view.Konzola;
import view.OsnovniProzor;

public class Aplikacija {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Korisnici korisnici=Korisnici.getInstanca();
			//		KorisnickiKontroler korisnickiKontroler=new KorisnickiKontroler(korisnici);
					Kontroler kontroler=Kontroler.getInstanca(korisnici);
					Konzola konzola=new Konzola(kontroler);
					OsnovniProzor frame=new OsnovniProzor(kontroler);
					kontroler.setFrame(frame);
					kontroler.setKonzola(konzola);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
