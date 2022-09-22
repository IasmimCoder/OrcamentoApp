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

        return input.nextInt();
    }

    public int inserirCategoria(TipoRegistro tipoDeRegistro){
        System.out.println("\nEscolha a Categoria: \n");
        categorias.mostrarCategorias(tipoDeRegistro);
        System.out.print("Sua resposta é: ");
    
        return input.nextInt();
    }
}
