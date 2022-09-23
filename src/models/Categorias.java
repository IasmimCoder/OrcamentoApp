package models;

import java.util.ArrayList;
import java.util.List;

import models.Enums.TipoRegistro;

public class Categorias {

    private List<String> listaCategorias= new ArrayList<>();

    private List<String> listaSaida = new ArrayList<>(){{
        add("Alimentação");
        add("Casa");
        add("Saúde");
        add("Lazer");
        add("Transporte");
        add("Outro");
    }};

    private List<String> listaEntradas = new ArrayList<>(){{
        add("Salário");
        add("Outro");
    }};

    public void mostrarCategorias(TipoRegistro tipo){
        if(tipo == TipoRegistro.ENTRADA) {
            listaCategorias = listaEntradas;
        }else if (tipo == TipoRegistro.SAIDA){
            listaCategorias = listaSaida;
        }
        for (int i = 0; i < listaCategorias.size(); i++){
            System.out.format("[%d] - %s\n", i+1, listaCategorias.get(i));
        }
    }

    public String escolheCategoria(int value) {
        String valor = listaCategorias.get(value-1); // retorna a String da lista categoria escolhida
        return valor;
    }
}
