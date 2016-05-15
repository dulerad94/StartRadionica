package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import controler.Kontroler;
import controler.exception.NePlacaException;
import model.Korisnici;
import model.Korisnik;

public class GlavniProzorPlaceniKorisnik extends GlavniProzor{
	public GlavniProzorPlaceniKorisnik(Kontroler kontroler) {
		super(kontroler);
		comboBox.setSelectedItem(kontroler.getTrenutniKorisnik().getKorisnickoIme());
	}
	protected JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(10, 120));	
			panel.add(getComboBoxKorisnici());
			panel.add(getBtnDodajAuto());
			panel.add(getBtnProfil());
			panel.add(getBtnIzlogujSe());
			
		}
		return panel;
	}
	
	protected JButton getBtnProfil() {
		if (btnProfil == null) {
			btnProfil = new JButton("Profil");
			btnProfil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						kontroler.predjiNaProfil();
						setVisible(false);
					}catch(NePlacaException exc){
						prikaziGresku("Plati pa ces videti");
					}
				}
			});
		}
		return btnProfil;
	}
	protected JComboBox getComboBoxKorisnici() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(94, 48, 86, 20);
			for (int i = 0; i < kontroler.listaSvihKorisnika().size(); i++) {
				comboBox.addItem(kontroler.listaSvihKorisnika().get(i).getKorisnickoIme());
			}
			
			comboBox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					String korisnik=(String) comboBox.getSelectedItem();
					textArea.setText(kontroler.procitajSveAutomobileOdKorisnika(korisnik));
				}
			});
			
		}
		return comboBox;
	}
	protected JButton getBtnDodajAuto() {
		if (btnDodajTekst == null) {
			btnDodajTekst = new JButton("Dodaj auto");
			btnDodajTekst.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String korisnik=(String) comboBox.getSelectedItem();
					String[] podaci=textAreaMaliTekst.getText().split(" ");
					String markaIModel=podaci[0];
					int konjskaSnaga=Integer.parseInt(podaci[1]);
					textArea.append(kontroler.dodajAuto(markaIModel,konjskaSnaga,korisnik));
				}
			});
		}
		return btnDodajTekst;
	}
	public void osveziStanje(String tekst){
		if(tekst.startsWith("I;"))
			comboBox.addItem(tekst.substring(2));
		else {
			String korisnik=(String) comboBox.getSelectedItem();
			textArea.setText(kontroler.procitajSveAutomobileOdKorisnika(korisnik));
		}
	}
}
