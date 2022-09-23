package view;

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
}
