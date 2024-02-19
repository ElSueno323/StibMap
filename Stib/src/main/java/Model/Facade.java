package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author <@Gabriel.espinosa>
 */
public class Facade {

    private ArrayList<Stops> ListStops = new ArrayList<>();
    private ArrayList<Lines> ListLines = new ArrayList<>();
    private ArrayList<Stations> ListStations = new ArrayList<>();
    private DataBase dt;

    public Facade() {
        try {
            dt = new DataBase();
            dt.Connexion();

            createStations();

            createLines();

            createStops();

        } catch (Exception e) {
            System.out.println("Error Facade :" + e.getMessage());
        }
    }

    private void createStations() {
        HashMap<Integer, String> st = dt.selectStations();
        for (Map.Entry<Integer, String> entry : st.entrySet()) {
            ListStations.add(new Stations(entry.getKey(), entry.getValue()));
        }
    }

    private void createLines() {
        ArrayList<Integer> lines = dt.selectLines();
        for (Integer line : lines) {
            ListLines.add(new Lines(line));
        }
    }

    private void createStops() {
        HashMap<Integer, ArrayList<Integer>> stops = dt.selectStop();
        for (Map.Entry<Integer, ArrayList<Integer>> entry : stops.entrySet()) {

            for (Stations station : ListStations) {
                if (station.getIdStations() == entry.getValue().get(0)) {
                    int idxln = ListLines.indexOf(
                            new Lines(entry.getValue().get(1)));

                    ListStops.add(new Stops(
                            entry.getKey(), station, ListLines.get(idxln)));
                    break;
                }
            }
        }
    }

    public int getNbrStation() {
        int x = ListStations.size();
        return x;
    }

    public ArrayList<Stops> getListStops() {
        ArrayList<Stops> copy = ListStops;
        return copy;
    }

    public ArrayList<Lines> getListLines() {
        ArrayList<Lines> copy = ListLines;
        return copy;
    }

    public ArrayList<Stations> getListStations() {
        ArrayList<Stations> copy = ListStations;
        return copy;
    }

}




