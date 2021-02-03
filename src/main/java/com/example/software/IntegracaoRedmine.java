package com.example.software;

import com.example.software.redmine.*;
import com.example.software.requests.*;
import com.example.software.tangerino.Employee;
import com.example.software.utils.GeneralUtils;
import com.google.gson.Gson;
import io.restassured.response.Response;

import javax.lang.model.util.SimpleElementVisitor6;
import java.text.SimpleDateFormat;
import java.util.*;

public class IntegracaoRedmine {

	private static ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();
	static ArrayList<Users> users = new ArrayList<>();
	static ArrayList<Projects> projects = new ArrayList<>();
	private static Response response;
	private static String json;

	public IntegracaoRedmine() {
		users = findAllUsers();
		projects = findAllProject();
	}

	public static float getHorasRhApropriacao (String dataInicio, String dataFinal, String email) {
		int user_id = 0;
		float horas = 0;

		for(Users u : users){
			if(u.mail.equals(email)){
				user_id = u.id;
				break;
			}
		}

		GetHorasRHApropriacao getHorasRHApropriacao = new GetHorasRHApropriacao(dataInicio, dataFinal, user_id,0);
		response = getHorasRHApropriacao.executeRequest();
		json = response.getBody().asString();

		Gson gson = new Gson();
		ColaboradorRedmine colaboradorRedmine = gson.fromJson(json, ColaboradorRedmine.class);
		ArrayList<TimeEntries> timeEntries = (ArrayList<TimeEntries>) colaboradorRedmine.time_entries;

		if (timeEntries.size() != 0) {
			for (TimeEntries te : timeEntries) {
				horas += te.hours;
			}
		}


		return horas;
	}

	public static ArrayList<Users> findAllUsers() {
		GetColaboradores getColaboradores = new GetColaboradores(0);
		response = getColaboradores.executeRequest();
		json = response.getBody().asString();

		Gson gson = new Gson();
		AllUsers allUsers = gson.fromJson(json, AllUsers.class);
		ArrayList<Users> usersArrayList = allUsers.users;

		if (allUsers.total_count > 100) {
			getColaboradores = new GetColaboradores(101);
			response = getColaboradores.executeRequest();
			json = response.getBody().asString();

			gson = new Gson();
			allUsers = gson.fromJson(json, AllUsers.class);

			for (int i = 0; i < allUsers.users.size(); i++) {
				Users user = allUsers.users.get(i);
				usersArrayList.add(user);

			}
		}
		return usersArrayList;
	}

	public static ArrayList<Projects> findAllProject() {
		GetProjects getProjects = new GetProjects(0);
		response = getProjects.executeRequest();
		json = response.getBody().asString();

		Gson gson = new Gson();
		AllProjects allProjects = gson.fromJson(json, AllProjects.class);
		ArrayList<Projects> projects = allProjects.projects;

		if (allProjects.total_count > 100) {
			getProjects = new GetProjects(101);
			response = getProjects.executeRequest();
			json = response.getBody().asString();

			gson = new Gson();
			allProjects = gson.fromJson(json, AllProjects.class);

			for (int i = 0; i < allProjects.projects.size(); i++) {
				Projects project = allProjects.projects.get(i);
				projects.add(project);

			}
		}
		return projects;
	}

	public static HorasRedmine horasPorProjetoRedmine(Colaborador colaborador, String dataInicio, String dataFinal) {
		HorasRedmine horasRedmine = new HorasRedmine();
		int userId = 0;
		int projectId = 0;
		float horas = 0;
		float horasPrevistas = 0;

		if (colaborador.getEmail() != null) {
			for (Users u : users) {
				if (colaborador.getEmail().equals(u.mail)) {
					userId = u.id;
					break;
				}
			}

			for (Projects p : projects) {
				if (p.name.contains(colaborador.getCliente().getNome())) {
					projectId = (int) p.id;
					break;
				}
			}

			GetHorasPorProjeto getHorasPorProjeto = new GetHorasPorProjeto(dataInicio, dataFinal, 0, projectId, userId);
			response = getHorasPorProjeto.executeRequest();
			json = response.getBody().asString();

			Gson gson = new Gson();
			ColaboradorRedmine colaboradorRedmine = gson.fromJson(json, ColaboradorRedmine.class);
			ArrayList<TimeEntries> timeEntries = (ArrayList<TimeEntries>) colaboradorRedmine.time_entries;

			String dataVerified = "";

			if (timeEntries.size() != 0) {
				for (TimeEntries te : timeEntries) {
					if(colaborador.isPjs()){
						horas += te.hours;
						horasPrevistas = horas;
					}else {
						horas += te.hours;
						if(!(dataVerified.equals(te.spent_on))) {
							horasPrevistas += 8;
						}
						dataVerified = te.spent_on;
					}
				}
			}
		}

		horasRedmine.setHorasTrabalhadas(horas);
		horasRedmine.setHorasPrevistas(horasPrevistas);

		return horasRedmine;
	}

	public static HorasRedmine getHorasPorColaborador(Colaborador colaborador, String dataInicio, String dataFinal) {
		float horas = 0;
		float horasPrevistas=0;
		HorasRedmine horasRedmine = new HorasRedmine();
		int userId = 0;
		float vetor[];

		if (colaborador.getEmail() != null) {
			for (Users u : users) {
				if (colaborador.getEmail().equals(u.mail)) {
					userId = u.id;
					break;
				}
			}
		}

		GetHorasPorColaborador getHorasPorColaborador = new GetHorasPorColaborador(dataFinal, dataInicio, userId, 0);
		response = getHorasPorColaborador.executeRequest();
		json = response.getBody().asString();
		Gson gson = new Gson();
		ColaboradorRedmine colaboradorRedmine = gson.fromJson(json, ColaboradorRedmine.class);
		ArrayList<TimeEntries> timeEntries = (ArrayList<TimeEntries>) colaboradorRedmine.time_entries;

		String dataVerified = "";

		for (TimeEntries te : timeEntries) {
			horas += te.hours;
			if(!(dataVerified.equals(te.spent_on))) {
				horasPrevistas += 8;
			}
			dataVerified = te.spent_on;
		}

		horasRedmine.setHorasTrabalhadas(horas);
		horasRedmine.setHorasPrevistas(horasPrevistas);

		return horasRedmine;

	}

	public static String setEmailRedmine(String nome){
		String email = null;

		for(Users u : users){
			if(nome.contains(u.firstname) && nome.contains(u.lastname)){
				email = u.mail;
			}
		}
		return email;
	}

	public static void main (String [] args){
		ArrayList<Users> users = findAllUsers();
		Colaborador colaborador = new Colaborador();
		colaborador.setEmail("alvaro.junior@base2.com.br");
		colaborador.getCliente().setNome("Automação-Pan");

	}
}

