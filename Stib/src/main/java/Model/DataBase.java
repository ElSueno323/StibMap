/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Config.ConfigManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author <@Gabriel.espinosa>
 */
public class DataBase {

    private String urlDb;
    private Statement sqlStat;

    DataBase() {
        try {//load 
            ConfigManager.getInstance().load();
            //cherche proprietes
            urlDb = ConfigManager.getInstance().getProperties("db.url");
            System.out.println("Bd stockée : " + urlDb);

        } catch (IOException e) {
            System.out.println("ERREUR :" + e.getMessage());
        }
    }

    void Connexion() throws SQLException {
        try {
            System.out.println(urlDb);
            Connection co = DriverManager.getConnection("jdbc:sqlite:" + urlDb);
            sqlStat = co.createStatement();
        } catch (SQLException e) {
            System.out.println("Connxeion Erreur :" + e.getMessage());
        }
    }

    HashMap selectStations() {
        try {

            HashMap<Integer, String> stationsMap = new HashMap<>();
            String request = "SELECT id,name FROM STATIONS";

            ResultSet rslt = sqlStat.executeQuery(request);
            while (rslt.next()) {
                stationsMap.put(rslt.getInt("id"), rslt.getString("name"));
            }
            return stationsMap;

        } catch (SQLException e) {
            System.out.println("ERROR SELECT STATIONS :" + e.getMessage());
            return null;
        }
    }

    ArrayList selectLines() {
        try {
            ArrayList<Integer> lines = new ArrayList<>();
            String request = "SELECT id FROM LINES";
            ResultSet rslt = sqlStat.executeQuery(request);
            while (rslt.next()) {
                lines.add(rslt.getInt("id"));
            }
            return lines;
        } catch (SQLException e) {
            System.out.println("ERROR SELECT LINES :" + e.getMessage());
            return null;
        }
    }

    /**
     * Use the sql commande "SELECT id_order,id_station,id_line FROM STOPS ".
     * Give a hashmap with a integer,the id of stop, and a arraylist,the id
     * stations and id line.
     *
     * @return
     */
    HashMap selectStop() {
        try {
            HashMap<Integer, ArrayList<Integer>> stops = new HashMap<>();
            String rqs = "SELECT id_order,id_station,id_line FROM STOPS ";
            ResultSet rslt = sqlStat.executeQuery(rqs);
            while (rslt.next()) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(rslt.getInt("id_station"));
                tmp.add(rslt.getInt("id_line"));
                stops.put(rslt.getInt("id_order"), tmp);
            }
            return stops;
        } catch (SQLException e) {
            System.out.println("ERROR SELECT STOPS:" + e.getMessage());
            return null;
        }
    }
}
