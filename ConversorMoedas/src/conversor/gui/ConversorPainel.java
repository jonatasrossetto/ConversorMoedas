package conversor.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class ConversorPainel extends JPanel {
	private JTextField textFieldValorMoedaOrigem;
	private JTextField textFieldValorMoedaDestino;
	private JTextField textFieldTaxaConversaoOrigemDestino;
	private JTextArea textAreaDisplayResultado;
	private JComboBox comboBoxMoedaOrigem;
	private JComboBox comboBoxMoedaDestino;
	private String[] moedas = { "BRL", "USD", "EUR", "GBP", "ARS", "CLP" };

	/**
	 * Create the panel.
	 */
	public ConversorPainel() {
		setLayout(null);

		JLabel labelConversorMoedas = new JLabel("Conversor de Moedas");
		labelConversorMoedas.setBounds(10, 10, 163, 15);
		labelConversorMoedas.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(labelConversorMoedas);

		JLabel lblNewLabel = new JLabel("é equivalente à:");
		lblNewLabel.setBounds(10, 78, 122, 13);
		add(lblNewLabel);

		comboBoxMoedaOrigem = new JComboBox(moedas);
		comboBoxMoedaOrigem.setSelectedIndex(1);
		comboBoxMoedaOrigem.setBounds(116, 47, 86, 21);
		add(comboBoxMoedaOrigem);

		comboBoxMoedaDestino = new JComboBox(moedas);
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
				realizaConversao();
			};
		});

	}

	public void realizaConversao() {
		float taxa;
		float valorMoedaOrigem;
		float valorMoedaDestino;
		String moedaOrigem;
		String moedaDestino;
		String time_last_update_utc;

		try {
			moedaOrigem = moedas[comboBoxMoedaOrigem.getSelectedIndex()];
			moedaDestino = moedas[comboBoxMoedaDestino.getSelectedIndex()];

			buscaTaxasConversao(moedaOrigem, moedaDestino);
			taxa = Float.valueOf(textFieldTaxaConversaoOrigemDestino.getText());
			valorMoedaOrigem = Float.valueOf(textFieldValorMoedaOrigem.getText());
			textFieldValorMoedaDestino.setText(String.valueOf(valorMoedaOrigem * taxa));
//			time_last_update_utc = 

			System.out.println("origem: " + moedaOrigem + " destino: " + moedaDestino);

		} catch (Exception e) {
			textAreaDisplayResultado.setText(
					" A taxa de conversão precisa ser um valor numérico,\n para o separador de casa decimal utilize o '.'");
		}
	}

	public String converteJsonEmString(BufferedReader buffereReader) throws IOException {
		String resposta, jsonEmString = "";
		while ((resposta = buffereReader.readLine()) != null) {
			jsonEmString += resposta;
		}
		return jsonEmString;
	}

	public void buscaTaxasConversao(String origem, String destino) {
		String urlParaChamada = "https://open.er-api.com/v6/latest/" + origem;
		int inicio;
		int fim;
		String texto = "";
		if (origem == destino) {
			textFieldTaxaConversaoOrigemDestino.setText("1.0");
		} else {
			try {
				URL url = new URL(urlParaChamada);
				HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

				if (conexao.getResponseCode() != 200)
					throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

				BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
				String jsonEmString = converteJsonEmString(resposta);
				inicio = jsonEmString.indexOf(destino) + 5;
				texto = jsonEmString.substring(inicio, jsonEmString.length());
				System.out.println(texto);
				fim = texto.indexOf(",");
				System.out.println(Float.valueOf(texto.substring(0, fim)));
				textFieldTaxaConversaoOrigemDestino.setText(texto.substring(0, fim));
				conexao.disconnect();

			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}

}
