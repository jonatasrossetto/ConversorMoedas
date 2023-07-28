# ConversorMoedas

Projeto em Java de um conversor de moedas
Desenvolvido no curso de Java da Alura/ONE T5 (Oracle Next Education)

### Como compilar e executar na linha de comando

No diretório src/conversor/gui compilar utilizando: <br>
"javac -encoding UTF-8 \*.java" (garantindo a acentuação)

Para executar, o programa utilize:<br>
"java -cp /caminho/prodiretorio/src converor.gui.Teste

### 25/07/2023

O objetivo é implementar uma aplicação desktop utilizando a biblioteca de interface
gráfica Swing do JAVA.
Inicialmente a aplicação deverá realizar converões entre as seguintes moedas:

- Reais
- Dolar
- Euro
- Libras esterlinas
- Peso argentino
- Peso chileno

### 26/07/2023

- Incluído o listenner do botão Converter
- Alterado o design do painel
- Implementado a busca na web das taxas de conversão entre moedas,
  para isso estamos utilizando o serviço https://www.exchangerate-api.com/docs/free
  com um get simples: https://open.er-api.com/v6/latest/USD onde só é necessário
  indicar qual é a moeda base. O resultado retorna como JSON, mas por enquanto o código
  realiza uma manipulação da string do JSON isolando a taxa de conversão solicitada pelo
  usuário.

### 27/07/2023

- Resolvi reoorganizar o código criando a classe Moeda para cuidar apenas das informações pertinentes
  a uma moeda. Como atributos a classe guarda além do código da moeda, o nome da moeda, as taxas de conversão e a data da última atualização das taxas de conversão. Além disso, a busca de dados na web é realizada apenas quando o construtor da classe é chamado. Precisa melhorar a inicialização da moeda incluindo um mecanismo de backup de dados em arquivo
  para quando o sistema não tiver acesso a web por exemplo.
- Criei também a classe ListaMoedas para tratar e gerenciar o conjunto de moedas que a aplicação irá utilizar.
  A classe é construída a partir de um array de códigos de moedas e passa a ser responsável pela conversão entre
  as diversas moedas da lista.

### 28/07/2023

- Implementada uma nova classe de visualização, PainelPrincipal, utilizando a classe ListaMoedas no seu construtor.
  Desta forma o aplicativo inicia buscando os dados das moedas e só então abre o painel de visualização.

- Talvez seja interessante implementar um painel inicial informando que o sistema está buscando as informações
  mais atualizadas na web (existe uma latência na busca das informações e o usuário pode achar que o aplicativo
  não está funcionando)

- necessário implementar uma estrutura de trycatch quando o listenner de conversão é acionado, para evitar crash
  quando o usuário não entrar com dados numéricos no campo de valor da moeda de origem

A fazer:

- o código precisa ser refatorado para melhorar a legibilidade e organização

- como o serviço web provê as taxas de cotação fechadas no dia anterior, seria interessante
  ter uma função que na inicialização do app busque novas cotações e armazene em um arquivo para
  evitar ter de fazer um novo request a cada solicitação de conversão por parte do usuário
- melhorar o tratamento de erros através do uso de estruturas try/catch
-
