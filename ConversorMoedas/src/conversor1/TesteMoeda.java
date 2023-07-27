package conversor1;

import java.util.Arrays;

public class TesteMoeda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Moeda moeda = new Moeda("USD");
		String[] moedas = {"BRL","USD","EUR","ARS","GBP","CLP"};
		ListaMoedas listaMoedas = new ListaMoedas(Arrays.asList(moedas));
		listaMoedas.getListaDeMoedas();
		System.out.println(listaMoedas.getTaxaConversao("BRL", "CLP"));
		System.out.println(listaMoedas.converte(1000, "USD", "BRL"));
		
//		System.out.println(moeda.getCodigo());
//		System.out.println(moeda.getTaxaDeConversao("USD"));
//		System.out.println(moeda.converte(1000,"BRL"));
//		System.out.println(moeda.getNome());
	}

}
