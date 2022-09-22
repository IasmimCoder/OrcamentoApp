import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Categorias;
import models.Registro;
import models.Enums.TipoRegistro;
import view.Forms;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /**
        Registro x = new Registro(
            "Almoço", 20,
            "25/09/2022 22:38:12",
            "Alimentação", TipoRegistro.SAIDA);
        */
        
        ArrayList<Registro> listaDeRegistros = new ArrayList<>();
        Categorias categorias = new Categorias();
        char entrada;
        
        Forms formulario = new Forms();

		do {

			Registro register = new Registro();

            
            int tipo = formulario.inserirTipo();

            if (tipo == 1){
                register.setTipo(TipoRegistro.ENTRADA);
            } else if (tipo == 2){
                register.setTipo(TipoRegistro.SAIDA);
            } else {
                while(tipo > 2 || tipo < 1){
                    System.out.print("Digite novamente seu tipo de registro: ");
                    tipo = input.nextInt();
                }
            }
               
			System.out.println("\nEscolha a Categoria: \n");
            categorias.mostrarCategorias(tipo);
            
            System.out.println("Sua resposta é: ");
            int indexCategoria = input.nextInt();

			register.setCategoria(categorias.escolheCategoria(indexCategoria));

            input.nextLine();
			System.out.println("\nDigite a Descrição: ");
			register.setDescricao(input.nextLine());

			System.out.println("Digite o valor:");
			register.setValor(Double.parseDouble(input.nextLine()));

            System.out.println("Digite a data de registro: [Caso não digite a data será hoje]");
            System.out.println("Digite o formarto: 00/00/0000");
            String data = input.nextLine();

            register.setDataDeCriacao(data);

			listaDeRegistros.add(register); 
		
			System.out.println("Deseja fornecer mais dados [y/n]?");
            
			entrada = input.nextLine().toLowerCase().strip().charAt(0);
			
		 }while (entrada == 'y');

         System.out.println(listaDeRegistros);
    }
}