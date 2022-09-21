import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Registro;

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

        String entrada = "";
	
		do {
			Registro register = new Registro();

			System.out.println("Digite a Categoria:");
			register.setCategoria(input.nextLine());

			System.out.println("Digite a Descricao");
			register.setDescricao(input.nextLine());

			System.out.println("Digite o valor gasto:");
			register.setValor(Double.parseDouble(input.nextLine()));

            System.out.println("Digite a data de registro: [Caso não digite a data será hoje]");
            System.out.println("Digite o formarto: 00/00/0000");
            String data = input.nextLine();

            register.setDataDeCriacao(data);

			listaDeRegistros.add(register); 
		
			System.out.println("Deseja fornecer mais dados (Sim/Nao)?");
			entrada = input.nextLine();
			entrada = entrada.toLowerCase();
			
	
		 }while (entrada.equals("sim"));

         System.out.println(listaDeRegistros);
    }
}