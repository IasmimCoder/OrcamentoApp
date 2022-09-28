package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import models.Categorias;
import models.LivroDeRegistro;
import models.Registro;
import models.Enums.TipoRegistro;
import services.TipoRegistroService;

public class Forms {

    Scanner input = new Scanner(System.in);
    Categorias categorias = new Categorias();

    private String linhaCabecalho;

    public Registro inserirDadosDeRegistro() {
        Registro register = new Registro();
        TipoRegistroService tipoRegistroService = new TipoRegistroService();
        // Escolhe o tipo
        int tipo = this.inserirTipo();
        TipoRegistro tipoDeRegistro = tipoRegistroService.definirTipoRegistro(tipo);
        register.setTipo(tipoDeRegistro);

        // Escolhe a categoria
        register.setCategoria(this.inserirCategoria(tipoDeRegistro));

        // Escolhe a descrição/nome do registro
        register.setDescricao(this.inserirDescricao());

        // Escolhe o valor
        register.setValor(this.inserirValor());

        // Define a data
        register.setDataDeCriacao(this.inserirData());

        return register;
    }

    public void exibirLivroDeRegistroView(ArrayList<ArrayList<String>> livroDeRegistro, String titulo) {
        System.out.println();
        this.mostrarTitulo(titulo);
        for (ArrayList<String> arrayList : livroDeRegistro) {
            for (String dado : arrayList) {
                System.out.print("| " + dado);
            }
            System.out.println("|");
        }
        System.out.println(linhaCabecalho + "\n");
    }

    /**
     * 
     * O método pega da Matriz o dado e formata este.
     * int i: é equivalente a linha, ou seja, a lista
     * int j: é equivalente a coluna, ou seja, o dado dentro da lista
     * 
     * @param livroDeRegistro
     * @return retorna a matriz (livroDeRegistro) com os dados formatados
     */
    // transformar esse método em um método genêrico
    public ArrayList<ArrayList<String>> ajustaLivroDeRegistroView(ArrayList<ArrayList<String>> livroDeRegistro) {

        for (int i = 0; i < livroDeRegistro.size(); i++) {
            for (int j = 0; j < livroDeRegistro.get(i).size(); j++) {
                String dado = livroDeRegistro.get(i).get(j);
                livroDeRegistro.get(i).set(j, formatedString(dado));
            }
        }
        return livroDeRegistro;
    }
   
    public ArrayList<String> cabecalhoFormatado(ArrayList<String> cabecalho) {

        int totalEspaco = 0;
        for (int i = 0; i < cabecalho.size(); i++) {
            String dado = cabecalho.get(i);
            cabecalho.set(i, formatedString(dado));
            totalEspaco += (cabecalho.get(i).length() + 2); //total = tamanho do cabeçalho + divisorias (|  |)
        }
        totalEspaco++; // ++ ultima divisoria |
        this.setLinhaCabecalho(totalEspaco);
        return cabecalho;
    }

    public void mostraTotalSaidasEntradas(LivroDeRegistro livroDeRegistro) {
        livroDeRegistro.calculaTotal(categorias);

        ArrayList<String> cabecalho = this.cabecalhoFormatado(new ArrayList<>(Arrays.asList("Categoria", "Valor")));
        
        //Ajuste da matriz de saída para exibição
        ArrayList<ArrayList<String>> resultadoSaidasView = new ArrayList<>();
        ArrayList<ArrayList<String>> matrizSaida = this.ajustaLivroDeRegistroView(livroDeRegistro.getTotalSaidaFormatado());
        
        //Ajuste da matriz de entrada para exibição
        ArrayList<ArrayList<String>> resultadoEntradasView = new ArrayList<>();
        ArrayList<ArrayList<String>> matrizEntrada = this.ajustaLivroDeRegistroView(livroDeRegistro.getTotalEntradaFormatado());


        resultadoSaidasView = this.toTableForView(matrizSaida, cabecalho);
        resultadoEntradasView = this.toTableForView(matrizEntrada, cabecalho);
    

        this.exibirLivroDeRegistroView(resultadoSaidasView, "REGISTROS DE SAÍDAS");
        this.exibirLivroDeRegistroView(resultadoEntradasView, "REGISTROS DE ENTRADAS");
    }

    private ArrayList<ArrayList<String>> toTableForView(ArrayList<ArrayList<String>> matriz, ArrayList<String> cabecalho) {
        ArrayList<ArrayList<String>> newMatriz = new ArrayList<>();
        newMatriz.add(cabecalho);
        for (ArrayList<String> linha : matriz) {
            newMatriz.add(linha);
        }
        return newMatriz;
    }

    private void setLinhaCabecalho(int number) {
        String linha = "";
        for (int i = 0; i < number; i++) {
            linha += "-";
        }
        this.linhaCabecalho = linha;
    }

    /**
     * Limita uma String a um determinado número de caracteres,
     * o que permite a organização da matriz.
     * 
     * @param text
     * @return retorna uma String modificada
     */
    private String formatedString(String text) {
        return String.format(" %-15.15s ", text);
    }

    private int inserirTipo() {
        System.out.println("Informe o tipo: \n");
        System.out.println("[1] ENTRADA\n[2] SAÍDA");
        System.out.print("Sua resposta:");
        int tipoIndex = Integer.parseInt(input.nextLine());
        return tipoIndex;
    }

    private String inserirCategoria(TipoRegistro tipoDeRegistro) {
        System.out.println("\nEscolha a Categoria: \n");
        categorias.mostrarCategorias(tipoDeRegistro);
        System.out.print("Sua resposta é: ");
        int indexCategoria = Integer.parseInt(input.nextLine());
        return categorias.escolheCategoria(indexCategoria);
    }

    private String inserirDescricao() {
        System.out.print("\nDigite a Descrição: ");
        String descricao = input.nextLine();
        return descricao;
    }

    private double inserirValor() {
        System.out.print("Digite o valor: ");
        double valor = Double.parseDouble(input.nextLine());
        return valor;
    }

    private String inserirData() {
        System.out.println("\nDigite a data de registro [00/00/0000]: ");
        System.out.println("(Caso não digite a data será hoje)");
        String data = input.nextLine();
        return data;
    }

    private void mostrarTitulo(String titulo) {
        System.out.println(linhaCabecalho);
        System.out.println(centralizarStringTitulo(titulo));
        System.out.println(linhaCabecalho);
    }

    private String centralizarStringTitulo(String string) {
        String stringCentralizada = "";
        for (int i = 0; i < (linhaCabecalho.length()/2 - string.length()/2); i++) {
            stringCentralizada += " ";
        }
        return stringCentralizada + string;
    }

    public void resultadoDeSaldo(LivroDeRegistro livroDeRegistro) {
        double saldo = livroDeRegistro.getSomaTotalDeCategoriasEntrada() - livroDeRegistro.getSomaTotalDeCategoriasSaida();

        if( saldo < 0) {
            System.out.println("CUIDADO!");
            System.out.println("Você gastou mais do que seu total de entradas.");
            System.out.println(String.format("Você possuí o saldo negativo de: R$ %.2f", saldo*-1));
        } else {
            System.out.println(String.format("Seu saldo restante é de: R$ %.2f", saldo));
        }
    }

    public void iniciarTituloDoPrograma() {
        this.setLinhaCabecalho(120);
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
        System.out.println(linhaCabecalho);
        System.out.println(centralizarStringTitulo("CALCULE SUAS DESPESAS"));
        System.out.println(linhaCabecalho);
        System.out.println("\n\n\n");
    }
}
