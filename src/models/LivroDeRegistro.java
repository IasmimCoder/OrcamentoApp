package models;

import java.util.ArrayList;
import java.util.Arrays;

import models.Enums.TipoRegistro;

public class LivroDeRegistro {

    private ArrayList<Double> totaisSaidas = new ArrayList<>();
    private ArrayList<Double> totaisEntradas = new ArrayList<>();

    // matrizes de valores por categoria e tipo
    private ArrayList<ArrayList<String>> totalSaidaFormatado = new ArrayList<>();
    private ArrayList<ArrayList<String>> totalEntradaFormatado = new ArrayList<>();

    private double somaTotalDeCategoriasSaida;
    private double somaTotalDeCategoriasEntrada;

    // listaCategorias = 8
    // Alimentação
    // Transporte
    // ...

    // ListaPronta = 8
    // Alimentação: R$ 845,55
    // Casa: R$ 899,20

    private ArrayList<Registro> listaDeRegistros = new ArrayList<>();

    public void calculaTotal(Categorias categorias) {

        /*
         * //inicializa as listas totaisEntradas/TotaisSaidas
         * //é necessário porque só podemos adicionar valores em determinadas posições
         * //somente quando elas já são existentes.
         */

        this.initLists(categorias);

        for (Registro registro : listaDeRegistros) {

            // verifica o tipo,
            // depois verifica categoria por categoria de acordo com seus índices
            // para depois somar, na listaSaidas/listaEntradas os valores de registros por
            // categoria
            // automatizar a verificação com indexRegister

            if (registro.getTipo() == TipoRegistro.SAIDA) {
                for (int i = 0; i < totaisSaidas.size(); i++) {
                    if (registro.getCategoria() == categorias.getListaSaida().get(i)) {
                        totaisSaidas.set(i, totaisSaidas.get(i) + registro.getValor());
                    }
                }
            }

            if (registro.getTipo() == TipoRegistro.ENTRADA) {
                for (int i = 0; i < totaisEntradas.size(); i++) {

                    if (registro.getCategoria() == categorias.getListaEntradas().get(i)) {
                        totaisEntradas.set(i, totaisEntradas.get(i) + registro.getValor());
                    }
                }
            }
        }

        // adicionar total
        this.calculaTotalSaidaEntrada();
        this.formataLista(categorias);
    }

    public ArrayList<Registro> getListaDeRegistros() {
        return listaDeRegistros;
    }

    public void addRegistroToListaDeRegistro(Registro registro) {
        this.listaDeRegistros.add(registro);
    }

    public ArrayList<ArrayList<String>> getTotalSaidaFormatado() {
        return totalSaidaFormatado;
    }

    public ArrayList<ArrayList<String>> getTotalEntradaFormatado() {
        return totalEntradaFormatado;
    }

    public double getSomaTotalDeCategoriasSaida() {
        return somaTotalDeCategoriasSaida;
    }

    public double getSomaTotalDeCategoriasEntrada() {
        return somaTotalDeCategoriasEntrada;
    }

    // inicializa os índeces das listas "totaisEntradas" e "totaisSaidas",
    private void initLists(Categorias categorias) {
        for (int i = 0; i < categorias.getListaSaida().size(); i++) {
            this.totaisSaidas.add(0.0);
        }

        for (int i = 0; i < categorias.getListaEntradas().size(); i++) {
            this.totaisEntradas.add(0.0);
        }
    }

    private void calculaTotalSaidaEntrada() {
        for (double value : totaisSaidas) {
            somaTotalDeCategoriasSaida += value;
        }

        for (double value : totaisEntradas) {
            somaTotalDeCategoriasEntrada += value;
        }
    }

    /**
     * adiciona, linha por linha, os valores de cada categoria dentro das matrizes,
     * juntamente com o nome da categoria.
     */
    private void formataLista(Categorias categorias) {

        for (int i = 0; i < categorias.getListaSaida().size(); i++) {
            this.totalSaidaFormatado.add(new ArrayList<>(
                    Arrays.asList(categorias.getListaSaida().get(i), String.format("R$ %.2f", totaisSaidas.get(i)))));
        }

        for (int i = 0; i < categorias.getListaEntradas().size(); i++) {
            this.totalEntradaFormatado.add(new ArrayList<>(
                    Arrays.asList(categorias.getListaEntradas().get(i),
                            String.format("R$ %.2f", totaisEntradas.get(i)))));
        }

        // Adiciona os totais de categoria ao final de cada matriz
        this.totalSaidaFormatado.add(new ArrayList<>(
                Arrays.asList("TOTAL", String.format("R$ %.2f", somaTotalDeCategoriasSaida))));

        this.totalEntradaFormatado.add(new ArrayList<>(
                Arrays.asList("TOTAL", String.format("R$ %.2f", somaTotalDeCategoriasEntrada))));
    }
}
