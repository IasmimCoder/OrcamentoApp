package models;

import java.time.LocalDateTime;

import models.Enums.TipoRegistro;
import utils.UtilDates;

public class Registro {
    private String descricao;
    private double valor;
    private LocalDateTime dataDeCriacao;
    private String categoria;
    private TipoRegistro tipo;
    
    public Registro() {
    }
    
    public Registro(String descricao, double valor, String dataDeCriacao, String categoria, TipoRegistro tipo) {
        this.descricao = descricao;
        this.valor = valor;
        this.dataDeCriacao = UtilDates.StringToLocalDateTime(dataDeCriacao, "dd/MM/yyyy HH:mm:ss");
        this.categoria = categoria;
        this.tipo = tipo;
    }


    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }
    public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public TipoRegistro getTipo() {
        return tipo;
    }
    public void setTipo(TipoRegistro tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Registro [categoria=" + categoria + ", dataDeCriacao=" + UtilDates.localDateTimeToString(dataDeCriacao, "dd/MM/yyyy HH:mm:ss") + ", descricao=" + descricao
                + ", tipo=" + tipo + ", valor=" + valor + "]";
    }

    
    

}
