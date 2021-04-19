package com.example.financy;

public class Financiamento {

    private float valor_carro;
    private float valor_entrada;
    private float taxa_juros_anual;
    private int qtd_parcelas;


    public Financiamento(float valor_carro, float valor_entrada,  float taxa_juros_anual, int qtd_parcelas) {
        setValor_carro(valor_carro);
        setValor_entrada(valor_entrada);
        setTaxa_juros_anual(taxa_juros_anual);
        setQtd_parcelas(qtd_parcelas);
    }

    public float getValor_carro() {
        return valor_carro;
    }

    public void setValor_carro(float valor_carro) {
        this.valor_carro = valor_carro;
    }

    public float getValor_entrada() {
        return valor_entrada;
    }

    public void setValor_entrada(float valor_entrada) {
        this.valor_entrada = valor_entrada;
    }


    public float getTaxa_juros_anual() {
        return taxa_juros_anual;
    }

    public void setTaxa_juros_anual(float taxa_juros_anual) {
        this.taxa_juros_anual = taxa_juros_anual;
    }

    public int getQtd_parcelas() {
        return qtd_parcelas;
    }

    public void setQtd_parcelas(int qtd_parcelas) {
        this.qtd_parcelas = qtd_parcelas;
    }


    public float calculaFinanciamento(){
        float coeficiente_financiamento;
        float taxa_juros_mensal;
        float vlr_prestacao;

        taxa_juros_mensal = (float) (Math.pow((1 + (getTaxa_juros_anual() / 100)), (1.0 / 12.0)) - 1);
        coeficiente_financiamento = (float) (taxa_juros_mensal / (1 - Math.pow(1 + taxa_juros_mensal, -getQtd_parcelas())));
        vlr_prestacao = (float) (getValor_liquido() * coeficiente_financiamento);

        return vlr_prestacao;
    }


    public float getValor_liquido(){
        return getValor_carro() - getValor_entrada();
    }



}
