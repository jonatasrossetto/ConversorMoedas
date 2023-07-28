package conversor1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PainelPrincipal extends JPanel {

	private JTextField textFieldValorMoedaOrigem;
	private JTextField textFieldValorMoedaDestino;
	private JTextField textFieldTaxaConversaoOrigemDestino;
	private JTextArea textAreaDisplayResultado;
	private JComboBox comboBoxMoedaOrigem;
	private JComboBox comboBoxMoedaDestino;
//	private String[] codigoMoedas = { "BRL", "USD", "EUR", "GBP", "ARS", "CLP" };

	/**
	 * Create the panel.
	 */
	public PainelPrincipal(ListaMoedas listaMoedas) {
		
		String[] codigoMoedas = listaMoedas.getListaDeMoedas();
		setLayout(null);

		JLabel labelConversorMoedas = new JLabel("Conversor de Moedas");
		labelConversorMoedas.setBounds(10, 10, 163, 15);
		labelConversorMoedas.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(labelConversorMoedas);

		JLabel lblNewLabel = new JLabel("é equivalente à:");
		lblNewLabel.setBounds(10, 78, 122, 13);
		add(lblNewLabel);

		comboBoxMoedaOrigem = new JComboBox(codigoMoedas);
		comboBoxMoedaOrigem.setSelectedIndex(1);
		comboBoxMoedaOrigem.setBounds(116, 47, 86, 21);
		add(comboBoxMoedaOrigem);

		comboBoxMoedaDestino = new JComboBox(codigoMoedas);
		comboBoxMoedaDestino.setBounds(116, 110, 86, 21);
		add(comboBoxMoedaDestino);

		JLabel lblNewLabel_1_1 = new JLabel("valor:");
		lblNewLabel_1_1.setBounds(10, 35, 45, 13);
		add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("valor:");
		lblNewLabel_1_1_1.setBounds(10, 98, 45, 13);
		add(lblNewLabel_1_1_1);

		textFieldValorMoedaOrigem = new JTextField();
		textFieldValorMoedaOrigem.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldValorMoedaOrigem.setBounds(10, 48, 96, 19);
		add(textFieldValorMoedaOrigem);
		textFieldValorMoedaOrigem.setColumns(10);

		textFieldValorMoedaDestino = new JTextField();
		textFieldValorMoedaDestino.setEditable(false);
		textFieldValorMoedaDestino.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldValorMoedaDestino.setBounds(10, 111, 96, 19);
		add(textFieldValorMoedaDestino);
		textFieldValorMoedaDestino.setColumns(10);

		textFieldTaxaConversaoOrigemDestino = new JTextField();
		textFieldTaxaConversaoOrigemDestino.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldTaxaConversaoOrigemDestino.setBounds(233, 75, 96, 19);
		add(textFieldTaxaConversaoOrigemDestino);
		textFieldTaxaConversaoOrigemDestino.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Taxa de Conversão");
		lblNewLabel_3.setBounds(233, 61, 132, 13);
		add(lblNewLabel_3);

		JButton btnConverter = new JButton("Converter");
		btnConverter.setBounds(10, 161, 111, 21);
		add(btnConverter);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(142, 161, 85, 21);
		add(btnLimpar);

		textAreaDisplayResultado = new JTextArea();
		textAreaDisplayResultado.setEditable(false);
		textAreaDisplayResultado.setText("TextArea para apresentar o resultado da operação");
		textAreaDisplayResultado.setBounds(10, 217, 417, 62);
		add(textAreaDisplayResultado);

		btnConverter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// ação de conversão
				String moedaOrigem = codigoMoedas[comboBoxMoedaOrigem.getSelectedIndex()];
				String moedaDestino = codigoMoedas[comboBoxMoedaDestino.getSelectedIndex()];
				float taxa = listaMoedas.getTaxaConversao(moedaOrigem,moedaDestino);
				float valorOrigem = Float.parseFloat(textFieldValorMoedaOrigem.getText());
				float valorDestino = listaMoedas.converte(valorOrigem, moedaOrigem, moedaDestino);
				textFieldTaxaConversaoOrigemDestino.setText(Float.toString(taxa));
				textFieldValorMoedaDestino.setText(Float.toString(valorDestino));
			};
		});

	}
}
