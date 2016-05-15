package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import controler.Kontroler;
import controler.KorisnickiKontroler;
import controler.exception.LosaSifraException;
import model.Korisnici;

public class LogIn extends OsnovniProzor {

	private JLabel lblKorisnickoIme;
	private JLabel lblSifra;
	private JPasswordField passwordField;
	private JButton btnUlogujSe;
	private JComboBox comboBox;
	private JButton btnVratiSe;

	

	/**
	 * Create the frame.
	 */
	public LogIn(Kontroler kontroler) {
		super(kontroler);
		setBounds(100, 100, 216, 245);
		contentPane.setLayout(null);
		contentPane.add(getLblKorisnickoIme());
		contentPane.add(getComboBox());
		contentPane.add(getLblSifra());
		contentPane.add(getPasswordField());
		contentPane.add(getBtnUlogujSe());
		contentPane.add(getBtnVratiSe());
		
	}
	private JLabel getLblKorisnickoIme() {
		if (lblKorisnickoIme == null) {
			lblKorisnickoIme = new JLabel("Korisnicko ime:");
			lblKorisnickoIme.setBounds(10, 51, 85, 14);
		}
		return lblKorisnickoIme;
	}
	private JLabel getLblSifra() {
		if (lblSifra == null) {
			lblSifra = new JLabel("Sifra:");
			lblSifra.setBounds(10, 89, 46, 14);
		}
		return lblSifra;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(94, 86, 86, 20);
		}
		return passwordField;
	}
	private JButton getBtnUlogujSe() {
		if (btnUlogujSe == null) {
			btnUlogujSe = new JButton("Uloguj se");
			btnUlogujSe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String[] podaci=izvuciPodatke();
					String korisnickoIme=podaci[0];
					String sifra=podaci[1];
					try{
						kontroler.ulogujSe(korisnickoIme, sifra);
						kontroler.predjiNaGlavniProzor();
						setVisible(false);
					}catch(LosaSifraException e){
						prikaziGresku("Uneli ste losu sifru");
					}
					
				}
			});
			btnUlogujSe.setBounds(10, 137, 170, 23);
			
		}
		return btnUlogujSe;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(94, 48, 86, 20);
			for (int i = 0; i < kontroler.listaSvihKorisnika().size(); i++) {
				comboBox.addItem(kontroler.listaSvihKorisnika().get(i).getKorisnickoIme());
			}
			
		}
		return comboBox;
	}
	private JButton getBtnVratiSe() {
		if (btnVratiSe == null) {
			btnVratiSe = new JButton("Vrati se");
			btnVratiSe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					kontroler.predjiNaLogInLogUp();
				}
			});
			btnVratiSe.setBounds(10, 166, 170, 23);
		}
		return btnVratiSe;
	}
	private String[] izvuciPodatke(){
		String korisnickoIme=(String) comboBox.getSelectedItem();
		char[] sifraC=passwordField.getPassword();
		String sifra="";
		for (int i = 0; i < sifraC.length; i++) {
			sifra+=sifraC[i];
		}
		return new String[]{korisnickoIme,sifra};
	}
	public void osveziStanje(String tekst){
		if(tekst.startsWith("I;"))
			comboBox.addItem(tekst.substring(2));
	}
}
