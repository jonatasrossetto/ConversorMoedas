package conversor1;

import java.util.Arrays;

import javax.swing.JFrame;

import conversor.gui.ConversorPainel;

public class TesteMoeda {

	public static void main(String[] args) {

		String[] moedas = {"BRL","USD","EUR","ARS","GBP","CLP"};
		System.out.println("instanciando a lista de moedas");
		ListaMoedas listaMoedas = new ListaMoedas(Arrays.asList(moedas));
		JFrame f = new JFrame("frame");
		System.out.println("instanciando o painel principal");
		PainelPrincipal c = new PainelPrincipal(listaMoedas);
		
		f.setSize(500, 400);
		f.add(c);
		f.setVisible(true);
		
		
		
//		listaMoedas.getListaDeMoedas();
//		System.out.println(listaMoedas.getTaxaConversao("BRL", "CLP"));
//		System.out.println(listaMoedas.converte(1000, "USD", "BRL"));
		
//		System.out.println(moeda.getCodigo());
//		System.out.println(moeda.getTaxaDeConversao("USD"));
//		System.out.println(moeda.converte(1000,"BRL"));
//		System.out.println(moeda.getNome());
	}

}
