package models;

import java.util.Scanner;

import models.Enums.TipoRegistro;

//import models.Enums.TipoRegistro;

public class Tipo {

    static Scanner input = new Scanner(System.in);

    public TipoRegistro definirTipoRegistro(int value) {

        while (value > 2 || value < 1) {
            System.out.print("Digite novamente seu tipo de registro: ");
            value = input.nextInt();
        }

        if (value == 1) {
            return TipoRegistro.ENTRADA;
        }
        return TipoRegistro.SAIDA;

    }
}
