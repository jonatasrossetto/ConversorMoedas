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

	}

}
