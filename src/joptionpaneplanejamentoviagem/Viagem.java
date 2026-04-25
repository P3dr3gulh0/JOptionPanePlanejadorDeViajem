/*
Nome do viajante 
Data da viagem no formato dd/MM/yyyy 
Quantidade de dias de viagem (inteiro) 
Valor gasto por dia (decimal) 
 */
package joptionpaneplanejamentoviagem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;

public class Viagem {

    private String nomeViajante;
    private LocalDate dataViagem;
    private int diasDeViagem;
    private double valorDia;

    public Viagem(String nomeViajante, LocalDate dataViagem, int diasDeViagem, double valorDia) {
        this.nomeViajante = nomeViajante;
        this.dataViagem = dataViagem;
        this.diasDeViagem = diasDeViagem;
        this.valorDia = valorDia;
    }

    public void exibir() {
        JOptionPane.showMessageDialog(null, getNomeViajante() + ", Sua viagem será em " + getDataViagem() 
                +"\n Faltam"+ contagemDias(dataViagem) + " Dias"
                + "\n Valot total estimado: "+ valorViagem(valorDia, diasDeViagem) );

    }

    //recebendo data marcada e guardando data atual para contagem de dias para a viagem
    public static long contagemDias(LocalDate diaMarcado) {
        LocalDate dataAtual = LocalDate.now();
        long contDias = ChronoUnit.DAYS.between(dataAtual, diaMarcado);
        return contDias;
    }

    // calculando valor total da viagem
    public static double valorViagem(double valorDia, int qntDiasViagem) {
        return qntDiasViagem * valorDia;
    }

    public String getNomeViajante() {
        return nomeViajante;
    }

    public void setNomeViajante(String nomeViajante) {
        this.nomeViajante = nomeViajante;
    }

    public LocalDate getDataViagem() {
        return dataViagem;
    }

    public void setDataViagem(LocalDate dataViagem) {
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
