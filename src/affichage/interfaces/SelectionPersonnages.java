package affichage.interfaces;

import application.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JButton;

public class SelectionPersonnages implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source instanceof JButton) {
			Icon image_path = ((JButton) source).getIcon();
			Main.p.setTexture_personnage(image_path);
		}
	}
}
