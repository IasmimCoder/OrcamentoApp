import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import models.Registro;
import models.Enums.TipoRegistro;
import services.TipoRegistroService;
import view.Forms;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Registro> listaDeRegistros = new ArrayList<>();
        Forms formulario = new Forms();
        char entrada;

        // do {
        //     // Adiciona registro na lista de registros
        //     listaDeRegistros.add(formulario.inserirDadosDeRegistro());

        //     System.out.print("\nDeseja fornecer mais dados [y/n]? ");
        //     entrada = input.nextLine().toLowerCase().strip().charAt(0);

        // } while (entrada == 'y');

        // MOCKS
            
        Registro register = new Registro("Feira", 123, "24/09/2022", "Alimentação", TipoRegistro.SAIDA);
        Registro register1 = new Registro("Feira1212dksoaksoaosa", 123, "24/09/2022", "Alimentação", TipoRegistro.SAIDA);
        
        listaDeRegistros.add(register);   
        listaDeRegistros.add(register1);   
        

        
       
        //Início da Matriz!
       
        //Lista que recebe outra lista: matriz
        ArrayList<ArrayList<String>> livroDeRegistro = new ArrayList<>();
        // livroDeRegistro.add(cabecalho);

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