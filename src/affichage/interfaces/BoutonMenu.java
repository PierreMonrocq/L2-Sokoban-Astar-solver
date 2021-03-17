package affichage.interfaces;

import application.Main;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BoutonMenu implements ActionListener, ItemListener {
	public void actionPerformed(ActionEvent e) {
		CardLayout cl = (CardLayout) Main.affichageMultiple.getLayout();
		cl.show(Main.affichageMultiple, "MenuO");
	}

	public void itemStateChanged(ItemEvent e) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
