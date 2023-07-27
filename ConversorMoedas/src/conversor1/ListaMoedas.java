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
	
	public void getListaDeMoedas() {
		for (Moeda moeda : lista) {
			System.out.println(moeda.getNome()+"\n");
		}
	}
	
}
