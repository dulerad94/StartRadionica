package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controler.Kontroler;
import controler.KorisnickiKontroler;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Profil extends OsnovniProzor {
	private JLabel lblKorisnickoIme;
	private JTextField txtKorisnickoIme;
	private JLabel lblSifra;
	private JTextField txtSifra;
	private JButton btnVratiSe;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	

	/**
	 * Create the frame.
	 */
	public Profil(Kontroler kontroler) {
		super(kontroler);
		setBounds(100, 100, 392, 231);	
		contentPane.setLayout(null);
		contentPane.add(getLblKorisnickoIme());
		contentPane.add(getTxtKorisnickoIme());
		contentPane.add(getLblSifra());
		contentPane.add(getTxtSifra());
		contentPane.add(getBtnVratiSe());
		contentPane.add(getScrollPane());
		ispisiPodatke();
	}
	private JLabel getLblKorisnickoIme() {
		if (lblKorisnickoIme == null) {
			lblKorisnickoIme = new JLabel("Korisnicko ime:");
			lblKorisnickoIme.setBounds(166, 25, 93, 14);
		}
		return lblKorisnickoIme;
	}
	private JTextField getTxtKorisnickoIme() {
		if (txtKorisnickoIme == null) {
			txtKorisnickoIme = new JTextField();
			txtKorisnickoIme.setEditable(false);
			txtKorisnickoIme.setBounds(253, 22, 86, 20);
			txtKorisnickoIme.setColumns(10);
		}
		return txtKorisnickoIme;
	}
	private JLabel getLblSifra() {
		if (lblSifra == null) {
			lblSifra = new JLabel("Sifra:");
			lblSifra.setBounds(166, 67, 70, 14);
		}
		return lblSifra;
	}
	private JTextField getTxtSifra() {
		if (txtSifra == null) {
			txtSifra = new JTextField();
			txtSifra.setEditable(false);
			txtSifra.setBounds(253, 64, 86, 20);
			txtSifra.setColumns(10);
		}
		return txtSifra;
	}
	private JButton getBtnVratiSe() {
		if (btnVratiSe == null) {
			btnVratiSe = new JButton("Vrati se");
			btnVratiSe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					kontroler.predjiNaGlavniProzor();
				}
			});
			btnVratiSe.setBounds(166, 142, 173, 23);
		}
		return btnVratiSe;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 22, 132, 143);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false);
		}
		return textArea;
	}
	private void ispisiPodatke(){
		String[] podaci=kontroler.podaciOTrenutomKorisniku();
		txtKorisnickoIme.setText(podaci[0]);
		txtSifra.setText(podaci[1]);
		textArea.setText(podaci[2]);
	}
}
