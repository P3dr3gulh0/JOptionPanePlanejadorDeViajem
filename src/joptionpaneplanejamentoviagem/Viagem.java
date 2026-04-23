/*
Nome do viajante 
Data da viagem no formato dd/MM/yyyy 
Quantidade de dias de viagem (inteiro) 
Valor gasto por dia (decimal) 
*/


package joptionpaneplanejamentoviagem;

import java.util.Date;


public class Viagem {
    private String nomeViajante;
    private Date dataViagem;
    private int diasDeViagem;
    private double valorDia;

    public Viagem(String nomeViajante, Date dataViagem, int diasDeViagem, double valorDia) {
        this.nomeViajante = nomeViajante;
        this.dataViagem = dataViagem;
        this.diasDeViagem = diasDeViagem;
        this.valorDia = valorDia;
    }

    
    
    public String getNomeViajante() {
        return nomeViajante;
    }

    public void setNomeViajante(String nomeViajante) {
        this.nomeViajante = nomeViajante;
    }

    public Date getDataViagem() {
        return dataViagem;
    }

    public void setDataViagem(Date dataViagem) {
        this.dataViagem = dataViagem;
    }

    public int getDiasDeViagem() {
        return diasDeViagem;
    }

    public void setDiasDeViagem(int diasDeViagem) {
        this.diasDeViagem = diasDeViagem;
    }

    public double getValorDia() {
        return valorDia;
    }

    public void setValorDia(double valorDia) {
        this.valorDia = valorDia;
    }
    
}
