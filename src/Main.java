import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import models.Registro;
import models.Tipo;
import models.Enums.TipoRegistro;
import view.Forms;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Registro> listaDeRegistros = new ArrayList<>();
        Tipo entradaOuSaida = new Tipo();
        char entrada;

        Forms formulario = new Forms();

        do {
            Registro register = new Registro();

            // Escolhe o tipo
            int tipo = formulario.inserirTipo();
            TipoRegistro tipoDeRegistro = entradaOuSaida.definirTipoRegistro(tipo);
            register.setTipo(tipoDeRegistro);

            // Escolhe a categoria
            register.setCategoria(formulario.inserirCategoria(tipoDeRegistro));

            // Escolhe a descrição/nome do registro
            register.setDescricao(formulario.inserirDescricao());

            // Escolhe o valor
            register.setValor(formulario.inserirValor());

            // Define a data
            register.setDataDeCriacao(formulario.inserirData());

            // Adiciona registro na lista de registros
            listaDeRegistros.add(register);

            System.out.print("\nDeseja fornecer mais dados [y/n]? ");
            entrada = input.nextLine().toLowerCase().strip().charAt(0);

        } while (entrada == 'y');

        // MOCKS
        /*    
        Registro register = new Registro("Feira", 123, "24/09/2022", "Alimentação", TipoRegistro.SAIDA);
        listaDeRegistros.add(register);    
         */
        
       
        //Início da Matriz!
        ArrayList<String> cabecalho = new ArrayList<>(Arrays.asList("Data", "Descrição", "Valor", "Categoria", "Tipo"));
       
        //Lista que recebe outra lista: matriz
        ArrayList<ArrayList<String>> livroDeRegistro = new ArrayList<>();
        livroDeRegistro.add(cabecalho);

        //no caso, tenho que transformar os valores de Registro em string e 
        //passar cada registro como lista? SIM. Para isso, há o método toTable() criado na classe Registro.


        //Neste for, acesso os dados dos registros como Strings DENTRO de listas. 
        for (Registro registros : listaDeRegistros){
            livroDeRegistro.add(registros.toTable()); // adiciona na matriz lista por lista
        }

        livroDeRegistro = formulario.ajustaLivroDeRegistro(livroDeRegistro);
        formulario.exibirLivroDeRegistro(livroDeRegistro);

        input.close();
    }
}