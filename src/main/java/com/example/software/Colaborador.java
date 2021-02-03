package com.example.software;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Colaborador {
	
	private long id;
	private String nome;
	private String email;
	private Cliente cliente =  new Cliente();
	private String perfilProfissional;
	private String valorHora;
	private float valorHora2;
	private String dataInicio;
	private String dataFinal;
	private String tipoData;
	private long dataInicioMili;
	private long dataFinalMili;
	
	private float horasReaisTrabalhadas;
	private float horasPrevistas;
	private float horasNoturnas;
	private float horasExtrasNoturnas;
	private float horaExtra;
	private float horasAdicionaisComAcrescimo;
	private float abono;
	private float ferias;
	private float compensacaoDeHoras;
	private float saldoDeHorasDoMes = 0;
	private double horasAFaturar;
	private double horasTotaisFaturadas;
	private float horasDedicadasABase2;
	private float valorAFaturar;
	private float valorAFaturarComDescontos;
	private String periodoFaturado;
	//private float saldoDeHorasAcumulado;
	private boolean pjs;
	
	public Colaborador() {
		super();
	}
	
	public Colaborador(int id, float horasReaisTrabalhadas) {
		super();
		this.id = id;
		this.horasReaisTrabalhadas = horasReaisTrabalhadas;
	}
	
	public Colaborador(String cliente, String nome, String perfilProfissional, String valorHora, String licenca, String periodoFaturado, boolean pjs) {
		super();
		this.nome = nome;
		this.cliente.setNome(cliente);
		this.perfilProfissional = perfilProfissional;
		this.valorHora = valorHora;
		this.valorHora2 = Float.parseFloat(valorHora.replaceAll("\\,", "."));
		this.periodoFaturado = periodoFaturado;
		this.cliente.setLicancaAzure(Float.parseFloat(licenca.replaceAll("\\,", "."))*168);
		this.pjs = pjs;

		//setDatas(periodoFaturado);
	}
	
	public Colaborador(int id,String nome, double horasReaisTrabalhadas) {
		super();
		this.id = id;
		this.nome = nome;
		this.horasReaisTrabalhadas = Float.parseFloat(String.valueOf(horasReaisTrabalhadas));
	}

	public Colaborador(long id,String nome, double horasReaisTrabalhadas) {
		super();
		this.id = id;
		this.nome = nome;
		this.horasReaisTrabalhadas = Float.parseFloat(String.valueOf(horasReaisTrabalhadas));
	}
	
	public Colaborador(long id, float horasReaisTrabalhadas, float horasPrevistas, float horasNoturnas, float abono, float compensacaoDeHoras) {
		super();
		this.id = id;
		this.horasReaisTrabalhadas = horasReaisTrabalhadas;
		this.horasNoturnas = horasNoturnas;
		this.horasPrevistas = horasPrevistas;
		this.abono = abono;
		this.compensacaoDeHoras = compensacaoDeHoras;
	}

	public Colaborador(String nome, float horasExtrasNoturnas){
		super();
		this.nome = nome;
		this.horasExtrasNoturnas = horasExtrasNoturnas;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Cliente getCliente() { return cliente; }
	public void setCliente(Cliente cliente) { this.cliente = cliente; }
	public String getPerfilProfissional() { return perfilProfissional; }
	public void setPerfilProfissional(String perfilProfissional) { this.perfilProfissional = perfilProfissional; }
	public String getValorHora() { return valorHora; }
	public void setValorHora(String valorHora) { this.valorHora = valorHora; }
	public float getHorasReaisTrabalhadas() { return horasReaisTrabalhadas; }
	public void setHorasReaisTrabalhadas(float horasReaisTrabalhadas) { this.horasReaisTrabalhadas = horasReaisTrabalhadas; }
	public float getHorasNoturnas() { return horasNoturnas; }
	public void setHorasNoturnas(float horasNoturnas) { this.horasNoturnas = horasNoturnas; }
	public float getAbono() { return abono; }
	public void setAbono(float abono) { this.abono = abono; }
	public float getFerias() { return ferias; }
	public void setFerias(float ferias) { this.ferias = ferias; }
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	public float getHorasPrevistas() { return horasPrevistas; }
	public void setHorasPrevistas(float horasPrevistas) { this.horasPrevistas = horasPrevistas; }
	public float getHoraExtra() { return horaExtra; }
	public void setHoraExtra(float horaExtra) { this.horaExtra = horaExtra; }
	public float getCompensacaoDeHoras() { return compensacaoDeHoras; }
	public void setCompensacaoDeHoras(float compensacaoDeHoras) { this.compensacaoDeHoras = compensacaoDeHoras; }
	public float getSaldoDeHorasDoMes() { return saldoDeHorasDoMes; }
	public void setSaldoDeHorasDoMes(float saldoDeHorasDoMes) { this.saldoDeHorasDoMes = saldoDeHorasDoMes; }
	public float getHorasExtrasNoturnas() { return horasExtrasNoturnas; }
	public void setHorasExtrasNoturnas(float horasExtrasNoturnas) { this.horasExtrasNoturnas = horasExtrasNoturnas; }
	public float getHorasDedicadasABase2() { return horasDedicadasABase2; }
	public void setHorasDedicadasABase2(float horasDedicadasABase2) { this.horasDedicadasABase2 = horasDedicadasABase2; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public double getHorasAFaturar() { return horasAFaturar; }
	public void setHorasAFaturar(double horasAFaturar) { this.horasAFaturar = horasAFaturar; }
	public double getHorasTotaisFaturadas() { return horasTotaisFaturadas; }
	public void setHorasTotaisFaturadas(double horasTotaisFaturadas) { this.horasTotaisFaturadas = horasTotaisFaturadas; }
	public float getValorAFaturar() { return valorAFaturar; }
	public void setValorAFaturar(float valorAFaturar) { this.valorAFaturar = valorAFaturar; }
	public float getValorAFaturarComDescontos() { return valorAFaturarComDescontos; }
	public void setValorAFaturarComDescontos(float valorAFaturarComDescontos) { this.valorAFaturarComDescontos = valorAFaturarComDescontos; }
	public float getHorasAdicionaisComAcrescimo() { return horasAdicionaisComAcrescimo; }
	public void setHorasAdicionaisComAcrescimo(float horasAdicionaisComAcrescimo) { this.horasAdicionaisComAcrescimo = horasAdicionaisComAcrescimo; }
	public String getPeriodoFaturado() { return periodoFaturado; }
	public void setPeriodoFaturado(String periodoFaturado) { this.periodoFaturado = periodoFaturado; }
	public float getValorHora2() { return valorHora2; }
	public void setValorHora2(float valorHora2) { this.valorHora2 = valorHora2; }
	public String getDataInicio() { return dataInicio; }
	public void setDataInicio(String dataInicio) { this.dataInicio = dataInicio; }
	public String getDataFinal() { return dataFinal; }
	public void setDataFinal(String dataFinal) { this.dataFinal = dataFinal; }
	public String getTipoData() { return tipoData; }
	public void setTipoData(String tipoData) { this.tipoData = tipoData; }
	public long getDataInicioMili() { return dataInicioMili; }
	public void setDataInicioMili(long dataInicioMili) { this.dataInicioMili = dataInicioMili; }
	public long getDataFinalMili() { return dataFinalMili; }
	public void setDataFinalMili(long dataFinalMili) { this.dataFinalMili = dataFinalMili; }
	public boolean isPjs() { return pjs; }
	public void setPjs(boolean pjs) { this.pjs = pjs; }

	public void setDatas (String periodoFaturado) throws ParseException {
		if(!(periodoFaturado.equals(""))) {
			String auxTipo = periodoFaturado.split(" ")[0];
			this.tipoData = auxTipo.split(":")[0];

			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
			Date date;
			if (this.tipoData.equals("Início")) {
				dataInicio = periodoFaturado.split(":")[1];
				date = formatter.parse(dataInicio);
				dataInicioMili = date.getTime();
				dataInicio = formatter2.format(date);

			} else if (this.tipoData.equals("Saída")) {
				dataFinal = periodoFaturado.split(":")[1];
				date = formatter.parse(dataFinal);
				dataFinalMili = date.getTime();
				dataFinal = formatter2.format(date);
			}
		}
	}

	public void addHorasTangerino(float horasReaisTrabalhadas, float horasPrevistas, float horasNoturnas, float abono, float compensacaoDeHoras) {
		this.horasReaisTrabalhadas += horasReaisTrabalhadas;
		this.horasPrevistas += horasPrevistas;
		this.horasNoturnas += horasNoturnas;
		this.abono += abono;
		this.compensacaoDeHoras += compensacaoDeHoras;
	}

	public void addHorasRedmine(float horasReaisTrabalhadas){
		this.horasReaisTrabalhadas += horasReaisTrabalhadas;
	}

	public void calculaHoraExtra (){
		this.saldoDeHorasDoMes = this.horasReaisTrabalhadas - horasPrevistas;

		if(this.saldoDeHorasDoMes > 0){
			this.horaExtra = this.saldoDeHorasDoMes;
			this.horasAdicionaisComAcrescimo = this.horaExtra;
		}
	}

	public void calculaSaldoDoMes (double horasafaturar){
		this.saldoDeHorasDoMes = (float) (this.horasReaisTrabalhadas - horasafaturar);
	}

	public double horasAfaturarBH(){
		horasAdicionaisComAcrescimo =0;
		horasAFaturar = horasPrevistas - abono;
		if(cliente.getNome().equals("BS2-Bonsucesso")) {
			if(this.horasNoturnas != 0) {
				this.horasReaisTrabalhadas -= this.horasNoturnas;
				calculaSaldoDoMes(this.horasAFaturar);
			}else{
				calculaSaldoDoMes(this.horasAFaturar);
			}
		}
		horaExtra = 0;
		if(!(cliente.getNome().equals("BS2-Bonsucesso"))) {
			if (horasNoturnas != 0) {
				horasAFaturar -= horasNoturnas;
			}
			if (horasExtrasNoturnas != 0) {
				horasAFaturar -= horasExtrasNoturnas;
			}
			calculaSaldoDoMes(this.horasAFaturar);
		}

		if(horasDedicadasABase2 != 0){
			horasAFaturar -= horasDedicadasABase2;
		}

		return horasAFaturar;
	}

	public double horasAfaturar2(){
		return horasAFaturar;
	}

	public double horasAfaturarHE(){
		horasAdicionaisComAcrescimo = 0;
		horaExtra -= horasExtrasNoturnas;
		horaExtra -= horasNoturnas;
		if(horasDedicadasABase2 != 0){
			horaExtra -= horasDedicadasABase2;
			if(horaExtra < 0){
				horaExtra = 0;
			}
		}
		horasAFaturar = horasReaisTrabalhadas - horaExtra - horasNoturnas - horasExtrasNoturnas - horasDedicadasABase2;
		return horasAFaturar;
	}

	public double horasAfaturarHA(){
		horaExtra= 0;
		horasAdicionaisComAcrescimo -= horasExtrasNoturnas;
		horasAdicionaisComAcrescimo -= horasNoturnas;
		if(horasDedicadasABase2 != 0){
			horasAdicionaisComAcrescimo -= horasDedicadasABase2;
			if(horasAdicionaisComAcrescimo < 0){
				horasAdicionaisComAcrescimo = 0;
			}
		}
		horasAFaturar = horasReaisTrabalhadas - horasAdicionaisComAcrescimo - horasNoturnas - horasExtrasNoturnas - horasDedicadasABase2;
		return horasAFaturar;
	}

	public double horasAfaturar(){
		horasAdicionaisComAcrescimo = 0;
		horaExtra -= horasExtrasNoturnas;
		if(horasDedicadasABase2 != 0){
			horaExtra -= horasDedicadasABase2;
			if(horaExtra < 0){
				horaExtra = 0;
			}
		}

		if(horasDedicadasABase2 > horasReaisTrabalhadas){
			horasAFaturar = horasReaisTrabalhadas - horaExtra;
		}else {
			horasAFaturar = horasReaisTrabalhadas - horaExtra - horasDedicadasABase2;
		}

		if(horasNoturnas != 0){
			horasAFaturar -= horasNoturnas;
		}

		return horasAFaturar;
	}

	public double horasTotaisF(Colaborador colaborador){
		if(colaborador.cliente.isAcordoBancoDeHoras()){
			horasTotaisFaturadas = colaborador.getHorasAFaturar();
		}else {
			horasTotaisFaturadas = colaborador.getHorasAFaturar() + horasExtrasNoturnas + horasNoturnas + horaExtra + horasAdicionaisComAcrescimo;
		}
		return horasTotaisFaturadas;
	}

	public float valorAFaturarBH(){
		if(this.cliente.isAcordoHorasNoturnas() && this.cliente.isAcordoHorasExtrasNoturnas()) {
			valorAFaturar = (float) ((float) 1.0 * (horasAFaturar * valorHora2) + (horasNoturnas * valorHora2 * 1.5) + (horasExtrasNoturnas * valorHora2 * 3));
		}else if(!(this.cliente.isAcordoHorasNoturnas() && this.cliente.isAcordoHorasExtrasNoturnas())){
			valorAFaturar = (float) ((float) 1.0 * (horasAFaturar * valorHora2));
		}else if(this.cliente.isAcordoHorasNoturnas() && !(this.cliente.isAcordoHorasExtrasNoturnas())){
			valorAFaturar = (float) ((float) 1.0 * (horasAFaturar * valorHora2) + (horasNoturnas * valorHora2 * 1.5));
		}else if(this.cliente.isAcordoHorasExtrasNoturnas() && !(this.cliente.isAcordoHorasNoturnas())){
			valorAFaturar = (float) ((float) 1.0 * (horasAFaturar * valorHora2) + (horasExtrasNoturnas * valorHora2 * 3));
		}
		return valorAFaturar;
	}

	public float valorAFaturarHE(){
		if(this.cliente.isAcordoHorasNoturnas() && this.cliente.isAcordoHorasExtrasNoturnas()) {
			valorAFaturar = (float) ((float) 1.0 * (horasAFaturar * valorHora2) + (horaExtra * valorHora2 *2) + (horasNoturnas * valorHora2 * 1.5) + (horasExtrasNoturnas * valorHora2 *3));
		}else if(!(this.cliente.isAcordoHorasNoturnas() && this.cliente.isAcordoHorasExtrasNoturnas())){
			valorAFaturar = (float) ((float) 1.0 * (horasAFaturar * valorHora2) + (horaExtra * valorHora2 *2));
		}else if(this.cliente.isAcordoHorasNoturnas() && !(this.cliente.isAcordoHorasExtrasNoturnas())){
			valorAFaturar = (float) ((float) 1.0 * (horasAFaturar * valorHora2) + (horaExtra * valorHora2 *2) + (horasNoturnas * valorHora2 * 1.5));
		}else if(this.cliente.isAcordoHorasExtrasNoturnas() && !(this.cliente.isAcordoHorasNoturnas())){
			valorAFaturar = (float) ((float) 1.0 * (horasAFaturar * valorHora2) + (horaExtra * valorHora2 *2) + (horasExtrasNoturnas * valorHora2 * 3));
		}
		return valorAFaturar;
	}

	public float valorAFaturarHA(){
		if(this.cliente.isAcordoHorasNoturnas() && this.cliente.isAcordoHorasExtrasNoturnas()) {
			valorAFaturar = (float) ((float) 1.0 * (horasAFaturar * valorHora2) + (horasAdicionaisComAcrescimo * valorHora2 *1.30) + (horasNoturnas * valorHora2 * 1.5) + (horasExtrasNoturnas * valorHora2 *3));
		}else if(!(this.cliente.isAcordoHorasNoturnas() && this.cliente.isAcordoHorasExtrasNoturnas())){
			valorAFaturar = (float) ((float) 1.0 * (horasAFaturar * valorHora2) + (horasAdicionaisComAcrescimo * valorHora2 *1.30));
		}else if(this.cliente.isAcordoHorasNoturnas() && !(this.cliente.isAcordoHorasExtrasNoturnas())){
			valorAFaturar = (float) ((float) 1.0 * (horasAFaturar * valorHora2) + (horasAdicionaisComAcrescimo * valorHora2 *1.30) + (horasNoturnas * valorHora2 * 1.5));
		}else if(this.cliente.isAcordoHorasExtrasNoturnas() && !(this.cliente.isAcordoHorasNoturnas())){
			valorAFaturar = (float) ((float) 1.0 * (horasAFaturar * valorHora2) + (horasAdicionaisComAcrescimo * valorHora2 *1.30) + (horasExtrasNoturnas * valorHora2 * 3));
		}

		return valorAFaturar;
	}

	public float valorAFaturar(){
		if(this.cliente.isAcordoHorasNoturnas() && this.cliente.isAcordoHorasExtrasNoturnas()) {
			valorAFaturar = (float) ((float) 1.0 * (horasAFaturar * valorHora2) + (horaExtra * valorHora2 *2) + (horasNoturnas * valorHora2 * 1.5) + (horasExtrasNoturnas * valorHora2 *3));
		}else if(!(this.cliente.isAcordoHorasNoturnas() && this.cliente.isAcordoHorasExtrasNoturnas())){
			valorAFaturar = (float) ((float) 1.0 * (horasAFaturar * valorHora2) + (horaExtra * valorHora2 *2));
		}else if(this.cliente.isAcordoHorasNoturnas() && !(this.cliente.isAcordoHorasExtrasNoturnas())){
			valorAFaturar = (float) ((float) 1.0 * (horasAFaturar * valorHora2) + (horaExtra * valorHora2 *2) + (horasNoturnas * valorHora2 * 1.5));
		}else if(this.cliente.isAcordoHorasExtrasNoturnas() && !(this.cliente.isAcordoHorasNoturnas())){
			valorAFaturar = (float) ((float) 1.0 * (horasAFaturar * valorHora2) + (horaExtra * valorHora2 *2) + (horasExtrasNoturnas * valorHora2 * 3));
		}
		return valorAFaturar;
	}

	public float valorAFaturarComDesconto(float valorAFaturar, float desconto){
		this.valorAFaturarComDescontos = valorAFaturar * (1 - desconto);
		this.valorAFaturarComDescontos -= this.cliente.getLicencaAzure();
		return valorAFaturarComDescontos;
	}
	@Override
	public String toString() {
		return "Colaborador{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", email='" + email + '\'' +
				", cliente=" + cliente +
				", perfilProfissional='" + perfilProfissional + '\'' +
				", valorHora='" + valorHora + '\'' +
				", horasReaisTrabalhadas=" + horasReaisTrabalhadas +
				", horasPrevistas=" + horasPrevistas +
				", horasNoturnas=" + horasNoturnas +
				", horasExtrasNoturnas=" + horasExtrasNoturnas +
				", horaExtra=" + horaExtra +
				", abono=" + abono +
				", ferias=" + ferias +
				", compensacaoDeHoras=" + compensacaoDeHoras +
				", saldoDeHorasDoMes=" + saldoDeHorasDoMes +
				", horasAFaturar=" + horasAFaturar +
				", horasDedicadasABase2=" + horasDedicadasABase2 +
				", valorAFaturar=" + valorAFaturar +
				", valorAFaturarComDescontos=" + valorAFaturarComDescontos +
				'}';
	}
}

