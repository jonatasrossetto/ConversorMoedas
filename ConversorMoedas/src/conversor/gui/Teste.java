package conversor.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Teste {

	public static void main(String[] args) {
		
		JFrame f = new JFrame("frame");

		ConversorPainel c = new ConversorPainel();
		f.setSize(500, 400);
		f.add(c);
		f.setVisible(true);

	}

}
