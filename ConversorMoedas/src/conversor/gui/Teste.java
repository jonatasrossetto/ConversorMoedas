package conversor.gui;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class Teste {

	public static void main(String[] args) {
		
		JFrame f = new JFrame("frame");
		
		ConversorPainel c = new ConversorPainel();
		f.setSize(500,400);
		f.add(c);
		f.setVisible(true);

		
	}

}
