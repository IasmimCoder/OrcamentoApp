package models;

import java.util.Scanner;

import models.Enums.TipoRegistro;

//import models.Enums.TipoRegistro;

public class Tipo {
    
    static Scanner input = new Scanner(System.in);
    
    public  TipoRegistro definirTipoRegistro(int value) {
       
        TipoRegistro tipo = TipoRegistro.SAIDA;
        
        if (value == 1){
            tipo = TipoRegistro.ENTRADA; 
        } else if (value == 2){
           tipo = TipoRegistro.SAIDA;
        }

        while(value > 2 || value < 1){
            System.out.print("Digite novamente seu tipo de registro: ");
            value = input.nextInt();
        }

        return tipo;
    }
}
