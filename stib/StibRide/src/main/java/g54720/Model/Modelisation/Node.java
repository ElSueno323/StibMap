package g54720.Model.Modelisation;

import java.util.*;

public class Node {

    private List<Node> shortestPath = new LinkedList<>();

    private String name;
    private int station;
    private List<Integer> lignes;

    private Integer distance = Integer.MAX_VALUE;

    private Map<Node, Integer> neightbord = new HashMap<>();

    public Node(String name, int station, int... lignes) {
        this.station = station;
        this.name = name;
        this.lignes = new ArrayList<>();
        for (int ligne : lignes) {
            this.lignes.add(ligne);
        }
    }
    public Node(Node other){
        this.station=other.station;
        this.name=other.name;
        this.lignes=other.lignes;
        this.distance=other.distance;
        this.neightbord=other.neightbord;

        this.shortestPath=new LinkedList<>();
    }

    public Integer getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public int getStation() {
        return station;
    }

    public List<Integer> getLignes() {
        return lignes;
    }

    public Map<Node, Integer> getNeightbord() {
        return neightbord;
    }

    public void addDestination(Node destination, int distance) {
        if(!this.alreadyNeightbord(destination)){
            neightbord.put(destination, distance);
        }
        if(!destination.alreadyNeightbord(this)){
            destination.getNeightbord().put(this, distance);
        }
    }

    public boolean alreadyNeightbord(Node destination){
        return neightbord.containsKey(destination);
    }

    public void addLigne(int line) {
        this.lignes.add(line);
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node node)) return false;

        if (station != node.station) return false;
        if (!Objects.equals(name, node.name)) return false;
        return Objects.equals(distance, node.distance);
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }
}
