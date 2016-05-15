package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controler.Kontroler;
import model.Automobil;

public class GlavniProzor extends OsnovniProzor {
	
	protected JPanel panelEast;
	protected JScrollPane scrollPane;
	protected JTextArea textArea;
	protected JButton btnDodajTekst;
	protected JButton btnProfil;
	protected JButton btnIzlogujSe;
	protected JScrollPane scrollPaneMaliTekst;
	protected JTextArea textAreaMaliTekst;
	protected JPanel panel;
	protected JComboBox comboBox;

	

	/**
	 * Create the frame.
	 */
	public GlavniProzor(Kontroler kontroler) {
		super(kontroler);
		
		setBounds(100, 100, 450, 333);	
		
		
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelEast(), BorderLayout.EAST);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
	}

	protected JPanel getPanelEast() {
		if (panelEast == null) {
			panelEast = new JPanel();
			panelEast.setPreferredSize(new Dimension(140, 10));
			panelEast.setLayout(new BorderLayout(0, 0));
			panelEast.add(getScrollPaneMaliTekst(), BorderLayout.CENTER);
			panelEast.add(getPanel(), BorderLayout.SOUTH);
		}
		return panelEast;
	}
	protected JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	protected JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			String tekst=kontroler.procitajSveAutomobileOdKorisnika();
			textArea.setText(tekst);
		}
		return textArea;
	}
	
	
	protected JButton getBtnIzlogujSe() {
		if (btnIzlogujSe == null) {
			btnIzlogujSe = new JButton("Izloguj se");
			btnIzlogujSe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					kontroler.izlogujSe();
					kontroler.predjiNaLogInLogUp();
					setVisible(false);
					
				}
			});
		}
		return btnIzlogujSe;
	}
	protected JScrollPane getScrollPaneMaliTekst() {
		if (scrollPaneMaliTekst == null) {
			scrollPaneMaliTekst = new JScrollPane();
			scrollPaneMaliTekst.setBorder(new EmptyBorder(10, 10, 10, 10));
			scrollPaneMaliTekst.setViewportView(getTextAreaMaliTekst());
		}
		return scrollPaneMaliTekst;
	}
	protected JTextArea getTextAreaMaliTekst() {
		if (textAreaMaliTekst == null) {
			textAreaMaliTekst = new JTextArea();
		}
		return textAreaMaliTekst;
	}
	protected JButton getBtnDodajAuto() {
		if (btnDodajTekst == null) {
			btnDodajTekst = new JButton("Dodaj auto");
			btnDodajTekst.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String[] podaci=textAreaMaliTekst.getText().split(" ");
					String markaIModel=podaci[0];
					int konjskaSnaga=Integer.parseInt(podaci[1]);
					textArea.append(kontroler.dodajAuto(markaIModel,konjskaSnaga));
				}
			});
		}
		return btnDodajTekst;
	}
	protected JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(10, 120));				
			panel.add(getBtnDodajAuto());
			panel.add(getBtnIzlogujSe());
			
		}
		return panel;
	}
	public void osveziStanje(){
		String tekst=kontroler.procitajSveAutomobileOdKorisnika();
		textArea.setText(tekst);
	}
}
