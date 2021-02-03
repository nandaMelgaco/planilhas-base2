package com.example.software;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.*;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegracaoGoogle {
    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    private static ArrayList<Colaborador> arrayColab = new ArrayList<Colaborador>();
    private static ArrayList<Cliente> arrayClien = new ArrayList<Cliente>();
    private static Cliente clien;
    private static Colaborador colab;
    private static String nome;
    private static String cliente;
    private static String perfilProfissional;
    private static String valorHora;
    private static String licenca;
    private static String periodoFaturado;
    private static boolean pjs;

    /**
     * Creates an authorized Credential object.
     *
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = IntegracaoGoogle.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    /**
     * Prints the names and majors of students in a sample spreadsheet:
     * https://docs.google.com/spreadsheets/d/1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms/edit
     */
    public static ArrayList<Colaborador> setColaborador() throws IOException, GeneralSecurityException, ParseException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1eAeAzqQTsyctIaPfsvqdR0Tuiv28bRwW9AJKLPVb4-g";
        final String range = "Recursos Alocados!A2:O";
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();

        List<List<Object>> values = response.getValues();
        if (values == null || values.isEmpty()) {
            System.out.println("No data found.");
        } else {
            for (List row : values) {
                nome = row.get(0).toString();
                cliente = row.get(2).toString();
                periodoFaturado = row.get(9).toString();
                perfilProfissional = row.get(10).toString();
                valorHora = row.get(11).toString();
                licenca = row.get(13).toString();
                String aux;
                aux = row.get(14).toString();
                if(aux.equals("sim")){
                    pjs = true;
                }else{
                    pjs = false;
                }
                System.out.println(nome);
                colab = new Colaborador(cliente, nome, perfilProfissional, valorHora, licenca, periodoFaturado,pjs);
                colab.setDatas(periodoFaturado);
                arrayColab.add(colab);
            }
        }
        return arrayColab;
    }

    public static ArrayList<Cliente> setCliente() throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1NyGB3FXWebLBWP_ockUGg5RsVG1i1cKk50MA8_ay7NY";
        final String range = "Clientes!A2:G";
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();

        List<List<Object>> values = response.getValues();
        if (values == null || values.isEmpty()) {
            System.out.println("No data found.");
        } else {
            for (List row : values) {
                nome = row.get(0).toString();
                String horaExtra = row.get(1).toString();
                String bancoDeHoras = row.get(2).toString();
                String horasAdicionais = row.get(3).toString();
                String horasNoturnas = row.get(4).toString();
                String horaExtraNoturna = row.get(5).toString();
                String descontos = row.get(6).toString();
                float aux = Float.parseFloat(descontos);

                clien = new Cliente();
                clien.setNome(nome);
                if (horaExtra.equals("sim")) {
                    clien.setAcordoHoraExtra(true);
                } else {
                    clien.setAcordoHoraExtra(false);
                }
                if (bancoDeHoras.equals("sim")) {
                    clien.setAcordoBancoDeHoras(true);
                } else {
                    clien.setAcordoBancoDeHoras(false);
                }
                if (horasAdicionais.equals("sim")) {
                    clien.setAcordoHorasAdicionais(true);
                } else {
                    clien.setAcordoHorasAdicionais(false);
                }
                if (horasNoturnas.equals("sim")) {
                    clien.setAcordoHorasNoturnas(true);
                } else {
                    clien.setAcordoHorasNoturnas(false);
                }
                if (horaExtraNoturna.equals("sim")) {
                    clien.setAcordoHorasExtrasNoturnas(true);
                } else {
                    clien.setAcordoHorasExtrasNoturnas(false);
                }
                if (aux != 0) {
                    clien.setDescontos(aux);
                }
                arrayClien.add(clien);
            }
        }
        return arrayClien;
    }

    public static ArrayList<Colaborador> setHorasExtrasNoturnas() throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "15BkgY5TH1EGzdW7GJGNf9OvdACREeYxNDcDFQl8rZqk";
        final String range = "Horas Extras Noturnas!A4:D";
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
        arrayColab = new ArrayList<Colaborador>();
        String nome;
        String aux;

        List<List<Object>> values = response.getValues();
        if (values == null || values.isEmpty()) {
            System.out.println("No data found.");
        } else {
            for (List row : values) {
                nome = row.get(0).toString();
                aux = row.get(1).toString();

                String aux1 = aux.split(":")[0];

                int horas = Integer.parseInt(aux1);
                int minutos = Integer.parseInt(String.valueOf(aux.split(":")[1]));

                float horasExtrasNoturnas = (float) (horas + (minutos / 60.0));
                Colaborador colaborador = new Colaborador(nome, horasExtrasNoturnas);

                arrayColab.add(colaborador);
            }
        }

        return arrayColab;
    }
}
// [END sheets_quickstart]
