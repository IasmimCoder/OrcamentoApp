import java.time.LocalDateTime;
import java.time.Month;

import models.Registro;
import models.Enums.TipoRegistro;

public class Main {
    public static void main(String[] args) {
        Registro x = new Registro(
            "Almoço", 20,
            "25/09/2022 22:38:12",
            "Alimentação", TipoRegistro.SAIDA);

        System.out.println(x);
    }
}