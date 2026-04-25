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
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class JOptionPanePlanejamentoViagem {

    public static void main(String[] args) {
        ArrayList<Viagem> viagens = new ArrayList();
        while(true){
        menu(viagens);
        }
    }
    
    
    public static void menu(ArrayList<Viagem> viagens) {
        
        String[] opcoes = {"Planejar viagem", "Verificar Viagem", "sair"};

        int escolha = JOptionPane.showOptionDialog(
                null,
                "Escolha: ",
                "Bem Vindo",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcoes,
                opcoes[0]);
        verificacao(escolha, viagens);

    }

    public static void verificacao(int valor, ArrayList<Viagem> viagens) {


        switch (valor) {
            case 0:
                Viagem v = planejarViagem();
                viagens.add(v);
                break;
            case 1:
                mostrarViagens(viagens);
                break;

            default:
                JOptionPane.showMessageDialog(null, "Fechando o Systema!");
                System.exit(0);

        }
    }

    public static Viagem planejarViagem() {

        //Receber Valores
        JOptionPane.showMessageDialog(null, "Vamor começar com seu cadastro!");

        String name = JOptionPane.showInputDialog("Qual seu nome? ");
        validacaoInputNull(name);

        String diaViagem = JOptionPane.showInputDialog("Quando planeja viajar(dia/mes/ano)?");
        diaViagem = validacaoInputNull(diaViagem);

        String qntDiasViagem = JOptionPane.showInputDialog("Quantos dias de viagem?  ");
        qntDiasViagem = validacaoInputNull(qntDiasViagem);

        String custoPorDia = JOptionPane.showInputDialog("valo total do custos por dias?");
        custoPorDia = validacaoInputNull(custoPorDia);

        //Conversão de valores
        LocalDate diaViagemTratado = tratamentoInputData(diaViagem);

        int qntDiasViagemTratado = Integer.parseInt(qntDiasViagem);
        double curtoPorDiaTratado = Double.parseDouble(custoPorDia);

        return new Viagem(name, diaViagemTratado, qntDiasViagemTratado, curtoPorDiaTratado);

    }

    //verifica entrada vazia
    public static String validacaoInputNull(String dado) {
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

    // recebendo valor em string e transformando em data valida
    public static LocalDate tratamentoInputData(String dataStr) {
        // criando e modelo de data        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //se entrada estiver fora do modelo, ele pede novamente até entrar
        while (true) {
            try {
                return LocalDate.parse(dataStr, formato);
            } catch (DateTimeParseException e) {
                dataStr = JOptionPane.showInputDialog(null, "Valor invalido! Use o modelo dia/mes/ano", JOptionPane.YES_OPTION);
            }
        }
    }
    

    public static void mostrarViagens(ArrayList<Viagem> viagem) {
        if (viagem.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lista vazia.", "Vazio", JOptionPane.WARNING_MESSAGE);
        } else {
            for (Viagem v : viagem) {
                v.exibir();
            }
        }
    }
}
