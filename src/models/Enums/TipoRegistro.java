package models.Enums;

public enum TipoRegistro {
    ENTRADA(1, "Entrada"),
    SAIDA(2, "Saída");

    private int tipo;
    private String nome;

    TipoRegistro(int tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;
    }

    public int getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    
}
