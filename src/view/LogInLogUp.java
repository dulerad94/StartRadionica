package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controler.Kontroler;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogInLogUp extends OsnovniProzor {

	
	private JButton btnLogin;
	private JButton btnLogup;

	

	/**
	 * Create the frame.
	 */
	public LogInLogUp(Kontroler kontroler) {
		super(kontroler);
		setBounds(100, 100, 228, 222);
		contentPane.setLayout(null);
		contentPane.add(getBtnLogin());
		contentPane.add(getBtnLogup());
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Log In");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					kontroler.predjiNaLogIn();
				}
			});
			btnLogin.setBounds(45, 25, 120, 62);
		}
		return btnLogin;
	}
	private JButton getBtnLogup() {
		if (btnLogup == null) {
			btnLogup = new JButton("Sign Up");
			btnLogup.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					kontroler.predjiNaLogUp();
				}
			});
			btnLogup.setBounds(45, 110, 120, 62);
		}
		return btnLogup;
	}
}
