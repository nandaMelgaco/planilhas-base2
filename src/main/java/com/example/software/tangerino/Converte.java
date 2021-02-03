package com.example.software.tangerino;

public class Converte {
    protected float aux;
    public Converte(){

    }

    public float converteMinutos (float minutos){
        aux = minutos / 60;
        return aux;
    }

    public float converteHoras (float horas){
        aux = horas * 60;
        return aux;
    }
}
