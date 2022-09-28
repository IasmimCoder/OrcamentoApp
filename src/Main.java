import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import models.LivroDeRegistro;
import models.Registro;
import models.Enums.TipoRegistro;
import view.Forms;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // ArrayList<Registro> listaDeRegistros = new ArrayList<>();
        LivroDeRegistro livroDeRegistro = new LivroDeRegistro();
        Forms formulario = new Forms();
        char entrada;

        formulario.iniciarTituloDoPrograma();

        do {
        // Adiciona registro na lista de registros
        livroDeRegistro.addRegistroToListaDeRegistro(formulario.inserirDadosDeRegistro());

        System.out.print("\nDeseja fornecer mais dados [y/n]? ");
        entrada = input.nextLine().toLowerCase().strip().charAt(0);

        } while (entrada == 'y');

        // Início da Matriz! Para Visualização

        // Lista que recebe outra lista: matriz
        ArrayList<ArrayList<String>> livroDeRegistroView = new ArrayList<>();

        // adiciona cabeçalho da tabela/matriz
        livroDeRegistroView.add(formulario
                .cabecalhoFormatado(new ArrayList<>(
                        Arrays.asList("Data", "Descrição",
                                "Valor", "Categoria", "Tipo"))));

        /**
         * No caso, tenho que transformar os valores de Registro em string e
         * passar cada objeto registro como lista?
         * SIM. Para isso, há o método toTable() criado na classe Registro.
         */

        // Neste for, acesso os dados dos registros como Strings DENTRO de listas
        // através do método toTable()
        // e adiciono à matriz.
        // Cada lista adicionada é uma linha na matriz
        for (Registro registros : livroDeRegistro.getListaDeRegistros()) {
            livroDeRegistroView.add(registros.toTable()); // adiciona na matriz lista por lista
        }

        // Matriz subscrita ao retornar esta (livroDeRegistroView) com os dados
        // formatados.
        livroDeRegistroView = formulario.ajustaLivroDeRegistroView(livroDeRegistroView);

        formulario.exibirLivroDeRegistroView(livroDeRegistroView, "LIVRO DE REGISTROS");
        formulario.mostraTotalSaidasEntradas(livroDeRegistro);
        formulario.resultadoDeSaldo(livroDeRegistro);

        // teste

        input.close();
    }
}