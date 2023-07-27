package conversor1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Currency;
import java.util.Date;


/**
 * Classe responsável por guardar as informações de uma moeda
 * @author Jônatas Rossettos
 */
public class Moeda {
	private String nome;
	private String codigo;
	private Date dataUltimaAtualizacao;
	private String taxasConversao;
	private String dados;
	
	public Moeda(String codigo) {
		try {
			Currency currency = Currency.getInstance(codigo);
			this.codigo = codigo;
			this.nome = currency.getDisplayName();
			this.dados = this.buscaDadosMoeda();
			this.dataUltimaAtualizacao = new Date(this.extraiDataUltimaAtualizacao()*1000);
			this.taxasConversao=this.extraiTaxasConversao();
		} catch(Exception e) {
			System.out.println("Moeda não pode ser criada pois o código solicitado é inexistente na ISO4217");
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCodigo() {
		return codigo;
	}
		
	public Date getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}
	
	
	
	public String getTaxasConversao() {
		return taxasConversao;
	}
	
	public void setTaxasConversao(String taxasConversao) {
		this.taxasConversao = taxasConversao;
	}
	
	//Realiza a busca dos dados da moeda na internet
	public String buscaDadosMoeda() {
		if (this.codigo!=null) {
			String urlParaChamada = "https://open.er-api.com/v6/latest/"+this.codigo;
			try {
				URL url = new URL(urlParaChamada);
				HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

				if (conexao.getResponseCode() != 200)
					throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

				BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
				String jsonEmString = converteJsonEmString(resposta);
				conexao.disconnect();
				return jsonEmString;

			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return "-1";
	}
	
	private String converteJsonEmString(BufferedReader buffereReader) throws IOException {
		String resposta, jsonEmString = "";
		while ((resposta = buffereReader.readLine()) != null) {
			jsonEmString += resposta;
		}
		return jsonEmString;
	}
	
	private long extraiDataUltimaAtualizacao() {
		if (this.codigo!=null) {
			int inicio = this.dados.indexOf("time_last_update_unix")+23;
			String aux = this.dados.substring(inicio);
			aux = aux.substring(0, aux.indexOf(","));
			long resultado = Long.valueOf(aux);
			return resultado;
		}
		return -1;
	}
	
	private String extraiTaxasConversao() {
		if (this.codigo!=null) {
			int inicio = this.dados.indexOf("rates")+7;
			String aux = this.dados.substring(inicio);
			return aux;
		}
		return null;
	}
	
	
	
}
