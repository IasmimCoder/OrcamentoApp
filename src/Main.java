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
            register.setCategoria(formulario.inserirCategoria(tipoDeRegistro));

            //Escolhe a descrição/nome do registro
            register.setDescricao(formulario.inserirDescricao());


            //Escolhe o valor
			register.setValor(formulario.inserirValor());

            //Define a data
            register.setDataDeCriacao(formulario.inserirData());


            //Adiciona registro na lista de registros
			listaDeRegistros.add(register); 
		

			System.out.print("\nDeseja fornecer mais dados [y/n]? ");
			entrada = input.nextLine().toLowerCase().strip().charAt(0);
			
		 }while (entrada == 'y');

         System.out.println(listaDeRegistros);
         input.close();
    }
}