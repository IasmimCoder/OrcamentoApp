package models;

import java.util.ArrayList;
import java.util.List;

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

    public void mostrarCategorias(int tipo){
        if(tipo == 1) {
            listaCategorias = listaEntradas;
        }else if (tipo == 2){
            listaCategorias = listaSaida;
        }
        for (int i = 0; i < listaCategorias.size(); i++){
            System.out.format("[%d] - %s\n", i+1, listaCategorias.get(i));
        }
    }

    public String escolheCategoria(int value) {
        return listaCategorias.get(value-1);
    }
}
