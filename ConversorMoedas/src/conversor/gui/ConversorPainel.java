package conversor.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ConversorPainel extends JPanel {
	private JTextField textFieldValorMoedaOrigem;
	private JTextField textFieldValorMoedaDestino;
	private JTextField textFieldTaxaConversaoOrigemDestino;

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
		
		String[] moedas = {"BRL","USD","EUR","GBP","ARS"};
		
		JComboBox comboBoxMoedaOrigem = new JComboBox(moedas);
		comboBoxMoedaOrigem.setBounds(10, 70, 86, 21);
		add(comboBoxMoedaOrigem);
		
		JComboBox comboBoxMoedaDestino = new JComboBox(moedas);
		comboBoxMoedaDestino.setBounds(10, 124, 86, 21);
		add(comboBoxMoedaDestino);
		
		JLabel lblNewLabel_1_1 = new JLabel("valor:");
		lblNewLabel_1_1.setBounds(106, 74, 45, 13);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("valor:");
		lblNewLabel_1_1_1.setBounds(106, 128, 45, 13);
		add(lblNewLabel_1_1_1);
		
		textFieldValorMoedaOrigem = new JTextField();
		textFieldValorMoedaOrigem.setBounds(142, 71, 96, 19);
		add(textFieldValorMoedaOrigem);
		textFieldValorMoedaOrigem.setColumns(10);
		
		textFieldValorMoedaDestino = new JTextField();
		textFieldValorMoedaDestino.setBounds(142, 125, 96, 19);
		add(textFieldValorMoedaDestino);
		textFieldValorMoedaDestino.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Resultado");
		lblNewLabel_2.setBounds(10, 155, 86, 13);
		add(lblNewLabel_2);
		
		JLabel labelDisplayResultado = new JLabel("texto com o resultado da conversão");
		labelDisplayResultado.setBounds(10, 178, 430, 43);
		add(labelDisplayResultado);
		
		textFieldTaxaConversaoOrigemDestino = new JTextField();
		textFieldTaxaConversaoOrigemDestino.setBounds(331, 98, 96, 19);
		add(textFieldTaxaConversaoOrigemDestino);
		textFieldTaxaConversaoOrigemDestino.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Taxa de Conversão");
		lblNewLabel_3.setBounds(189, 101, 132, 13);
		add(lblNewLabel_3);
		
		JButton btnConverter = new JButton("Converter");
		btnConverter.setBounds(222, 151, 111, 21);
		add(btnConverter);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(342, 151, 85, 21);
		add(btnLimpar);

		
	}
}
