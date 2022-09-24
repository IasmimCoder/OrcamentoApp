import java.util.ArrayList;
import java.util.Arrays;

import models.Enums.TipoRegistro;

public class Teste {
    public static void main(String[] args) {
        String testeString = "Descrição";
        String testeString1 = "Valor";

        ArrayList<String> register = new ArrayList<>(Arrays.asList("Feira 12312312wkdwksdkq", "R$ 123,00 92183921809321", "24/09/2022", "Alimentação", "Saída"));
        ArrayList<String> cabecalho = new ArrayList<>(Arrays.asList("Data", "Descrição", "Valor", "Categoria", "Tipo"));

        ArrayList<ArrayList<String>> livroDeRegistro = new ArrayList<>();

        livroDeRegistro.add(cabecalho);
        livroDeRegistro.add(register);

        // {
        //     {},
        //     {}
        // }

        /*
         * int i: é equivalente a linha, ou seja, a lista
         * int j: é equivalente a coluna, ou seja, o dado dentro da lista
         * Pega da Matriz o dado e formata este.
         */
        for (int i = 0; i < livroDeRegistro.size(); i++) {
            for (int j = 0; j < livroDeRegistro.get(i).size(); j++) {
                String dado = livroDeRegistro.get(i).get(j);
                livroDeRegistro.get(i).set(j, formatedString(dado));
            }
        }

        testeString = formatedString(testeString);
        testeString1 = formatedString(testeString1);

        for (ArrayList<String> arrayList : livroDeRegistro) {
            for (String dado : arrayList) {
                System.out.print(dado);
            }
            System.out.println();
        }

        // System.out.println( testeString + testeString1);

    }

    public static String formatedString(String text) {
        String textFormatted = String.format("%-15s", text);
        return textFormatted.substring(0, 15) + " ";
    }
}
