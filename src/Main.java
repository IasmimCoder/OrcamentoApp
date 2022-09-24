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

        System.out.println(listaDeRegistros);

        int qtdRegistros = listaDeRegistros.size();

        //Início da Matriz!
        ArrayList<String> cabecalho = new ArrayList<>(Arrays.asList("Data", "Descrição", "Valor", "Categoria", "Tipo"));
        ArrayList<ArrayList<String>> livroDeRegistro = new ArrayList<>();
        livroDeRegistro.add(cabecalho);

        for (ArrayList<String> arrayList : livroDeRegistro) {
            for (String dados : arrayList) {
                System.out.print(dados + "\t");
            }
            System.out.println();
        }
        
                                                //$
        // Data             Descrição           Valor            Categoria          Tipo
        // 01/12/2022       Feira do mÊs        R$ 405,48        Alimentação        SAÍDA
        input.close();
    }
}