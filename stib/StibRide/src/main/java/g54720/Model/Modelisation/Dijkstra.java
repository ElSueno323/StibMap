package g54720.Model.Modelisation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Dijkstra {
    /**
     * Donne le sous grpahe d'un graphe avec le chemin le plus courte avec un noeud
     * de source.
     * @param graph
     * @param source
     * @return
     */
    public static Graph calculateShortestPathFromSource(Graph graph, Node source){
        source.setDistance(0);

        Set<Node> settleNodes=new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);
        while (unsettledNodes.size()!=0){
            Node currentN=getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentN);
            for(Map.Entry<Node,Integer> adjacencyPair: currentN.getNeightbord().entrySet()){
                Node adjacent=adjacencyPair.getKey();
                Integer edgeWeight=adjacencyPair.getValue();
                if(!settleNodes.contains(adjacent)){
                    CalculateMinimDistance(adjacent, edgeWeight, currentN);
                    unsettledNodes.add(adjacent);
                }
            }
            settleNodes.add(currentN);
        }
        return graph;
    }

    /**
     * permet d'obtenir le noeud qui a la distance la plus courte entre les voisin
     * @param unsettledNodes
     * @return
     */
    private static Node getLowestDistanceNode(Set <Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node: unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    /**
     * calcule le minimum entre 2 noeud en modifant sa list de chemin le plus cours
     * @param evalN
     * @param edgeWeigh
     * @param source
     */
    private static void CalculateMinimDistance(Node evalN, int edgeWeigh, Node source){
        int sourceDist=source.getDistance();
        if(sourceDist+edgeWeigh<evalN.getDistance()){
            evalN.setDistance(sourceDist+edgeWeigh);
            LinkedList<Node> shortestPath=new LinkedList<>(source.getShortestPath());
            shortestPath.add(source);
            evalN.setShortestPath(shortestPath);
        }
    }
}
