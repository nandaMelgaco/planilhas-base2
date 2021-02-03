package com.example.software.planilha;

import com.example.software.Colaborador;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

public interface Planilha {

    void addLabel(WritableSheet planilha, int coluna, int linha, String s, WritableCellFormat cellFormatTexto) throws WriteException, RowsExceededException;
    void addDados(WritableSheet planilha, ArrayList<Colaborador> colaboradores, WritableCellFormat cellFormatTexto) throws IOException, GeneralSecurityException, RowsExceededException, WriteException ;
}
