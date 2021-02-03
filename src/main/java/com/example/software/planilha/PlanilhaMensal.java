package com.example.software.planilha;

import com.example.software.Colaborador;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

public class PlanilhaMensal implements Planilha{

    public PlanilhaMensal() {
    }

    public void addLabel(WritableSheet planilha, int coluna, int linha, String s, WritableCellFormat cellFormatTexto) throws WriteException, RowsExceededException {
        Label label;
        label = new Label(coluna, linha, s, cellFormatTexto);
        planilha.addCell(label);
    }

    public void addDados(WritableSheet planilha, ArrayList<Colaborador> colaboradores, WritableCellFormat cellFormatTexto) throws IOException, GeneralSecurityException, RowsExceededException, WriteException  {
        int i = 0;
        int j = 1;
        for(Colaborador colab : colaboradores) {
            addLabel(planilha,i,j,colab.getNome(),cellFormatTexto);
            j++;
        }

        i = 1;
        j = 1;
        for(Colaborador colab : colaboradores) {
            addLabel(planilha,i,j,colab.getCliente().getNome(),cellFormatTexto);
            j++;
        }

        i = 2;
        j = 1;
        for(Colaborador colab : colaboradores) {
            if(colab.getCliente().isAcordoHoraExtra()) {
                addLabel(planilha, i, j, "Hora Extra", cellFormatTexto);
            }
            if(colab.getCliente().isAcordoBancoDeHoras()){
                addLabel(planilha, i, j, "Banco de Horas", cellFormatTexto);
            }
            if(colab.getCliente().isAcordoHorasAdicionais()){
                addLabel(planilha,i,j,"Horas Adicionais com acrescimo de 30%",cellFormatTexto);
            }
            j++;
        }

        i = 3;
        j = 1;
        for(Colaborador colab : colaboradores) {
            addLabel(planilha,i,j,colab.getPerfilProfissional(),cellFormatTexto);
            j++;
        }

        i = 4;
        j = 1;
        for(Colaborador colab : colaboradores) {
            addLabel(planilha,i,j,colab.getValorHora(),cellFormatTexto);
            j++;
        }

        i=5;
        j=1;
        for(Colaborador colab : colaboradores){
            addLabel(planilha,i,j,colab.getPeriodoFaturado(),cellFormatTexto);
            j++;
        }


        i = 6;
        j = 1;
        for(Colaborador colab : colaboradores) {
            addLabel(planilha,i,j,String.valueOf(colab.getHorasPrevistas()).replaceAll("\\.",","),cellFormatTexto);
            j++;
        }

        i = 7;
        j = 1;
        for(Colaborador colab : colaboradores) {
            if(colab.getCliente().getNome().equals("BS2-Bonsucesso")){
                if(colab.getHorasNoturnas() != 0){
                    float aux;
                    aux = colab.getHorasReaisTrabalhadas() - colab.getHorasNoturnas();
                    addLabel(planilha,i,j,String.valueOf(aux).replaceAll("\\.",","),cellFormatTexto);
                }
                else{
                    addLabel(planilha,i,j,String.valueOf(colab.getHorasReaisTrabalhadas()).replaceAll("\\.",","),cellFormatTexto);
                }
            }else {
                addLabel(planilha,i,j,String.valueOf((colab.getHorasReaisTrabalhadas())).replaceAll("\\.",","),cellFormatTexto);
            }

            j++;
        }

        i = 8;
        j = 1;
        for(Colaborador colab : colaboradores) {
            if(colab.getCliente().isAcordoBancoDeHoras()){
                addLabel(planilha,i,j,String.valueOf(colab.horasAfaturarBH()).replaceAll("\\.",","),cellFormatTexto);
            }else if(colab.getCliente().isAcordoHoraExtra()){
                addLabel(planilha,i,j,String.valueOf(colab.horasAfaturarHE()).replaceAll("\\.",","),cellFormatTexto);
            }else if (colab.getCliente().isAcordoHorasAdicionais()) {
                addLabel(planilha,i,j,String.valueOf(colab.horasAfaturarHA()).replaceAll("\\.",","),cellFormatTexto);
            }else{
                addLabel(planilha,i,j,String.valueOf(colab.horasAfaturar()).replaceAll("\\.",","),cellFormatTexto);
            }
            j++;
        }

        i = 9;
        j = 1;
        for(Colaborador colab : colaboradores) {
            addLabel(planilha,i,j,String.valueOf(colab.horasTotaisF(colab)).replaceAll("\\.",","),cellFormatTexto);
            j++;
        }

        i = 10;
        j = 1;
        for(Colaborador colab : colaboradores) {
            if(colab.getAbono() != 0) {
                addLabel(planilha, i, j, String.valueOf(colab.getAbono()).replaceAll("\\.", ","), cellFormatTexto);
            }
            j++;
        }

        i = 11;
        j = 1;
        for(Colaborador colab : colaboradores) {
            if(colab.getCompensacaoDeHoras() != 0) {
                addLabel(planilha, i, j, String.valueOf(colab.getCompensacaoDeHoras()).replaceAll("\\.", ","), cellFormatTexto);
            }
            j++;
        }

        i = 12;
        j = 1;
        for(Colaborador colab : colaboradores) {
            if(colab.getHorasDedicadasABase2() != 0) {
                addLabel(planilha, i, j, String.valueOf(colab.getHorasDedicadasABase2()).replaceAll("\\.", ","), cellFormatTexto);
            }
            j++;
        }

        i = 13;
        j = 1;
        for(Colaborador colab : colaboradores) {
            if(colab.getCliente().isAcordoHorasAdicionais()) {
                addLabel(planilha, i, j, String.valueOf(colab.getHorasAdicionaisComAcrescimo()).replaceAll("\\.", ","), cellFormatTexto);
            }
            j++;
        }

        i = 14;
        j = 1;
        for(Colaborador colab : colaboradores) {
            addLabel(planilha,i,j,String.valueOf(colab.getHorasNoturnas()).replaceAll("\\.",","),cellFormatTexto);
            j++;
        }

        i = 15;
        j = 1;
        for(Colaborador colab : colaboradores) {
            addLabel(planilha,i,j,String.valueOf(colab.getHorasExtrasNoturnas()).replaceAll("\\.",","),cellFormatTexto);
            j++;
        }

        i = 16;
        j = 1;
        for(Colaborador colab : colaboradores) {
            if(colab.getCliente().isAcordoHoraExtra()) {
                addLabel(planilha, i, j, String.valueOf(colab.getHoraExtra()).replaceAll("\\.", ","), cellFormatTexto);
            }
            j++;
        }
        /*
        i = 17;
        j = 1;
        for(Colaborador colab : colaboradores) {
            addLabel(planilha, i, j, String.valueOf(colab.getAcertoBH()).replaceAll("\\.", ","), cellFormatTexto);
            j++;
        }*/

        i = 18;
        j = 1;
        for(Colaborador colab : colaboradores) {
            if(colab.getCliente().getLicencaAzure() != 0) {
                addLabel(planilha, i, j, String.valueOf(colab.getCliente().getLicencaAzure()).replaceAll("\\.", ","), cellFormatTexto);
            }
            j++;
        }

        i = 19;
        j = 1;
        for(Colaborador colab : colaboradores) {
            if(colab.getCliente().isAcordoBancoDeHoras()) {
                addLabel(planilha, i, j, String.valueOf(colab.valorAFaturarBH()).replaceAll("\\.", ","), cellFormatTexto);
            }else if(colab.getCliente().isAcordoHoraExtra()){
                addLabel(planilha, i, j, String.valueOf(colab.valorAFaturarHE()).replaceAll("\\.", ","), cellFormatTexto);
            }else if(colab.getCliente().isAcordoHorasAdicionais()){
                addLabel(planilha, i, j, String.valueOf(colab.valorAFaturarHA()).replaceAll("\\.", ","), cellFormatTexto);
            }else{
                addLabel(planilha,i,j,String.valueOf(colab.valorAFaturar()).replaceAll("\\.", ","),cellFormatTexto);
            }
            j++;
        }

        i = 20;
        j = 1;
        for(Colaborador colab : colaboradores) {
            if(colab.getCliente().getDescontos() != 0) {
                if (colab.getCliente().isAcordoBancoDeHoras()) {
                    addLabel(planilha, i, j, String.valueOf(colab.valorAFaturarComDesconto(colab.valorAFaturarBH(), colab.getCliente().getDescontos())).replaceAll("\\.", ","), cellFormatTexto);
                } else if (colab.getCliente().isAcordoHoraExtra()) {
                    addLabel(planilha, i, j, String.valueOf(colab.valorAFaturarComDesconto(colab.valorAFaturarHE(), colab.getCliente().getDescontos())).replaceAll("\\.", ","), cellFormatTexto);
                } else if (colab.getCliente().isAcordoHorasAdicionais()) {
                    addLabel(planilha, i, j, String.valueOf(colab.valorAFaturarComDesconto(colab.valorAFaturarHA(), colab.getCliente().getDescontos())).replaceAll("\\.", ","), cellFormatTexto);
                }
            }
            j++;
        }

        i = 21;
        j = 1;
        for(Colaborador colab : colaboradores) {
            if(colab.getCliente().isAcordoBancoDeHoras()){
                addLabel(planilha, i, j, String.valueOf(colab.getSaldoDeHorasDoMes()).replaceAll("\\.", ","), cellFormatTexto);
            }
            j++;
        }
        /*
        i = 22;
        j = 1;
        for(Colaborador colab : colaboradores) {
            addLabel(planilha,i,j,String.valueOf(colab.getSaldoDeHorasAcumulado()).replaceAll("\\.",","),cellFormatTexto);
            j++;
        }

        i = 23;
        j = 1;
        for(Colaborador colab : colaboradores) {
            addLabel(planilha,i,j,String.valueOf(colab.getSaldoDeHorasAcumuladoComAcrescimo()).replaceAll("\\.",","),cellFormatTexto);
            j++;
        }*/
    }
}
