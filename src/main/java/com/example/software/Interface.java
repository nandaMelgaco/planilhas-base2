package com.example.software;

import com.toedter.calendar.JDateChooser;
import jxl.write.WriteException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Interface extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	EsqueletoPlanilha exemplo;
	
	private JFrame frmGeraPlanilha;
	private JTable table;
	private JRadioButton semanal;
	private JRadioButton mensal;
	private JDateChooser dateInicio;
	private JDateChooser dateFinal;
	private JButton btn;
	
	private String nomeArquivo;
	private String  tipo;
	private String dataInicio;
	private String dataFinal;
	private String dataInicioArquivo;
	private String dataFinalArquivo;
	private String string;
	private long dataInicioMili;
	private long dataFinalMili;
	private String mes;
	
	private Calendar calendar;
	private Date date;
	private Date aux;
	private SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat formato3 = new SimpleDateFormat("dd-MM-yyyy");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frmGeraPlanilha.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface() {
		initialize();
	}
	
	private void initialize() {
		frmGeraPlanilha = new JFrame();
		frmGeraPlanilha.setTitle("Planilhas Base2");
		frmGeraPlanilha.setBackground(Color.DARK_GRAY);
		frmGeraPlanilha.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmGeraPlanilha.setBounds(100, 100, 296, 225);
		frmGeraPlanilha.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGeraPlanilha.getContentPane().setLayout(null);
		
		btn = new JButton("Download");
		btn.setBackground(Color.WHITE);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
										
					if(semanal.isSelected()) {
						tipo = "semanal";
						
						date = dateInicio.getDate();
						dataInicio = formato.format(date);
						dataInicioArquivo = formato3.format(date);
						
						date = dateFinal.getDate();
						dataFinal = formato.format(date);
						dataFinalArquivo = formato3.format(date);

						date = dateInicio.getDate();
						string = formato2.format(date);
						aux = formato2.parse(string);
						dataInicioMili = aux.getTime();

						date = dateFinal.getDate();
						string = formato2.format(date);
						aux = formato2.parse(string);
						dataFinalMili = aux.getTime();
						
						nomeArquivo = "PlanilhaSemanal "+ dataInicioArquivo + " a " + dataFinalArquivo;
					}
					if(mensal.isSelected()) {
						tipo = "mensal";
						
						date = dateInicio.getDate();
						dataInicio = formato.format(date);
						dataInicioArquivo = formato3.format(date);
						
						date = dateFinal.getDate();
						dataFinal = formato.format(date);
						dataFinalArquivo = formato3.format(date);

						date = dateInicio.getDate();
						string = formato2.format(date);
						aux = formato2.parse(string);
						dataInicioMili = aux.getTime();

						date = dateFinal.getDate();
						string = formato2.format(date);
						aux = formato2.parse(string);
						dataFinalMili = aux.getTime();

						nomeArquivo = "PlanilhaMensal "+ dataInicioArquivo + " a " + dataFinalArquivo;
					}
					
					exemplo = EsqueletoPlanilha.getInstance(dataInicioMili,dataFinalMili,dataInicio,dataFinal,tipo);
					exemplo.setOutputFile(System.getProperty("user.home")+ "\\Downloads\\"+nomeArquivo + ".xls");
					try {
						exemplo.criaPlanilha(tipo,dataInicio,dataFinal,dataInicioMili,dataFinalMili);
					}catch (WriteException we) {
						// TODO Auto-generated catch block
						we.printStackTrace();
					}catch (IOException ie) {
						// TODO Auto-generated catch block
						ie.printStackTrace();
					} catch (GeneralSecurityException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}catch (IOException ie) {
					// TODO Auto-generated catch block
					ie.printStackTrace();
				} catch (GeneralSecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException parseException) {
					parseException.printStackTrace();
				}
			}
		});
		btn.setBounds(80, 152, 132, 23);
		frmGeraPlanilha.getContentPane().add(btn);
		
		semanal = new JRadioButton("Semanal");
		semanal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(semanal.isSelected()) {
					mensal.setSelected(false);
				}
			}
		});
		semanal.setBackground(Color.LIGHT_GRAY);
		semanal.setBounds(156, 40, 77, 23);
		frmGeraPlanilha.getContentPane().add(semanal);
		
		mensal = new JRadioButton("Mensal");
		mensal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mensal.isSelected()) {
					semanal.setSelected(false);
				}
			}
		});
		mensal.setBackground(Color.LIGHT_GRAY);
		mensal.setBounds(156, 14, 66, 23);
		frmGeraPlanilha.getContentPane().add(mensal);
		
		table = new JTable();
		table.setBounds(258, 111, 20, -14);
		frmGeraPlanilha.getContentPane().add(table);
		
		dateInicio = new JDateChooser();
		dateInicio.setBounds(20, 111, 108, 20);
		frmGeraPlanilha.getContentPane().add(dateInicio);
		
		dateFinal = new JDateChooser();
		dateFinal.setBounds(151, 111, 108, 20);
		frmGeraPlanilha.getContentPane().add(dateFinal);
		
		JTextPane txtpnDataInicio = new JTextPane();
		txtpnDataInicio.setBackground(Color.LIGHT_GRAY);
		txtpnDataInicio.setEditable(false);
		txtpnDataInicio.setText("Data Inicio:");
		txtpnDataInicio.setBounds(20, 85, 77, 20);
		frmGeraPlanilha.getContentPane().add(txtpnDataInicio);
		
		JTextPane txtpnDataFinal = new JTextPane();
		txtpnDataFinal.setBackground(Color.LIGHT_GRAY);
		txtpnDataFinal.setEditable(false);
		txtpnDataFinal.setText("Data Final:");
		txtpnDataFinal.setBounds(151, 85, 108, 20);
		frmGeraPlanilha.getContentPane().add(txtpnDataFinal);
		
		JTextPane txtpnTipoDePlanilha = new JTextPane();
		txtpnTipoDePlanilha.setBackground(Color.LIGHT_GRAY);
		txtpnTipoDePlanilha.setEditable(false);
		txtpnTipoDePlanilha.setText("Tipo de Planilha:");
		txtpnTipoDePlanilha.setBounds(20, 14, 130, 20);
		frmGeraPlanilha.getContentPane().add(txtpnTipoDePlanilha);
	}
}
