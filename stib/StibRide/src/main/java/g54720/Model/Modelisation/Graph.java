package g54720.Model.Modelisation;

import java.util.*;

public class Graph {

    private Set<Node> nodes=new HashSet<>();

    public Graph(){
    }
    public Graph(Graph other){
        nodes=new HashSet<>();
        for (Node node :other.getNodes()){
                Node temp=new Node(node);
                this.nodes.add(temp);
        }
    }
    public void addNode(Node... nodez){
        for (Node node:nodez) {
            nodes.add(node);
        }
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public Node getTheNode(int id){
        for(Node node : nodes){
            if(node.getStation()==id){
                return node;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String text="";
        for (Node node:nodes) {
            text=text+node.getName()+",distance:"+node.getDistance() +" ";
        }
        return text ;
    }

    public static Graph FasterWay(Graph graph , Node source , Node end){
        graph=new Graph(Dijkstra.calculateShortestPathFromSource(graph,source));
        Graph temp=new Graph();
        for(Node node: graph.getNodes()){
            if(node.getName()== end.getName()){
                temp.addNode(node);
                for(Node chemin:end.getShortestPath()){
                    temp.addNode(chemin);
                }
            }
        }
        return temp;
    }

    public void resetShortPath(){
        for(Node node : this.nodes){
            node.setShortestPath(new LinkedList<>());
        }
    }
}
