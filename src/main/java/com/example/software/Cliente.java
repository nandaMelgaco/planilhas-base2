package com.example.software;

public class Cliente {
    private String nome;
    private boolean acordoHoraExtra;
    private boolean acordoBancoDeHoras;
    private boolean acordoHorasAdicionais;
    private float licancaAzure;
    private boolean acordoHorasNoturnas;
    private boolean acordoHorasExtrasNoturnas;
    private float descontos;

    public Cliente() {
    }

    public Cliente(String nome, boolean acordoHoraExtra, boolean acordoBancoDeHoras, boolean acordoHorasAdicionais, float licancaAzure, float descontos) {
        this.nome = nome;
        this.acordoHoraExtra = acordoHoraExtra;
        this.acordoBancoDeHoras = acordoBancoDeHoras;
        this.acordoHorasAdicionais = acordoHorasAdicionais;
        this.licancaAzure = licancaAzure;
        this.descontos = descontos;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public float getLicencaAzure() { return licancaAzure; }
    public void setLicancaAzure(float licancaAzure) { this.licancaAzure = licancaAzure; }

    public boolean isAcordoHoraExtra() {
        return acordoHoraExtra;
    }

    public void setAcordoHoraExtra(boolean acordoHoraExtra) {
        this.acordoHoraExtra = acordoHoraExtra;
    }

    public boolean isAcordoBancoDeHoras() {
        return acordoBancoDeHoras;
    }

    public void setAcordoBancoDeHoras(boolean acordoBancoDeHoras) {
        this.acordoBancoDeHoras = acordoBancoDeHoras;
    }

    public boolean isAcordoHorasAdicionais() {
        return acordoHorasAdicionais;
    }

    public void setAcordoHorasAdicionais(boolean acordoHorasAdicionais) {
        this.acordoHorasAdicionais = acordoHorasAdicionais;
    }

    public boolean isAcordoHorasNoturnas() {
        return acordoHorasNoturnas;
    }

    public void setAcordoHorasNoturnas(boolean acordoHorasNoturnas) {
        this.acordoHorasNoturnas = acordoHorasNoturnas;
    }

    public boolean isAcordoHorasExtrasNoturnas() {
        return acordoHorasExtrasNoturnas;
    }

    public void setAcordoHorasExtrasNoturnas(boolean acordoHorasExtrasNoturnas) {
        this.acordoHorasExtrasNoturnas = acordoHorasExtrasNoturnas;
    }


    public float getDescontos() {
        return descontos;
    }

    public void setDescontos(float descontos) {
        this.descontos = descontos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", acordoHoraExtra=" + acordoHoraExtra +
                ", acordoBancoDeHoras=" + acordoBancoDeHoras +
                ", acordoHorasAdicionais=" + acordoHorasAdicionais +
                ", licancaAzure=" + licancaAzure +
                ", acordoHorasNoturnas=" + acordoHorasNoturnas +
                ", acordoHorasExtrasNoturnas=" + acordoHorasExtrasNoturnas +
                ", descontos=" + descontos +
                '}';
    }
}
