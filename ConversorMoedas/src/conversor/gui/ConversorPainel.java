package conversor.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ConversorPainel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public ConversorPainel() {
		setLayout(null);
		
		JLabel labelConversorMoedas = new JLabel("Conversor de Moedas");
		labelConversorMoedas.setBounds(10, 10, 163, 15);
		labelConversorMoedas.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(labelConversorMoedas);
		
		JLabel lblNewLabel = new JLabel("Converter de:");
		lblNewLabel.setBounds(10, 47, 122, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("para");
		lblNewLabel_1.setBounds(10, 101, 45, 13);
		add(lblNewLabel_1);
		
		String moedas[]= { "BRL","USD","EUR","GBP","ARS"};
		JComboBox comboBox = new JComboBox(moedas);
		comboBox.setBounds(10, 70, 86, 21);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(new Object[]{});
		comboBox_1.setBounds(10, 124, 86, 21);
		add(comboBox_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("valor:");
		lblNewLabel_1_1.setBounds(106, 74, 45, 13);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("valor:");
		lblNewLabel_1_1_1.setBounds(106, 128, 45, 13);
		add(lblNewLabel_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(142, 71, 96, 19);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(142, 125, 96, 19);
		add(textField_1);
		textField_1.setColumns(10);
		
		

	}
}
