package conversor1;

public class TesteMoeda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Moeda moeda = new Moeda("USD");
		System.out.println(moeda.getCodigo());
		System.out.println(moeda.getTaxaDeConversao("USD"));
		System.out.println(moeda.converte(1000,"BRL"));
		System.out.println(moeda.getNome());
	}

}
