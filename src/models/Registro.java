package models;

import java.time.LocalDate;

import models.Enums.TipoRegistro;
import utils.UtilDates;

public class Registro {
    private String descricao;
    private double valor;
    private LocalDate dataDeCriacao;
    private String categoria;
    private TipoRegistro tipo;
    
    public Registro() {
    }
    
    public Registro(String descricao, double valor, String dataDeCriacao, String categoria, TipoRegistro tipo) {
        this.descricao = descricao;
        this.valor = valor;
        this.dataDeCriacao = new UtilDates().StringToLocalDate(dataDeCriacao);
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
    public String getDataDeCriacao() {
        return new UtilDates().localDateToString(this.dataDeCriacao);
    }
    public void setDataDeCriacao(String dataDeCriacao) {
        this.dataDeCriacao = new UtilDates().StringToLocalDate(dataDeCriacao);
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
        return "Registro [categoria=" + categoria + ", dataDeCriacao=" + new UtilDates().localDateToString(dataDeCriacao) + ", descricao=" + descricao
                + ", tipo=" + tipo + ", valor=" + valor + "]";
    }

    
    

}
