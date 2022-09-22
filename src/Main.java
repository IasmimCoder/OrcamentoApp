import java.util.ArrayList;
import java.util.Scanner;

import models.Categorias;
import models.Registro;
import models.Tipo;
import models.Enums.TipoRegistro;
import view.Forms;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        
        ArrayList<Registro> listaDeRegistros = new ArrayList<>();
        Tipo entradaOuSaida = new Tipo();
        Categorias categorias = new Categorias();
        char entrada;
        
        Forms formulario = new Forms();

		do {

			Registro register = new Registro();

            //Escolhe o tipo
            int tipo = formulario.inserirTipo();
            TipoRegistro tipoDeRegistro = entradaOuSaida.definirTipoRegistro(tipo);
            register.setTipo(tipoDeRegistro);

            //Escolhe a categoria
            int indexCategoria = formulario.inserirCategoria(tipoDeRegistro);
            register.setCategoria(categorias.escolheCategoria(indexCategoria));
			// System.out.println("\nEscolha a Categoria: \n");
            // categorias.mostrarCategorias(tipoDeRegistro);
            
            // System.out.print("Sua resposta é: ");
            // int indexCategoria = input.nextInt();

		 
            input.nextLine();
			System.out.print("\nDigite a Descrição: ");
			register.setDescricao(input.nextLine());

			System.out.print("Digite o valor: ");
			register.setValor(Double.parseDouble(input.nextLine()));

            
            System.out.println("\nDigite a data de registro [00/00/0000]: ");
            System.out.println("(Caso não digite a data será hoje)");
            String data = input.nextLine();

            register.setDataDeCriacao(data);

			listaDeRegistros.add(register); 
		
			System.out.print("\nDeseja fornecer mais dados [y/n]? ");
            
			entrada = input.nextLine().toLowerCase().strip().charAt(0);
			
		 }while (entrada == 'y');

         System.out.println(listaDeRegistros);
         input.close();
    }
}