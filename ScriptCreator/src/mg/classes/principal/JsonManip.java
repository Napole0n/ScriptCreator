/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.classes.principal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mg.classes.database.DataBase;

/**
 *
 * @author Murilo_2
 */
public class JsonManip {

    private static final String DATABASE_DIR = "files/database.json";

    /**
     *
     * @return todas as databases no arquivo JSON
     */
    public static List<DataBase> getDataBases() {

        List<DataBase> lista = new ArrayList<>();
        BufferedReader bufferedReader = null;
        java.lang.reflect.Type listType = new TypeToken<ArrayList<DataBase>>() {
        }.getType();

        try {
            bufferedReader = new BufferedReader(new FileReader(DATABASE_DIR));
            lista = new Gson().fromJson(bufferedReader, listType);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JsonManip.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }

    /**
     *
     * @param db a DataBase a ser adicionada no arquivo
     * @throws IOException
     */
    public static void addDataBase(DataBase db) throws IOException {

        List<DataBase> lDataBases = new ArrayList<>();
        try {
            lDataBases = getDataBases();
        } catch (Exception e) {
            e.toString();
        }
        lDataBases.add(db);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        try (FileWriter writer = new FileWriter(DATABASE_DIR)) {
            writer.write(gson.toJson(lDataBases));
        }

    }
    
    /**
     *
     * @throws IOException limpa as listas de Databases
     */
    public static void clearDataBases() throws IOException{
        List<DataBase> lDataBases = new ArrayList<>();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        try (FileWriter writer = new FileWriter(DATABASE_DIR)) {
            writer.write(gson.toJson(lDataBases));
        }
    }

}
