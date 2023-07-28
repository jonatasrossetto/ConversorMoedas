package conversor1;

import java.util.ArrayList;
import java.util.List;

public class ListaMoedas {
	private List<Moeda> lista = new ArrayList<Moeda>();

	public ListaMoedas(List<String> codigoMoedas) {
		for (String codigo : codigoMoedas) {
			lista.add(new Moeda(codigo));
		}
	}

	public String[] getListaDeMoedas() {
		String[] moedas = new String[lista.size()];
		int inc=0;
		for (Moeda moeda : lista) {
			moedas[inc] = moeda.getCodigo();
			inc++;
			
		}
		return moedas;
	}

	public float getTaxaConversao(String codigoMoedaOrigem, String codigoMoedaDestino) {
		float resultado = 0.0f;
		for (Moeda moeda : lista) {
			if (moeda.getCodigo() == codigoMoedaOrigem) {
				resultado = moeda.getTaxaDeConversao(codigoMoedaDestino);
			}
		}
		return resultado;
	}
	
	public float converte(float valor, String codigoMoedaOrigem, String codigoMoedaDestino ) {
		if (Moeda.verificaCodigoMoeda(codigoMoedaOrigem)&Moeda.verificaCodigoMoeda(codigoMoedaDestino)) {
			return this.getTaxaConversao(codigoMoedaOrigem, codigoMoedaDestino)*valor;
		} else {
			return 0.0f;
		}
	}

}
