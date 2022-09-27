import java.util.ArrayList;
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

        // do {
        //     // Adiciona registro na lista de registros
        //     livroDeRegistro.addRegistroToListaDeRegistro(formulario.inserirDadosDeRegistro());

        //     System.out.print("\nDeseja fornecer mais dados [y/n]? ");
        //     entrada = input.nextLine().toLowerCase().strip().charAt(0);

        // } while (entrada == 'y');

        // MOCKS
            
        Registro register = new Registro("Feira", 123, "24/09/2022", "Alimentação", TipoRegistro.SAIDA);
        Registro register1 = new Registro("Feira1212dksoaksoaosa", 123, "24/09/2022", "Alimentação", TipoRegistro.SAIDA);
        
        
        livroDeRegistro.addRegistroToListaDeRegistro(register);
        livroDeRegistro.addRegistroToListaDeRegistro(register1);
        
       
        //Início da Matriz! Para Visualização
       
        //Lista que recebe outra lista: matriz
        ArrayList<ArrayList<String>> livroDeRegistroView = new ArrayList<>();

        formulario.mostraTotalSaidas(livroDeRegistro);

        //adiciona cabeçalho da tabela/matriz
        livroDeRegistroView.add(formulario.cabecalhoFormatado());
        
        /**
            No caso, tenho que transformar os valores de Registro em string e 
          passar cada objeto registro como lista? 
          SIM. Para isso, há o método toTable() criado na classe Registro.
         */

        //Neste for, acesso os dados dos registros como Strings DENTRO de listas através do método toTable() 
        //e adiciono à matriz. 
        //Cada lista adicionada é uma linha na matriz
        for (Registro registros : livroDeRegistro.getListaDeRegistros()){
            livroDeRegistroView.add(registros.toTable()); // adiciona na matriz lista por lista
        }

        //Matriz subscrita ao retornar esta (livroDeRegistroView) com os dados formatados.
        livroDeRegistroView = formulario.ajustaLivroDeRegistroView(livroDeRegistroView); 

        formulario.exibirLivroDeRegistroView(livroDeRegistroView);

        input.close();
    }
}