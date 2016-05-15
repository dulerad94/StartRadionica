package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controler.Kontroler;
import controler.KorisnickiKontroler;
import model.Korisnici;

public class OsnovniProzor extends JFrame {

	protected JPanel contentPane;
	protected Kontroler kontroler;
	
	public void setKontroler(Kontroler kontrolerGUI){
		kontroler=kontrolerGUI;
	}
	/**
	 * Create the frame.
	 */
	public OsnovniProzor(Kontroler kontroler) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.kontroler=kontroler;
		
	}
	protected void prikaziGresku(String tekst){
		JOptionPane.showMessageDialog(contentPane,
				tekst, "START",
				JOptionPane.ERROR_MESSAGE);
	}
	protected void prikaziPoruku(String tekst){
		JOptionPane.showMessageDialog(contentPane,
				tekst, "START",
				JOptionPane.INFORMATION_MESSAGE);
	}
	public void osveziStanje(String tekst){}
}
