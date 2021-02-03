package com.example.software.planilha;

import com.example.software.Colaborador;
import jxl.format.Colour;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

public class PlanilhaSemanal implements Planilha{

    public PlanilhaSemanal() {
    }

    public void addLabel(WritableSheet planilha, int coluna, int linha, String s, WritableCellFormat cellFormatTexto) throws WriteException, RowsExceededException {
        Label label;
        label = new Label(coluna, linha, s, cellFormatTexto);
        planilha.addCell(label);
    }

    public void addDados(WritableSheet planilha, ArrayList<Colaborador> colaboradores, WritableCellFormat cellFormatTexto) throws IOException, GeneralSecurityException, RowsExceededException, WriteException  {
        int i = 0;
        int j = 1;
        for(Colaborador c : colaboradores) {
            if(c.getCliente().getNome().contains("BS2")){
                addLabel(planilha,i,j,c.getNome(),cellFormatTexto);
                j++;
            }
        }

        i = 1;
        j = 1;
        for(Colaborador colab : colaboradores) {
            if(colab.getCliente().getNome().contains("BS2")){
                addLabel(planilha,i,j,colab.getPerfilProfissional(),cellFormatTexto);
                j++;
            }
        }

        i = 2;
        j = 1;
        for(Colaborador colab : colaboradores) {
            if(colab.getCliente().getNome().contains("BS2")){
                addLabel(planilha,i,j,colab.getValorHora(),cellFormatTexto);
                j++;
            }
        }

        i=3;
        j=1;
        for(Colaborador colab : colaboradores) {
            if(colab.getCliente().getNome().contains("BS2")){
                addLabel(planilha,i,j,colab.getPeriodoFaturado(),cellFormatTexto);
                j++;
            }
        }

        i = 4;
        j = 1;
        for(Colaborador colab : colaboradores) {
            if(colab.getCliente().getNome().contains("BS2")){
                addLabel(planilha,i,j,String.valueOf(colab.getHorasReaisTrabalhadas()).replaceAll("\\.",","),cellFormatTexto);
                j++;
            }
        }

        i = 5;
        j = 1;
        for(Colaborador colab : colaboradores) {
            if(colab.getCliente().getNome().contains("BS2")){
                addLabel(planilha,i,j,String.valueOf(colab.getHorasNoturnas()).replaceAll("\\.",","),cellFormatTexto);
                j++;
            }
        }
    }

}
