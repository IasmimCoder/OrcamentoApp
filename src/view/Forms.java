package view;

import java.util.ArrayList;
import java.util.Scanner;

import models.Categorias;
import models.Enums.TipoRegistro;

public class Forms {

    Scanner input = new Scanner(System.in);
    Categorias categorias = new Categorias();

    public int inserirTipo() {
        System.out.println("Informe o tipo: \n");
        System.out.println("[1] ENTRADA\n[2] SAÍDA");
        System.out.print("Sua resposta:");
        int tipoIndex = Integer.parseInt(input.nextLine());
        return tipoIndex;
    }

    public String inserirCategoria(TipoRegistro tipoDeRegistro){
        System.out.println("\nEscolha a Categoria: \n");
        categorias.mostrarCategorias(tipoDeRegistro);
        System.out.print("Sua resposta é: ");
        int indexCategoria = Integer.parseInt(input.nextLine());
        
        return categorias.escolheCategoria(indexCategoria);
    }

    public String inserirDescricao(){
        System.out.print("\nDigite a Descrição: ");
        String descricao = input.nextLine(); 
        return descricao;
    }

    public double inserirValor(){
        System.out.print("Digite o valor: ");
        double valor = Double.parseDouble(input.nextLine());
        return valor;
    }

    public String inserirData(){
        System.out.println("\nDigite a data de registro [00/00/0000]: ");
        System.out.println("(Caso não digite a data será hoje)");
        String data = input.nextLine();
        return data;
    }

    public void exibirLivroDeRegistro(ArrayList<ArrayList<String>> livroDeRegistro){
        for (ArrayList<String> arrayList : livroDeRegistro) {
            for (String dado : arrayList) {
                System.out.print(dado);
            }
            System.out.println();
        }
    }

    /**
     * 
     * O método pega da Matriz o dado e formata este. 
     * int i: é equivalente a linha, ou seja, a lista
     * int j: é equivalente a coluna, ou seja, o dado dentro da lista        
     * @param livroDeRegistro
     * @return retorna a matriz (livroDeRegistro) com os dados formatados
     */
    public ArrayList<ArrayList<String>> ajustaLivroDeRegistro(ArrayList<ArrayList<String>> livroDeRegistro) {
        for (int i = 0; i < livroDeRegistro.size(); i++) {
            for (int j = 0; j < livroDeRegistro.get(i).size(); j++) {
                String dado = livroDeRegistro.get(i).get(j);
                livroDeRegistro.get(i).set(j, formatedString(dado));
            }
        }
        return livroDeRegistro;
    }

    /**
     * Limita uma String a um determinado número de caracteres,
     * o que permite a organização da matriz.
     * @param text
     * @return retorna uma String modificada
     */
    private String formatedString(String text) {
        String textFormatted = String.format("%-15s", text);
        return textFormatted.substring(0, 15) + " ";
    }
}
