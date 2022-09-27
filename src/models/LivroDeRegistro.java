package models;

import java.util.ArrayList;
import java.util.Arrays;

import models.Enums.TipoRegistro;

public class LivroDeRegistro {
    //SAIDAS
    private double totalAlimetacao;
    private double totalCasa;
    private double totalSaude;
    private double totalLazer;
    private double totalTransporte;
    private double totalOutroSaida;

    private ArrayList<Double> totaisSaidas = new ArrayList<>();
    private ArrayList<Double> totaisEntradas = new ArrayList<>();

    private ArrayList<ArrayList<String>> totalSaidaFormatado = new ArrayList<>();

    //listaCategorias = 8
    // Alimentação
    // Transporte
    //...

    // ListaPronta = 8
    // Alimentação: R$ 845,55
    // Casa: R$ 899,20

    //ENTRADAS
    private double totalSalario;
    
    private double totalOutroEntrada;


    private ArrayList<Registro> listaDeRegistros = new ArrayList<>();
    
    public void calculaTotal(Categorias categorias) {

        this.initLists(categorias);

        int indexRegister = 0;
        for (Registro registro : listaDeRegistros){

            if (registro.getTipo() == TipoRegistro.SAIDA) {
                if (registro.getCategoria() == categorias.getListaSaida().get(0)) {
                    totaisSaidas.set(0, totaisSaidas.get(0) + registro.getValor());
                };

                if (registro.getCategoria() == categorias.getListaSaida().get(1)) {
                    totaisSaidas.set(1, totaisSaidas.get(1) + registro.getValor());
                };

                if (registro.getCategoria() == categorias.getListaSaida().get(2)) {
                    totaisSaidas.set(2, totaisSaidas.get(2) + registro.getValor());
                };

                if (registro.getCategoria() == categorias.getListaSaida().get(3)) {
                    totaisSaidas.set(3, totaisSaidas.get(3) + registro.getValor());
                };

                if (registro.getCategoria() == categorias.getListaSaida().get(4)) {
                    totaisSaidas.set(4, totaisSaidas.get(4) + registro.getValor());
                };

                if (registro.getCategoria() == categorias.getListaSaida().get(5)) {
                    totaisSaidas.set(5, totaisSaidas.get(5) + registro.getValor());
                };
            }

            if (registro.getTipo() == TipoRegistro.ENTRADA){
                if (registro.getCategoria() == categorias.getListaSaida().get(0)) {
                    totaisSaidas.set(0, totaisSaidas.get(0) + registro.getValor());
                };

                if (registro.getCategoria() == categorias.getListaSaida().get(1)) {
                    totaisSaidas.set(1, totaisSaidas.get(1) + registro.getValor());
                };
            }
            indexRegister++;
        }
        System.out.println(totaisSaidas);
        this.formataLista(categorias);
        totalSaidaFormatado.forEach(el -> System.out.println(el));
    }
    
    public ArrayList<Registro> getListaDeRegistros() {
        return listaDeRegistros;
    }

    public void addRegistroToListaDeRegistro(Registro registro) {
        this.listaDeRegistros.add(registro);
    }

    public double getTotalAlimetacao() {
        return totalAlimetacao;
    }

    public double getTotalCasa() {
        return totalCasa;
    }

    public double getTotalSaude() {
        return totalSaude;
    }

    public double getTotalLazer() {
        return totalLazer;
    }

    public double getTotalTransporte() {
        return totalTransporte;
    }

    public double getTotalOutroSaida() {
        return totalOutroSaida;
    }

    public double getTotalSalario() {
        return totalSalario;
    }

    public double getTotalOutroEntrada() {
        return totalOutroEntrada;
    }
    
    private void initLists(Categorias categorias) {
        for (int i = 0; i < categorias.getListaSaida().size(); i++) {
            this.totaisSaidas.add(0.0);
        };

        for (int i = 0; i < categorias.getListaEntradas().size(); i++) {
            this.totaisEntradas.add(0.0);
        };
    }

    private void formataLista(Categorias categorias) {
        
        for (int i = 0; i < categorias.getListaSaida().size(); i++) {
            this.totalSaidaFormatado.add(new ArrayList<>(
                Arrays.asList(categorias.getListaSaida().get(i), String.format("R$ %.2f", totaisSaidas.get(i)))
            ));
        }
    }
}
