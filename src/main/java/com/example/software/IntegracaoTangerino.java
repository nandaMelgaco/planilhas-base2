package com.example.software;

import com.example.software.requests.GetDailySummary;
import com.example.software.requests.GetEmployee;
import com.example.software.tangerino.*;

import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;

public class IntegracaoTangerino {

    private static ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();
    private static Response response;
    private static JsonPath jsonPath;
    public static Converte converte = new Converte();

    public IntegracaoTangerino() {
        // TODO Auto-generated constructor stub
    }

    public static ArrayList<Colaborador> setColaboradorTangerino(long dataInicio, long dataFinal) {
        ArrayList<Employee> employees = findAllEmployees();
        String endDate = String.valueOf(dataFinal);
        String startDate = String.valueOf(dataInicio);

        GetDailySummary getDailySummary = new GetDailySummary(endDate, startDate);
        response = getDailySummary.executeRequest();

        jsonPath = response.body().jsonPath();
        List<ColaboradorTangerinoDailySumary> colaboradoresTangerinosDailySumary = jsonPath.getList("", ColaboradorTangerinoDailySumary.class);
        colaboradores = getDailySumary(colaboradoresTangerinosDailySumary);

        for (Colaborador c : colaboradores) {
            for (Employee e : employees) {
                if (c.getId() == e.getId()) {
                    c.setNome(e.getName());
                    c.setEmail(e.getEmail());
                }
            }
        }

        return colaboradores;
    }

    public static ArrayList<Colaborador> getDailySumary(List<ColaboradorTangerinoDailySumary> colaboradoresTangerinosDailySumary) {
        ArrayList<Colaborador> arrayColab = new ArrayList<Colaborador>();
        ArrayList<Colaborador> arrayColab2 = new ArrayList<Colaborador>();

        for (ColaboradorTangerinoDailySumary c1 : colaboradoresTangerinosDailySumary) {
            Colaborador colaborador = new Colaborador(c1.getEmployeeId(), c1.getWorkedHours(), c1.getEstimatedHours(), c1.getNightHours(), c1.getPaidHours(), c1.getDayMissing());
            arrayColab.add(colaborador);
        }
        boolean flag = false;
        for (Colaborador c : arrayColab) {
            if (arrayColab2.size() == 0) {
                Colaborador col = new Colaborador(c.getId(), c.getHorasReaisTrabalhadas(), c.getHorasPrevistas(), c.getHorasNoturnas(), c.getAbono(), c.getCompensacaoDeHoras());
                arrayColab2.add(col);
            } else {
                for (Colaborador c2 : arrayColab2) {
                    if (c2.getId() == (c.getId())) {
                        c2.addHorasTangerino(c.getHorasReaisTrabalhadas(), c.getHorasPrevistas(), c.getHorasNoturnas(), c.getAbono(), c.getCompensacaoDeHoras());
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    flag = false;
                    continue;
                }
                arrayColab2.add(new Colaborador(c.getId(), c.getHorasReaisTrabalhadas(), c.getHorasPrevistas(), c.getHorasNoturnas(), c.getAbono(), c.getCompensacaoDeHoras()));
            }
        }

        for (Colaborador c : arrayColab2) {
            c.setHorasReaisTrabalhadas(converte.converteMinutos(c.getHorasReaisTrabalhadas()));
            c.setHorasPrevistas(converte.converteMinutos(c.getHorasPrevistas()));
            c.setHorasNoturnas(converte.converteMinutos(c.getHorasNoturnas()));
            c.setAbono(converte.converteMinutos(c.getAbono()));
            c.setCompensacaoDeHoras(converte.converteMinutos(c.getCompensacaoDeHoras()));
        }

        return arrayColab2;
    }

    public static ArrayList<Employee> findAllEmployees(){
        GetEmployee getEmployee = new GetEmployee();
        response = getEmployee.executeRequest();

        String json = response.getBody().asString();

        Gson gson = new Gson();
        ColaboradorTangerino colaboradorTangerino = gson.fromJson(json,ColaboradorTangerino.class);

        ArrayList<Content> contents = (ArrayList<Content>) colaboradorTangerino.getContent();
        ArrayList<Employee> employees = new ArrayList<Employee>();

        for(Content c: contents){
            Employee employee = new Employee(c.getId(),c.getName(),c.getEmail());
            employees.add(employee);
        }
        return employees;
    }

    public static void main(String [] args){


    }

}