# ConversorMoedas

Projeto em Java de um conversor de moedas
Desenvolvido no curso de Java da Alura/ONE (Oracle Next Education)

25/07/2023
O objetivo é implementar uma aplicação desktop utilizando a biblioteca de interface
gráfica Swing do JAVA.
Inicialmente a aplicação deverá realizar converões entre as seguintes moedas:

- Reais
- Dolar
- Euro
- Libras esterlinas
- Peso argentino
- Peso chileno

26/07/2023

- Incluído o listenner do botão Converter
- Alterado o design do painel
- Implementado a busca na web das taxas de conversão entre moedas,
  para isso estamos utilizando o serviço https://www.exchangerate-api.com/docs/free
  com um get simples: https://open.er-api.com/v6/latest/USD onde só é necessário
  indicar qual é a moeda base. O resultado retorna como JSON, mas por enquanto o código
  realiza uma manipulação da string do JSON isolando a taxa de conversão solicitada pelo
  usuário.

A fazer:

- o código precisa ser refatorado para melhorar a legibilidade e organização
- funcionalidade para mostrar a data da taxa de câmbio utilizada
- como o serviço web provê as taxas de cotação fechadas no dia anterior, seria interessante
  ter uma função que na inicialização do app busque novas cotações e armazene em um arquivo para
  evitar ter de fazer um novo request a cada solicitação de conversão por parte do usuário
- melhorar o tratamento de erros através do uso de estruturas try/catch
- implementar uma classe específica para armazenar as cotações diretamente do JSON com o auxílio
  da biblioteca GSON.
