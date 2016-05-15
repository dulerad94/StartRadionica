package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controler.Kontroler;
import controler.KorisnickiKontroler;
import controler.exception.LosaSifraException;
import controler.exception.RazliciteSifreException;
import controler.exception.ZauzetoKorisnickoImeException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class LogUp extends OsnovniProzor {


	private JLabel lblKorisnickoIme;
	private JTextField txtIme;
	private JLabel lblSifra;
	private JLabel lblPonovljenaSifra;
	private JPasswordField txtSifra;
	private JPasswordField txtPonovljenaSifra;
	private JComboBox comboBox;
	private JLabel lblTipKorisnika;
	private JButton btnRegistrujSe;
	private JLabel labelZauzetoIme;
	private JLabel lblBiografija;
	private JButton btnVratiSe;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	

	/**
	 * Create the frame.
	 */
	public LogUp(Kontroler kontroler) {
		super(kontroler);
		setBounds(100, 100, 270, 465);
		contentPane.setLayout(null);
		contentPane.add(getLblKorisnickoIme());
		contentPane.add(getTxtIme());
		contentPane.add(getLblSifra());
		contentPane.add(getLblPonovljenaSifra());
		contentPane.add(getTxtSifra());
		contentPane.add(getTxtPonovljenaSifra());
		contentPane.add(getComboBox());
		contentPane.add(getLblTipKorisnika());
		contentPane.add(getBtnRegistrujSe());
		contentPane.add(getLabelZauzetoIme());
		contentPane.add(getLblBiografija());
		contentPane.add(getBtnVratiSe());
		contentPane.add(getScrollPane());
	}

	private JLabel getLblKorisnickoIme() {
		if (lblKorisnickoIme == null) {
			lblKorisnickoIme = new JLabel("Korisnicko ime:");
			lblKorisnickoIme.setBounds(10, 58, 110, 14);
		}
		return lblKorisnickoIme;
	}
	private JTextField getTxtIme() {
		if (txtIme == null) {
			txtIme = new JTextField();
			txtIme.setBounds(158, 55, 86, 20);
			txtIme.setColumns(10);
		}
		return txtIme;
	}
	private JLabel getLblSifra() {
		if (lblSifra == null) {
			lblSifra = new JLabel("Sifra:");
			lblSifra.setBounds(10, 104, 46, 14);
		}
		return lblSifra;
	}
	private JLabel getLblPonovljenaSifra() {
		if (lblPonovljenaSifra == null) {
			lblPonovljenaSifra = new JLabel("Ponovljena sifra:");
			lblPonovljenaSifra.setBounds(10, 137, 110, 14);
		}
		return lblPonovljenaSifra;
	}
	private JPasswordField getTxtSifra() {
		if (txtSifra == null) {
			txtSifra = new JPasswordField();
			txtSifra.setBounds(158, 101, 86, 20);
		}
		return txtSifra;
	}
	private JPasswordField getTxtPonovljenaSifra() {
		if (txtPonovljenaSifra == null) {
			txtPonovljenaSifra = new JPasswordField();
			txtPonovljenaSifra.setBounds(158, 134, 86, 20);
		}
		return txtPonovljenaSifra;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					String tip=(String) comboBox.getSelectedItem();
					if(tip.equals("Ne placa")){
						textArea.setText("");
						lblBiografija.setVisible(false);
						scrollPane.setVisible(false);
					}else {	
						lblBiografija.setVisible(true);
						scrollPane.setVisible(true);
						
					}
				}
			});
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ne placa", "Placa"}));
			comboBox.setBounds(158, 165, 86, 20);
			
		}
		return comboBox;
	}
	private JLabel getLblTipKorisnika() {
		if (lblTipKorisnika == null) {
			lblTipKorisnika = new JLabel("Tip korisnika:");
			lblTipKorisnika.setBounds(10, 168, 81, 14);
		}
		return lblTipKorisnika;
	}
	private JButton getBtnRegistrujSe() {
		if (btnRegistrujSe == null) {
			btnRegistrujSe = new JButton("Registruj se");
			btnRegistrujSe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String[] podaci=izvuciPodatke();
					String korisnickoIme=podaci[0];
					String sifra=podaci[1];
					String ponovljenaSifra=podaci[2];
					String biografija=podaci[3];
					try {
						kontroler.registrujKorisnika(korisnickoIme,sifra,ponovljenaSifra,biografija);
						prikaziPoruku("Uspesno ste se registrovali");
					} catch (ZauzetoKorisnickoImeException e1) {
						prikaziGresku("Korisnicko ime koje ste izabrali je zauzeto");
					} catch (RazliciteSifreException e1) {
						prikaziGresku("Sifra i ponovljena sifra su vam razlicite");
					}
				}
			});
			btnRegistrujSe.setBounds(10, 340, 234, 23);
		}
		return btnRegistrujSe;
	}
	private JLabel getLabelZauzetoIme() {
		if (labelZauzetoIme == null) {
			labelZauzetoIme = new JLabel("");
			labelZauzetoIme.setBounds(211, 58, 46, 14);
		}
		return labelZauzetoIme;
	}
	private JLabel getLblBiografija() {
		if (lblBiografija == null) {
			lblBiografija = new JLabel("Biografija:");
			lblBiografija.setHorizontalAlignment(SwingConstants.CENTER);
			lblBiografija.setBounds(10, 199, 191, 14);
			lblBiografija.setVisible(false);
		}
		return lblBiografija;
	}
	private JButton getBtnVratiSe() {
		if (btnVratiSe == null) {
			btnVratiSe = new JButton("Vrati se");
			btnVratiSe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					kontroler.predjiNaLogInLogUp();
				}
			});
			btnVratiSe.setBounds(10, 374, 234, 23);
		}
		return btnVratiSe;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 224, 234, 105);
			scrollPane.setViewportView(getTextArea());
			scrollPane.setVisible(false);
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private String[] izvuciPodatke(){
		String korisnickoIme=txtIme.getText();
		char[] sifraC=txtSifra.getPassword();
		String sifra="";
		for (int i = 0; i < sifraC.length; i++) {
			sifra+=sifraC[i];
		}
		char[] ponovljenaSifraC=txtPonovljenaSifra.getPassword();
		String ponovljenaSifra="";
		for (int i = 0; i < ponovljenaSifraC.length; i++) {
			ponovljenaSifra+=ponovljenaSifraC[i];
		}
		String biografija=textArea.getText();
		return new String[]{korisnickoIme,sifra,ponovljenaSifra,biografija};
	}
	
}
