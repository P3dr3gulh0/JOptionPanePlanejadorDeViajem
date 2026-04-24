/*
Descrição 

Desenvolva um programa em Java utilizando JOptionPane que simula o planejamento de uma viagem. O usuário informa seus dados, uma data de viagem e alguns valores numéricos. O sistema realiza conversões, valida os dados e apresenta um resumo da viagem. 

Objetivos 

Utilizar JOptionPane para entrada e saída 
Trabalhar com conversão de String para números (int, double) 
Utilizar datas (LocalDate) 
Validar dados digitados 
Realizar cálculos simples 
Regras do Programa 

Exibir um menu inicial: 
Planejar viagem 
Sair 
Solicitar os seguintes dados: 
Nome do viajante 
Data da viagem no formato dd/MM/yyyy 
Quantidade de dias de viagem (inteiro) 
Valor gasto por dia (decimal) 
Validar: 
Campos vazios 
Conversão de números (usar parseInt e parseDouble) 
Data válida (usar LocalDate) 
Valores negativos não são permitidos 
Processar: 
Calcular o valor total da viagem: 
total = dias * valorPorDia 
Verificar se a viagem é: 
Passada 
Hoje 
Futura 
Se for futura, calcular quantos dias faltam 
Exibir resultado: 
Nome 
Data da viagem 
Dias de viagem 
Valor total 
Situação da viagem (passada, hoje ou futura) 
Exemplo de funcionamento 

Entrada: 

Nome: Sebastiana 
Data: 20/12/2026 
Dias: 5 
Valor por dia: 150.50 
Saída: 

Sebastiana, sua viagem será em 20/12/2026 
Faltam 40 dias 
Total estimado: R$ 752.50 
 */
package joptionpaneplanejamentoviagem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import javax.swing.JOptionPane;

public class JOptionPanePlanejamentoViagem {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int sair = JOptionPane.showConfirmDialog(null, "Deseja planejar Viagem?", "Bem vindo!", JOptionPane.YES_NO_OPTION);
        verificacao(sair);
    }

    public static void verificacao(int valor) {
        if (valor == 0) {
            planejarViagem();
        }
        if (valor == 1) {
            JOptionPane.showMessageDialog(null, "Fechando o Systema!");
            System.exit(0);
        }
    }

    public static void planejarViagem() {
//        JOptionPane.showMessageDialog(null, "Vamor começar com seu cadastro!");
//
//        String name = JOptionPane.showInputDialog("Qual seu nome? ");
//        validacaoInput(name);

        String diaViagem = JOptionPane.showInputDialog("Quando planeja viajar(dia/mes/ano)?");
        validacaoInput(diaViagem);
        tratamentoInputData(diaViagem);

        String qntDiadViagem = JOptionPane.showInputDialog("Quantos dias de viagem?  ");
        validacaoInput(qntDiadViagem);

        String custoPorDia = JOptionPane.showInputDialog("valo total do custos por dias?");
        validacaoInput(custoPorDia);
    }

    //verificar entrada vazia
    public static String validacaoInput(String dado) {
        boolean validacao = true;

        while (validacao) {
            if (dado == null || dado.isBlank()) {
                dado = JOptionPane.showInputDialog(null, "Valor invalido! Tente Novamente", JOptionPane.YES_OPTION);
                System.out.println(dado);
                validacao = true;
            } else {
                validacao = false;
            }
        }
        return dado;
    }

    public static LocalDate tratamentoInputData(String dataStr) {
        // criando e modelo de data        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataAtual = new LocalDate.now();
        while (true) {
            try {
                return LocalDate.parse(dataStr, formato);
            } catch (DateTimeParseException e) {
                dataStr = JOptionPane.showInputDialog(null, "Valor invalido! Use o modelo dia/mes/ano", JOptionPane.YES_OPTION);

            }
        }

    }
}
