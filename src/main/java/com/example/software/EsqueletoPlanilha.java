package com.example.software;

import com.example.software.planilha.Planilha;
import com.example.software.planilha.PlanilhaMensal;
import com.example.software.planilha.PlanilhaSemanal;
import com.example.software.redmine.HorasRedmine;
import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

public class EsqueletoPlanilha {
	
	private static EsqueletoPlanilha esqueletoPlanilha;

	private static IntegracaoRedmine integracaoRedmine = new IntegracaoRedmine();
	private static ArrayList<Colaborador> arrayColaboradoresGoogle;
	private static ArrayList<Colaborador> arrayColabTangerino;
	private static ArrayList<Cliente> arrayCliente;
	private static ArrayList<Colaborador> arrayColabBaseTime;
	private static ArrayList<Colaborador> arrayColaboradores;
	private static ArrayList<Colaborador>arrayTeste = new ArrayList<Colaborador>();
	
	private WritableCellFormat cellFormat;
	private WritableCellFormat cellFormatTexto;
	private WritableCellFormat cellFormatCabecalho;

	private String inputArquivo;

	
	private EsqueletoPlanilha() {
		
	}
	
	public static synchronized EsqueletoPlanilha getInstance(long dataInicioMili, long dataFinalMili , String dataInicio, String dataFinal, String tipo) throws IOException, GeneralSecurityException, ParseException {
		if(esqueletoPlanilha == null) {
			esqueletoPlanilha = new EsqueletoPlanilha();
			arrayColaboradores = new ArrayList<Colaborador>();
			arrayColaboradoresGoogle = IntegracaoGoogle.setColaborador();
			arrayColabTangerino = IntegracaoTangerino.setColaboradorTangerino(dataInicioMili,dataFinalMili);
			arrayCliente = IntegracaoGoogle.setCliente();
			arrayColabBaseTime = IntegracaoGoogle.setHorasExtrasNoturnas();

			for(Colaborador colab : arrayColaboradoresGoogle){
				if(!(colab.getCliente().getNome().equals("Desalocacao") || colab.getCliente().getNome().equals("Sem alocacao") || colab.getPeriodoFaturado().equals("Periodo nao faturado"))){
					arrayColaboradores.add(colab);
				}
			}

			for(Colaborador colab : arrayColaboradores){
				for(Cliente cliente : arrayCliente){
					if(colab.getCliente().getNome().equals(cliente.getNome())){
						colab.getCliente().setAcordoHoraExtra(cliente.isAcordoHoraExtra());
						colab.getCliente().setAcordoBancoDeHoras(cliente.isAcordoBancoDeHoras());
						colab.getCliente().setAcordoHorasAdicionais(cliente.isAcordoHorasAdicionais());
						colab.getCliente().setAcordoHorasNoturnas(cliente.isAcordoHorasNoturnas());
						colab.getCliente().setAcordoHorasExtrasNoturnas(cliente.isAcordoHorasExtrasNoturnas());
						colab.getCliente().setDescontos(cliente.getDescontos());
						break;
					}
				}
			}
			
			for(Colaborador colab : arrayColaboradores) {
				for(Colaborador colab2 : arrayColabTangerino) {
					if(colab.getNome().equals(colab2.getNome())) {
						colab.setEmail(colab2.getEmail());
						colab.setHorasReaisTrabalhadas(colab2.getHorasReaisTrabalhadas());
						colab.setHorasPrevistas(colab2.getHorasPrevistas());
						colab.setHorasNoturnas(colab2.getHorasNoturnas());
						colab.setAbono(colab2.getAbono());
						colab.setCompensacaoDeHoras(colab2.getCompensacaoDeHoras());
						if(colab.getDataInicioMili()!=0 && colab.getDataFinalMili()==0) {
							colab.setHorasDedicadasABase2(IntegracaoRedmine.getHorasRhApropriacao(colab.getDataInicio(),dataFinal,colab.getEmail()));
						} else if (colab.getDataInicioMili() == 0 && colab.getDataFinalMili()!=0){
							colab.setHorasDedicadasABase2(IntegracaoRedmine.getHorasRhApropriacao(dataInicio,colab.getDataFinal(),colab.getEmail()));
						}else{
							colab.setHorasDedicadasABase2(IntegracaoRedmine.getHorasRhApropriacao(dataInicio,dataFinal,colab.getEmail()));
						}
						if(colab.getCliente().isAcordoHoraExtra() || colab.getCliente().isAcordoHorasAdicionais()){
							colab.calculaHoraExtra();
						}

						if(colab.getDataInicioMili()>dataFinalMili){
							colab.setHorasReaisTrabalhadas(0);
							colab.setHorasPrevistas(0);
							colab.setAbono(0);
							colab.setHoraExtra(0);
							colab.setHorasAdicionaisComAcrescimo(0);
						}
						break;
					}
				}
				if(colab.getEmail() == null){
					colab.setEmail(IntegracaoRedmine.setEmailRedmine(colab.getNome()));
					for(Colaborador colab2 : arrayColabTangerino) {
						if(colab.getEmail().equals(colab2.getEmail())) {
							colab.setHorasReaisTrabalhadas(colab2.getHorasReaisTrabalhadas());
							colab.setHorasPrevistas(colab2.getHorasPrevistas());
							colab.setHorasNoturnas(colab2.getHorasNoturnas());
							colab.setAbono(colab2.getAbono());
							colab.setCompensacaoDeHoras(colab2.getCompensacaoDeHoras());
							if(colab.getCliente().isAcordoHoraExtra() || colab.getCliente().isAcordoHorasAdicionais()){
								colab.calculaHoraExtra();
							}
							if(colab.getDataInicioMili()!=0 && colab.getDataFinalMili() == 0) {
								colab.setHorasDedicadasABase2(IntegracaoRedmine.getHorasRhApropriacao(colab.getDataInicio(),dataFinal,colab.getEmail()));
							} else if (colab.getDataInicioMili() == 0 && colab.getDataFinalMili()!=0){
								colab.setHorasDedicadasABase2(IntegracaoRedmine.getHorasRhApropriacao(dataInicio,colab.getDataFinal(),colab.getEmail()));
							}else{
								colab.setHorasDedicadasABase2(IntegracaoRedmine.getHorasRhApropriacao(dataInicio,dataFinal,colab.getEmail()));
							}
							if(colab.getCliente().isAcordoHoraExtra() || colab.getCliente().isAcordoHorasAdicionais()){
								colab.calculaHoraExtra();
							}

							if(colab.getDataInicioMili()>dataFinalMili){
								colab.setHorasReaisTrabalhadas(0);
								colab.setHorasPrevistas(0);
								colab.setAbono(0);
								colab.setHoraExtra(0);
								colab.setHorasAdicionaisComAcrescimo(0);
							}
							break;
						}
					}
				}
				System.out.println(colab.getNome());
			}

			System.out.println("ok 1");
			for(Colaborador c : arrayColaboradores){
				if(c.getDataInicioMili() >= dataInicioMili && c.getDataInicioMili() <= dataFinalMili && c.getDataInicioMili() != 0 ){
					HorasRedmine horasRedmine = IntegracaoRedmine.getHorasPorColaborador(c,c.getDataInicio(),dataFinal);
					c.setHorasReaisTrabalhadas(horasRedmine.getHorasTrabalhadas());
					c.setHorasPrevistas(horasRedmine.getHorasPrevistas());
					if(c.getCliente().isAcordoHoraExtra() || c.getCliente().isAcordoHorasAdicionais()){
						c.calculaHoraExtra();
					}
				}else if(c.getDataFinalMili() <= dataFinalMili && c.getDataFinalMili() >= dataInicioMili && c.getDataFinalMili() != 0){
					HorasRedmine horasRedmine = IntegracaoRedmine.getHorasPorColaborador(c,dataInicio,c.getDataFinal());
					c.setHorasReaisTrabalhadas(horasRedmine.getHorasTrabalhadas());
					c.setHorasPrevistas(horasRedmine.getHorasPrevistas());
					if(c.getCliente().isAcordoHoraExtra() || c.getCliente().isAcordoHorasAdicionais()){
						c.calculaHoraExtra();
					}
				}
				else if(c.getDataInicioMili() > dataFinalMili){
					c.setHorasPrevistas(0);
					c.setHorasReaisTrabalhadas(0);
					if(c.getCliente().isAcordoHoraExtra() || c.getCliente().isAcordoHorasAdicionais()){
						c.calculaHoraExtra();
					}
				}
				else if(c.getDataFinalMili() < dataInicioMili && c.getDataFinal() != null){
					c.setHorasReaisTrabalhadas(0);
					c.setHorasPrevistas(0);
					if(c.getCliente().isAcordoHoraExtra() || c.getCliente().isAcordoHorasAdicionais()){
						c.calculaHoraExtra();
					}
				}
			}

			System.out.println("ok 2");
			if (tipo.equals("mensal")) {
				
				for (Colaborador c : arrayColabBaseTime) {
					for (Colaborador c2 : arrayColaboradores) {
						if (c2.getNome().contains(c.getNome().split(" ")[0]) && c2.getNome().contains(c.getNome().split(" ")[1])) {
							if (c2.getCliente().isAcordoHorasExtrasNoturnas()) {
								if (c2.getHorasNoturnas() == c.getHorasExtrasNoturnas()) {
									c2.setHorasNoturnas(0);
									c2.setHorasExtrasNoturnas(c.getHorasExtrasNoturnas());
									break;
								} else if (c2.getHorasNoturnas() > c.getHorasExtrasNoturnas()) {
									c2.setHorasNoturnas(c2.getHorasNoturnas() - c.getHorasExtrasNoturnas());
									c2.setHorasExtrasNoturnas(c.getHorasExtrasNoturnas());
									break;
								}
							} else {
								if(!(c2.getCliente().getNome().equals("BS2-Bonsucesso"))){
									if (c2.getHorasNoturnas() == c.getHorasExtrasNoturnas()) {
										c2.setHorasNoturnas(0);
										c2.setHorasExtrasNoturnas(c.getHorasExtrasNoturnas());
										break;
									} else if (c2.getHorasNoturnas() > c.getHorasExtrasNoturnas()) {
										c2.setHorasNoturnas(c2.getHorasNoturnas() - c.getHorasExtrasNoturnas());
										c2.setHorasExtrasNoturnas(c.getHorasExtrasNoturnas());
										break;
									}
								}
								break;
							}
							if(!(c2.getCliente().isAcordoHorasNoturnas())){
								c2.setHorasNoturnas(0);
							}

							if(c2.getDataInicioMili()>dataFinalMili){
								c2.setHorasNoturnas(0);
								c2.setHorasExtrasNoturnas(0);
							}
						}
					}
				}

				ArrayList<Colaborador> arrayAux = new ArrayList<Colaborador>();
				boolean flag = false;
				for (Colaborador colab : arrayColaboradores) {
					if (arrayTeste.size() == 0) {
						arrayTeste.add(colab);
					} else {
						for (Colaborador cTeste : arrayTeste) {
							if (colab.getNome().equals(cTeste.getNome()) && !(colab.getCliente().getNome().equals(cTeste.getCliente().getNome()))) {
								if(arrayAux.size() == 0) {
									arrayAux.add(cTeste);
								}else{
									for(Colaborador c : arrayAux){
										if(!(c.getNome().equals(cTeste.getNome()))){
											arrayAux.add(cTeste);
											break;
										}
									}
								}
								if(colab.getDataInicioMili() != 0 && colab.getDataFinalMili() == 0) {
									HorasRedmine horasRedmine = IntegracaoRedmine.horasPorProjetoRedmine(colab, colab.getDataInicio(), dataFinal);
									colab.setHorasReaisTrabalhadas(horasRedmine.getHorasTrabalhadas());
									colab.setHorasPrevistas(horasRedmine.getHorasPrevistas());
									float aux = colab.getHorasReaisTrabalhadas() + colab.getHorasDedicadasABase2();
									colab.setHorasReaisTrabalhadas(aux);
									if (colab.getCliente().isAcordoHoraExtra() || colab.getCliente().isAcordoHorasAdicionais()) {
										colab.calculaHoraExtra();
									}
								}else if(colab.getDataInicioMili() == 0 && colab.getDataFinalMili() != 0){
									HorasRedmine horasRedmine = IntegracaoRedmine.horasPorProjetoRedmine(colab, dataInicio,colab.getDataFinal());
									colab.setHorasReaisTrabalhadas(horasRedmine.getHorasTrabalhadas());
									colab.setHorasPrevistas(horasRedmine.getHorasPrevistas());
									float aux = colab.getHorasReaisTrabalhadas() + colab.getHorasDedicadasABase2();
									colab.setHorasReaisTrabalhadas(aux);
									if (colab.getCliente().isAcordoHoraExtra() || colab.getCliente().isAcordoHorasAdicionais()) {
										colab.calculaHoraExtra();
									}
								}
								else{
									HorasRedmine horasRedmine = IntegracaoRedmine.horasPorProjetoRedmine(colab, dataInicio, dataFinal);
									colab.setHorasReaisTrabalhadas(horasRedmine.getHorasTrabalhadas());
									colab.setHorasPrevistas(horasRedmine.getHorasPrevistas());
									float aux = colab.getHorasReaisTrabalhadas() + colab.getHorasDedicadasABase2();
									colab.setHorasReaisTrabalhadas(aux);
									if (colab.getCliente().isAcordoHoraExtra() || colab.getCliente().isAcordoHorasAdicionais()) {
										colab.calculaHoraExtra();
									}
								}
								flag = true;
								break;
							}
						}
						if (flag) {
							flag = false;
							continue;
						}
						arrayTeste.add(colab);
					}
				}

				for(Colaborador c : arrayAux){
					for(Colaborador colab: arrayColaboradores){
						if(c.getNome().equals(colab.getNome()) && c.getCliente().getNome().equals(colab.getCliente().getNome())){
							if(colab.getDataInicioMili() != 0 && colab.getDataFinalMili() == 0) {
								HorasRedmine horasRedmine = IntegracaoRedmine.horasPorProjetoRedmine(colab, colab.getDataInicio(), dataFinal);
								colab.setHorasReaisTrabalhadas(horasRedmine.getHorasTrabalhadas());
								colab.setHorasPrevistas(horasRedmine.getHorasPrevistas());
								float aux = colab.getHorasReaisTrabalhadas() + colab.getHorasDedicadasABase2();
								colab.setHorasReaisTrabalhadas(aux);
								if (colab.getCliente().isAcordoHoraExtra() || colab.getCliente().isAcordoHorasAdicionais()) {
									colab.calculaHoraExtra();
								}
							}else if(colab.getDataInicioMili() == 0 && colab.getDataFinalMili() != 0){
								HorasRedmine horasRedmine = IntegracaoRedmine.horasPorProjetoRedmine(colab, dataInicio,colab.getDataFinal());
								colab.setHorasReaisTrabalhadas(horasRedmine.getHorasTrabalhadas());
								colab.setHorasPrevistas(horasRedmine.getHorasPrevistas());
								float aux = colab.getHorasReaisTrabalhadas() + colab.getHorasDedicadasABase2();
								colab.setHorasReaisTrabalhadas(aux);
								if (colab.getCliente().isAcordoHoraExtra() || colab.getCliente().isAcordoHorasAdicionais()) {
									colab.calculaHoraExtra();
								}
							}
							else {
								HorasRedmine horasRedmine = IntegracaoRedmine.horasPorProjetoRedmine(colab, dataInicio, dataFinal);
								colab.setHorasReaisTrabalhadas(horasRedmine.getHorasTrabalhadas());
								colab.setHorasPrevistas(horasRedmine.getHorasPrevistas());
								float aux = colab.getHorasReaisTrabalhadas() + colab.getHorasDedicadasABase2();
								colab.setHorasReaisTrabalhadas(aux);
								if (colab.getCliente().isAcordoHoraExtra() || colab.getCliente().isAcordoHorasAdicionais()) {
									colab.calculaHoraExtra();
								}
							}
						}
					}
				}

			}
		}
		return esqueletoPlanilha;
	}
	
	public void setOutputFile(String inputArquivo) {
		this.inputArquivo = inputArquivo;
	}
	 
	public void criaPlanilha(String tipo,String diaInicio, String diaFinal,long dataInicioMili, long dataFinalMili) throws IOException, WriteException, GeneralSecurityException {
	// Cria um novo arquivo
		File arquivo = new File(inputArquivo);
		WorkbookSettings wbSettings = new WorkbookSettings();
		 
		wbSettings.setLocale(new Locale("pt", "BR"));
		 
		WritableWorkbook workbook = Workbook.createWorkbook(arquivo, wbSettings);
		// Define um nome para a planilha
		workbook.createSheet("Mes "+ diaInicio +" a "+ diaFinal, 0);
		WritableSheet excelSheet = workbook.getSheet(0);
		formataLabel(excelSheet);
		criaCabecalho(excelSheet,tipo, diaInicio, diaFinal);
		
		if(tipo.equals("semanal")) {
			Planilha planilhaSemanal = new PlanilhaSemanal();
			planilhaSemanal.addDados(excelSheet, arrayColaboradores,cellFormatTexto);
		}else if(tipo.equals("mensal")) {
			Planilha planilhaMensal = new PlanilhaMensal();
			planilhaMensal.addDados(excelSheet, arrayColaboradores,cellFormatTexto);
		}
	
		workbook.write();
		workbook.close();
	}
	
	private void formataLabel(WritableSheet sheet) throws WriteException {
		
		WritableFont arial10pt = new WritableFont(WritableFont.ARIAL, 10);
		cellFormat = new WritableCellFormat(arial10pt);
		cellFormat.setAlignment(Alignment.RIGHT);
		
		cellFormatTexto = new WritableCellFormat(arial10pt);
		cellFormatTexto.setAlignment(Alignment.LEFT);
		
		WritableFont arial10ptBoldCentralize = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
		cellFormatCabecalho = new WritableCellFormat(arial10ptBoldCentralize);
		cellFormatCabecalho.setAlignment(Alignment.CENTRE);
		
		CellView cv = new CellView();
		cv.setFormat(cellFormat);
		cv.setFormat(cellFormatTexto);
	}
	
	private void criaCabecalho(WritableSheet planilha, String tipo, String diaInicio, String diaFinal) throws RowsExceededException, WriteException {
		if(tipo.equals("semanal")) {
			addCaption(planilha,0,0,"Colaborador");
			addCaption(planilha,1,0,"Perfil Profissional");
			addCaption(planilha,2,0,"VH");
			addCaption(planilha,3,0,"Periodo de alocacao");
			addCaption(planilha,4,0,diaInicio+" a "+ diaFinal);
			addCaption(planilha,5,0,"Horas Noturnas");
			addCaption(planilha,6,0,"Observacoes");
		}else if(tipo.equals("mensal")) {
			addCaption(planilha,0,0,"Colaborador");
			addCaption(planilha,1,0,"Cliente");
			addCaption(planilha,2,0,"Acordo de Hora Extra ou Banco de Horas");
			addCaption(planilha,3,0,"Perfil Profissional");
			addCaption(planilha,4,0,"VH");
			addCaption(planilha,5,0,"Período de Alocacao");
			addCaption(planilha,6,0,"Horas Uteis do mes");
			addCaption(planilha,7,0,"Horas Reais Trabalhadas");
			addCaption(planilha,8,0,"Horas a Faturar");
			addCaption(planilha,9,0,"Horas a Totais a Faturar");
			addCaption(planilha,10,0,"Atestado/Abono");
			addCaption(planilha,11,0,"Compensacao de Horas");
			addCaption(planilha,12,0,"Horas dedicadas a Base2");
			addCaption(planilha,13,0,"Horas Adicionais com acrescimo de 30%");
			addCaption(planilha,14,0,"Horas Noturnas");
			addCaption(planilha,15,0,"Horas Extras Noturnas");
			addCaption(planilha,16,0,"Horas Extras");
			addCaption(planilha,17,0,"Acerto de Banco de Horas");
			addCaption(planilha,18,0,"Localiza -> Licenca Azure");
			addCaption(planilha,19,0,"Valor a Faturar");
			addCaption(planilha,20,0,"Valor a Faturar com Descontos");
			addCaption(planilha,21,0,"Saldo de Horas do Mes");
			addCaption(planilha,22,0,"Saldo de Horas acumulado");
			addCaption(planilha,23,0,"Saldo de Horas acumulado Total sem acrescimo");
			addCaption(planilha,24,0,"Observacoes");
		}
	}

	private void addCaption(WritableSheet planilha, int coluna, int linha, String s) throws RowsExceededException, WriteException {
		Label label;
		label = new Label(coluna, linha, s, cellFormatCabecalho);
		planilha.addCell(label);
	}

}